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
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.websocket.Connection
import com.icure.sdk.websocket.ConnectionImpl
import com.icure.sdk.websocket.Subscribable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface HealthcareElementBasicFlavourlessApi {
	suspend fun matchHealthcareElementsBy(filter: AbstractFilter<EncryptedHealthElement>): List<String>
	suspend fun deleteHealthcareElement(entityId: String): DocIdentifier
	suspend fun deleteHealthcareElements(entityIds: List<String>): List<DocIdentifier>
	suspend fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface HealthcareElementBasicFlavouredApi<E : HealthElement> : Subscribable<HealthElement, E> {
	suspend fun modifyHealthcareElement(entity: E): E
	suspend fun modifyHealthcareElements(entities: List<E>): List<E>
	suspend fun getHealthcareElement(entityId: String): E
	suspend fun getHealthcareElements(entityIds: List<String>): List<E>
	suspend fun filterHealthcareElementsBy(
		filterChain: FilterChain<EncryptedHealthElement>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>
	suspend fun findHealthcareElementsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E>
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
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): List<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface HealthcareElementApi : HealthcareElementBasicFlavourlessApi, HealthcareElementFlavouredApi<DecryptedHealthElement> {
	suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement
	suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement>
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedHealthElement,
		patient: Patient,
		user: User,
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

	override suspend fun getHealthcareElement(entityId: String): E =
		rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthcareElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterHealthcareElementsBy(
		filterChain: FilterChain<EncryptedHealthElement>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterHealthElementsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findHealthcareElementsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKey(hcPartyId, secretPatientKey, startKey.encodeStartKey(), startDocumentId, limit).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
	abstract suspend fun tryMaybeDecrypt(entity: EncryptedHealthElement): E?

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<HealthElement>,
		eventFired: suspend (E) -> Unit,
	): Connection {
		return ConnectionImpl(
			hostname = this.rawApi.apiUrl,
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = filter,
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			channelCallback = { queue ->
				for (x in queue) {
					eventFired(maybeDecrypt(x))
				}
			}
		)
	}
}


@InternalIcureApi
private abstract class AbstractHealthcareElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val encryptionService: EntityEncryptionService,
) : AbstractHealthcareElementBasicFlavouredApi<E>(rawApi), HealthcareElementFlavouredApi<E> {
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
	override suspend fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): List<E> = rawApi.findHealthElementsByHCPartyPatientForeignKeys(
		hcPartyId,
		encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList()
	).successBody().map { maybeDecrypt(it) }

}

@InternalIcureApi
private class AbstractHealthcareElementBasicFlavourlessApi(val rawApi: RawHealthElementApi) : HealthcareElementBasicFlavourlessApi {
	override suspend fun matchHealthcareElementsBy(filter: AbstractFilter<EncryptedHealthElement>) =
		rawApi.matchHealthElementsBy(filter).successBody()

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
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : HealthcareElementApi, HealthcareElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthcareElementFlavouredApi<DecryptedHealthElement>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedHealthElement.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
		return tryMaybeDecrypt(entity)
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created") //TODO: "decrypted" instead of "created"?
	}

	override suspend fun tryMaybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement? {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi) {

	override val encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthcareElementFlavouredApi<EncryptedHealthElement>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
			override suspend fun tryMaybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthcareElementFlavouredApi<HealthElement> =
		object : AbstractHealthcareElementFlavouredApi<HealthElement>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				tryMaybeDecrypt(entity)


			override suspend fun tryMaybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
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

	override suspend fun createHealthcareElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createHealthcareElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
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

	private suspend fun encrypt(entity: DecryptedHealthElement) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedHealthElement.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	suspend fun decrypt(entity: EncryptedHealthElement, errorMessage: () -> String): DecryptedHealthElement =
		encryptionService.tryDecryptEntity(
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
	override suspend fun tryMaybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthcareElementBasicFlavourlessApi by AbstractHealthcareElementBasicFlavourlessApi(rawApi)
