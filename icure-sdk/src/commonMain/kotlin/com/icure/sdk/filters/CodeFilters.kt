package com.icure.sdk.filters

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.code.AllCodesFilter
import com.icure.sdk.model.filter.code.CodeByIdsFilter
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object CodeFilters {
    /**
     * Filter options to match all codes.
     * These options are not sortable.
     */
    fun all(): FilterOptions<Code> = All

    /**
     * Filter options that match all codes with one of the provided ids.
     * These options are sortable. When sorting using these options the codes will have the same order as the input ids.
     * @param ids a list of unique code ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): BaseSortableFilterOptions<Code> = ByIds(ids)

    /**
     * Filter options to match all codes with the provided type that have a [Code.label] or [Code.searchTerms] for the
     * provided [language].
     * Optionally, you can also limit the filter to match only codes where that contain some search string ([label]) in
     * label the [Code.label] or [Code.searchTerms] for the chosen [language].
     * Finally if you limit your search by a label you can further limit the search to only include codes for a specific
     * [region]. Note: you can't limit the search to a specific [region] without providing a [label]. If you want to get
     * all codes of a certain type for a specific [region] you should instead use [TODO]
     * These options are not sortable.
     * @param language the language in ISO standard of the label. Only the codes that have this language as key
     * in the [Code.label] or in the [Code.searchTerms] will be included in the result.
     * @param type the type of the code. Only the codes with this `type` will be included in the result.
     * @param label a search string. If provided, then the filter will match only codes that have word of at least 3
     * characters starting with this search string in any of the following properties:
     * - the [Code.label] for the specified [language]
     * - the [Code.searchTerms] for the specified [language]
     * @param region if provided, only the codes that have this region in the [Code.regions] list will be included in
     * the result. If None, the resulting codes will not be filtered based on the region.
     * @throws IllegalArgumentException if region is provided but label is not
     */
    fun byLanguageTypeLabelRegion(
        language: String,
        type: String,
        @DefaultValue("null")
        label: String? = null,
        @DefaultValue("null")
        region: String? = null
    ): BaseFilterOptions<Code> = ByLanguageTypeLabelRegion(
        language = language,
        type = type,
        label = label,
        region = region
    )

    @Serializable
    internal data object All : FilterOptions<Code>

    @Serializable
    internal class ByIds(
        val ids: List<String>
    ): BaseSortableFilterOptions<Code> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    @Serializable
    internal class ByLanguageTypeLabelRegion(
        val language: String,
        val type: String,
        val label: String?,
        val region: String?
    ): BaseFilterOptions<Code> {
        init {
            require(label != null || region == null) {
                "You can use region in byLanguageTypeLabelRegion options only if you are filtering for a specific label"
            }
        }
    }
}

internal suspend fun mapCodeFilterOptions(
    filterOptions: FilterOptions<Code>
): AbstractFilter<Code> = mapIfMetaFilterOptions(filterOptions, ::mapCodeFilterOptions) ?: when (filterOptions) {
    CodeFilters.All -> AllCodesFilter()
    is CodeFilters.ByIds -> CodeByIdsFilter(ids = filterOptions.ids.toSet())
    is CodeFilters.ByLanguageTypeLabelRegion -> CodeByRegionTypeLabelLanguageFilter(
        language = filterOptions.language,
        type = filterOptions.type,
        label = filterOptions.label,
        region = filterOptions.region
    )
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Codes")
}