package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.data.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ContactBasicFlavourlessApi {
	/**
	 * Deletes a contact. If you don't have write access to the contact the method will fail.
	 * @param entityId id of the contact.
	 * @param rev the latest known rev of the contact to delete
	 * @return the id and revision of the deleted contact.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteContactById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many contacts. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the contacts to delete.
	 * @return the id and revision of the deleted contacts. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteContactsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a contact.
	 * @param id id of the contact to purge
	 * @param rev latest revision of the contact
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeContactById(id: String, rev: String)

	/**
	 * Deletes a contact. If you don't have write access to the contact the method will fail.
	 * @param contact the contact to delete
	 * @return the id and revision of the deleted contact.
	 * @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	suspend fun deleteContact(contact: Contact): DocIdentifier =
		deleteContactById(contact.id, requireNotNull(contact.rev) { "Can't delete an contact that has no rev" })

	/**
	 * Deletes many contacts. Ignores contact for which you don't have write access or that don't match the latest revision.
	 * @param contacts the contacts to delete
	 * @return the id and revision of the deleted contacts. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteContacts(contacts: List<Contact>): List<DocIdentifier> =
		deleteContactsByIds(contacts.map { contact ->
			IdWithMandatoryRev(contact.id, requireNotNull(contact.rev) { "Can't delete an contact that has no rev" })
		})

	/**
	 * Permanently deletes a contact.
	 * @param contact the contact to purge.
	 * @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	suspend fun purgeContact(contact: Contact) {
		purgeContactById(contact.id, requireNotNull(contact.rev) { "Can't delete an contact that has no rev" })
	}

	@Deprecated("Use filter instead")
	suspend fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): List<IcureStub>

	/**
	 * Gives an approximation of the amount of times each code of type [codeType] is used in services where the current
	 * data owner is a direct delegate (does not count situations where the data owner has access to the service through
	 * delegations to a parent data owner).
	 * This number is not exact, and may be cached, so you should not use this method if you need precise values, but
	 * it can be useful if you want to give suggestions.
	 * Only codes that occur at least [minOccurrences] times will be used.
	 * @return the occurrences for codes of type [codeType] in services.
	 */
	suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ContactBasicFlavouredApi<E : Contact, S : Service> {
	/**
	 * Restores a contact that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteContactById(id: String, rev: String): E

	/**
	 * Restores a contact that was marked as deleted.
	 * @param contact the contact to undelete
	 * @return the restored contact.
	 * @throws RevisionConflictException if the provided contact doesn't match the latest known revision
	 */
	suspend fun undeleteContact(contact: Contact): E =
		undeleteContactById(contact.id, requireNotNull(contact.rev) { "Can't delete an contact that has no rev" })

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

	@Deprecated("Use filter instead")
	suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun listContactsByExternalId(externalId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		@DefaultValue("null")
		planOfActionsIds: String? = null,
		@DefaultValue("null")
		skipClosedContacts: Boolean? = null,
	): List<E>

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

	@Deprecated("Use filter instead")
	suspend fun getServicesLinkedTo(linkType: String, ids: List<String>): List<S>

	@Deprecated("Use filter instead")
	suspend fun listServicesByAssociationId(associationId: String): List<S>

	@Deprecated("Use filter instead")
	suspend fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String): List<S>

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterContactsBy(ContactByHcPartyTagCodeDateFilter(healthcarePartyId = hcPartyId, startOfContactOpeningDate = startDate, endOfContactOpeningDate = endDate))",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter")
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
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ContactFlavouredApi<E : Contact, S : Service> : ContactBasicFlavouredApi<E, S> {
	/**
	 * Share a contact with another data owner. The contact must already exist in the database for this method to
	 * succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the contact
	 * @param contact the contact to share with [delegateId]
	 * @param options specifies how the contact will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the contact. Refer
	 * to the documentation of [ContactShareOptions] for more information.
	 * @return the updated contact if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		contact: E,
		@DefaultValue("null")
		options: ContactShareOptions? = null
	): E

	/**
	 * Share a contact with multiple data owners. The contact must already exist in the database for this method to
	 * succeed. If you want to share the contact before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
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

	@Deprecated("Use filter instead")
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

	/**
	 * Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterContactsBySorted] instead.
	 *
	 * @param filter a contact filter
	 * @return an iterator that iterates over all contacts matching the provided filter.
	 */
	suspend fun filterContactsBy(filter: FilterOptions<Contact>): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterServicesBySorted] instead.
	 *
	 * @param filter a service filter
	 * @return an iterator that iterates over all services matching the provided filter.
	 */
	suspend fun filterServicesBy(filter: FilterOptions<Service>): PaginatedListIterator<S>

	/**
	 * Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterContactsBy].
	 *
	 * @param filter a contact filter
	 * @return an iterator that iterates over all contacts matching the provided filter.
	 */
	suspend fun filterContactsBySorted(filter: SortableFilterOptions<Contact>): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterServicesBy].
	 *
	 * @param filter a service filter
	 * @return an iterator that iterates over all services matching the provided filter.
	 */
	suspend fun filterServicesBySorted(filter: SortableFilterOptions<Service>): PaginatedListIterator<S>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ContactApi : ContactBasicFlavourlessApi, ContactFlavouredApi<DecryptedContact, DecryptedService>, Subscribable<Contact, EncryptedContact, FilterOptions<Contact>> {
	/**
	 * Get the ids of all contacts matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchContactsBySorted] instead.
	 *
	 * @param filter a contact filter
	 * @return a list of contact ids
	 */
	suspend fun matchContactsBy(filter: FilterOptions<Contact>): List<String>

	/**
	 * Get the ids of all services matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchServicesBySorted] instead.
	 *
	 * @param filter a service filter
	 * @return a list of service ids
	 */
	suspend fun matchServicesBy(filter: FilterOptions<Service>): List<String>

	/**
	 * Get the ids of all contacts matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchContactsBy].
	 *
	 * @param filter a contact filter
	 * @return a list of contact ids
	 */
	suspend fun matchContactsBySorted(filter: SortableFilterOptions<Contact>): List<String>

	/**
	 * Get the ids of all services matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchServicesBy].
	 *
	 * @param filter a service filter
	 * @return a list of service ids
	 */
	suspend fun matchServicesBySorted(filter: SortableFilterOptions<Service>): List<String>

	/**
	 * Create a new contact. The provided contact must have the encryption metadata initialized.
	 * @param entity a contact with initialized encryption metadata
	 * @return the created contact with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createContact(entity: DecryptedContact): DecryptedContact

	/**
	 * Create multiple contacts. All the provided contacts must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities contacts with initialized encryption metadata
	 * @return the created contacts with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any contact in the input was not initialized.
	 */
	suspend fun createContacts(entities: List<DecryptedContact>): List<DecryptedContact>

	/**
	 * Creates a new contact with initialized encryption metadata
	 * @param base a contact with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the contact.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new contact
	 * @return a contact with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedContact?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
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


	/**
	 * Subscribe to creation and update events on Services. Unlike other entity events subscription methods for services
	 * you all subscription will be notified of both creation and update events.
	 * @param filter only events for services matching this filter will be notified
	 * @param subscriptionConfig customize the subscription configuration
	 * @return a subscription that receives notifications for creation or update of services.
	 */
	suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: FilterOptions<Service>,
		@DefaultValue("null")
		subscriptionConfig: EntitySubscriptionConfiguration? = null
	): EntitySubscription<EncryptedService>
}

