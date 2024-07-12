package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.crypto.entities.ClassificationShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Classification
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ClassificationBasicFlavourlessApi {
	suspend fun deleteClassification(entityId: String): DocIdentifier
	suspend fun deleteClassifications(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ClassificationBasicFlavouredApi<E : Classification> {
	suspend fun modifyClassification(entity: E): E
	suspend fun getClassification(entityId: String): E
	suspend fun getClassifications(entityIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ClassificationFlavouredApi<E : Classification> : ClassificationBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		classification: E,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param classification the [Classification] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the [SimpleShareResult] of the operation: the updated entity if the operation was successful or details of the error if
	 * the operation failed.
	 */
	suspend fun tryShareWithMany(
		classification: E,
		delegates: Map<String, ClassificationShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param classification the [Classification]
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the updated entity.
	 * @throws IllegalStateException if the operation was not successful.
	 */
	suspend fun shareWithMany(
		classification: E,
		delegates: Map<String, ClassificationShareOptions>
	): E


	suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ClassificationApi : ClassificationBasicFlavourlessApi, ClassificationFlavouredApi<DecryptedClassification> {
	suspend fun createClassification(entity: DecryptedClassification): DecryptedClassification
	suspend fun withEncryptionMetadata(
		base: DecryptedClassification?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedClassification
	suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString>
	suspend fun hasWriteAccess(classification: Classification): Boolean
	suspend fun decryptPatientIdOf(classification: Classification): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>)
	suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification
	suspend fun tryDecrypt(classification: EncryptedClassification): Classification

	val encrypted: ClassificationFlavouredApi<EncryptedClassification>
	val tryAndRecover: ClassificationFlavouredApi<Classification>
}

interface ClassificationBasicApi : ClassificationBasicFlavourlessApi, ClassificationBasicFlavouredApi<EncryptedClassification>

@InternalIcureApi
private abstract class AbstractClassificationBasicFlavouredApi<E : Classification>(protected val rawApi: RawClassificationApi) :
	ClassificationBasicFlavouredApi<E> {
	override suspend fun modifyClassification(entity: E): E =
		rawApi.modifyClassification(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


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
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			classification.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptionsImpl(
					shareSecretIds = null,
					shareEncryptionKey = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(classification: E, delegates: Map<String, ClassificationShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			classification.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(classification: E, delegates: Map<String, ClassificationShareOptions>): E =
		tryShareWithMany(classification, delegates).updatedEntityOrThrow()

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

}

@InternalIcureApi
private class AbstractClassificationBasicFlavourlessApi(val rawApi: RawClassificationApi) : ClassificationBasicFlavourlessApi {
	override suspend fun deleteClassification(entityId: String) = rawApi.deleteClassification(entityId).successBody()
	override suspend fun deleteClassifications(entityIds: List<String>) = rawApi.deleteClassifications(ListOfIds(entityIds)).successBody()
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
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }
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
				) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
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
		secretId: SecretIdOption,
	): DecryptedClassification =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedClassification(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
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
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }

	override suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification =
		decryptOrNull(classification) ?: throw EntityEncryptionException("Classification cannot be decrypted")

	override suspend fun tryDecrypt(classification: EncryptedClassification): Classification =
		decryptOrNull(classification) ?: classification
}

@InternalIcureApi
internal class ClassificationBasicApiImpl(
	rawApi: RawClassificationApi,
	private val config: BasicApiConfiguration,
) : ClassificationBasicApi, ClassificationBasicFlavouredApi<EncryptedClassification> by object :
	AbstractClassificationBasicFlavouredApi<EncryptedClassification>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedClassification): EncryptedClassification =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedClassification.serializer(), config.encryption.classification)

	override suspend fun maybeDecrypt(entity: EncryptedClassification): EncryptedClassification = entity
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi)
