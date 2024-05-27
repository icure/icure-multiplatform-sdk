package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface HealthcareElementBasicFlavourlessApi {
	suspend fun matchHealthcareElementsBy(filter: AbstractFilter<HealthElement>): List<String>
	suspend fun deleteHealthcareElement(entityId: String): DocIdentifier
	suspend fun deleteHealthcareElements(entityIds: List<String>): List<DocIdentifier>
	suspend fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<IcureStub>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthcareElementBasicFlavouredApi<E : HealthElement> {
	suspend fun modifyHealthcareElement(entity: E): E
	suspend fun modifyHealthcareElements(entities: List<E>): List<E>
	suspend fun getHealthcareElement(entityId: String): E
	suspend fun getHealthcareElements(entityIds: List<String>): List<E>
	suspend fun filterHealthcareElementsBy(filterChain: FilterChain<HealthElement>, startDocumentId: String?, limit: Int?): PaginatedList<E>
	suspend fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface HealthcareElementFlavouredApi<E : HealthElement> : HealthcareElementBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
	suspend fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthcareElementApi : HealthcareElementBasicFlavourlessApi, HealthcareElementFlavouredApi<DecryptedHealthElement> {
	suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement
	suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>
	suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedHealthElement

	val encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement>
	val tryAndRecover: HealthcareElementFlavouredApi<HealthElement>
}

interface HealthcareElementBasicApi : HealthcareElementBasicFlavourlessApi, HealthcareElementBasicFlavouredApi<EncryptedHealthElement>

@InternalIcureApi
private abstract class AbstractHealthcareElementBasicFlavouredApi<E : HealthElement>(protected val rawApi: RawHealthElementApi) :
	HealthcareElementBasicFlavouredApi<E> {
	override suspend fun modifyHealthcareElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyHealthcareElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getHealthcareElement(entityId: String): E = rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getHealthcareElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterHealthcareElementsBy(filterChain: FilterChain<HealthElement>, startDocumentId: String?, limit: Int?): PaginatedList<E> =
		rawApi.filterHealthElementsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
}

@InternalIcureApi
private abstract class AbstractHealthcareElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val crypto: InternalCryptoServices,
) : AbstractHealthcareElementBasicFlavouredApi<E>(rawApi), HealthcareElementFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
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
	override suspend fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listHealthElementIdsByDataOwnerPatientOpeningDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getHealthElements(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractHealthcareElementBasicFlavourlessApi(val rawApi: RawHealthElementApi) : HealthcareElementBasicFlavourlessApi {
	override suspend fun matchHealthcareElementsBy(filter: AbstractFilter<HealthElement>) = rawApi.matchHealthElementsBy(filter).successBody()
	override suspend fun deleteHealthcareElement(entityId: String) = rawApi.deleteHealthElement(entityId).successBody()
	override suspend fun deleteHealthcareElements(entityIds: List<String>) = rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	override suspend fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()
}

@InternalIcureApi
internal class HealthcareElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
	) : HealthcareElementApi, HealthcareElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthcareElementFlavouredApi<DecryptedHealthElement>(rawApi, crypto) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedHealthElement.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi) {
	override val encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthcareElementFlavouredApi<EncryptedHealthElement>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthcareElementFlavouredApi<HealthElement> =
		object : AbstractHealthcareElementFlavouredApi<HealthElement>(rawApi, crypto) {
			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: HealthElement): EncryptedHealthElement = when (entity) {
				is EncryptedHealthElement -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedHealthElement -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedHealthElement.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }
			}
		}

	override suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedHealthElement =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedHealthElement(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedHealthElement) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedHealthElement.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	suspend fun decrypt(entity: EncryptedHealthElement, errorMessage: () -> String): DecryptedHealthElement = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedHealthElement.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class HealthcareElementBasicApiImpl(
	rawApi: RawHealthElementApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : HealthcareElementBasicApi, HealthcareElementBasicFlavouredApi<EncryptedHealthElement> by object :
	AbstractHealthcareElementBasicFlavouredApi<EncryptedHealthElement>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi)
