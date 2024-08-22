package com.icure.sdk.filters

import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.medicallocation.AllMedicalLocationsFilter
import com.icure.sdk.model.filter.medicallocation.MedicalLocationByPostCodeFilter
import kotlinx.serialization.Serializable

object MedicalLocationFilters {

	/**
	 * Filter options to match all medical locations.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<MedicalLocation> = All

	/**
	 * Filter options to match all the medical locations where the postcode in [MedicalLocation.address] is equal to [postCode].
	 *
	 * @param postCode the post code to use in the filter.
	 */
	fun byPostCode(
		postCode: String
	): BaseFilterOptions<MedicalLocation> = ByPostCode(postCode)

	@Serializable
	internal data object All: BaseFilterOptions<MedicalLocation>

	@Serializable
	internal class ByPostCode(
		val postCode: String
	) : BaseFilterOptions<MedicalLocation>

}

internal suspend fun mapMedicalLocationFilterOptions(
	filterOptions: FilterOptions<MedicalLocation>
): AbstractFilter<MedicalLocation> = mapIfMetaFilterOptions(filterOptions, ::mapMedicalLocationFilterOptions) ?: when (filterOptions) {
	is MedicalLocationFilters.All -> AllMedicalLocationsFilter()
	is MedicalLocationFilters.ByPostCode -> MedicalLocationByPostCodeFilter(filterOptions.postCode)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering MedicalLocations")
}
