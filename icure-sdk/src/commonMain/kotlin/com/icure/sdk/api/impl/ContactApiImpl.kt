package com.icure.sdk.api.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.ContactApi
import com.icure.sdk.api.ContactBasicApi
import com.icure.sdk.api.ContactBasicFlavouredApi
import com.icure.sdk.api.ContactBasicFlavourlessApi
import com.icure.sdk.api.ContactFlavouredApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.filters.mapContactFilterOptions
import com.icure.sdk.filters.mapServiceFilterOptions
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.options.JsonPatcher
import com.icure.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.currentFuzzyDateTime
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.ensureNonNull
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import com.icure.sdk.utils.pagination.encodeStartKey
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
private abstract class AbstractContactBasicFlavouredApi<E : Contact, S : Service>(
	protected val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) : ContactBasicFlavouredApi<E, S> {
	override suspend fun modifyContact(entity: E): E =
		rawApi.modifyContact(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyContacts(entities: List<E>): List<E> =
		rawApi.modifyContacts(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getContact(entityId: String): E = rawApi.getContact(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getContacts(entityIds: List<String>): List<E> =
		rawApi.getContacts(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E> =
		rawApi.listContactByHCPartyServiceId(hcPartyId, serviceId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listContactsByExternalId(externalId: String): List<E> =
		rawApi.listContactsByExternalId(externalId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E> =
		rawApi.listContactsByHCPartyAndFormId(hcPartyId, formId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E> =
		rawApi.listContactsByHCPartyAndFormIds(hcPartyId, ListOfIds(formIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): List<E> =
		rawApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, secretPatientKeys, planOfActionsIds, skipClosedContacts).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun getService(serviceId: String): S = rawApi.getService(serviceId).successBody().let { maybeDecryptService(it) }

	override suspend fun getServices(entityIds: List<String>): List<S> =
		rawApi.getServices(ListOfIds(entityIds)).successBody().map { maybeDecryptService(it) }

	@Deprecated("Use filter instead")
	override suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S> =
		rawApi.getServicesLinkedTo(linkType, ListOfIds(ids)).successBody().map { maybeDecryptService(it) }

	@Deprecated("Use filter instead")
	override suspend fun listServicesByAssociationId(associationId: String): List<S> =
		rawApi.listServicesByAssociationId(associationId).successBody().map { maybeDecryptService(it) }

	@Deprecated("Use filter instead")
	override suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S> =
		rawApi.listServicesByHealthElementId(healthElementId, hcPartyId).successBody().map { maybeDecryptService(it) }

	@Deprecated(
		"Find methods are deprecated",
		replaceWith = ReplaceWith(
			"filterContactsBy(ContactByHcPartyTagCodeDateFilter(healthcarePartyId = hcPartyId, startOfContactOpeningDate = startDate, endOfContactOpeningDate = endDate))",
			"com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter"
		)
	)
	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> = rawApi.findContactsByOpeningDate(startDate, endDate, hcPartyId, startKey.encodeStartKey(), startDocumentId, limit).successBody()
		.map { maybeDecrypt(it) }

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
		options: ContactShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			contact.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: ContactShareOptions()),
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

	@Deprecated("Use filter instead")
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

	override suspend fun filterContactsBy(filter: FilterOptions<Contact>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchContactsBy(
				mapContactFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)
			).successBody(),
			this::getContacts
		)

	override suspend fun filterServicesBy(filter: FilterOptions<Service>): PaginatedListIterator<S> =
		IdsPageIterator(
			rawApi.matchServicesBy(
				mapServiceFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)
			).successBody(),
			this::getServices
		)

	override suspend fun filterContactsBySorted(filter: SortableFilterOptions<Contact>): PaginatedListIterator<E> =
		filterContactsBy(filter)

	override suspend fun filterServicesBySorted(filter: SortableFilterOptions<Service>): PaginatedListIterator<S> =
		filterServicesBy(filter)
}

private fun Service.hasOnlyCompoundContent() =
	content.values.all {
		it.isCompound()
	}

@InternalIcureApi
private suspend fun DecryptedService.encrypt(
	config: ApiConfiguration,
	contactKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	serviceEncryptedFieldsManifest: EncryptedFieldsManifest
): EncryptedService =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			serviceEncryptedFieldsManifest
		).let {
			Serialization.json.decodeFromJsonElement<EncryptedService>(it)
		}.copy(
			content = content.mapValues { (_, compoundContent) ->
				EncryptedContent(
					compoundValue = ensureNonNull(compoundContent.compoundValue) {
						"Compound value can't be null on a only-compound compound content"
					}.map {
						it.encrypt(config, contactKey, serviceEncryptedFieldsManifest)
					}
				)
			}
		)
	} else {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			serviceEncryptedFieldsManifest.copy(topLevelFields = serviceEncryptedFieldsManifest.topLevelFields + "content")
		).let {
			Serialization.json.decodeFromJsonElement(it)
		}
	}


@InternalIcureApi
private fun EncryptedService.requiresEncryption(
	config: BasicApiConfiguration,
	serviceEncryptedFieldsManifest: EncryptedFieldsManifest
): Boolean =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			serviceEncryptedFieldsManifest
		) || content.values.any { compoundContent ->
			ensureNonNull(compoundContent.compoundValue) {
				"Compound value can't be null on a only-compound compound content"
			}.any {
				it.requiresEncryption(config, serviceEncryptedFieldsManifest)
			}
		}
	} else {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			serviceEncryptedFieldsManifest.copy(topLevelFields = serviceEncryptedFieldsManifest.topLevelFields + "content")
		)
	}

