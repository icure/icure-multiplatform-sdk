package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.ClassificationShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
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
	/**
	 * Deletes a classification. If you don't have write access to the classification the method will fail.
	 * @param entityId id of the classification.
	 * @return the id and revision of the deleted classification.
	 */
	suspend fun deleteClassification(entityId: String): DocIdentifier

	/**
	 * Deletes many classifications. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the classifications.
	 * @return the id and revision of the deleted classifications. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteClassifications(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ClassificationBasicFlavouredApi<E : Classification> {
	/**
	 * Modifies a classification. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a classification with update content
	 * @return the classification updated with the provided content and a new revision.
	 */
	suspend fun modifyClassification(entity: E): E

	/**
	 * Get a classification by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a classification, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a classification id.
	 * @return the classification with id [entityId].
	 */
	suspend fun getClassification(entityId: String): E

	/**
	 * Get multiple classifications by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a classification, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of classifications ids
	 * @return all classifications that you can access with one of the provided ids.
	 */
	suspend fun getClassifications(entityIds: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ClassificationFlavouredApi<E : Classification> : ClassificationBasicFlavouredApi<E> {
	/**
	 * Share a classification with another data owner. The classification must already exist in the database for this method to
	 * succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the classification
	 * @param classification the classification to share with [delegateId]
	 * @param options specifies how the classification will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the classification. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated classification if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		classification: E,
		@DefaultValue("null")
		options: ClassificationShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a classification with multiple data owners. The classification must already exist in the database for this method to
	 * succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param classification the classification to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated classification if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		classification: E,
		delegates: Map<String, ClassificationShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a classification with multiple data owners. The classification must already exist in the database for this method to
	 * succeed. If you want to share the classification before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param classification the classification to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated classification.
	 */
	suspend fun shareWithMany(
		classification: E,
		delegates: Map<String, ClassificationShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
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
	/**
	 * Create a new classification. The provided classification must have the encryption metadata initialised.
	 * @param entity a classification with initialised encryption metadata
	 * @return the created classification with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createClassification(entity: DecryptedClassification): DecryptedClassification

	/**
	 * Creates a new classification with initialised encryption metadata
	 * @param base a classification with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the classification.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new classification
	 * @return a classification with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
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

	/**
	 * Attempts to extract the encryption keys of a classification. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param classification a classification
	 * @return the encryption keys extracted from the provided classification.
	 */
	suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString>

	/**
	 * Specifies if the current user has write access to a classification.
	 * @param classification a classification
	 * @return if the current user has write access to the provided classification
	 */
	suspend fun hasWriteAccess(classification: Classification): Boolean

	/**
	 * Attempts to extract the patient id linked to a classification.
	 * Note: classifications usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param classification a classification
	 * @return the id of the patient linked to the classification, or empty if the current user can't access any patient id
	 * of the classification.
	 */
	suspend fun decryptPatientIdOf(classification: Classification): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a classification.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided classification. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the classification the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Classification,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a classification E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any classification that you have shared with P, H will be able to know that the classification was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a classification that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a classification
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>)

	/**
	 * Decrypts a classification, throwing an exception if it is not possible.
	 * @param classification a classification
	 * @return the decrypted classification
	 * @throws EntityEncryptionException if the classification could not be decrypted
	 */
	suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification

	/**
	 * Tries to decrypt a classification, returns the input if it is not possible.
	 * @param classification an encrypted classification
	 * @return the decrypted classification if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(classification: EncryptedClassification): Classification

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: ClassificationFlavouredApi<EncryptedClassification>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
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
		options: ClassificationShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			classification.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: ClassificationShareOptions()),
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

	@Deprecated("Will be replaced by filter")
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
