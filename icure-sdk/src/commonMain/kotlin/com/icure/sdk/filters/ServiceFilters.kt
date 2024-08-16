package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.embed.SubContact
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.service.ServiceByIdsFilter
import com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object ServiceFilters {
    /**
     * Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with a specific data owner.
     * @param dataOwnerId a data owner id
     * @return options for service filtering
     */
    fun allServicesForDataOwner(
        dataOwnerId: String
    ): BaseFilterOptions<Service> =
        AllForDataOwner(dataOwnerId)

    /**
     * Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with the current data owner.
     * @return options for service filtering
     */
    fun allServicesForSelf(): FilterOptions<Service> =
        AllForSelf

    /**
     * Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the services will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id
     * @return options for service filtering
     */
    fun byIdentifiersForDataOwner(
        dataOwnerId: String,
        identifiers: List<Identifier>,
    ): BaseSortableFilterOptions<Service> =
        ByIdentifiersForDataOwner(identifiers, dataOwnerId)

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
     * If you specify only the [codeType] you will get all entities that have at least a code of that type.
     *
     * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
     * if the first is missing), but in that case you must specify the [codeCode].
     *
     * These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
     * by [Service.valueDate].
     *
     * @param codeType a code type
     * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
     * with a code of the provided type.
     * @param startOfServiceValueDate if provided the options will match only services with a value date
     * that is after this value (inclusive).
     * @param endOfServiceValueDate if provided the options will match only services with a value date
     * that is before this value (inclusive).
     * @param dataOwnerId a data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
     */
    fun byCodeAndValueDateForDataOwner(
        dataOwnerId: String,
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
    ): BaseSortableFilterOptions<Service> = ByCodeAndValueDateForDataOwner(
        codeType = codeType,
        codeCode = codeCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
     * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
     *
     * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
     * if the first is missing), but in that case you must specify the [tagCode].
     *
     * These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
     * by [Service.valueDate].
     *
     * @param tagType a tag type
     * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
     * with a tag of the provided type.
     * @param startOfServiceValueDate if provided the options will match only services with a value date
     * that is after this value (inclusive).
     * @param endOfServiceValueDate if provided the options will match only services with a value date
     * that is before this value (inclusive).
     * @param dataOwnerId a data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
     */
    fun byTagAndValueDateForDataOwner(
        dataOwnerId: String,
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
    ): BaseSortableFilterOptions<Service> = ByTagAndValueDateForDataOwner(
        tagType = tagType,
        tagCode = tagCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
     * of the provided patients.
     *
     * When using these options the sdk will automatically extract the secret ids from the provided patients and use
     * those for filtering.
     * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
     * If the current data owner does not have access to any secret id of one of the provide patients the patient will
     * simply be ignored.
     * Note that these may not be used in methods of apis from [IcureBaseApis].
     *
     * These options are sortable. When sorting using these options the services will be sorted by the patients, using
     * the same order as the input patients.
     * @param patients a list of patients.
     * @param dataOwnerId a data owner id
     */
    fun byPatientsForDataOwner(
        dataOwnerId: String,
        patients: List<Patient>,
    ): SortableFilterOptions<Service> = ByPatientsForDataOwner(
        patients = patients,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
     * patient through one of the provided secret ids.
     * These options are sortable. When sorting using these options the services will be sorted by the linked patients
     * secret id, using the same order as the input.
     * @param secretIds a list of patients secret ids
     * @param dataOwnerId a data owner id
     */
    fun byPatientsSecretIdsForDataOwner(
        dataOwnerId: String,
        secretIds: List<String>,
    ): BaseSortableFilterOptions<Service> = ByPatientsSecretIdsForDataOwner(
        secretIds = secretIds,
        dataOwnerId = dataOwnerId
    )


    /**
     * Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with a specific data owner that exist in at
     * least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
     * id.
     *
     * These options are sortable. When sorting using these options the services will be sorted in the same order as the
     * input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
     * health element service is considered for the ordering.
     * @param healthElementIds a list of health element ids
     * @param dataOwnerId a data owner id
     */
    fun byHealthElementIdFromSubcontactForDataOwner(
        dataOwnerId: String,
        healthElementIds: List<String>,
    ): BaseSortableFilterOptions<Service> = ByHealthElementIdFromSubcontactForDataOwner(
        healthElementIds = healthElementIds,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the services will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id
     * @return options for service filtering
     */
    fun byIdentifiersForSelf(
        identifiers: List<Identifier>,
    ): SortableFilterOptions<Service> =
        ByIdentifiersForSelf(identifiers)

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
     * If you specify only the [codeType] you will get all entities that have at least a code of that type.
     *
     * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
     * if the first is missing), but in that case you must specify the [codeCode].
     *
     * These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
     * by [Service.valueDate].
     *
     * @param codeType a code type
     * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
     * with a code of the provided type.
     * @param startOfServiceValueDate if provided the options will match only services with a value date
     * that is after this value (inclusive).
     * @param endOfServiceValueDate if provided the options will match only services with a value date
     * that is before this value (inclusive).
     * @param dataOwnerId a data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
     */
    fun byCodeAndValueDateForSelf(
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
    ): SortableFilterOptions<Service> = ByCodeAndValueDateForSelf(
        codeType = codeType,
        codeCode = codeCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
     * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
     *
     * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
     * if the first is missing), but in that case you must specify the [tagCode].
     *
     * These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
     * by [Service.valueDate].
     *
     * @param tagType a tag type
     * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
     * with a tag of the provided type.
     * @param startOfServiceValueDate if provided the options will match only services with a value date
     * that is after this value (inclusive).
     * @param endOfServiceValueDate if provided the options will match only services with a value date
     * that is before this value (inclusive).
     * @param dataOwnerId a data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
     */
    fun byTagAndValueDateForSelf(
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
    ): SortableFilterOptions<Service> = ByTagAndValueDateForSelf(
        tagType = tagType,
        tagCode = tagCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
     * of the provided patients.
     *
     * When using these options the sdk will automatically extract the secret ids from the provided patients and use
     * those for filtering.
     * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
     * If the current data owner does not have access to any secret id of one of the provide patients the patient will
     * simply be ignored.
     * Note that these may not be used in methods of apis from [IcureBaseApis].
     *
     * These options are sortable. When sorting using these options the services will be sorted by the patients, using
     * the same order as the input patients.
     * @param patients a list of patients.
     * @param dataOwnerId a data owner id
     */
    fun byPatientsForSelf(
        patients: List<Patient>,
    ): SortableFilterOptions<Service> = ByPatientsForSelf(
        patients = patients,
    )

    /**
     * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
     * patient through one of the provided secret ids.
     * These options are sortable. When sorting using these options the services will be sorted by the linked patients
     * secret id, using the same order as the input.
     * @param secretIds a list of patients secret ids
     * @param dataOwnerId a data owner id
     */
    fun byPatientsSecretIdsForSelf(
        secretIds: List<String>,
    ): SortableFilterOptions<Service> = ByPatientsSecretIdsForSelf(
        secretIds = secretIds,
    )


    /**
     * Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with the current data owner that exist in at
     * least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
     * id.
     *
     * These options are sortable. When sorting using these options the services will be sorted in the same order as the
     * input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
     * health element service is considered for the ordering.
     * @param healthElementIds a list of health element ids
     * @param dataOwnerId a data owner id
     */
    fun byHealthElementIdFromSubcontactForSelf(
        healthElementIds: List<String>,
    ): SortableFilterOptions<Service> = ByHealthElementIdFromSubcontactForSelf(
        healthElementIds = healthElementIds,
    )

    /**
     * Filter options that match all services with one of the provided ids.
     * These options are sortable. When sorting using these options the services will have the same order as the input ids.
     * @param ids a list of unique service ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): BaseSortableFilterOptions<Service> = ByIds(ids)

    @Serializable
    internal class AllForDataOwner(
        val dataOwnerId: String
    ) : BaseFilterOptions<Service>

    @Serializable
    internal class ByIdentifiersForDataOwner(
        val identifiers: List<Identifier>,
        val dataOwnerId: String
    ) : BaseSortableFilterOptions<Service>

    @Serializable
    internal class ByCodeAndValueDateForDataOwner(
        val codeType: String,
        val codeCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Service> {
        init {
            require (codeCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Code code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    @Serializable
    internal class ByTagAndValueDateForDataOwner(
        val tagType: String,
        val tagCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Service> {
        init {
            require (tagCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Tag code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    @Serializable
    internal class ByPatientsForDataOwner(
        val patients: List<Patient>,
        val dataOwnerId: String
    ): SortableFilterOptions<Service>

    @Serializable
    internal class ByPatientsSecretIdsForDataOwner(
        val secretIds: List<String>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Service>

    @Serializable
    internal class ByHealthElementIdFromSubcontactForDataOwner(
        val healthElementIds: List<String>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<Service>

    @Serializable
    internal data object AllForSelf : FilterOptions<Service>

    @Serializable
    internal class ByIdentifiersForSelf(
        val identifiers: List<Identifier>
    ) : SortableFilterOptions<Service>

    @Serializable
    internal class ByCodeAndValueDateForSelf(
        val codeType: String,
        val codeCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?
    ): SortableFilterOptions<Service> {
        init {
            require (codeCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Code code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    @Serializable
    internal class ByTagAndValueDateForSelf(
        val tagType: String,
        val tagCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?
    ): SortableFilterOptions<Service> {
        init {
            require (tagCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Tag code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    @Serializable
    internal class ByPatientsForSelf(
        val patients: List<Patient>
    ): SortableFilterOptions<Service>

    @Serializable
    internal class ByPatientsSecretIdsForSelf(
        val secretIds: List<String>
    ): SortableFilterOptions<Service>

    @Serializable
    internal class ByHealthElementIdFromSubcontactForSelf(
        val healthElementIds: List<String>
    ): SortableFilterOptions<Service>

    @Serializable
    internal class ByIds(
        val ids: List<String>
    ): BaseSortableFilterOptions<Service> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }
}

@InternalIcureApi
internal suspend fun mapServiceFilterOptions(
    filterOptions: FilterOptions<Service>,
    selfDataOwnerId: String?,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Service> = mapIfMetaFilterOptions(filterOptions) {
    mapServiceFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is ServiceFilters.AllForDataOwner -> {
        ServiceByHcPartyFilter(
            hcpId = filterOptions.dataOwnerId
        )
    }
    ServiceFilters.AllForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceByHcPartyFilter(
            hcpId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByCodeAndValueDateForDataOwner -> {
        ServiceByHcPartyTagCodeDateFilter(
            patientSecretForeignKey = null,
            tagType = null,
            tagCode = null,
            codeType = filterOptions.codeType,
            codeCode = filterOptions.codeCode,
            startValueDate = filterOptions.startOfServiceValueDate,
            endValueDate = filterOptions.endOfServiceValueDate,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByHealthElementIdFromSubcontactForDataOwner -> {
        ServiceByHcPartyHealthElementIdsFilter(
            healthElementIds = filterOptions.healthElementIds,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByIdentifiersForDataOwner -> {
        ServiceByHcPartyIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByPatientsForDataOwner -> {
        ServiceBySecretForeignKeys(
            patientSecretForeignKeys = filterOptions.patients.flatMap {
                requireNotNull(entityEncryptionService) {
                    "Service filter options `byPatients` can't be used in iCure base apis"
                }.secretIdsOf(it.withTypeInfo(), null)
            }.toSet(),
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByPatientsSecretIdsForDataOwner -> {
        ServiceBySecretForeignKeys(
            patientSecretForeignKeys = filterOptions.secretIds.toSet(),
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByTagAndValueDateForDataOwner -> {
        ServiceByHcPartyTagCodeDateFilter(
            patientSecretForeignKey = null,
            tagType = filterOptions.tagType,
            tagCode = filterOptions.tagCode,
            codeType = null,
            codeCode = null,
            startValueDate = filterOptions.startOfServiceValueDate,
            endValueDate = filterOptions.endOfServiceValueDate,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is ServiceFilters.ByCodeAndValueDateForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceByHcPartyTagCodeDateFilter(
            patientSecretForeignKey = null,
            tagType = null,
            tagCode = null,
            codeType = filterOptions.codeType,
            codeCode = filterOptions.codeCode,
            startValueDate = filterOptions.startOfServiceValueDate,
            endValueDate = filterOptions.endOfServiceValueDate,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByHealthElementIdFromSubcontactForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceByHcPartyHealthElementIdsFilter(
            healthElementIds = filterOptions.healthElementIds,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByIdentifiersForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceByHcPartyIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByPatientsForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceBySecretForeignKeys(
            patientSecretForeignKeys = filterOptions.patients.flatMap {
                entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
            }.toSet(),
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByPatientsSecretIdsForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceBySecretForeignKeys(
            patientSecretForeignKeys = filterOptions.secretIds.toSet(),
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByTagAndValueDateForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        ServiceByHcPartyTagCodeDateFilter(
            patientSecretForeignKey = null,
            tagType = filterOptions.tagType,
            tagCode = filterOptions.tagCode,
            codeType = null,
            codeCode = null,
            startValueDate = filterOptions.startOfServiceValueDate,
            endValueDate = filterOptions.endOfServiceValueDate,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is ServiceFilters.ByIds -> {
        ServiceByIdsFilter(ids = filterOptions.ids.toSet())
    }
    else -> {
        throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Services")
    }
}