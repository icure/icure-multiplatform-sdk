package com.icure.sdk.filters

import com.icure.sdk.crypto.EntityEncryptionService
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
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object PatientFilters {
    /**
     * Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with a specific data owner.
     * @param dataOwnerId a data owner id
     * @return options for patient filtering
     */
    fun allPatientsForDataOwner(
        dataOwnerId: String
    ): BaseFilterOptions<Patient> =
        AllForDataOwner(dataOwnerId)

    /**
     * Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with the current data owner.
     * @return options for patient filtering
     */
    fun allPatientsForSelf(): FilterOptions<Patient> =
        AllForSelf

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
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the patients will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id
     * @return options for patient filtering
     */
    fun byIdentifiersForDataOwner(
        dataOwnerId: String,
        identifiers: List<Identifier>
    ): BaseSortableFilterOptions<Patient> =
        ByIdentifiersForDataOwner(identifiers, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
     * [Patient.ssin] matching one of the provided ssins.
     * These options are sortable. When sorting using these options the patients will be in the same order as the
     * provided ssins.
     * @param ssins a list of ssins
     * @param dataOwnerId a data owner id
     */
    fun bySsinsForDataOwner(
        dataOwnerId: String,
        ssins: List<String>
    ): BaseSortableFilterOptions<Patient> = BySsinsForDataOwner(ssins, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
     * [Patient.dateOfBirth] between the provided values (inclusive).
     * These options are sortable. When sorting using these options the patients will be ordered by date of birth.
     * @param fromDate the start date in YYYYMMDD format (inclusive)
     * @param toDate the end date in YYYYMMDD format (inclusive)
     * @param dataOwnerId a data owner id
     */
    fun byDateOfBirthBetweenForDataOwner(
        dataOwnerId: String,
        fromDate: Int,
        toDate: Int
    ): BaseSortableFilterOptions<Patient> = ByDateOfBirthBetweenForDataOwner(
        fromDate = fromDate,
        toDate = toDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
     * provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
     * [Patient.spouseName].
     *
     * @param searchString part of a patient name.
     * @param dataOwnerId a data owner id
     */
    fun byFuzzyNameForDataOwner(
        dataOwnerId: String,
        searchString: String
    ): BaseFilterOptions<Patient> =
        ByFuzzyNameForDataOwner(searchString, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
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
     * @param dataOwnerId a data owner id
     * @throws IllegalArgumentException if [profession] is not null and [education] is null.
     */
    fun byGenderEducationProfessionForDataOwner(
        dataOwnerId: String,
        gender: Gender,
        @DefaultValue("null")
        education: String? = null,
        @DefaultValue("null")
        profession: String? = null
    ): BaseSortableFilterOptions<Patient> =
        ByGenderEducationProfessionForDataOwner(
            gender = gender,
            education = education,
            profession = profession,
            dataOwnerId = dataOwnerId
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
     * provided [Patient.active] value.
     *
     * @param active true if the options should match active patients, false if it should match inactive patients.
     * @param dataOwnerId a data owner id
     */
    fun byActiveForDataOwner(
        dataOwnerId: String,
        active: Boolean
    ) : BaseFilterOptions<Patient> = ByActiveForDataOwner(active, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
     * starts with the provided [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the matching telecom number.
     *
     * @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
     * @param dataOwnerId a data owner id
     */
    fun byTelecomForDataOwner(
        dataOwnerId: String,
        searchString: String
    ) : BaseSortableFilterOptions<Patient> = ByTelecomForDataOwner(searchString, dataOwnerId)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
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
     * @param dataOwnerId a data owner id
     */
    fun byAddressPostalCodeHouseNumberForDataOwner(
        dataOwnerId: String,
        searchString: String,
        postalCode: String,
        @DefaultValue("null")
        houseNumber: String? = null
    ) : BaseSortableFilterOptions<Patient> =
        ByAddressPostalCodeHouseNumberForDataOwner(
            searchString = searchString,
            postalCode = postalCode,
            houseNumber = houseNumber,
            dataOwnerId = dataOwnerId,
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
     * [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
     * by the matching portion of street+postalCode+city, then by postal code and finally by house number.
     *
     * @param searchString part of a patient address street, postal code, or city
     * @param dataOwnerId a data owner id
     */
    fun byAddressForDataOwner(
        dataOwnerId: String,
        searchString: String
    ) : BaseSortableFilterOptions<Patient> =
        ByAddressForDataOwner(
            searchString = searchString,
            dataOwnerId = dataOwnerId
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have [Patient.externalId]
     * starting with the provided [externalIdPrefix].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the full [Patient.externalId].
     *
     * @param externalIdPrefix a patient external id prefix
     * @param dataOwnerId a data owner id
     */
    fun byExternalIdForDataOwner(
        dataOwnerId: String,
        externalIdPrefix: String
    ) : BaseSortableFilterOptions<Patient> =
        ByExternalIdForDataOwner(
            externalIdPrefix = externalIdPrefix,
            dataOwnerId = dataOwnerId
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the patients will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @return options for patient filtering
     */
    fun byIdentifiersForSelf(
        identifiers: List<Identifier>
    ): SortableFilterOptions<Patient> =
        ByIdentifiersForSelf(identifiers)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
     * [Patient.ssin] matching one of the provided ssins.
     * These options are sortable. When sorting using these options the patients will be in the same order as the
     * provided ssins.
     * @param ssins a list of ssins
     */
    fun bySsinsForSelf(
        ssins: List<String>
    ): SortableFilterOptions<Patient> = BySsinsForSelf(ssins)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
     * [Patient.dateOfBirth] between the provided values (inclusive).
     * These options are sortable. When sorting using these options the patients will be ordered by date of birth.
     * @param fromDate the start date in YYYYMMDD format (inclusive)
     * @param toDate the end date in YYYYMMDD format (inclusive)
     */
    fun byDateOfBirthBetweenForSelf(
        fromDate: Int,
        toDate: Int
    ): SortableFilterOptions<Patient> = ByDateOfBirthBetweenForSelf(
        fromDate = fromDate,
        toDate = toDate,
    )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
     * provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
     * [Patient.spouseName].
     *
     * @param searchString part of a patient name.
     */
    fun byFuzzyNameForSelf(
        searchString: String
    ): FilterOptions<Patient> =
        ByFuzzyNameForSelf(searchString)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
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
     * @throws IllegalArgumentException if [profession] is not null and [education] is null.
     */
    fun byGenderEducationProfessionForSelf(
        gender: Gender,
        @DefaultValue("null")
        education: String? = null,
        @DefaultValue("null")
        profession: String? = null
    ): SortableFilterOptions<Patient> =
        ByGenderEducationProfessionForSelf(
            gender = gender,
            education = education,
            profession = profession,
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
     * provided [Patient.active] value.
     *
     * @param active true if the options should match active patients, false if it should match inactive patients.
     */
    fun byActiveForSelf(
        active: Boolean
    ) : FilterOptions<Patient> = ByActiveForSelf(active)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
     * starts with the provided [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the matching telecom number.
     *
     * @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
     */
    fun byTelecomForSelf(
        searchString: String
    ) : SortableFilterOptions<Patient> = ByTelecomForSelf(searchString)

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
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
     */
    fun byAddressPostalCodeHouseNumberForSelf(
        searchString: String,
        postalCode: String,
        @DefaultValue("null")
        houseNumber: String? = null
    ) : SortableFilterOptions<Patient> =
        ByAddressPostalCodeHouseNumberForSelf(
            searchString = searchString,
            postalCode = postalCode,
            houseNumber = houseNumber,
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
     * [searchString].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
     * by the matching portion of street+postalCode+city, then by postal code and finally by house number.
     *
     * @param searchString part of a patient address street, postal code, or city
     */
    fun byAddressForSelf(
        searchString: String
    ) : SortableFilterOptions<Patient> =
        ByAddressForSelf(
            searchString = searchString,
        )

    /**
     * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have [Patient.externalId]
     * starting with the provided [externalIdPrefix].
     *
     * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
     * the full [Patient.externalId].
     *
     * @param externalIdPrefix a patient external id prefix
     */
    fun byExternalIdForSelf(
        externalIdPrefix: String
    ) : SortableFilterOptions<Patient> =
        ByExternalIdForSelf(
            externalIdPrefix = externalIdPrefix,
        )

    @Serializable
    internal class ByIds(
        val ids: List<String>
    ) : SortableFilterOptions<Patient> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    @Serializable
    internal class AllForDataOwner(
        val dataOwnerId: String
    ) : BaseFilterOptions<Patient>

    @Serializable
    internal data object AllForSelf : FilterOptions<Patient>

    @Serializable
    internal class ByIdentifiersForDataOwner(
        val identifiers: List<Identifier>,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class BySsinsForDataOwner(
        val ssins: List<String>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByDateOfBirthBetweenForDataOwner(
        val fromDate: Int,
        val toDate: Int,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByFuzzyNameForDataOwner(
        val searchString: String,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByGenderEducationProfessionForDataOwner(
        val gender: Gender,
        val education: String?,
        val profession: String?,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Patient> {
        init {
            require (profession == null || education != null) {
                "You must provide a value for education if you want to filter by profession"
            }
        }
    }

    @Serializable
    internal class ByActiveForDataOwner(
        val active: Boolean,
        val dataOwnerId: String
    ) : BaseFilterOptions<Patient>

    @Serializable
    internal class ByTelecomForDataOwner(
        val searchString: String,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByAddressPostalCodeHouseNumberForDataOwner(
        val searchString: String,
        val postalCode: String,
        val houseNumber: String?,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByAddressForDataOwner(
        val searchString: String,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByExternalIdForDataOwner(
        val externalIdPrefix: String,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Patient>

    @Serializable
    internal class ByIdentifiersForSelf(
        val identifiers: List<Identifier>
    ) : SortableFilterOptions<Patient>

    @Serializable
    internal class BySsinsForSelf(
        val ssins: List<String>
    ): SortableFilterOptions<Patient>

    @Serializable
    internal class ByDateOfBirthBetweenForSelf(
        val fromDate: Int,
        val toDate: Int
    ): SortableFilterOptions<Patient>

    @Serializable
    internal class ByFuzzyNameForSelf(
        val searchString: String
    ) : SortableFilterOptions<Patient>

    @Serializable
    internal class ByGenderEducationProfessionForSelf(
        val gender: Gender,
        val education: String?,
        val profession: String?
    ): SortableFilterOptions<Patient> {
        init {
            require (profession == null || education != null) {
                "You must provide a value for education if you want to filter by profession"
            }
        }
    }

    @Serializable
    internal class ByActiveForSelf(
        val active: Boolean
    ) : FilterOptions<Patient>

    @Serializable
    internal class ByTelecomForSelf(
        val searchString: String
    ) : SortableFilterOptions<Patient>

    @Serializable
    internal class ByAddressPostalCodeHouseNumberForSelf(
        val searchString: String,
        val postalCode: String,
        val houseNumber: String?
    ) : SortableFilterOptions<Patient>

    @Serializable
    internal class ByAddressForSelf(
        val searchString: String
    ) : SortableFilterOptions<Patient>

    @Serializable
    internal class ByExternalIdForSelf(
        val externalIdPrefix: String
    ) : SortableFilterOptions<Patient>
}


@InternalIcureApi
internal suspend fun mapPatientFilterOptions(
    filterOptions: FilterOptions<Patient>,
    selfDataOwnerId: String?,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Patient> = mapIfMetaFilterOptions(filterOptions) {
    mapPatientFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is PatientFilters.AllForDataOwner -> {
        PatientByHcPartyFilter(
            healthcarePartyId = filterOptions.dataOwnerId,
        )
    }
    PatientFilters.AllForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyFilter(
            healthcarePartyId = selfDataOwnerId,
        )
    }
    is PatientFilters.ByIds -> {
        PatientByIdsFilter(ids = filterOptions.ids.toSet())
    }
    is PatientFilters.ByActiveForDataOwner -> {
        PatientByHcPartyAndActiveFilter(
            healthcarePartyId = filterOptions.dataOwnerId,
            active = filterOptions.active
        )
    }
    is PatientFilters.ByAddressForDataOwner -> {
        PatientByHcPartyAndAddressFilter(
            searchString = filterOptions.searchString,
            postalCode = null,
            houseNumber = null,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByAddressPostalCodeHouseNumberForDataOwner -> {
        PatientByHcPartyAndAddressFilter(
            searchString = filterOptions.searchString,
            postalCode = filterOptions.postalCode,
            houseNumber = filterOptions.houseNumber,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByDateOfBirthBetweenForDataOwner -> {
        if (filterOptions.fromDate == filterOptions.toDate) {
            PatientByHcPartyDateOfBirthFilter(
                dateOfBirth = filterOptions.fromDate,
                healthcarePartyId = filterOptions.dataOwnerId
            )
        } else {
            PatientByHcPartyDateOfBirthBetweenFilter(
                minDateOfBirth = filterOptions.fromDate,
                maxDateOfBirth = filterOptions.toDate,
                healthcarePartyId = filterOptions.dataOwnerId
            )
        }
    }
    is PatientFilters.ByExternalIdForDataOwner -> {
        PatientByHcPartyAndExternalIdFilter(
            externalId = filterOptions.externalIdPrefix,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByFuzzyNameForDataOwner -> {
        PatientByHcPartyNameContainsFuzzyFilter(
            searchString = filterOptions.searchString,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByGenderEducationProfessionForDataOwner -> {
        PatientByHcPartyGenderEducationProfession(
            gender = filterOptions.gender,
            education = filterOptions.education,
            profession = filterOptions.profession,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByIdentifiersForDataOwner -> {
        PatientByHcPartyAndIdentifiersFilter(
            healthcarePartyId = filterOptions.dataOwnerId,
            identifiers = filterOptions.identifiers
        )
    }
    is PatientFilters.BySsinsForDataOwner -> {
        if (filterOptions.ssins.size == 1) {
            PatientByHcPartyAndSsinFilter(
                ssin = filterOptions.ssins.first(),
                healthcarePartyId = filterOptions.dataOwnerId
            )
        } else {
            PatientByHcPartyAndSsinsFilter(
                ssins = filterOptions.ssins,
                healthcarePartyId = filterOptions.dataOwnerId
            )
        }
    }
    is PatientFilters.ByTelecomForDataOwner -> {
        PatientByHcPartyAndTelecomFilter(
            searchString = filterOptions.searchString,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is PatientFilters.ByActiveForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyAndActiveFilter(
            healthcarePartyId = selfDataOwnerId,
            active = filterOptions.active
        )
    }
    is PatientFilters.ByAddressForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyAndAddressFilter(
            searchString = filterOptions.searchString,
            postalCode = null,
            houseNumber = null,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is PatientFilters.ByAddressPostalCodeHouseNumberForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyAndAddressFilter(
            searchString = filterOptions.searchString,
            postalCode = filterOptions.postalCode,
            houseNumber = filterOptions.houseNumber,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is PatientFilters.ByDateOfBirthBetweenForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        if (filterOptions.fromDate == filterOptions.toDate) {
            PatientByHcPartyDateOfBirthFilter(
                dateOfBirth = filterOptions.fromDate,
                healthcarePartyId = selfDataOwnerId
            )
        } else {
            PatientByHcPartyDateOfBirthBetweenFilter(
                minDateOfBirth = filterOptions.fromDate,
                maxDateOfBirth = filterOptions.toDate,
                healthcarePartyId = selfDataOwnerId
            )
        }
    }
    is PatientFilters.ByExternalIdForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyAndExternalIdFilter(
            externalId = filterOptions.externalIdPrefix,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is PatientFilters.ByFuzzyNameForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyNameContainsFuzzyFilter(
            searchString = filterOptions.searchString,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is PatientFilters.ByGenderEducationProfessionForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyGenderEducationProfession(
            gender = filterOptions.gender,
            education = filterOptions.education,
            profession = filterOptions.profession,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is PatientFilters.ByIdentifiersForSelf -> {
        PatientByHcPartyAndIdentifiersFilter(
            healthcarePartyId = selfDataOwnerId,
            identifiers = filterOptions.identifiers
        )
    }
    is PatientFilters.BySsinsForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        if (filterOptions.ssins.size == 1) {
            PatientByHcPartyAndSsinFilter(
                ssin = filterOptions.ssins.first(),
                healthcarePartyId = selfDataOwnerId
            )
        } else {
            PatientByHcPartyAndSsinsFilter(
                ssins = filterOptions.ssins,
                healthcarePartyId = selfDataOwnerId
            )
        }
    }
    is PatientFilters.ByTelecomForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        PatientByHcPartyAndTelecomFilter(
            searchString = filterOptions.searchString,
            healthcarePartyId = selfDataOwnerId
        )
    }
    else -> {
        throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Patients")
    }
}