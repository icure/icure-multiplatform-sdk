package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
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
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Classification.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ClassificationBasicFlavourlessApi {
	suspend fun deleteClassification(entityId: String): DocIdentifier
	suspend fun deleteClassifications(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ClassificationBasicFlavouredApi<E : Classification> {
	suspend fun modifyClassification(entity: E): E
	suspend fun getClassification(entityId: String): E
	suspend fun findClassificationsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
	suspend fun getClassificationByHcPartyId(ids: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ClassificationFlavouredApi<E : Classification> : ClassificationBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): List<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ClassificationApi : ClassificationBasicFlavourlessApi, ClassificationFlavouredApi<DecryptedClassification> {
	suspend fun createClassification(entity: DecryptedClassification): DecryptedClassification
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedClassification,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedClassification

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

	//TODO: Check method name
	override suspend fun getClassificationByHcPartyId(ids: String): List<E> =
		rawApi.getClassificationByHcPartyId(ids).successBody().map { maybeDecrypt(it) }

	override suspend fun findClassificationsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findClassificationsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedClassification
	abstract suspend fun maybeDecrypt(entity: EncryptedClassification): E
}

@InternalIcureApi
private abstract class AbstractClassificationFlavouredApi<E : Classification>(
	rawApi: RawClassificationApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractClassificationBasicFlavouredApi<E>(rawApi), ClassificationFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			healthcareElement.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = null,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): List<E> = rawApi.findClassificationsByHCPartyPatientForeignKeys(
		hcPartyId,
		encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList().joinToString(","),
	).successBody().map { maybeDecrypt(it) }


}

@InternalIcureApi
private class AbstractClassificationBasicFlavourlessApi(val rawApi: RawClassificationApi) : ClassificationBasicFlavourlessApi {
	override suspend fun deleteClassification(entityId: String) = rawApi.deleteClassification(entityId).successBody()
	override suspend fun deleteClassifications(entityIds: List<String>) = rawApi.deleteClassifications(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class ClassificationApiImpl(
	private val rawApi: RawClassificationApi,
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ClassificationApi, ClassificationFlavouredApi<DecryptedClassification> by object :
	AbstractClassificationFlavouredApi<DecryptedClassification>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedClassification): EncryptedClassification =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedClassification.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedClassification): DecryptedClassification {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override val encrypted: ClassificationFlavouredApi<EncryptedClassification> =
		object : AbstractClassificationFlavouredApi<EncryptedClassification>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedClassification): EncryptedClassification =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedClassification.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedClassification): EncryptedClassification = entity
		}

	override val tryAndRecover: ClassificationFlavouredApi<Classification> =
		object : AbstractClassificationFlavouredApi<Classification>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedClassification): Classification =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedClassification.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Classification): EncryptedClassification = when (entity) {
				is EncryptedClassification -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedClassification.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedClassification -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedClassification.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }
			}
		}

	override suspend fun createClassification(entity: DecryptedClassification): DecryptedClassification {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createClassification(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedClassification,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedClassification =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			healthcareElement.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (
				(user.autoDelegations[DelegationTag.MedicalInformation] ?: emptySet()) +
					(user.autoDelegations[DelegationTag.All] ?: emptySet())
				).associateWith { AccessLevel.Write },
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedClassification) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedClassification.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }

	suspend fun decrypt(entity: EncryptedClassification, errorMessage: () -> String): DecryptedClassification = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedClassification.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class ClassificationBasicApiImpl(
	rawApi: RawClassificationApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ClassificationBasicApi, ClassificationBasicFlavouredApi<EncryptedClassification> by object :
	AbstractClassificationBasicFlavouredApi<EncryptedClassification>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedClassification): EncryptedClassification =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedClassification.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedClassification): EncryptedClassification = entity
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi)
