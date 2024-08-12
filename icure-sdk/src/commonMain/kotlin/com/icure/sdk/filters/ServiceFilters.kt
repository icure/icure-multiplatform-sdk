package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.filters.ContactFilters.byPatientsSecretIds
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

object ServiceFilters {
    /**
     * Create options for service filtering that will match all services shared with a specific data owner.
     * If [dataOwnerId] is null the filter will match all services shared directly with the current data owner.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for service filtering
     */
    fun allServicesForDataOwner(
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): FilterOptions<Service> =
        ByDataOwner(dataOwnerId)

    /**
     * Options for service filtering which match all the services shared with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the services will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for service filtering
     */
    fun byIdentifiers(
        identifiers: List<Identifier>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> =
        ByIdentifiers(identifiers, dataOwnerId)

    /**
     * Options for service filtering which match all services shared with a specific data owner that have a certain code.
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
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
     */
    fun byCodeAndValueDate(
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> = ByCodeAndValueDate(
        codeType = codeType,
        codeCode = codeCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared with a specific data owner that have a certain tag.
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
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
     */
    fun byTagAndValueDate(
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null,
        @DefaultValue("null")
        startOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        endOfServiceValueDate: Long? = null,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> = ByTagAndValueDate(
        tagType = tagType,
        tagCode = tagCode,
        startOfServiceValueDate = startOfServiceValueDate,
        endOfServiceValueDate = endOfServiceValueDate,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared with a specific data owner that are linked with one
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
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byPatients(
        patients: List<Patient>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> = ByPatients(
        patients = patients,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for service filtering which match all services shared with a specific data owner that are linked with a
     * patient through one of the provided secret ids.
     * These options are sortable. When sorting using these options the services will be sorted by the linked patients
     * secret id, using the same order as the input.
     * @param secretIds a list of patients secret ids
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byPatientsSecretIds(
        secretIds: List<String>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> = ByPatientsSecretIds(
        secretIds = secretIds,
        dataOwnerId = dataOwnerId
    )


    /**
     * Options for service filtering which match all services from shared with a specific data owner that exist in at
     * least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
     * id.
     *
     * These options are sortable. When sorting using these options the services will be sorted in the same order as the
     * input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
     * health element service is considered for the ordering.
     * @param healthElementIds a list of health element ids
     * @param dataOwnerId a data owner id or null to use the current data owner id
     */
    fun byHealthElementIdFromSubcontact(
        healthElementIds: List<String>,
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): SortableFilterOptions<Service> = ByHealthElementIdFromSubcontact(
        healthElementIds = healthElementIds,
        dataOwnerId = dataOwnerId
    )

    /**
     * Filter options that match all services with one of the provided ids.
     * These options are sortable. When sorting using these options the services will have the same order as the input ids.
     * @param ids a list of unique service ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<Service> = ByIds(ids)

    internal class ByDataOwner(
        val dataOwnerId: String?
    ) : FilterOptions<Service>

    internal class ByIdentifiers(
        val identifiers: List<Identifier>,
        val dataOwnerId: String?
    ) : SortableFilterOptions<Service>

    internal class ByCodeAndValueDate(
        val codeType: String,
        val codeCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?,
        val dataOwnerId: String?
    ): SortableFilterOptions<Service> {
        init {
            require (codeCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Code code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    internal class ByTagAndValueDate(
        val tagType: String,
        val tagCode: String?,
        val startOfServiceValueDate: Long?,
        val endOfServiceValueDate: Long?,
        val dataOwnerId: String?
    ): SortableFilterOptions<Service> {
        init {
            require (tagCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
                "Tag code is mandatory if you want to restrict the range of service value date"
            }
        }
    }

    internal class ByPatients(
        val patients: List<Patient>,
        val dataOwnerId: String?
    ): SortableFilterOptions<Service>

    internal class ByPatientsSecretIds(
        val secretIds: List<String>,
        val dataOwnerId: String?
    ): SortableFilterOptions<Service>

    internal class ByHealthElementIdFromSubcontact(
        val healthElementIds: List<String>,
        val dataOwnerId: String?
    ): SortableFilterOptions<Service>

    internal class ByIds(
        val ids: List<String>
    ): SortableFilterOptions<Service> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }
}

@InternalIcureApi
internal suspend fun mapServiceFilterOptions(
    filterOptions: FilterOptions<Service>,
    selfDataOwnerId: String,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Service> = mapIfMetaFilterOptions(filterOptions) {
    mapServiceFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is ServiceFilters.ByDataOwner -> ServiceByHcPartyFilter(
        hcpId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByCodeAndValueDate -> ServiceByHcPartyTagCodeDateFilter(
        patientSecretForeignKey = null,
        tagType = null,
        tagCode = null,
        codeType = filterOptions.codeType,
        codeCode = filterOptions.codeCode,
        startValueDate = filterOptions.startOfServiceValueDate,
        endValueDate = filterOptions.endOfServiceValueDate,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByHealthElementIdFromSubcontact -> ServiceByHcPartyHealthElementIdsFilter(
        healthElementIds = filterOptions.healthElementIds,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByIdentifiers -> ServiceByHcPartyIdentifiersFilter(
        identifiers = filterOptions.identifiers,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByIds -> ServiceByIdsFilter(ids = filterOptions.ids.toSet())
    is ServiceFilters.ByPatients -> ServiceBySecretForeignKeys(
        patientSecretForeignKeys = filterOptions.patients.flatMap {
            requireNotNull(entityEncryptionService) {
                "Service filter options `byPatients` can't be used in iCure base apis"
            }.secretIdsOf(it.withTypeInfo(), null)
        }.toSet(),
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByPatientsSecretIds -> ServiceBySecretForeignKeys(
        patientSecretForeignKeys = filterOptions.secretIds.toSet(),
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    is ServiceFilters.ByTagAndValueDate -> ServiceByHcPartyTagCodeDateFilter(
        patientSecretForeignKey = null,
        tagType = filterOptions.tagType,
        tagCode = filterOptions.tagCode,
        codeType = null,
        codeCode = null,
        startValueDate = filterOptions.startOfServiceValueDate,
        endValueDate = filterOptions.endOfServiceValueDate,
        healthcarePartyId = filterOptions.dataOwnerId ?: selfDataOwnerId
    )
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Services")
}