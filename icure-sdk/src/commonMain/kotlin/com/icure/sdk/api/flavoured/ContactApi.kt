package com.icure.sdk.api.flavoured

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.SecretIdOption
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
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.DefaultValue
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
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ContactBasicFlavourlessApi : Subscribable<Contact, EncryptedContact> {
	/**
	 * Get the ids of all contacts matching the provided filter.
	 * @param filter a contact filter
	 * @return a list of contact ids
	 */
	suspend fun matchContactsBy(filter: AbstractFilter<Contact>): List<String>

	/**
	 * Get the ids of all services matching the provided filter.
	 * @param filter a service filter
	 * @return a list of service ids
	 */
	suspend fun matchServicesBy(filter: AbstractFilter<Service>): List<String>

	/**
	 * Deletes a contact. If you don't have write access to the contact the method will fail.
	 * @param entityId id of the contact.
	 * @return the id and revision of the deleted contact.
	 */
	suspend fun deleteContact(entityId: String): DocIdentifier

	/**
	 * Deletes many contacts. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the contacts.
	 * @return the id and revision of the deleted contacts. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteContacts(entityIds: List<String>): List<DocIdentifier>

	@Deprecated("Will be replaced by filter")
	suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>

	/**
	 * Gives an approximation of the amount of times each code of type [codeType] is used in services. This number is
	 * not exact, and may be cached, so you should not use this method if you need precise values, but it can be useful
	 * if you want to give suggestions.
	 * Only codes that occur at least [minOccurrences] times will be used.
	 * @return the occurrences for codes of type [codeType] in services.
	 */
	suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence>

	/**
	 * Subscribe to creation and update events on Services. Unlike other entity events subscription methods for services
	 * you all subscription will be notified of both creation and update events.
	 * @param filter only events for services matching this filter will be notified
	 * @param subscriptionConfig customise the subscription configuration
	 * @return a subscription that receives notifications for creation or update of services.
	 */
	suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: AbstractFilter<Service>,
		@DefaultValue("null")
		subscriptionConfig: EntitySubscriptionConfiguration? = null
	): EntitySubscription<EncryptedService>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ContactBasicFlavouredApi<E : Contact, S : Service> {
	/**
	 * Modifies a contact. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a contact with update content
	 * @return the contact updated with the provided content and a new revision.
	 */
	suspend fun modifyContact(entity: E): E

	/**
	 * Modifies multiple contacts. Ignores all contacts for which you don't have write access.
	 * Flavoured method.
	 * @param entities contacts with update content
	 * @return the updated contacts with a new revision.
	 */
	suspend fun modifyContacts(entities: List<E>): List<E>

	/**
	 * Get a contact by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a contact, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a contact id.
	 * @return the contact with id [entityId].
	 */
	suspend fun getContact(entityId: String): E

	/**
	 * Get multiple contacts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a contact, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of contacts ids
	 * @return all contacts that you can access with one of the provided ids.
	 */
	suspend fun getContacts(entityIds: List<String>): List<E>

	/**
	 * @param filter a contact filter
	 * @return an iterator that iterates over all contacts matching the provided filter.
	 */
	suspend fun filterContactsBy(filter: AbstractFilter<Contact>): PaginatedListIterator<E>


	@Deprecated("Will be replaced by filter")
	suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listContactsByExternalId(externalId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		@DefaultValue("null")
		planOfActionsIds: String? = null,
		@DefaultValue("null")
		skipClosedContacts: Boolean? = null,
	): List<E>

	@Deprecated("The method is very specialised and rarely needed. Can be replaced by bulk get and modify") // Maybe we can add a close contacts by ids to save some bandwidth (close without getting first).
	suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>

	/**
	 * Get a service by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a service, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param serviceId a service id
	 * @return the service with id [serviceId].
	 */
	suspend fun getService(serviceId: String): S

	/**
	 * Get multiple services by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a services, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of service ids
	 * @return all services that you can access with one of the provided ids.
	 */
	suspend fun getServices(entityIds: List<String>): List<S>

	@Deprecated("Will be replaced by filter")
	suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S>

	@Deprecated("Will be replaced by filter")
	suspend fun listServicesByAssociationId(associationId: String): List<S>

	@Deprecated("Will be replaced by filter")
	suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S>

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterContactsBy(ContactByHcPartyTagCodeDateFilter(healthcarePartyId = hcPartyId, startOfContactOpeningDate = startDate, endOfContactOpeningDate = endDate))",
			imports = arrayOf("com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter")
		)
	)
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

	/**
	 * @param filter a service filter
	 * @return an iterator that iterates over all services matching the provided filter.
	 */
	suspend fun filterServicesBy(filter: AbstractFilter<Service>): PaginatedListIterator<S>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ContactFlavouredApi<E : Contact, S : Service> : ContactBasicFlavouredApi<E, S> {
	/**
	 * Share a contact with another data owner. The contact must already exist in the database for this method to
	 * succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the contact
	 * @param contact the contact to share with [delegateId]
	 * @param options specifies how the contact will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the contact. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated contact if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		contact: E,
		@DefaultValue("null")
		options: ContactShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a contact with multiple data owners. The contact must already exist in the database for this method to
	 * succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param contact the contact to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated contact if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		contact: E,
		delegates: Map<String, ContactShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a contact with multiple data owners. The contact must already exist in the database for this method to
	 * succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param contact the contact to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated contact.
	 */
	suspend fun shareWithMany(
		contact: E,
		delegates: Map<String, ContactShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
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
	/**
	 * Create a new contact. The provided contact must have the encryption metadata initialised.
	 * @param entity a contact with initialised encryption metadata
	 * @return the created contact with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createContact(entity: DecryptedContact): DecryptedContact

	/**
	 * Create multiple contacts. All the provided contacts must have the encryption metadata initialised, otherwise
	 * this method fails without doing anything.
	 * @param entities contacts with initialised encryption metadata
	 * @return the created contacts with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any contact in the input was not initialised.
	 */
	suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact>

	/**
	 * Creates a new contact with initialised encryption metadata
	 * @param base a contact with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the contact.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new contact
	 * @return a contact with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
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

	/**
	 * Attempts to extract the encryption keys of a contact. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param contact a contact
	 * @return the encryption keys extracted from the provided contact.
	 */
	suspend fun getEncryptionKeysOf(contact: Contact): Set<HexString>

	/**
	 * Specifies if the current user has write access to a contact.
	 * @param contact a contact
	 * @return if the current user has write access to the provided contact
	 */
	suspend fun hasWriteAccess(contact: Contact): Boolean

	/**
	 * Attempts to extract the patient id linked to a contact.
	 * Note: contacts usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param contact a contact
	 * @return the id of the patient linked to the contact, or empty if the current user can't access any patient id
	 * of the contact.
	 */
	suspend fun decryptPatientIdOf(contact: Contact): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a contact.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided contact. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the contact the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Contact,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a contact E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any contact that you have shared with P, H will be able to know that the contact was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a contact that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a contact
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Set<String>)

	suspend fun decrypt(contact: EncryptedContact): DecryptedContact

	suspend fun tryDecrypt(contact: EncryptedContact): Contact

	/**
	 * Decrypts a single [EncryptedService].
	 * Note: you should use this function only when you retrieve [Service]s as single entity. If you are retrieving them as part of a
	 * [Contact], use [decrypt] instead.
	 *
	 * @param service the [EncryptedService] to decrypt.
	 * @return the [DecryptedService].
	 * @throws EntityEncryptionException if [service] could not be decrypted.
	 */
	suspend fun decryptService(service: EncryptedService): DecryptedService

	/**
	 * Tries to decrypt a single [EncryptedService].
	 * Note: you should use this function only when you retrieve [Service]s as single entity. If you are retrieving them as part of a
	 * [Contact], use [tryDecrypt] instead.
	 *
	 * @param service the [EncryptedService] to decrypt.
	 * @return the [DecryptedService] if the decryption was successful, the original [service] otherwise.
	 */
	suspend fun tryDecryptService(service: EncryptedService): Service

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

	override suspend fun filterContactsBy(filter: AbstractFilter<Contact>): PaginatedListIterator<E> =
		IdsPageIterator(rawApi.matchContactsBy(filter).successBody(), this::getContacts)

	@Deprecated("Will be replaced by filter")
	override suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E> =
		rawApi.listContactByHCPartyServiceId(hcPartyId, serviceId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listContactsByExternalId(externalId: String): List<E> =
		rawApi.listContactsByExternalId(externalId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E> =
		rawApi.listContactsByHCPartyAndFormId(hcPartyId, formId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E> =
		rawApi.listContactsByHCPartyAndFormIds(hcPartyId, ListOfIds(formIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): List<E> =
		rawApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, secretPatientKeys, planOfActionsIds, skipClosedContacts).successBody()
			.map { maybeDecrypt(it) }

	@Deprecated("The method is very specialised and rarely needed. Can be replaced by bulk get and modify")
	override suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.closeForHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }

	override suspend fun getService(serviceId: String): S = rawApi.getService(serviceId).successBody().let { maybeDecryptService(it) }

	override suspend fun getServices(entityIds: List<String>): List<S> =
		rawApi.getServices(ListOfIds(entityIds)).successBody().map { maybeDecryptService(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S> =
		rawApi.getServicesLinkedTo(linkType, ListOfIds(ids)).successBody().map { maybeDecryptService(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listServicesByAssociationId(associationId: String): List<S> =
		rawApi.listServicesByAssociationId(associationId).successBody().map { maybeDecryptService(it) }

	@Deprecated("Will be replaced by filter")
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

	override suspend fun filterServicesBy(filter: AbstractFilter<Service>): PaginatedListIterator<S> =
		IdsPageIterator(
			rawApi.matchServicesBy(filter).successBody(),
			this::getServices
		)

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

	@Deprecated("Will be replaced by filter")
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
	override suspend fun matchContactsBy(filter: AbstractFilter<Contact>) = rawApi.matchContactsBy(filter).successBody()
	override suspend fun matchServicesBy(filter: AbstractFilter<Service>): List<String> = rawApi.matchServicesBy(filter).successBody()
	override suspend fun deleteContact(entityId: String) = rawApi.deleteContact(entityId).successBody()
	override suspend fun deleteContacts(entityIds: List<String>) = rawApi.deleteContacts(ListOfIds(entityIds)).successBody()
	@Deprecated("Will be replaced by filter")
	override suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long) =
		rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()

	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: AbstractFilter<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedService.serializer(),
			events = setOf(SubscriptionEventType.Create, SubscriptionEventType.Update),
			filter = filter,
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ServiceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun subscribeToEvents(
		events: Set<com.icure.sdk.subscription.SubscriptionEventType>,
		filter: AbstractFilter<Contact>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedContact> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedContact.serializer(),
			events = events,
			filter = filter,
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
private suspend fun decryptServiceOrNull(entity: EncryptedService, crypto: InternalCryptoServices): DecryptedService? = try {
		crypto.entity.tryDecryptAndImportAnyEncryptionKey(entity.asIcureStubWithTypeInfo())?.key
	} catch (e: InternalIcureException) {
		null
	}?.let { contactKey ->
		Serialization.json.encodeToJsonElement<EncryptedService>(entity).jsonObject
			.let { crypto.jsonEncryption.decrypt(contactKey, it) }
			.let {
				Serialization.json.decodeFromJsonElement<DecryptedService>(it)
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
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}

	override suspend fun maybeDecryptService(entity: EncryptedService): DecryptedService =
		decryptServiceOrNull(entity, crypto)
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
				) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }
					?: entity

			override suspend fun maybeDecryptService(entity: EncryptedService): Service =
				decryptServiceOrNull(entity, crypto) ?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Contact): EncryptedContact = when (entity) {
				is EncryptedContact -> entity.also { it.validateEncrypted(config, fieldsToEncrypt, serviceFieldsToEncrypt) }

				is DecryptedContact -> entity.encrypt(config, fieldsToEncrypt, serviceFieldsToEncrypt)
			}
		}

	override suspend fun createContact(entity: DecryptedContact): DecryptedContact {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createContact(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
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
	) { Serialization.json.decodeFromJsonElement<DecryptedContact>(it) }

	override suspend fun decrypt(contact: EncryptedContact): DecryptedContact =
		decryptOrNull(contact) ?: throw EntityEncryptionException("Contact cannot be decrypted")

	override suspend fun tryDecrypt(contact: EncryptedContact): Contact =
		decryptOrNull(contact) ?: contact

	override suspend fun decryptService(service: EncryptedService): DecryptedService =
		decryptServiceOrNull(service, crypto) ?: throw EntityEncryptionException("Service cannot be decrypted")

	override suspend fun tryDecryptService(service: EncryptedService): Service =
		decryptServiceOrNull(service, crypto) ?: service
}

@InternalIcureApi
internal class ContactBasicApiImpl(
	rawApi: RawContactApi,
	config: BasicApiConfiguration
) : ContactBasicApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService> by object :
	AbstractContactBasicFlavouredApi<EncryptedContact, EncryptedService>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedContact): EncryptedContact =
		entity.also { it.validateEncrypted(config, config.encryption.contact, config.encryption.service) }

	override suspend fun maybeDecrypt(entity: EncryptedContact): EncryptedContact = entity
	override suspend fun maybeDecryptService(entity: EncryptedService): EncryptedService = entity
}, ContactBasicFlavourlessApi by AbstractContactBasicFlavourlessApi(rawApi, config)
