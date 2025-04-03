package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CalendarItemBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteCalendarItemUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteCalendarItemsUnsafe(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 * @param entityId id of the calendarItem.
	 * @param rev the latest known rev of the calendarItem to delete
	 * @return the id and revision of the deleted calendarItem.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteCalendarItemById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many calendarItems. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the calendarItems to delete.
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteCalendarItemsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a calendarItem.
	 * @param id id of the calendarItem to purge
	 * @param rev latest revision of the calendarItem
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeCalendarItemById(id: String, rev: String)

	/**
	 * Deletes a calendarItem. If you don't have write access to the calendarItem the method will fail.
	 * @param calendarItem the calendarItem to delete
	 * @return the id and revision of the deleted calendarItem.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun deleteCalendarItem(calendarItem: CalendarItem): DocIdentifier =
		deleteCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })

	/**
	 * Deletes many calendarItems. Ignores calendarItem for which you don't have write access or that don't match the latest revision.
	 * @param calendarItems the calendarItems to delete
	 * @return the id and revision of the deleted calendarItems. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteCalendarItems(calendarItems: List<CalendarItem>): List<DocIdentifier> =
		deleteCalendarItemsByIds(calendarItems.map { calendarItem ->
			IdWithMandatoryRev(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })
		})

	/**
	 * Permanently deletes a calendarItem.
	 * @param calendarItem the calendarItem to purge.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun purgeCalendarItem(calendarItem: CalendarItem) {
		purgeCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })
	}
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CalendarItemBasicFlavouredApi<E : CalendarItem> {
	/**
	 * Restores a calendarItem that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteCalendarItemById(id: String, rev: String): E

	/**
	 * Restores a calendarItem that was marked as deleted.
	 * @param calendarItem the calendarItem to undelete
	 * @return the restored calendarItem.
	 * @throws RevisionConflictException if the provided calendarItem doesn't match the latest known revision
	 */
	suspend fun undeleteCalendarItem(calendarItem: CalendarItem): E =
		undeleteCalendarItemById(calendarItem.id, requireNotNull(calendarItem.rev) { "Can't delete a calendarItem that has no rev" })

	/**
	 * Modifies a calendar item. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a calendar item with update content
	 * @return the calendar item updated with the provided content and a new revision.
	 */
	suspend fun modifyCalendarItem(entity: E): E

	/**
	 * Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 * read access.
	 * @param entityId a calendar item id.
	 * @param groupId the id of the group containing the entity. If null it is considered as the same group of the
	 * current user.
	 * @return the calendar item with id [entityId].
	 */
	suspend fun getCalendarItem(
		entityId: String,
		@DefaultValue("null")
		groupId: String? = null
	): E

	/**
	 * Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of calendar items ids
	 * @return all calendar items that you can access with one of the provided ids.
	 */
	suspend fun getCalendarItems(entityIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun getCalendarItemsByPeriodAndHcPartyId(startDate: Long, endDate: Long, hcPartyId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun getCalendarsByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CalendarItemFlavouredApi<E : CalendarItem> : CalendarItemBasicFlavouredApi<E> {
	/**
	 * Share a calendar item with another data owner. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the calendar item
	 * @param calendarItem the calendar item to share with [delegateId]
	 * @param options specifies how the calendar item will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the calendar item. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated calendar item
	 */
	suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		@DefaultValue("null")
		options: CalendarItemShareOptions? = null
	): E

	/**
	 * Share a calendar item with multiple data owners. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param calendarItem the calendar item to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated calendar item.
	 */
	suspend fun shareWithMany(
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): E

	suspend fun shareInGroup(
		calendarItem: E,
		entityGroupId: String?,
		delegates: @JsMapAsObjectArray(flattenKey = true, flattenValue = true) Map<EntityReferenceInGroup, CalendarItemShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findCalendarItemsByHcPartyPatient(
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
	 * Links a calendar item with a patient. Note that this operation is not reversible: it is not possible to change the patient linked to a calendar
	 * item.
	 * @param calendarItem a calendar item.
	 * @param patient the patient which will be linked to the calendar item.
	 * @param shareLinkWithDelegates data owners other than the current data owner which will also be able to decrypt the id of the newly linked
	 * patient. If any of these data owners do not already have access to the calendar item, they will be granted read access (no write).
	 * @return the updated calendar item.
	 */
	suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBy(
		filter: FilterOptions<CalendarItem>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBySorted(
		filter: SortableFilterOptions<CalendarItem>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CalendarItemApi : CalendarItemBasicFlavourlessApi, CalendarItemFlavouredApi<DecryptedCalendarItem>,
	Subscribable<CalendarItem, EncryptedCalendarItem, FilterOptions<CalendarItem>> {
	/**
	 * Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 * @param entity a calendar item with initialized encryption metadata
	 * @param groupId the id of the group where the entity should be created. If left null it will be the same group
	 * of the current user.
	 * @return the created calendar item with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createCalendarItem(
		entity: DecryptedCalendarItem,
		@DefaultValue("null")
		groupId: String? = null
	): DecryptedCalendarItem

	/**
	 * Creates a new calendar item entity with initialized encryption metadata.
	 * NOTE: this method doesn't send the entity to the backend, to store it you will need to pass the entity to the
	 * [createCalendarItem] method.
	 * @param base a calendar item with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the calendar item.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new calendar item
	 * @return a calendar item with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedCalendarItem

	/**
	 * Equivalent to [withEncryptionMetadata] but initializes the encryption metadata for storage in a group that
	 * can be different from the current user's group, or with delegates in an external group.
	 */
	suspend fun withEncryptionMetadataForGroup(
		entityGroupId: String?,
		base: DecryptedCalendarItem?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: @JsMapAsObjectArray(flattenKey = true, valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedCalendarItem

	/**
	 * Attempts to extract the encryption keys of a calendar item. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param calendarItem a calendar item
	 * @return the encryption keys extracted from the provided calendar item.
	 */
	suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString>

	/**
	 * Specifies if the current user has write access to a calendar item.
	 * @param calendarItem a calendar item
	 * @return if the current user has write access to the provided calendar item
	 */
	suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean

	/**
	 * Attempts to extract the patient id linked to a calendar item.
	 * Note: calendar items usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param calendarItem a calendar item
	 * @return the id of the patient linked to the calendar item, or empty if the current user can't access any patient id
	 * of the calendar item.
	 */
	suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a calendar item.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided calendar item. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the calendar item the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any CalendarItem,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a calendar item E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any calendar item that you have shared with P, H will be able to know that the calendar item was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a calendar item that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a calendar item
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>)
	suspend fun createDelegationDeAnonymizationMetadataInGroup(
		entityGroupId: String?,
		entity: CalendarItem,
		delegates: Set<EntityReferenceInGroup>
	)

	/**
	 * Decrypts a calendar item, throwing an exception if it is not possible.
	 * @param calendarItem a calendar item
	 * @param groupId the group of the calendar item
	 * @return the decrypted calendar item
	 * @throws EntityEncryptionException if the calendar item could not be decrypted
	 */
	suspend fun decrypt(calendarItem: EncryptedCalendarItem, groupId: String? = null): DecryptedCalendarItem

	/**
	 * Tries to decrypt a calendar item, returns the input if it is not possible.
	 * @param calendarItem an encrypted calendar item
	 * @param groupId the group of the calendar item
	 * @return the decrypted calendar item if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(calendarItem: EncryptedCalendarItem, groupId: String? = null): CalendarItem

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: CalendarItemFlavouredApi<CalendarItem>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): List<String>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): List<String>
}

interface CalendarItemBasicApi : CalendarItemBasicFlavourlessApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem>,
	Subscribable<CalendarItem, EncryptedCalendarItem, FilterOptions<CalendarItem>> {
	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): List<String>

	/**
	 * Get the ids of all calendarItems matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return a list of calendarItem ids
	 */
	suspend fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): List<String>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterCalendarItemsBySorted] instead.
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBy(
		filter: BaseFilterOptions<CalendarItem>
	): PaginatedListIterator<EncryptedCalendarItem>

	/**
	 * Get an iterator that iterates through all calendarItems matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterCalendarItemsBy].
	 *
	 * @param filter a calendarItem filter
	 * @return an iterator that iterates over all calendarItems matching the provided filter.
	 */
	suspend fun filterCalendarItemsBySorted(
		filter: BaseSortableFilterOptions<CalendarItem>
	): PaginatedListIterator<EncryptedCalendarItem>
}
