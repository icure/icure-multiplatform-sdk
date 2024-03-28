package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedIcureStub
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface HealthElementBasicFlavourlessApi {
	suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): List<String>
	suspend fun deleteHealthElement(entityId: String): DocIdentifier
	suspend fun deleteHealthElements(entityIds: List<String>): List<DocIdentifier>
	suspend fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<EncryptedIcureStub>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthElementBasicFlavouredApi<E : HealthElement> {
	suspend fun modifyHealthElement(entity: E): E
	suspend fun modifyHealthElements(entities: List<E>): List<E>
	suspend fun getHealthElement(entityId: String): E
	suspend fun getHealthElements(entityIds: List<String>): List<E>
	suspend fun filterHealthElementsBy(filterChain: FilterChain<HealthElement>, startDocumentId: String?, limit: Int?): PaginatedList<E, *>
	suspend fun findHealthElementsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E, *>
	suspend fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthElementFlavouredApi<E : HealthElement> : HealthElementBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthElementApi : HealthElementBasicFlavourlessApi, HealthElementFlavouredApi<DecryptedHealthElement> {
	suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement
	suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedHealthElement,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedHealthElement
	suspend fun findHealthElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): List<DecryptedHealthElement>

	val encrypted: HealthElementFlavouredApi<EncryptedHealthElement>
	val tryAndRecover: HealthElementFlavouredApi<HealthElement>
}

interface HealthElementBasicApi : HealthElementBasicFlavourlessApi, HealthElementBasicFlavouredApi<EncryptedHealthElement>

@InternalIcureApi
private abstract class AbstractHealthElementBasicFlavouredApi<E : HealthElement>(protected val rawApi: RawHealthElementApi) :
	HealthElementBasicFlavouredApi<E> {
	override suspend fun modifyHealthElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyHealthElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getHealthElement(entityId: String): E = rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getHealthElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterHealthElementsBy(filterChain: FilterChain<HealthElement>, startDocumentId: String?, limit: Int?): PaginatedList<E, *> =
		rawApi.filterHealthElementsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findHealthElementsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E, *> =
		rawApi.findHealthElementsByHCPartyPatientForeignKey(hcPartyId, secretPatientKey, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
}

@InternalIcureApi
private abstract class AbstractHealthElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractHealthElementBasicFlavouredApi<E>(rawApi), HealthElementFlavouredApi<E> {
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
}

@InternalIcureApi
private class AbstractHealthElementBasicFlavourlessApi(val rawApi: RawHealthElementApi) : HealthElementBasicFlavourlessApi {
	override suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>) = rawApi.matchHealthElementsBy(filter).successBody()
	override suspend fun deleteHealthElement(entityId: String) = rawApi.deleteHealthElement(entityId).successBody()
	override suspend fun deleteHealthElements(entityIds: List<String>) = rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	override suspend fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()
}

@InternalIcureApi
internal class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : HealthElementApi, HealthElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthElementFlavouredApi<DecryptedHealthElement>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedHealthElement.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			HealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created")
	}
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi) {
	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> =
		object : AbstractHealthElementFlavouredApi<HealthElement>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					HealthElement.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: HealthElement): EncryptedHealthElement = when (entity) {
				is EncryptedHealthElement -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedHealthElement -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedHealthElement.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }
			}
		}

	override suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedHealthElement,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedHealthElement =
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

	override suspend fun findHealthElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): List<DecryptedHealthElement> = rawApi.findHealthElementsByHCPartyPatientForeignKeys(
		hcPartyId,
		encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList()
	).successBody().map { decrypt(it) { "Found healthcare element cannot be decrypted"} }

	private suspend fun encrypt(entity: DecryptedHealthElement) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedHealthElement.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	suspend fun decrypt(entity: EncryptedHealthElement, errorMessage: () -> String): DecryptedHealthElement = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		HealthElement.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
		?: throw EntityDecryptionException(errorMessage())

}

@InternalIcureApi
internal class HealthElementBasicApiImpl(
	rawApi: RawHealthElementApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : HealthElementBasicApi, HealthElementBasicFlavouredApi<EncryptedHealthElement> by object :
	AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi)