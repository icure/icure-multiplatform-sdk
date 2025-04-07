package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.api.ContactBasicApi
import com.icure.cardinal.sdk.api.ContactBasicFlavouredApi
import com.icure.cardinal.sdk.api.ContactBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ContactFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.decrypt
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapContactFilterOptions
import com.icure.cardinal.sdk.filters.mapServiceFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.data.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.currentFuzzyDateTime
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
private abstract class AbstractContactBasicFlavouredApi<E : Contact, S : Service>(
	protected val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) : ContactBasicFlavouredApi<E, S>, FlavouredApi<EncryptedContact, E> {
	override suspend fun undeleteContactById(id: String, rev: String): E =
		rawApi.undeleteContact(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyContact(entity: E): E =
		rawApi.modifyContact(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyContacts(entities: List<E>): List<E> =
		maybeDecrypt(rawApi.modifyContacts(validateAndMaybeEncrypt(entities)).successBody())

	override suspend fun getContact(entityId: String): E =
		rawApi.getContact(entityId).successBody().let { maybeDecrypt(null, it) }
	override suspend fun getContacts(entityIds: List<String>): List<E> =
		maybeDecrypt(rawApi.getContacts(ListOfIds(entityIds)).successBody())

	@Deprecated("Use filter instead")
	override suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E> =
		maybeDecrypt(rawApi.listContactByHCPartyServiceId(hcPartyId, serviceId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun listContactsByExternalId(externalId: String): List<E> =
		maybeDecrypt(rawApi.listContactsByExternalId(externalId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E> =
		maybeDecrypt(rawApi.listContactsByHCPartyAndFormId(hcPartyId, formId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E> =
		maybeDecrypt(rawApi.listContactsByHCPartyAndFormIds(hcPartyId, ListOfIds(formIds)).successBody())

	override suspend fun getService(serviceId: String): S =
		rawApi.getService(serviceId).successBody().let { maybeDecryptServices(null, listOf(it)).single() }

	override suspend fun getServices(entityIds: List<String>): List<S> =
		rawApi.getServices(ListOfIds(entityIds)).successBody().let { maybeDecryptServices(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S> =
		rawApi.getServicesLinkedTo(linkType, ListOfIds(ids)).successBody().let { maybeDecryptServices(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun listServicesByAssociationId(associationId: String): List<S> =
		rawApi.listServicesByAssociationId(associationId).successBody().let { maybeDecryptServices(null, it) }

	@Deprecated("Use filter instead")
	override suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S> =
		rawApi.listServicesByHealthElementId(healthElementId, hcPartyId).successBody().let { maybeDecryptServices(null, it) }

	@Deprecated(
		"Find methods are deprecated",
		replaceWith = ReplaceWith(
			"filterContactsBy(ContactByHcPartyTagCodeDateFilter(healthcarePartyId = hcPartyId, startOfContactOpeningDate = startDate, endOfContactOpeningDate = endDate))",
			"com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter"
		)
	)
	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> = maybeDecrypt(rawApi.findContactsByOpeningDate(startDate, endDate, hcPartyId, startKey.encodeStartKey(), startDocumentId, limit).successBody())

	abstract suspend fun maybeDecryptServices(entitiesGroupId: String?, entities: List<EncryptedService>): List<S>
}

@InternalIcureApi
private abstract class AbstractContactFlavouredApi<E : Contact, S : Service>(
	rawApi: RawContactApi,
	protected val config: ApiConfiguration,
) : AbstractContactBasicFlavouredApi<E, S>(rawApi, config), ContactFlavouredApi<E, S> {

	override suspend fun shareWith(
		delegateId: String,
		contact: E,
		options: ContactShareOptions?,
	): E =
		shareWithMany(contact, mapOf(delegateId to (options ?: ContactShareOptions())))

	override suspend fun shareWithMany(contact: E, delegates: Map<String, ContactShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			contact,
			EntityWithEncryptionMetadataTypeName.Contact,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getContact(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) },
		).updatedEntityOrThrow()

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
			secretPatientKeys = ListOfIds(
				config.crypto.entity.secretIdsOf(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					null
				).toList())
		).successBody()
	) { ids ->
		maybeDecrypt(rawApi.getContacts(ListOfIds(ids)).successBody())
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
	contactKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
): EncryptedService =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceBase
		).let {
			Serialization.json.decodeFromJsonElement<EncryptedService>(it)
		}.copy(
			content = content.mapValues { (_, compoundContent) ->
				EncryptedContent(
					compoundValue = ensureNonNull(compoundContent.compoundValue) {
						"Compound value can't be null on a only-compound compound content"
					}.map {
						it.encrypt(config, contactKey)
					}
				)
			}
		)
	} else {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceWithContent
		).let {
			Serialization.json.decodeFromJsonElement(it)
		}
	}


@InternalIcureApi
private fun EncryptedService.requiresEncryption(
	config: BasicApiConfiguration
): Boolean =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceBase
		) || content.values.any { compoundContent ->
			ensureNonNull(compoundContent.compoundValue) {
				"Compound value can't be null on a only-compound compound content"
			}.any {
				it.requiresEncryption(config)
			}
		}
	} else {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceWithContent
		)
	}

@InternalIcureApi
private suspend fun encryptContacts(
	config: ApiConfiguration,
	entitiesGroupId: String?,
	contacts: List<DecryptedContact>
): List<EncryptedContact> {
	val keysById = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
		entitiesGroupId,
		contacts,
		EntityWithEncryptionMetadataTypeName.Contact
	)
	if (!contacts.all { keysById.containsKey(it.id) }) throw EntityEncryptionException(
		"No encryption key found for Contacts ${contacts.filter { !keysById.containsKey(it.id) }.map { it.id }}"
	)
	return contacts.map { contact ->
		val contactKey = keysById.getValue(contact.id).key
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(contact).jsonObject,
			config.encryption.contact
		).let {
			Serialization.json.decodeFromJsonElement<EncryptedContact>(it)
		}.copy(
			services = contact.services.map {
				it.encrypt(config, contactKey)
			}.toSet(),
		)
	}
}

@InternalIcureApi
private suspend fun validateEncryptedContacts(
	config: BasicApiConfiguration,
	contacts: List<EncryptedContact>
) {
	config.crypto.validationService.validateEncryptedEntities(
		contacts,
		EntityWithEncryptionMetadataTypeName.Contact,
		EncryptedContact.serializer(),
		config.encryption.contact
	)
	contacts.forEach { contact ->
		contact.services.forEach {
			if (it.requiresEncryption(config)) {
				throw EntityEncryptionException("Service ${it.id} in contact ${contact.id} is not properly encrypted according to the manifest")
			}
		}
	}
}

@InternalIcureApi
internal fun Service.asIcureStub(): IcureStub {
	ensure(this.delegations.isNotEmpty() || !this.securityMetadata?.secureDelegations.isNullOrEmpty()) { "The service must be include the encryption metadata to use this method. The Service gets populated with encryption metadata when it is obtained through one of the getServices, or filterServices method." }
	return IcureStub(
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
	)
}

@InternalIcureApi
private class AbstractContactBasicFlavourlessApi(
	val rawApi: RawContactApi,
	private val config: BasicApiConfiguration
) : ContactBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteContactUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteContact(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteContactsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteContacts(ListOfIds(entityIds)).successBody()
	
	override suspend fun deleteContactById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteContact(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteContactsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteContactsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeContactById(id: String, rev: String) {
		rawApi.purgeContact(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence> {
		return rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()
	}
}

@InternalIcureApi
private suspend fun tryDecryptServices(
	config: ApiConfiguration,
	servicesGroupId: String?,
	services: List<EncryptedService>,
	requireAllSuccess: Boolean
): Map<String, DecryptedService> {
	val servicesById = services.associateBy { it.id }
	val results = config.crypto.incrementalSecurityMetadataDecryptor.doManyIncrementallyDecryptingKeys(
		servicesGroupId,
		services.map { it.asIcureStub() },
		EntityWithEncryptionMetadataTypeName.Contact,
	) { serviceStub, _, keys ->
		runCatching {
			Serialization.json.decodeFromJsonElement<DecryptedService>(
				config.jsonPatcher.patchIndividualService(
					config.crypto.jsonEncryption.decrypt(
						keys,
						Serialization.json.encodeToJsonElement(servicesById.getValue(serviceStub.id)).jsonObject
					)
				)
			)
		}
	}
	return if (requireAllSuccess) {
		if (results.size != services.size) throw EntityEncryptionException(
			"No encryption key found for Services ${services.filter { !results.containsKey(it.id) }.map { it.id }}"
		)
		results.mapValues { it.value.getOrThrow() }
	} else {
		results.mapNotNull { (k, v) -> v.getOrNull()?.let { k to it } }.toMap()
	}
}

@InternalIcureApi
internal class ContactApiImpl(
	private val rawApi: RawContactApi,
	private val config: ApiConfiguration,
) : ContactApi, ContactFlavouredApi<DecryptedContact, DecryptedService> by object :
	AbstractContactFlavouredApi<DecryptedContact, DecryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedContact>
	): List<EncryptedContact> =
		encryptContacts(config, entitiesGroupId, entities)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>
	): List<DecryptedContact> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Contact,
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }

	override suspend fun maybeDecryptServices(
		entitiesGroupId: String?,
		entities: List<EncryptedService>
	): List<DecryptedService> {
		val successfullyDecrypted = tryDecryptServices(
			config,
			entitiesGroupId,
			entities,
			requireAllSuccess = true
		)
		return entities.map { successfullyDecrypted.getValue(it.id) }
	}

}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi, config) {
	private val crypto get() = config.crypto

	override val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService> =
		object : AbstractContactFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
			override suspend fun maybeDecryptServices(
				entitiesGroupId: String?,
				entities: List<EncryptedService>
			): List<EncryptedService> =
				entities

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedContact>
			): List<EncryptedContact> =
				entities.also {
					validateEncryptedContacts(
						config,
						it
					)
				}

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedContact>
			): List<EncryptedContact> =
				entities
		}

	override val tryAndRecover: ContactFlavouredApi<Contact, Service> =
		object : AbstractContactFlavouredApi<Contact, Service>(rawApi, config) {
			override suspend fun maybeDecryptServices(
				entitiesGroupId: String?,
				entities: List<EncryptedService>
			): List<Service> {
				val successfullyDecrypted = tryDecryptServices(
					config,
					entitiesGroupId,
					entities,
					requireAllSuccess = false
				)
				return entities.map { successfullyDecrypted[it.id] ?: it }
			}

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedContact>
			): List<Contact> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Contact,
					EncryptedContact.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Contact>
			): List<EncryptedContact> =
				validateOrEncryptEntities<Contact, EncryptedContact, DecryptedContact>(
					entities,
					{ encryptContacts(config, entitiesGroupId, it) },
					{ validateEncryptedContacts(config, it) }
				)
		}

	override suspend fun createContact(entity: DecryptedContact): DecryptedContact {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContact(
			encryptContacts(config, null, listOf(entity)).single(),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContacts(
			encryptContacts(config, null, entities),
		).successBody().map {
			decrypt(it)
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedContact?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedContact =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedContact(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				openingDate = base?.openingDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
				groupId = base?.groupId ?: base?.id,
			),
			EntityWithEncryptionMetadataTypeName.Contact,
			OwningEntityDetails(
				null,
				patient.id,
				crypto.entity.resolveSecretIdOption(null, patient, EntityWithEncryptionMetadataTypeName.Patient, secretId),
			),
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(contact: Contact): Set<HexString> = crypto.entity.encryptionKeysOf(null, contact, EntityWithEncryptionMetadataTypeName.Contact, null)

	override suspend fun hasWriteAccess(contact: Contact): Boolean = crypto.entity.hasWriteAccess(null, contact, EntityWithEncryptionMetadataTypeName.Contact)

	override suspend fun decryptPatientIdOf(contact: Contact): Set<String> = crypto.entity.owningEntityIdsOf(null, contact, EntityWithEncryptionMetadataTypeName.Contact, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(null, entity, EntityWithEncryptionMetadataTypeName.Contact, delegates.asLocalDataOwnerReferences())
	}

	override suspend fun decrypt(contact: EncryptedContact): DecryptedContact =
		crypto.entity.decryptEntities(
			null,
			listOf(contact),
			EntityWithEncryptionMetadataTypeName.Contact,
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }.single()

	override suspend fun tryDecrypt(contact: EncryptedContact): Contact =
		crypto.entity.tryDecryptEntities(
			null,
			listOf(contact),
			EntityWithEncryptionMetadataTypeName.Contact,
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }.single()

	override suspend fun decryptService(service: EncryptedService): DecryptedService =
		tryDecryptServices(config, null, listOf(service), true).values.single()

	override suspend fun tryDecryptService(service: EncryptedService): Service =
		tryDecryptServices(config, null, listOf(service), false).values.singleOrNull() ?: service

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
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
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
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
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
	override suspend fun maybeDecryptServices(
		entitiesGroupId: String?,
		entities: List<EncryptedService>
	): List<EncryptedService> =
		entities

	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>
	): List<EncryptedContact> =
		entities.also { validateEncryptedContacts(config, it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>
	): List<EncryptedContact> =
		entities
}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi, config) {

	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: BaseFilterOptions<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
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
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
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
