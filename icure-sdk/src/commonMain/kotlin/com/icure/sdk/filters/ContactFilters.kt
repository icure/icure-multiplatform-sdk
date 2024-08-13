package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

object ContactFilters {
	/**
	 * Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id
	 * @return options for contact filtering
	 */
	fun allContactsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Contact> =
		AllByDataOwner(dataOwnerId)

	/**
	 * Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * @return options for contact filtering
	 */
	fun allContactsForSelf(): FilterOptions<Contact> =
		AllForSelf

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with the current data owner that
	 * have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param identifiers a list of identifiers
	 * @return options for contact filtering
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>
	): SortableFilterOptions<Contact> =
		ByIdentifiersForSelf(identifiers)

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param dataOwnerId a data owner id
	 * @param identifiers a list of identifiers
	 * @return options for contact filtering
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<Contact> =
		ByIdentifiersForDataOwner(identifiers, dataOwnerId)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific
	 * data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 * by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	fun byCodeAndOpeningDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
	): BaseSortableFilterOptions<Contact> = ByCodeAndOpeningDateForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 * by [Contact.openingDate].
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	fun byCodeAndOpeningDateForSelf(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
	): SortableFilterOptions<Contact> = ByCodeAndOpeningDateForSelf(
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 * by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	fun byTagAndOpeningDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null
	): BaseSortableFilterOptions<Contact> = ByTagAndOpeningDateForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 * by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	fun byTagAndOpeningDateForSelf(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null
	): SortableFilterOptions<Contact> = ByTagAndOpeningDateForSelf(
		tagType = tagType,
		tagCode = tagCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [IcureBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 * the same order as the input patients.
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 */
	fun byPatientsForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>
	): BaseSortableFilterOptions<Contact> = ByPatientsForDataOwner(
		patients = patients,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [IcureBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 * the same order as the input patients.
	 * @param patients a list of patients.
	 */
	fun byPatientsForSelf(
		patients: List<Patient>
	): SortableFilterOptions<Contact> = ByPatientsForSelf(
		patients = patients
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>
	): BaseSortableFilterOptions<Contact> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForSelf(
		secretIds: List<String>
	): SortableFilterOptions<Contact> = ByPatientsSecretIdsForSelf(
		secretIds = secretIds,
	)


	/**
	 * Options for contact filtering which match all contacts that have at least a service with an id in [serviceIds].
	 * These options are sortable. When sorting using these options the contacts will be sorted in the same order as the
	 * input service ids. If a contact has multiple services only the first matching service is considered.
	 * @param serviceIds a list of service ids
	 */
	fun byServiceIds(
		serviceIds: List<String>,
	): BaseSortableFilterOptions<Contact> = ByServiceIds(
		serviceIds = serviceIds
	)

	internal class AllByDataOwner(
		val dataOwnerId: String
	) : BaseFilterOptions<Contact>

	internal data object AllForSelf : FilterOptions<Contact>

	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwnerId: String
	) : BaseSortableFilterOptions<Contact>

	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>
	) : SortableFilterOptions<Contact>

	internal class ByCodeAndOpeningDateForDataOwner(
		val codeType: String,
		val codeCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact> {
		init {
			require (codeCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Code code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByCodeAndOpeningDateForSelf(
		val codeType: String,
		val codeCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?
	): SortableFilterOptions<Contact> {
		init {
			require (codeCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Code code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByTagAndOpeningDateForDataOwner(
		val tagType: String,
		val tagCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact> {
		init {
			require (tagCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Tag code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByTagAndOpeningDateForSelf(
		val tagType: String,
		val tagCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
	): SortableFilterOptions<Contact> {
		init {
			require (tagCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Tag code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByPatientsForDataOwner(
		val patients: List<Patient>,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact>

	internal class ByPatientsForSelf(
		val patients: List<Patient>,
	): SortableFilterOptions<Contact>

	internal class ByPatientsSecretIdsForDataOwner(
		val secretIds: List<String>,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact>

	internal class ByPatientsSecretIdsForSelf(
		val secretIds: List<String>,
	): SortableFilterOptions<Contact>

	internal class ByServiceIds(
		val serviceIds: List<String>,
	): BaseSortableFilterOptions<Contact>
}

@InternalIcureApi
internal suspend fun mapContactFilterOptions(
	filterOptions: FilterOptions<Contact>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Contact> = mapIfMetaFilterOptions(filterOptions) {
	mapContactFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is ContactFilters.AllByDataOwner -> {
		ContactByHcPartyFilter(
			hcpId = filterOptions.dataOwnerId
		)
	}
	ContactFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyFilter(hcpId = selfDataOwnerId)
	}
	is ContactFilters.ByCodeAndOpeningDateForDataOwner -> {
		ContactByHcPartyTagCodeDateFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByCodeAndOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyTagCodeDateFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByIdentifiersForDataOwner -> {
		ContactByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByPatientsForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			},
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByPatientsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			},
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByPatientsSecretIdsForDataOwner -> {
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.secretIds,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByPatientsSecretIdsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.secretIds,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByServiceIds -> {
		ContactByServiceIdsFilter(
			ids = filterOptions.serviceIds
		)
	}
	is ContactFilters.ByTagAndOpeningDateForDataOwner -> {
		ContactByHcPartyTagCodeDateFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByTagAndOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyTagCodeDateFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = selfDataOwnerId
		)
	}
	else -> {
		throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Contacts")
	}
}