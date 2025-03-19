package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.form.FormByDataOwnerParentIdFilter
import com.icure.cardinal.sdk.model.filter.form.FormByDataOwnerPatientOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.form.FormByLogicalUuidFilter
import com.icure.cardinal.sdk.model.filter.form.FormByUniqueUuidFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object FormFilters {

	/**
	 * Options for form filter which match all the forms shared directly (i.e. ignoring hierarchies) with a specific data owner and where
	 * [Form.parent] is equal to [parentId].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param parentId the form parent id.
	 */
	fun byParentIdForDataOwner(
		dataOwnerId: String,
		parentId: String,
	): BaseFilterOptions<Form> = ByParentIdForDataOwner(dataOwnerId, parentId)

	/**
	 * Options for form filter which match all the forms shared directly (i.e. ignoring hierarchies) with the current data owner and where
	 * [Form.parent] is equal to [parentId].
	 *
	 * @param parentId the form parent id.
	 */
	fun byParentIdForSelf(
		parentId: String,
	): FilterOptions<Form> = ByParentIdForSelf(parentId)

	/**
	 * Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the forms based on [Form.openingDate]:
	 * - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsOpeningDateForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Form> = ByPatientsOpeningDateForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the forms based on [Form.openingDate]:
	 * - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsOpeningDateForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Form> = ByPatientsOpeningDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the forms based on [Form.openingDate]:
	 * - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	fun byPatientSecretIdsOpeningDateForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<Form> = ByPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for form filtering which match all forms shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the forms based on [Form.openingDate]:
	 * - if the [from] fuzzy date is not null, only the forms where [Form.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the forms where [Form.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the forms will be sorted by [Form.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Form.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Form.openingDate] (default: ascending).
	 */
	fun byPatientSecretIdsOpeningDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Form> = ByPatientSecretIdsOpeningDateForSelf(secretIds, from, to, descending)

	/**
	 * Options for form filtering which mach all the forms where [Form.logicalUuid] is equal to [logicalUuid].
	 *
	 * These options are sortable. When sorting using these options, the forms will be sorted by [Form.created] in ascending or descending
	 * order according to the value of the [descending] parameter.
	 *
	 * @param logicalUuid the [Form.logicalUuid] to use for filtering.
	 * @param descending whether to sort the results in descending or ascending order by [Form.created] (default: ascending).
	 */
	fun byLogicalUuid(
		logicalUuid: String,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<Form> = ByLogicalUuid(logicalUuid, descending)

	/**
	 * Options for form filtering which mach all the forms where [Form.uniqueId] is equal to [uniqueId].
	 *
	 * These options are sortable. When sorting using these options, the forms will be sorted by [Form.created] in ascending or descending
	 * order according to the value of the [descending] parameter.
	 *
	 * @param uniqueId the [Form.uniqueId] to use for filtering.
	 * @param descending whether to sort the results in descending or ascending order by [Form.created] (default: ascending).
	 */
	fun byUniqueId(
		uniqueId: String,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<Form> = ByUniqueId(uniqueId, descending)

	@Serializable
	internal class ByParentIdForDataOwner(
		val dataOwnerId: String,
		val parentId: String
	): BaseFilterOptions<Form>

	@Serializable
	internal class ByParentIdForSelf(
		val parentId: String
	): FilterOptions<Form>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Form>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Form>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : BaseSortableFilterOptions<Form>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Form>

	@Serializable
	internal class ByLogicalUuid(
		val logicalUuid: String,
		val descending: Boolean
	): BaseSortableFilterOptions<Form>

	@Serializable
	internal class ByUniqueId(
		val uniqueId: String,
		val descending: Boolean
	): BaseSortableFilterOptions<Form>
}

@InternalIcureApi
internal suspend fun mapFormFilterOptions(
	filterOptions: FilterOptions<Form>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Form> = mapIfMetaFilterOptions(filterOptions) {
	mapFormFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is FormFilters.ByParentIdForDataOwner -> FormByDataOwnerParentIdFilter(dataOwnerId = filterOptions.dataOwnerId, parentId = filterOptions.parentId)
	is FormFilters.ByParentIdForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		FormByDataOwnerParentIdFilter(dataOwnerId = selfDataOwnerId, parentId = filterOptions.parentId)
	}
	is FormFilters.ByPatientsOpeningDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		FormByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is FormFilters.ByPatientsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		FormByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is FormFilters.ByPatientSecretIdsOpeningDateForDataOwner -> FormByDataOwnerPatientOpeningDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.from,
		endDate = filterOptions.to,
		descending = filterOptions.descending
	)
	is FormFilters.ByPatientSecretIdsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		FormByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is FormFilters.ByLogicalUuid -> FormByLogicalUuidFilter(logicalUuid = filterOptions.logicalUuid, descending = filterOptions.descending)
	is FormFilters.ByUniqueId -> FormByUniqueUuidFilter(uniqueId = filterOptions.uniqueId, descending = filterOptions.descending)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Forms")
}
