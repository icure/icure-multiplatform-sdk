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
	 * Create options for contact filtering that will match all contacts shared with a specific data owner.
	 * If [dataOwnerId] is null the filter will match all contacts shared directly with the current data owner.
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @return options for contact filtering
	 */
	fun allContactsForDataOwner(
		@DefaultValue("null")
		dataOwnerId: String? = null
	): FilterOptions<Contact> =
		ByDataOwner(dataOwnerId)

	/**
	 * Options for contact filtering which match all the contacts shared with a specific data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param identifiers a list of identifiers
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @return options for contact filtering
	 */
	fun byIdentifiers(
		identifiers: List<Identifier>,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> =
		ByIdentifiers(identifiers, dataOwnerId)

	/**
	 * Options for contact filtering which match all contacts shared with a specific data owner that have a certain code.
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
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	fun byCodeAndOpeningDate(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> = ByCodeAndOpeningDate(
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared with a specific data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 * by [Contact.openingDate].
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	fun byTagAndOpeningDate(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> = ByTagAndOpeningDate(
		tagType = tagType,
		tagCode = tagCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared with a specific data owner that are linked with one
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
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 */
	fun byPatients(
		patients: List<Patient>,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> = ByPatients(
		patients = patients,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared with a specific data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 * @param secretIds a list of patients secret ids
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 */
	fun byPatientsSecretIds(
		secretIds: List<String>,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> = ByPatientsSecretIds(
		secretIds = secretIds,
		dataOwnerId = dataOwnerId
	)


	/**
	 * Options for contact filtering which match all contacts shared with a specific data owner that have at least a
	 * service with an id in [serviceIds].
	 * These options are sortable. When sorting using these options the contacts will be sorted in the same order as the
	 * input service ids. If a contact has multiple services only the first matching service is considered.
	 * @param serviceIds a list of service ids
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 */
	fun byServiceIds(
		serviceIds: List<String>,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Contact> = ByServiceIds(
		serviceIds = serviceIds,
		dataOwnerId = dataOwnerId
	)

	internal class ByDataOwner(
		val dataOwnerId: String?
	) : FilterOptions<Contact>

	internal class ByIdentifiers(
		val identifiers: List<Identifier>,
		val dataOwnerId: String?
	) : SortableFilterOptions<Contact>

	internal class ByCodeAndOpeningDate(
		val codeType: String,
		val codeCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String?
	): SortableFilterOptions<Contact> {
		init {
			require (codeCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Code code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByTagAndOpeningDate(
		val tagType: String,
		val tagCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String?
	): SortableFilterOptions<Contact> {
		init {
			require (tagCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Tag code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	internal class ByPatients(
		val patients: List<Patient>,
		val dataOwnerId: String?
	): SortableFilterOptions<Contact>

	internal class ByPatientsSecretIds(
		val secretIds: List<String>,
		val dataOwnerId: String?
	): SortableFilterOptions<Contact>

	internal class ByServiceIds(
		val serviceIds: List<String>,
		val dataOwnerId: String?
	): SortableFilterOptions<Contact>
}

@InternalIcureApi
internal suspend fun mapContactFilterOptions(
	filterOptions: FilterOptions<Contact>,
	selfDataOwnerId: String,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Contact> = mapIfMetaFilterOptions(filterOptions) {
	mapContactFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is ContactFilters.ByDataOwner -> ContactByHcPartyFilter(
		hcpId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	is ContactFilters.ByCodeAndOpeningDate -> ContactByHcPartyTagCodeDateFilter(
		tagType = null,
		tagCode = null,
		codeType = filterOptions.codeType,
		codeCode = filterOptions.codeCode,
		startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
		endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
		healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	is ContactFilters.ByIdentifiers -> ContactByHcPartyIdentifiersFilter(
		identifiers = filterOptions.identifiers,
		healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	is ContactFilters.ByPatients -> ContactByHcPartyPatientTagCodeDateFilter(
		patientSecretForeignKeys = filterOptions.patients.flatMap {
			requireNotNull(entityEncryptionService) {
				"Contact filter options `byPatients` can't be used in iCure base apis"
			}.secretIdsOf(it.withTypeInfo(), null)
		},
		healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	is ContactFilters.ByPatientsSecretIds -> ContactByHcPartyPatientTagCodeDateFilter(
		patientSecretForeignKeys = filterOptions.secretIds,
		healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	is ContactFilters.ByServiceIds -> ContactByServiceIdsFilter(
		ids = filterOptions.serviceIds
	)
	is ContactFilters.ByTagAndOpeningDate -> ContactByHcPartyTagCodeDateFilter(
		tagType = filterOptions.tagType,
		tagCode = filterOptions.tagCode,
		codeType = null,
		codeCode = null,
		startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
		endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
		healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Contacts")
}