package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.SecretIdOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTimeTable
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TimeTableBasicFlavourlessApi {
	/**
	 * Deletes a time-table. If you don't have write access to the time-table the method will fail.
	 * @param entityId id of the time-table.
	 * @return the id and revision of the deleted time-table.
	 */
	suspend fun deleteTimeTable(entityId: String): DocIdentifier

	/**
	 * Deletes many time-tables. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the time-tables.
	 * @return the id and revision of the deleted time-tables. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteTimeTables(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TimeTableBasicFlavouredApi<E : TimeTable> {
	/**
	 * Modifies a time-table. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a time-table with update content
	 * @return the time-table updated with the provided content and a new revision.
	 */
	suspend fun modifyTimeTable(entity: E): E

	/**
	 * Get a time-table by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a time-table, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a time-table id.
	 * @return the time-table with id [entityId].
	 */
	suspend fun getTimeTable(entityId: String): E

	/**
	 * Get multiple time tables by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a time table, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param timeTableIds a list of time table ids
	 * @return all patients that you can access with one of the provided ids.
	 */
	suspend fun getTimeTables(timeTableIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun getTimeTablesByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun getTimeTablesByAgendaId(agendaId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TimeTableFlavouredApi<E : TimeTable> : TimeTableBasicFlavouredApi<E> {
	/**
	 * Share a time-table with another data owner. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the time-table
	 * @param timeTable the time-table to share with [delegateId]
	 * @param options specifies how the time-table will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the time-table. Refer
	 * to the documentation of [TimeTableShareOptions] for more information.
	 * @return the updated time-table if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		timeTable: E,
		@DefaultValue("null")
		options: TimeTableShareOptions? = null
	): SimpleShareResult<E>


	/**
	 * Share a time-table with multiple data owners. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param timeTable the time-table to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated time-table if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		timeTable: E,
		delegates: Map<String, TimeTableShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a time-table with multiple data owners. The time-table must already exist in the database for this method to
	 * succeed. If you want to share the time-table before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param timeTable the time-table to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated time-table.
	 */
	suspend fun shareWithMany(
		timeTable: E,
		delegates: Map<String, TimeTableShareOptions>
	): E

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBy(
		filter: FilterOptions<TimeTable>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBySorted(
		filter: SortableFilterOptions<TimeTable>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TimeTableApi : TimeTableBasicFlavourlessApi, TimeTableFlavouredApi<DecryptedTimeTable> {
	/**
	 * Create a new time-table. The provided time-table must have the encryption metadata initialized.
	 * @param entity a time-table with initialized encryption metadata
	 * @return the created time-table with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createTimeTable(entity: DecryptedTimeTable): DecryptedTimeTable

	/**
	 * Creates a new time-table with initialized encryption metadata
	 * @param base a time-table with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the time-table.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new time-table
	 * @return a time-table with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedTimeTable?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTimeTable

	/**
	 * Attempts to extract the encryption keys of a time-table. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param timeTable a time-table
	 * @return the encryption keys extracted from the provided time-table.
	 */
	suspend fun getEncryptionKeysOf(timeTable: TimeTable): Set<HexString>

	/**
	 * Specifies if the current user has write access to a time-table.
	 * @param timeTable a time-table
	 * @return if the current user has write access to the provided time-table
	 */
	suspend fun hasWriteAccess(timeTable: TimeTable): Boolean

	/**
	 * Attempts to extract the patient id linked to a time-table.
	 * Note: time-tables usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param timeTable a time-table
	 * @return the id of the patient linked to the time-table, or empty if the current user can't access any patient id
	 * of the time-table.
	 */
	suspend fun decryptPatientIdOf(timeTable: TimeTable): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a time-table.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided time-table. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the time-table the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any TimeTable,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a time-table E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any time-table that you have shared with P, H will be able to know that the time-table was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a time-table that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a time-table
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: TimeTable, delegates: Set<String>)

	/**
	 * Decrypts a time-table, throwing an exception if it is not possible.
	 * @param timeTable a time-table
	 * @return the decrypted time-table
	 * @throws EntityEncryptionException if the time-table could not be decrypted
	 */
	suspend fun decrypt(timeTable: EncryptedTimeTable): DecryptedTimeTable

	/**
	 * Tries to decrypt a time-table, returns the input if it is not possible.
	 * @param timeTable an encrypted time-table
	 * @return the decrypted time-table if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(timeTable: EncryptedTimeTable): TimeTable

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: TimeTableFlavouredApi<EncryptedTimeTable>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: TimeTableFlavouredApi<TimeTable>

	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBy(filter: FilterOptions<TimeTable>): List<String>

	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): List<String>
}

interface TimeTableBasicApi : TimeTableBasicFlavourlessApi, TimeTableBasicFlavouredApi<EncryptedTimeTable> {
	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): List<String>

	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): List<String>

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBy(
		filter: BaseFilterOptions<TimeTable>
	): PaginatedListIterator<EncryptedTimeTable>

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBySorted(
		filter: BaseSortableFilterOptions<TimeTable>
	): PaginatedListIterator<EncryptedTimeTable>
}

