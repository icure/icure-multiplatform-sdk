package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object HealthElementFilters {
    /**
     * Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with a specific data owner.
     * @param dataOwnerId a data owner id
     * @return options for health element filtering
     */
    fun allHealthElementsForDataOwner(
        dataOwnerId: String
    ): BaseFilterOptions<HealthElement> =
        AllForDataOwner(dataOwnerId)

    /**
     * Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with the current data owner.
     * @return options for health element filtering
     */
    fun allHealthElementsForSelf(): FilterOptions<HealthElement> =
        AllForSelf

    /**
     * Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the health elements will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @param identifiers a list of identifiers
     * @return options for health element filtering
     */
    fun byIdentifiersForDataOwner(
        dataOwnerId: String,
        identifiers: List<Identifier>
    ): BaseSortableFilterOptions<HealthElement> =
        ByIdentifiersForDataOwner(identifiers, dataOwnerId)

    /**
     * Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the health elements will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param identifiers a list of identifiers
     * @return options for health element filtering
     */
    fun byIdentifiersForSelf(
        identifiers: List<Identifier>
    ): SortableFilterOptions<HealthElement> =
        ByIdentifiersForSelf(identifiers)

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
     * If you specify only the [codeType] you will get all entities that have at least a code of that type.
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
     *
     * @param dataOwnerId a data owner id
     * @param codeType a code type
     * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
     * with a code of the provided type.
     */
    fun byCodeForDataOwner(
        dataOwnerId: String,
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null
    ): BaseSortableFilterOptions<HealthElement> = ByCodeForDataOwner(
        codeType = codeType,
        codeCode = codeCode,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
     * If you specify only the [codeType] you will get all entities that have at least a code of that type.
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
     *
     * @param codeType a code type
     * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
     * with a code of the provided type.
     */
    fun byCodeForSelf(
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null
    ): SortableFilterOptions<HealthElement> = ByCodeForSelf(
        codeType = codeType,
        codeCode = codeCode
    )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
     * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
     *
     * @param dataOwnerId a data owner id
     * @param tagType a tag type
     * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
     * with a tag of the provided type.
     */
    fun byTagForDataOwner(
        dataOwnerId: String,
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null
    ): BaseSortableFilterOptions<HealthElement> = ByTagForDataOwner(
        tagType = tagType,
        tagCode = tagCode,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
     * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
     *
     * @param tagType a tag type
     * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
     * with a tag of the provided type.
     */
    fun byTagForSelf(
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null
    ): SortableFilterOptions<HealthElement> = ByTagForSelf(
            tagType = tagType,
            tagCode = tagCode
        )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
     * of the provided patients.
     *
     * When using these options the sdk will automatically extract the secret ids from the provided patients and use
     * those for filtering.
     * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
     * If the current data owner does not have access to any secret id of one of the provide patients the patient will
     * simply be ignored.
     * Note that these may not be used in methods of apis from [IcureBaseApis].
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
     * the same order as the input patients.
     * @param dataOwnerId a data owner id
     * @param patients a list of patients.
     */
    fun byPatientsForDataOwner(
        dataOwnerId: String,
        patients: List<Patient>
    ): SortableFilterOptions<HealthElement> = ByPatientsForDataOwner(
        patients = patients,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
     * of the provided patients.
     *
     * When using these options the sdk will automatically extract the secret ids from the provided patients and use
     * those for filtering.
     * If you already have the secret ids of the patient you may instead use [byPatientsSecretIds].
     * If the current data owner does not have access to any secret id of one of the provide patients the patient will
     * simply be ignored.
     * Note that these may not be used in methods of apis from [IcureBaseApis].
     *
     * These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
     * the same order as the input patients.
     * @param patients a list of patients.
     */
    fun byPatientsForSelf(
        patients: List<Patient>
    ): SortableFilterOptions<HealthElement> = ByPatientsForSelf(
            patients = patients
        )


    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
     * patient through one of the provided secret ids.
     * These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
     * secret id, using the same order as the input.
     * @param dataOwnerId a data owner id
     * @param secretIds a list of patients secret ids
     */
    fun byPatientsSecretIdsForDataOwner(
        dataOwnerId: String,
        secretIds: List<String>
    ): BaseSortableFilterOptions<HealthElement> = ByPatientsSecretIdsForDataOwner(
        secretIds = secretIds,
        dataOwnerId = dataOwnerId
    )

    /**
     * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
     * patient through one of the provided secret ids.
     * These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
     * secret id, using the same order as the input.
     * @param secretIds a list of patients secret ids
     */
    fun byPatientsSecretIdsForSelf(
        secretIds: List<String>
    ): SortableFilterOptions<HealthElement> = ByPatientsSecretIdsForSelf(
            secretIds = secretIds
        )

    /**
     * Filter options that match all health elements with one of the provided ids.
     * These options are sortable. When sorting using these options the health elements will have the same order as the input ids.
     * @param ids a list of unique health element ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): BaseSortableFilterOptions<HealthElement> = ByIds(ids)

    @Serializable
    internal class AllForDataOwner(
        val dataOwnerId: String
    ): BaseFilterOptions<HealthElement>

    @Serializable
    internal data object AllForSelf: FilterOptions<HealthElement>

    @Serializable
    internal class ByIdentifiersForDataOwner(
        val identifiers: List<Identifier>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<HealthElement>

    @Serializable
    internal class ByIdentifiersForSelf(
        val identifiers: List<Identifier>,
    ): SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByCodeForDataOwner(
        val codeType: String,
        val codeCode: String?,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<HealthElement>

    @Serializable
    internal class ByCodeForSelf(
        val codeType: String,
        val codeCode: String?,
    ): SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByTagForDataOwner(
        val tagType: String,
        val tagCode: String?,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<HealthElement>

    @Serializable
    internal class ByTagForSelf(
        val tagType: String,
        val tagCode: String?,
    ): SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByPatientsForDataOwner(
        val patients: List<Patient>,
        val dataOwnerId: String
    ) : SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByPatientsForSelf(
        val patients: List<Patient>
    ) : SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByPatientsSecretIdsForDataOwner(
        val secretIds: List<String>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<HealthElement>

    @Serializable
    internal class ByPatientsSecretIdsForSelf(
        val secretIds: List<String>
    ): SortableFilterOptions<HealthElement>

    @Serializable
    internal class ByIds(
        val ids: List<String>
    ): BaseSortableFilterOptions<HealthElement> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }
}

@InternalIcureApi
internal suspend fun mapHealthElementFilterOptions(
    filterOptions: FilterOptions<HealthElement>,
    selfDataOwnerId: String?,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<HealthElement> = mapIfMetaFilterOptions(filterOptions) {
    mapHealthElementFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is HealthElementFilters.AllForDataOwner -> {
        HealthElementByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
    }
    is HealthElementFilters.AllForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartyFilter(hcpId = selfDataOwnerId)
    }
    is HealthElementFilters.ByIds -> {
        HealthElementByIdsFilter(ids = filterOptions.ids.toSet())
    }
    is HealthElementFilters.ByCodeForDataOwner -> {
        HealthElementByHcPartyTagCodeFilter(
            tagType = null,
            tagCode = null,
            codeType = filterOptions.codeType,
            codeCode = filterOptions.codeCode,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is HealthElementFilters.ByIdentifiersForDataOwner -> {
        HealthElementByHcPartyIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            hcPartyId = filterOptions.dataOwnerId
        )
    }
    is HealthElementFilters.ByPatientsForDataOwner -> {
        HealthElementByHcPartySecretForeignKeysFilter(
            patientSecretForeignKeys = filterOptions.patients.flatMap {
                requireNotNull(entityEncryptionService) {
                    "Health element filter options `byPatients` can't be used in iCure base apis"
                }.secretIdsOf(it.withTypeInfo(), null)
            }.toSet(),
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is HealthElementFilters.ByPatientsSecretIdsForDataOwner -> {
        HealthElementByHcPartySecretForeignKeysFilter(
            patientSecretForeignKeys = filterOptions.secretIds.toSet(),
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is HealthElementFilters.ByTagForDataOwner -> {
        HealthElementByHcPartyTagCodeFilter(
            tagType = filterOptions.tagType,
            tagCode = filterOptions.tagCode,
            codeType = null,
            codeCode = null,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }

    is HealthElementFilters.ByCodeForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartyTagCodeFilter(
            tagType = null,
            tagCode = null,
            codeType = filterOptions.codeType,
            codeCode = filterOptions.codeCode,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is HealthElementFilters.ByIdentifiersForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartyIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            hcPartyId = selfDataOwnerId
        )
    }
    is HealthElementFilters.ByPatientsForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartySecretForeignKeysFilter(
            patientSecretForeignKeys = filterOptions.patients.flatMap {
                entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
            }.toSet(),
            healthcarePartyId = selfDataOwnerId
        )
    }
    is HealthElementFilters.ByPatientsSecretIdsForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartySecretForeignKeysFilter(
            patientSecretForeignKeys = filterOptions.secretIds.toSet(),
            healthcarePartyId = selfDataOwnerId
        )
    }
    is HealthElementFilters.ByTagForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        HealthElementByHcPartyTagCodeFilter(
            tagType = filterOptions.tagType,
            tagCode = filterOptions.tagCode,
            codeType = null,
            codeCode = null,
            healthcarePartyId = selfDataOwnerId
        )
    }
    else -> {
        throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering HealthElements")
    }
}