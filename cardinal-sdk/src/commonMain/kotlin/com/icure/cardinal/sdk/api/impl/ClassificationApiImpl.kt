package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ClassificationApi
import com.icure.cardinal.sdk.api.ClassificationBasicApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavouredApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ClassificationFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapClassificationFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractClassificationBasicFlavouredApi<E : Classification>(protected val rawApi: RawClassificationApi) :
	ClassificationBasicFlavouredApi<E> {
	override suspend fun modifyClassification(entity: E): E =
		rawApi.modifyClassification(validateAndMaybeEncrypt(entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }


	override suspend fun getClassification(entityId: String): E = rawApi.getClassification(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getClassifications(entityIds: List<String>): List<E> =
		rawApi.getClassifications(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedClassification
	abstract suspend fun maybeDecrypt(entity: EncryptedClassification): E
}

@InternalIcureApi
private abstract class AbstractClassificationFlavouredApi<E : Classification>(
	rawApi: RawClassificationApi,
	private val config: ApiConfiguration,
) : AbstractClassificationBasicFlavouredApi<E>(rawApi), ClassificationFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.classification

	override suspend fun shareWith(
		delegateId: String,
		classification: E,
		options: ClassificationShareOptions?,
	): E =
		shareWithMany(classification, mapOf(delegateId to (options ?: ClassificationShareOptions())))

	override suspend fun shareWithMany(classification: E, delegates: Map<String, ClassificationShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			classification.withTypeInfo(),
			delegates,
			true,
			{ getClassification(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } } }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listClassificationIdsByDataOwnerPatientCreated(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getClassifications(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

	override suspend fun filterClassificationsBySorted(filter: SortableFilterOptions<Classification>): PaginatedListIterator<E> =
		filterClassificationsBy(filter)

	override suspend fun filterClassificationsBy(filter: FilterOptions<Classification>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchClassificationBy(
				mapClassificationFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			::getClassifications
		)
}

@InternalIcureApi
private class AbstractClassificationBasicFlavourlessApi(val rawApi: RawClassificationApi) :
	ClassificationBasicFlavourlessApi {
	override suspend fun deleteClassification(entityId: String) = rawApi.deleteClassification(entityId).successBody()
	override suspend fun deleteClassifications(entityIds: List<String>) = rawApi.deleteClassifications(
		ListOfIds(
			entityIds
		)
	).successBody()
}

@InternalIcureApi
internal class ClassificationApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: ApiConfiguration,
) : ClassificationApi, ClassificationFlavouredApi<DecryptedClassification> by object :
	AbstractClassificationFlavouredApi<DecryptedClassification>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedClassification): EncryptedClassification =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedClassification.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedClassification): DecryptedClassification {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override val encrypted: ClassificationFlavouredApi<EncryptedClassification> =
		object : AbstractClassificationFlavouredApi<EncryptedClassification>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedClassification): EncryptedClassification =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedClassification.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedClassification): EncryptedClassification = entity
		}

	override val tryAndRecover: ClassificationFlavouredApi<Classification> =
		object : AbstractClassificationFlavouredApi<Classification>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedClassification): Classification =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedClassification.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Classification): EncryptedClassification = when (entity) {
				is EncryptedClassification -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedClassification.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedClassification -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedClassification.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }
			}
		}

	override suspend fun createClassification(entity: DecryptedClassification): DecryptedClassification {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createClassification(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	private val crypto get() = config.crypto

	override suspend fun withEncryptionMetadata(
		base: DecryptedClassification?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
	): DecryptedClassification =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedClassification(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString> = crypto.entity.encryptionKeysOf(classification.withTypeInfo(), null)

	override suspend fun hasWriteAccess(classification: Classification): Boolean = crypto.entity.hasWriteAccess(classification.withTypeInfo())

	override suspend fun decryptPatientIdOf(classification: Classification): Set<String> = crypto.entity.owningEntityIdsOf(classification.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedClassification) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedClassification.serializer(),
		config.encryption.classification
	) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }

	private suspend fun decryptOrNull(entity: EncryptedClassification): DecryptedClassification? =
		crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }

	override suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification =
		decryptOrNull(classification) ?: throw EntityEncryptionException("Classification cannot be decrypted")

	override suspend fun tryDecrypt(classification: EncryptedClassification): Classification =
		decryptOrNull(classification) ?: classification

	override suspend fun matchClassificationsBy(filter: FilterOptions<Classification>): List<String> =
		rawApi.matchClassificationBy(
			mapClassificationFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()

	override suspend fun matchClassificationsBySorted(filter: SortableFilterOptions<Classification>): List<String> =
		matchClassificationsBy(filter)
}

@InternalIcureApi
internal class ClassificationBasicApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: BasicApiConfiguration,
) : ClassificationBasicApi, ClassificationBasicFlavouredApi<EncryptedClassification> by object :
	AbstractClassificationBasicFlavouredApi<EncryptedClassification>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedClassification): EncryptedClassification =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedClassification.serializer(), config.encryption.classification)

	override suspend fun maybeDecrypt(entity: EncryptedClassification): EncryptedClassification = entity
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override suspend fun matchClassificationsBy(filter: BaseFilterOptions<Classification>): List<String> =
		rawApi.matchClassificationBy(
			mapClassificationFilterOptions(
				filter,
				null,
				null
			)
		).successBody()

	override suspend fun matchClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): List<String> =
		matchClassificationsBy(filter)

	override suspend fun filterClassificationsBy(filter: BaseFilterOptions<Classification>): PaginatedListIterator<EncryptedClassification> =
		IdsPageIterator(matchClassificationsBy(filter), ::getClassifications)

	override suspend fun filterClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): PaginatedListIterator<EncryptedClassification> =
		filterClassificationsBy(filter)
}