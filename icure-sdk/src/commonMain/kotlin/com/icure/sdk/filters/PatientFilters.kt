package com.icure.sdk.filters

import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.Telecom
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter
import com.icure.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.requireUniqueElements

object PatientFilters {
    /**
     * Create options for patient filtering that will match all patients shared with a specific data owner.
     * If [dataOwnerId] is null the filter will match all patients shared directly with the current data owner.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for patient filtering
     */
    fun allPatientsForDataOwner(
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): FilterOptions<Patient> =
        ByDataOwner(dataOwnerId)

    /**
     * Filter options that match all patients with one of the provided ids.
     * These options are sortable. When sorting using these options the patients will have the same order as the input ids.
     * @param ids a list of unique patient ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<Patient> =
        ByIds(ids)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the patients will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for patient filtering
     */
    fun byIdentifiers(
        identifiers: List<Identifier>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Patient> =
        ByIdentifiers(identifiers, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have
     * [Patient.ssin] matching one of the provided ssins.
     * These options are sortable. When sorting using these options the patients will be in the same order as the
     * provided ssins.
     * @param ssins a list of ssins
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun bySsins(
        ssins: List<String>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Patient> = BySsins(ssins, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have
     * [Patient.dateOfBirth] between the provided values (inclusive).
     * These options are sortable. When sorting using these options the patients will be ordered by date of birth.
     * @param fromDate the start date in YYYYMMDD format (inclusive)
     * @param toDate the end date in YYYYMMDD format (inclusive)
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byDateOfBirthBetween(
        fromDate: Int,
        toDate: Int,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Patient> = ByDateOfBirthBetween(
        fromDate = fromDate,
        toDate = toDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have the
     * provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
     * [Patient.spouseName].
     *
     * @param searchString part of a patient name.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byFuzzyName(
        searchString: String,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): FilterOptions<Patient> =
        ByFuzzyName(searchString, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have the
     * provided [Patient.gender], and optionally also the provided [Patient.education] and [Patient.profession].
     * Note you can only provide profession if you have provided the education.
     *
     * These options are sortable. When sorting using these options the patients will be ordered first by education
     * then by profession.
     *
     * @param gender the patient gender.
     * @param education the patient education. If not provided patient the education of the patient will be ignored by
     * this filter.
     * @param profession the patient profession. If not provided patient the profession of the patient will be ignored by
     * this filter.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @throws IllegalArgumentException if [profession] is not null and [education] is null.
     */
    fun byGenderEducationProfession(
        gender: Gender,
        @DefaultValue("null")
        education: String? = null,
        @DefaultValue("null")
        profession: String? = null,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Patient> =
        ByGenderEducationProfession(
            gender = gender,
            education = education,
            profession = profession,
            dataOwnerId = dataOwnerId
        )

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have the
     * provided [Patient.active] value.
     *
     * @param active true if the options should match active patients, false if it should match inactive patients.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byActive(
        active: Boolean,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ) : FilterOptions<Patient> = ByActive(active, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have at least
     * an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
     * starts with the provided [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the matching telecom number.
     *
     * @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byTelecom(
        searchString: String,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ) : SortableFilterOptions<Patient> = ByTelecom(searchString, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have at least
     * an [Patient.addresses] where the [Address.street] or [Address.city] contain the provided [searchString] and
     * [Address.postalCode] matches the provided [postalCode].
     * Additionally you can limit the search to a specific house number.
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
     * by the matching portion of street+city, then by postal code and finally by house number.
     *
     * @param searchString part of a patient address street or city
     * @param postalCode the patient postal code
     * @param houseNumber the patient house number
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byAddressPostalCodeHouseNumber(
        searchString: String,
        postalCode: String,
        @DefaultValue("null")
        houseNumber: String? = null,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ) : SortableFilterOptions<Patient> =
        ByAddressPostalCodeHouseNumber(
            searchString = searchString,
            postalCode = postalCode,
            houseNumber = houseNumber,
            dataOwnerId = dataOwnerId,
        )

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have at least
     * an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
     * [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
     * by the matching portion of street+postalCode+city, then by postal code and finally by house number.
     *
     * @param searchString part of a patient address street, postal code, or city
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byAddress(
        searchString: String,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ) : SortableFilterOptions<Patient> =
        ByAddress(
            searchString = searchString,
            dataOwnerId = dataOwnerId
        )

    /**
     * Options for patient filtering which match all the patients shared with a specific data owner that have [Patient.externalId]
     * starting with the provided [externalIdPrefix].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the full [Patient.externalId].
     *
     * @param externalIdPrefix a patient external id prefix
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byExternalId(
        externalIdPrefix: String,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ) : SortableFilterOptions<Patient> =
        ByExternalId(
            externalIdPrefix = externalIdPrefix,
            dataOwnerId = dataOwnerId
        )

    internal class ByDataOwner(
        val dataOwnerId: String?
    ) : FilterOptions<Patient>

    internal class ByIdentifiers(
        val identifiers: List<Identifier>,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>

    internal class ByIds(
        val ids: List<String>
    ) : SortableFilterOptions<Patient> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    internal class BySsins(
        val ssins: List<String>,
        val dataOwnerId: String?
    ): SortableFilterOptions<Patient>

    internal class ByDateOfBirthBetween(
        val fromDate: Int,
        val toDate: Int,
        val dataOwnerId: String?
    ): SortableFilterOptions<Patient>

    internal class ByFuzzyName(
        val searchString: String,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>

    internal class ByGenderEducationProfession(
        val gender: Gender,
        val education: String?,
        val profession: String?,
        val dataOwnerId: String?
    ): SortableFilterOptions<Patient> {
        init {
            require (profession == null || education != null) {
                "You must provide a value for education if you want to filter by profession"
            }
        }
    }

    internal class ByActive(
        val active: Boolean,
        val dataOwnerId: String?
    ) : FilterOptions<Patient>

    internal class ByTelecom(
        val searchString: String,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>

    internal class ByAddressPostalCodeHouseNumber(
        val searchString: String,
        val postalCode: String,
        val houseNumber: String?,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>

    internal class ByAddress(
        val searchString: String,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>

    internal class ByExternalId(
        val externalIdPrefix: String,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Patient>
}


internal suspend fun mapPatientFilterOptions(
    filterOptions: FilterOptions<Patient>,
    selfDataOwnerId: String
): AbstractFilter<Patient> = mapIfMetaFilterOptions(filterOptions) {
    mapPatientFilterOptions(it, selfDataOwnerId)
} ?: when (filterOptions) {
    is PatientFilters.ByActive -> PatientByHcPartyAndActiveFilter(
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId,
        active = filterOptions.active
    )
    is PatientFilters.ByDataOwner -> PatientByHcPartyFilter(
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId,
    )
    is PatientFilters.ByAddress -> PatientByHcPartyAndAddressFilter(
        searchString = filterOptions.searchString,
        postalCode = null,
        houseNumber = null,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is PatientFilters.ByAddressPostalCodeHouseNumber -> PatientByHcPartyAndAddressFilter(
        searchString = filterOptions.searchString,
        postalCode = filterOptions.postalCode,
        houseNumber = filterOptions.houseNumber,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is PatientFilters.ByDateOfBirthBetween -> if (filterOptions.fromDate == filterOptions.toDate) {
        PatientByHcPartyDateOfBirthFilter(
            dateOfBirth = filterOptions.fromDate,
            healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
        )
    } else {
        PatientByHcPartyDateOfBirthBetweenFilter(
            minDateOfBirth = filterOptions.fromDate,
            maxDateOfBirth = filterOptions.toDate,
            healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
        )
    }
    is PatientFilters.ByExternalId -> PatientByHcPartyAndExternalIdFilter(
        externalId = filterOptions.externalIdPrefix,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is PatientFilters.ByFuzzyName -> PatientByHcPartyNameContainsFuzzyFilter(
        searchString = filterOptions.searchString,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is PatientFilters.ByGenderEducationProfession -> PatientByHcPartyGenderEducationProfession(
        gender = filterOptions.gender,
        education = filterOptions.education,
        profession = filterOptions.profession,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is PatientFilters.ByIdentifiers -> PatientByHcPartyAndIdentifiersFilter(
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId,
        identifiers = filterOptions.identifiers
    )
    is PatientFilters.ByIds -> PatientByIdsFilter(ids = filterOptions.ids.toSet())
    is PatientFilters.BySsins -> if (filterOptions.ssins.size == 1) {
        PatientByHcPartyAndSsinFilter(
            ssin = filterOptions.ssins.first(),
            healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
        )
    } else {
        PatientByHcPartyAndSsinsFilter(
            ssins = filterOptions.ssins,
            healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
        )
    }
    is PatientFilters.ByTelecom -> PatientByHcPartyAndTelecomFilter(
        searchString = filterOptions.searchString,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Patients")
}