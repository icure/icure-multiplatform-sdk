package com.icure.sdk.api.flavoured

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.data.LabelledOccurence
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.currentFuzzyDateTime
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import com.icure.sdk.websocket.Connection
import com.icure.sdk.websocket.ConnectionImpl
import com.icure.sdk.websocket.EmittedEvent
import com.icure.sdk.websocket.Subscribable
import io.ktor.util.InternalAPI
import kotlinx.coroutines.channels.Channel
import kotlinx.datetime.TimeZone
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ContactBasicFlavourlessApi {
	suspend fun matchContactsBy(filter: AbstractFilter<Contact>): List<String>
	suspend fun matchServicesBy(filter: AbstractFilter<Service>): List<String>
	suspend fun deleteContact(entityId: String): DocIdentifier
	suspend fun deleteContacts(entityIds: List<String>): List<DocIdentifier>
	suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>

	suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ContactBasicFlavouredApi<E : Contact, S : Service> : Subscribable<Contact, E> {
	suspend fun modifyContact(entity: E): E
	suspend fun modifyContacts(entities: List<E>): List<E>
	suspend fun getContact(entityId: String): E
	suspend fun getContacts(entityIds: List<String>): List<E>
	suspend fun filterContactsBy(filterChain: FilterChain<Contact>, startDocumentId: String?, limit: Int?): PaginatedList<E>

	suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E>
	suspend fun listContactsByExternalId(externalId: String): List<E>
	suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E>
	suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E>
	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		@DefaultValue("null")
		planOfActionsIds: String? = null,
		@DefaultValue("null")
		skipClosedContacts: Boolean? = null,
	): List<E>

	suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>
	suspend fun getService(serviceId: String): S
	suspend fun getServices(entityIds: List<String>): List<S>
	suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S>
	suspend fun listServicesByAssociationId(associationId: String): List<S>
	suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S>
	suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>

	suspend fun filterServicesBy(filterChain: FilterChain<Service>, startDocumentId: String?, limit: Int?): PaginatedList<S>

	suspend fun subscribeToServiceEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Service>,
		@DefaultValue("{}")
		onConnected: suspend () -> Unit = {},
		@DefaultValue("kotlinx.coroutines.channels.Channel.BUFFERED")
		channelCapacity: Int = Channel.BUFFERED,
		@DefaultValue("2.seconds")
		retryDelay: Duration = 2.seconds,
		@DefaultValue("2.0")
		retryDelayExponentFactor: Double = 2.0,
		@DefaultValue("5")
		maxRetries: Int = 5,
		eventFired: suspend (S) -> Unit,
	): Connection
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ContactFlavouredApi<E : Contact, S : Service> : ContactBasicFlavouredApi<E, S> {
	suspend fun shareWith(
		delegateId: String,
		contact: E,
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
	 * @param contact the [Contact] to share.
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
		contact: E,
		delegates: Map<String, ContactShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param contact the [Contact] to share.
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
		contact: E,
		delegates: Map<String, ContactShareOptions>
	): E


	suspend fun findContactsByHcPartyPatient(
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
interface ContactApi : ContactBasicFlavourlessApi, ContactFlavouredApi<DecryptedContact, DecryptedService> {
	suspend fun createContact(entity: DecryptedContact): DecryptedContact
	suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact>
	suspend fun withEncryptionMetadata(
		base: DecryptedContact?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedContact
	suspend fun getEncryptionKeysOf(contact: Contact): Set<HexString>
	suspend fun hasWriteAccess(contact: Contact): Boolean
	suspend fun decryptPatientIdOf(contact: Contact): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Set<String>)

	val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService>
	val tryAndRecover: ContactFlavouredApi<Contact, Service>
}

interface ContactBasicApi : ContactBasicFlavourlessApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService>

@InternalIcureApi
private abstract class AbstractContactBasicFlavouredApi<E : Contact, S : Service>(
	protected val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) :	ContactBasicFlavouredApi<E, S> {
	override suspend fun modifyContact(entity: E): E =
		rawApi.modifyContact(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyContacts(entities: List<E>): List<E> =
		rawApi.modifyContacts(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getContact(entityId: String): E = rawApi.getContact(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getContacts(entityIds: List<String>): List<E> =
		rawApi.getContacts(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterContactsBy(
		filterChain: FilterChain<Contact>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterContactsBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E> =
		rawApi.listContactByHCPartyServiceId(hcPartyId, serviceId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByExternalId(externalId: String): List<E> =
		rawApi.listContactsByExternalId(externalId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E> =
		rawApi.listContactsByHCPartyAndFormId(hcPartyId, formId).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E> =
		rawApi.listContactsByHCPartyAndFormIds(hcPartyId, ListOfIds(formIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): List<E> =
		rawApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, secretPatientKeys, planOfActionsIds, skipClosedContacts).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.closeForHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun getService(serviceId: String): S = rawApi.getService(serviceId).successBody().let { maybeDecryptService(it) }
	override suspend fun filterServicesBy(
		filterChain: FilterChain<Service>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<S> =
		rawApi.filterServicesBy(startDocumentId, limit, filterChain).successBody().map { maybeDecryptService(it) }

	override suspend fun getServices(entityIds: List<String>): List<S> =
		rawApi.getServices(ListOfIds(entityIds)).successBody().map { maybeDecryptService(it) }

	override suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S> =
		rawApi.getServicesLinkedTo(linkType, ListOfIds(ids)).successBody().map { maybeDecryptService(it) }

	override suspend fun listServicesByAssociationId(associationId: String): List<S> =
		rawApi.listServicesByAssociationId(associationId).successBody().map { maybeDecryptService(it) }

	override suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S> =
		rawApi.listServicesByHealthElementId(healthElementId, hcPartyId).successBody().map { maybeDecryptService(it) }

	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> = rawApi.findContactsByOpeningDate(startDate, endDate, hcPartyId, startKey.encodeStartKey(), startDocumentId, limit).successBody()
		.map { maybeDecrypt(it) }

	@OptIn(InternalAPI::class)
	override suspend fun subscribeToServiceEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Service>,
		onConnected: suspend () -> Unit,
		channelCapacity: Int,
		retryDelay: Duration,
		retryDelayExponentFactor: Double,
		maxRetries: Int,
		eventFired: suspend (S) -> Unit
	): Connection {
		return ConnectionImpl.initialize(
			client = config.httpClient,
			hostname = config.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedService.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			onOpenListener = onConnected,
			retryDelay = retryDelay,
			retryDelayExponentFactor = retryDelayExponentFactor,
			maxRetries = maxRetries,
			eventCallback = { entity, onEvent ->
				try {
					eventFired(maybeDecryptService(entity))
				} catch (e: EntityEncryptionException) {
					onEvent(EmittedEvent.Error(e.message, false))
				}
			}
		)
	}

	@OptIn(InternalAPI::class)
	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Contact>,
		onConnected: suspend () -> Unit,
		channelCapacity: Int,
		retryDelay: Duration,
		retryDelayExponentFactor: Double,
		maxRetries: Int,
		eventFired: suspend (E) -> Unit
	): Connection {
		return ConnectionImpl.initialize(
			client = config.httpClient,
			hostname = config.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedContact.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Contact.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			onOpenListener = onConnected,
			retryDelay = retryDelay,
			retryDelayExponentFactor = retryDelayExponentFactor,
			maxRetries = maxRetries,
			eventCallback = { entity, onEvent ->
				try {
					eventFired(maybeDecrypt(entity))
				} catch (e: EntityEncryptionException) {
					onEvent(EmittedEvent.Error(e.message, false))
				}
			}
		)
	}

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedContact
	abstract suspend fun maybeDecrypt(entity: EncryptedContact): E
	abstract suspend fun maybeDecryptService(entity: EncryptedService): S
}

@InternalIcureApi
private abstract class AbstractContactFlavouredApi<E : Contact, S : Service>(
	rawApi: RawContactApi,
	private val config: ApiConfiguration,
) : AbstractContactBasicFlavouredApi<E, S>(rawApi, config), ContactFlavouredApi<E, S> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.contact
	protected val serviceFieldsToEncrypt get() = config.encryption.service

	override suspend fun shareWith(
		delegateId: String,
		contact: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			contact.withTypeInfo(),
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

	override suspend fun tryShareWithMany(contact: E, delegates: Map<String, ContactShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			contact.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(contact: E, delegates: Map<String, ContactShareOptions>): E =
		tryShareWithMany(contact, delegates).updatedEntityOrThrow()

	override suspend fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listContactIdsByDataOwnerPatientOpeningDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getContacts(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}
}

suspend fun JsonObject.walkCompounds(transform: suspend (JsonObject) -> JsonObject): JsonObject =
	if (this["content"]?.jsonObject?.values?.all { c -> c.jsonObject.entries.all { (k, v) -> k == "compoundValue" || v == JsonNull || (v is JsonArray && v.isEmpty()) } } == true) JsonObject(
		mapValues { (k, v) ->
			if (k == "content")
				JsonObject(
					v.jsonObject.mapValues { (_, c) ->
						JsonObject(
							c.jsonObject["compoundValue"]?.jsonArray?.let { compoundServices ->
								mapOf(
									"compoundValue" to JsonArray(
										compoundServices.map { dSvc ->
											dSvc.jsonObject.walkCompounds(transform)
										},
									),
								)
							} ?: emptyMap(),
						)
					},
				)
			else v
		},
	) else transform(this)

@OptIn(InternalIcureApi::class)
internal suspend fun DecryptedService.encrypt(jsonEncryptionService: JsonEncryptionService, contactKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>, serviceEncryptedFieldsManifest: EncryptedFieldsManifest): EncryptedService =
	Serialization.json.encodeToJsonElement<DecryptedService>(this).jsonObject
		.walkCompounds { jsonEncryptionService.encrypt(contactKey, it, serviceEncryptedFieldsManifest) }
		.let {
			Serialization.json.decodeFromJsonElement<EncryptedService>(it)
		}


@OptIn(InternalIcureApi::class)
internal suspend fun EncryptedService.validate(jsonEncryptionService: JsonEncryptionService, serviceEncryptedFieldsManifest: EncryptedFieldsManifest): EncryptedService {
	return this.also { encryptedService ->
		Serialization.json.encodeToJsonElement<EncryptedService>(encryptedService).jsonObject
			.walkCompounds {
				it.also { encryptedJson ->
					require(!jsonEncryptionService.requiresEncryption(encryptedJson, serviceEncryptedFieldsManifest)) {
						"Service ${this.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
					}
				}
			}
	}
}

@InternalIcureApi
internal fun Service.asIcureStubWithTypeInfo(): EntityWithTypeInfo<IcureStub> {
	ensure(this.delegations.isNotEmpty() || !this.securityMetadata?.secureDelegations.isNullOrEmpty()) { "The service must be include the encryption metadata to use this method. The Service gets populated with encryption metadata when it is obtained through one of the getServices, or filterServices method." }
	return EntityWithTypeInfo(
		IcureStub(
			id = id,
			rev = null,
			created = created,
			modified = modified,
			author = author,
			responsible = responsible,
			medicalLocationId = medicalLocationId,
			tags = tags,
			codes = codes,
			endOfLife = endOfLife,
			secretForeignKeys = secretForeignKeys ?: emptySet(),
			cryptedForeignKeys = cryptedForeignKeys,
			delegations = delegations,
			encryptionKeys = encryptionKeys,
			securityMetadata = securityMetadata,
		),
		EntityWithEncryptionMetadataTypeName.Contact,
	)
}

@InternalIcureApi
private class AbstractContactBasicFlavourlessApi(val rawApi: RawContactApi) : ContactBasicFlavourlessApi {
	override suspend fun matchContactsBy(filter: AbstractFilter<Contact>) = rawApi.matchContactsBy(filter).successBody()
	override suspend fun matchServicesBy(filter: AbstractFilter<Service>): List<String> = rawApi.matchServicesBy(filter).successBody()
	override suspend fun deleteContact(entityId: String) = rawApi.deleteContact(entityId).successBody()
	override suspend fun deleteContacts(entityIds: List<String>) = rawApi.deleteContacts(ListOfIds(entityIds)).successBody()
	override suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long) =
		rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()
}

@InternalIcureApi
internal class ContactApiImpl(
	private val rawApi: RawContactApi,
	private val config: ApiConfiguration,
) : ContactApi, ContactFlavouredApi<DecryptedContact, DecryptedService> by object :
	AbstractContactFlavouredApi<DecryptedContact, DecryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedContact): EncryptedContact =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedContact.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
			services = entity.services.map {
				it.encrypt(
					crypto.jsonEncryption,
					crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
						?: throw EntityEncryptionException("Cannot obtain key from contact"),
					serviceFieldsToEncrypt
				)
			}.toSet(),
		)

	override suspend fun maybeDecrypt(entity: EncryptedContact): DecryptedContact {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}

	override suspend fun maybeDecryptService(entity: EncryptedService): DecryptedService =
		try {
			crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
		} catch (e: InternalIcureException) {
			null
		}?.let { contactKey ->
			Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
				.let { crypto.jsonEncryption.decrypt(contactKey, it) }
				.let {
					Serialization.json.decodeFromJsonElement<DecryptedService>(it)
				}
		} ?: throw EntityEncryptionException("Service ${entity.id} cannot be decrypted")

}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi) {
	private val crypto get() = config.crypto

	override val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService> =
		object : AbstractContactFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedContact.serializer(), fieldsToEncrypt).copy(
					services = entity.services.map {
						it.validate(crypto.jsonEncryption, serviceFieldsToEncrypt)
					}.toSet(),
				)

			override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
			override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
		}

	override val tryAndRecover: ContactFlavouredApi<Contact, Service> =
		object : AbstractContactFlavouredApi<Contact, Service>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedContact): Contact =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedContact.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
					?: entity

			override suspend fun maybeDecryptService(entity: EncryptedService): Service = try {
				crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
			} catch (e: InternalIcureException) {
				null
			}?.let { contactKey ->
				Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
					.let { crypto.jsonEncryption.decrypt(contactKey, it) }
					.let {
						Serialization.json.decodeFromJsonElement<DecryptedService>(it)
					}
			} ?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Contact): EncryptedContact = when (entity) {
				is EncryptedContact -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedContact.serializer(),
					fieldsToEncrypt,
				).copy(
					services = entity.services.map {
						it.validate(crypto.jsonEncryption, serviceFieldsToEncrypt)
					}.toSet(),
				)

				is DecryptedContact -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedContact.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
					services = entity.services.map {
						it.encrypt(
							crypto.jsonEncryption,
							crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
								?: throw EntityEncryptionException("Cannot obtain key from contact"),
							serviceFieldsToEncrypt
						)
					}.toSet(),
				)
			}
		}

	override suspend fun createContact(entity: DecryptedContact): DecryptedContact {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContact(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContacts(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedContact?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedContact =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedContact(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				openingDate = base?.openingDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
				groupId = base?.groupId ?: base?.id,
				).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(contact: Contact): Set<HexString> = crypto.entity.encryptionKeysOf(contact.withTypeInfo(), null)

	override suspend fun hasWriteAccess(contact: Contact): Boolean = crypto.entity.hasWriteAccess(contact.withTypeInfo())

	override suspend fun decryptPatientIdOf(contact: Contact): Set<String> = crypto.entity.owningEntityIdsOf(contact.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedContact) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedContact.serializer(),
		config.encryption.contact,
	) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
		services = entity.services.map {
			it.encrypt(
				crypto.jsonEncryption,
				crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
					?: throw EntityEncryptionException("Cannot obtain key from contact"),
				config.encryption.service
			)
		}.toSet(),
	)

	suspend fun decrypt(entity: EncryptedContact, errorMessage: () -> String): DecryptedContact = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedContact.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
		?: throw EntityEncryptionException(errorMessage())
}

@InternalIcureApi
internal class ContactBasicApiImpl(
	rawApi: RawContactApi,
	config: BasicApiConfiguration
) : ContactBasicApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService> by object :
	AbstractContactBasicFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedContact.serializer(), config.encryption.contact).copy(
			services = entity.services.map {
				it.validate(config.crypto.jsonEncryption, config.encryption.service)
			}.toSet(),
		)

	override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
	override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi)
