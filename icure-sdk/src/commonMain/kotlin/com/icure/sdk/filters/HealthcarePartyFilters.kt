package com.icure.sdk.filters

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.requireUniqueElements

object HealthcarePartyFilters {
    /**
     * Filter options to match all healthcare parties.
     * These options are not sortable.
     */
    fun all(): FilterOptions<HealthcareParty> = All

    /**
     * Options for healthcare party filtering which match all the healthcare parties that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the healthcare parties will be in the same order as
     * the input identifiers. In case an entity has multiple identifiers only the first matching identifier is considered
     * for the sorting.
     * @param identifiers a list of identifiers
     */
    fun byIdentifiers(identifiers: List<Identifier>): FilterOptions<HealthcareParty> = ByIdentifiers(identifiers)

    /**
     * Options for healthcare party filtering which match all healthcare parties shared with a specific data owner that have a certain code.
     * If you specify only the [codeType] you will get all entities that have at least a code of that type.
     *
     * These options are sortable. When sorting using these options the healthcare parties will be sorted by [codeCode]
     *
     * @param codeType a code type
     * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
     * with a code of the provided type.
     */
    fun byCode(
        codeType: String,
        @DefaultValue("null")
        codeCode: String? = null
    ): SortableFilterOptions<HealthcareParty> = ByCode(codeType, codeCode)

    /**
     * Options for healthcare party filtering which match all healthcare parties shared with a specific data owner that have a certain tag.
     * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
     *
     * These options are sortable. When sorting using these options the healthcare parties will be sorted by [tagCode]
     *
     * @param tagType a tag type
     * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
     * with a tag of the provided type.
     */
    fun byTag(
        tagType: String,
        @DefaultValue("null")
        tagCode: String? = null
    ): SortableFilterOptions<HealthcareParty> = ByTag(tagType, tagCode)

    /**
     * Filter options that match all healthcare parties with one of the provided ids.
     * These options are sortable. When sorting using these options the healthcare parties will have the same order as the input ids.
     * @param ids a list of unique healthcare party ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): SortableFilterOptions<HealthcareParty> = ByIds(ids)

    /**
     * Get all healthcare parties where the normalized last_name+first_name or speciality contain the provided
     * search string.
     *
     * These options are sortable. When sorting using these options the healthcare parties will be sorted lexicographically
     * by the matching part of the last_name+first_name or speciality substring. If a healthcare party has multiple
     * matching substrings only the first will be returned.
     * @param searchString a string to search for
     * @param descending when using these options to sort if true inverts the sorting order.
     */
    fun byName(
        searchString: String,
        descending: Boolean = false
    ): SortableFilterOptions<HealthcareParty> = ByName(searchString, descending)


    internal data object All: FilterOptions<HealthcareParty>
    internal class ByIdentifiers(val identifiers: List<Identifier>): FilterOptions<HealthcareParty>
    internal class ByCode(
        val codeType: String,
        val codeCode: String?
    ): SortableFilterOptions<HealthcareParty>
    internal class ByTag(
        val tagType: String,
        val tagCode: String?
    ): SortableFilterOptions<HealthcareParty>
    internal class ByIds(
        val ids: List<String>
    ): SortableFilterOptions<HealthcareParty> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    internal class ByName(
        val searchString: String,
        val descending: Boolean
    ): SortableFilterOptions<HealthcareParty>
}


internal suspend fun mapHealthcarePartyFilterOptions(
    filterOptions: FilterOptions<HealthcareParty>
): AbstractFilter<HealthcareParty> = mapIfMetaFilterOptions(filterOptions, ::mapHealthcarePartyFilterOptions) ?: when (filterOptions) {
    HealthcarePartyFilters.All -> AllHealthcarePartiesFilter()
    is HealthcarePartyFilters.ByIds -> HealthcarePartyByIdsFilter(ids = filterOptions.ids.toSet())
    is HealthcarePartyFilters.ByIdentifiers -> HealthcarePartyByIdentifiersFilter(identifiers = filterOptions.identifiers)
    is HealthcarePartyFilters.ByCode -> HealthcarePartyByTagCodeFilter(
        tagType = null,
        tagCode = null,
        codeType = filterOptions.codeType,
        codeCode = filterOptions.codeCode,
    )
    is HealthcarePartyFilters.ByName -> HealthcarePartyByNameFilter(
        name = filterOptions.searchString,
        descending = filterOptions.descending
    )
    is HealthcarePartyFilters.ByTag -> HealthcarePartyByTagCodeFilter(
        tagType = filterOptions.tagType,
        tagCode = filterOptions.tagCode,
        codeType = null,
        codeCode = null,
    )
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering HealthcareParties")
}