@InternalIcureApi
private suspend fun DecryptedContact.encrypt(
	config: ApiConfiguration,
	contactEncryptedFieldsManifest: EncryptedFieldsManifest,
	serviceEncryptedFieldsManifest: EncryptedFieldsManifest
): EncryptedContact =
	config.crypto.entity.encryptEntity(
		this.withTypeInfo(),
		DecryptedContact.serializer(),
		contactEncryptedFieldsManifest,
	) { Serialization.json.decodeFromJsonElement<EncryptedContact>(it) }.copy(
		services = this.services.map {
			it.encrypt(
				config,
				config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(this.withTypeInfo())?.key
					?: throw EntityEncryptionException("Cannot obtain key from contact"),
				serviceEncryptedFieldsManifest
			)
		}.toSet(),
	)

@InternalIcureApi
private suspend fun EncryptedContact.validateEncrypted(
	config: BasicApiConfiguration,
	contactEncryptedFieldsManifest: EncryptedFieldsManifest,
	serviceEncryptedFieldsManifest: EncryptedFieldsManifest
) {
	config.crypto.validationService.validateEncryptedEntity(
		this.withTypeInfo(),
		EncryptedContact.serializer(),
		contactEncryptedFieldsManifest
	)
	services.forEach {
		if (it.requiresEncryption(config, serviceEncryptedFieldsManifest)) {
			throw EntityEncryptionException("Service ${it.id} in contact ${this.id} is not properly encrypted according to the manifest")
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
private class AbstractContactBasicFlavourlessApi(
	val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) : ContactBasicFlavourlessApi {
	override suspend fun deleteContact(entityId: String) = rawApi.deleteContact(entityId).successBody()
	override suspend fun deleteContacts(entityIds: List<String>) = rawApi.deleteContacts(ListOfIds(entityIds)).successBody()
	@Deprecated("Use filter instead")
	override suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long) =
		rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()
}

@InternalIcureApi
private suspend fun decryptServiceOrNull(entity: EncryptedService, crypto: InternalCryptoServices, jsonPatcher: JsonPatcher): DecryptedService? = try {
	crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
} catch (e: InternalIcureException) {
	null
}?.let { contactKey ->
	Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
		.let { crypto.jsonEncryption.decrypt(contactKey, it) }
		.let {
			Serialization.json.decodeFromJsonElement<DecryptedService>(jsonPatcher.patchIndividualService(it))
		}
}

@InternalIcureApi
internal class ContactApiImpl(
	private val rawApi: RawContactApi,
	private val config: ApiConfiguration,
) : ContactApi, ContactFlavouredApi<DecryptedContact, DecryptedService> by object :
	AbstractContactFlavouredApi<DecryptedContact, DecryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedContact): EncryptedContact =
		entity.encrypt(config, fieldsToEncrypt, serviceFieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedContact): DecryptedContact {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}

	override suspend fun maybeDecryptService(entity: EncryptedService): DecryptedService =
		decryptServiceOrNull(entity, crypto, config.jsonPatcher)
			?: throw EntityEncryptionException("Service ${entity.id} cannot be decrypted")

}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi, config) {
	private val crypto get() = config.crypto

	override val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService> =
		object : AbstractContactFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
				entity.also { it.validateEncrypted(config, fieldsToEncrypt, serviceFieldsToEncrypt) }

			override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
			override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
		}

	override val tryAndRecover: ContactFlavouredApi<Contact, Service> =
		object : AbstractContactFlavouredApi<Contact, Service>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedContact): Contact =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedContact.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }
					?: entity

			override suspend fun maybeDecryptService(entity: EncryptedService): Service =
				decryptServiceOrNull(entity, crypto, config.jsonPatcher) ?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Contact): EncryptedContact = when (entity) {
				is EncryptedContact -> entity.also { it.validateEncrypted(config, fieldsToEncrypt, serviceFieldsToEncrypt) }

				is DecryptedContact -> entity.encrypt(config, fieldsToEncrypt, serviceFieldsToEncrypt)
			}
		}

	override suspend fun createContact(entity: DecryptedContact): DecryptedContact {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContact(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContacts(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it)
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
		crypto.entity.entityWithInitializedEncryptedMetadata(
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
			initializeEncryptionKey = true,
			initializeSecretId = false,
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
				config,
				crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.withTypeInfo())?.key
					?: throw EntityEncryptionException("Cannot obtain key from contact"),
				config.encryption.service
			)
		}.toSet(),
	)

	private suspend fun decryptOrNull(entity: EncryptedContact): DecryptedContact? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedContact.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }

	override suspend fun decrypt(contact: EncryptedContact): DecryptedContact =
		decryptOrNull(contact) ?: throw EntityEncryptionException("Contact cannot be decrypted")

	override suspend fun tryDecrypt(contact: EncryptedContact): Contact =
		decryptOrNull(contact) ?: contact

	override suspend fun decryptService(service: EncryptedService): DecryptedService =
		decryptServiceOrNull(service, crypto, config.jsonPatcher) ?: throw EntityEncryptionException("Service cannot be decrypted")

	override suspend fun tryDecryptService(service: EncryptedService): Service =
		decryptServiceOrNull(service, crypto, config.jsonPatcher) ?: service

	override suspend fun matchContactsBy(filter: FilterOptions<Contact>): List<String> =
		rawApi.matchContactsBy(
			mapContactFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)
		).successBody()

	override suspend fun matchServicesBy(filter: FilterOptions<Service>): List<String> =
		rawApi.matchServicesBy(
			mapServiceFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)
		).successBody()

	override suspend fun matchContactsBySorted(filter: SortableFilterOptions<Contact>): List<String> =
		matchContactsBy(filter)

	override suspend fun matchServicesBySorted(filter: SortableFilterOptions<Service>): List<String> =
		matchServicesBy(filter)


	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: FilterOptions<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedService.serializer(),
			events = setOf(SubscriptionEventType.Create, SubscriptionEventType.Update),
			filter = mapServiceFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity),
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ServiceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Contact>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedContact> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedContact.serializer(),
			events = events,
			filter = mapContactFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity),
			qualifiedName = Contact.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ContactAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class ContactBasicApiImpl(
	private val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) : ContactBasicApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService> by object :
	AbstractContactBasicFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
		entity.also { it.validateEncrypted(config, config.encryption.contact, config.encryption.service) }

	override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
	override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi, config) {

	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: BaseFilterOptions<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedService.serializer(),
			events = setOf(SubscriptionEventType.Create, SubscriptionEventType.Update),
			filter = mapServiceFilterOptions(filter, null, null),
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ServiceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Contact>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedContact> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedContact.serializer(),
			events = events,
			filter = mapContactFilterOptions(filter, null, null),
			qualifiedName = Contact.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ContactAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun matchContactsBy(filter: BaseFilterOptions<Contact>): List<String> =
		rawApi.matchContactsBy(
			mapContactFilterOptions(filter, null, null)
		).successBody()

	override suspend fun matchServicesBy(filter: BaseFilterOptions<Service>): List<String> =
		rawApi.matchServicesBy(
			mapServiceFilterOptions(filter, null, null)
		).successBody()

	override suspend fun matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): List<String> =
		matchContactsBy(filter)

	override suspend fun matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): List<String> =
		matchServicesBy(filter)

	override suspend fun filterContactsBy(filter: BaseFilterOptions<Contact>): PaginatedListIterator<EncryptedContact> =
		IdsPageIterator(
			matchContactsBy(filter),
			this::getContacts
		)

	override suspend fun filterServicesBy(filter: BaseFilterOptions<Service>): PaginatedListIterator<EncryptedService> =
		IdsPageIterator(
			matchServicesBy(filter),
			this::getServices
		)

	override suspend fun filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): PaginatedListIterator<EncryptedContact> =
		filterContactsBy(filter)

	override suspend fun filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): PaginatedListIterator<EncryptedService> =
		filterServicesBy(filter)
}