interface ContactBasicApi : ContactBasicFlavourlessApi, ContactBasicFlavouredApi<EncryptedContact, EncryptedService>, Subscribable<Contact, EncryptedContact, BaseFilterOptions<Contact>> {
	/**
	 * Get the ids of all contacts matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchContactsBySorted] instead.
	 *
	 * @param filter a contact filter
	 * @return a list of contact ids
	 */
	suspend fun matchContactsBy(filter: BaseFilterOptions<Contact>): List<String>

	/**
	 * Get the ids of all services matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchServicesBySorted] instead.
	 *
	 * @param filter a service filter
	 * @return a list of service ids
	 */
	suspend fun matchServicesBy(filter: BaseFilterOptions<Service>): List<String>

	/**
	 * Get the ids of all contacts matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchContactsBy].
	 *
	 * @param filter a contact filter
	 * @return a list of contact ids
	 */
	suspend fun matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): List<String>

	/**
	 * Get the ids of all services matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchServicesBy].
	 *
	 * @param filter a service filter
	 * @return a list of service ids
	 */
	suspend fun matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): List<String>

	/**
	 * Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterContactsBySorted] instead.
	 *
	 * @param filter a contact filter
	 * @return an iterator that iterates over all contacts matching the provided filter.
	 */
	suspend fun filterContactsBy(filter: BaseFilterOptions<Contact>): PaginatedListIterator<EncryptedContact>

	/**
	 * Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterServicesBySorted] instead.
	 *
	 * @param filter a service filter
	 * @return an iterator that iterates over all services matching the provided filter.
	 */
	suspend fun filterServicesBy(filter: BaseFilterOptions<Service>): PaginatedListIterator<EncryptedService>

	/**
	 * Get an iterator that iterates through all contacts matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterContactsBy].
	 *
	 * @param filter a contact filter
	 * @return an iterator that iterates over all contacts matching the provided filter.
	 */
	suspend fun filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): PaginatedListIterator<EncryptedContact>

	/**
	 * Get an iterator that iterates through all services matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterServicesBy].
	 *
	 * @param filter a service filter
	 * @return an iterator that iterates over all services matching the provided filter.
	 */
	suspend fun filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): PaginatedListIterator<EncryptedService>


	/**
	 * Subscribe to creation and update events on Services. Unlike other entity events subscription methods for services
	 * you all subscription will be notified of both creation and update events.
	 * @param filter only events for services matching this filter will be notified
	 * @param subscriptionConfig customize the subscription configuration
	 * @return a subscription that receives notifications for creation or update of services.
	 */
	suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: BaseFilterOptions<Service>,
		@DefaultValue("null")
		subscriptionConfig: EntitySubscriptionConfiguration? = null
	): EntitySubscription<EncryptedService>
}
