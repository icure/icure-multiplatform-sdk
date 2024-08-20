package com.icure.sdk.js.filters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.DispatchedMetaFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.utils.InternalIcureApi

@JsExport
@JsName("FilterOptions")
interface FilterOptionsJs<T : IdentifiableJs<String>>

@JsExport
@JsName("SortableFilterOptions")
interface SortableFilterOptionsJs<T : IdentifiableJs<String>> : FilterOptionsJs<T>

@JsExport
@JsName("BaseFilterOptions")
interface BaseFilterOptionsJs<T : IdentifiableJs<String>> : FilterOptionsJs<T>

@JsExport
@JsName("BaseSortableFilterOptions")
interface BaseSortableFilterOptionsJs<T : IdentifiableJs<String>> : BaseFilterOptionsJs<T> , SortableFilterOptionsJs<T>

internal class FilterOptionsJsImpl<T_JS : IdentifiableJs<String>> (
	val options: FilterOptions<*>
) : FilterOptionsJs<T_JS> {
	@Suppress("UNCHECKED_CAST")
	internal fun <T : Identifiable<String>> castOptions(): FilterOptions<T> = options as FilterOptions<T>
}

internal class SortableFilterOptionsJsImpl<T_JS : IdentifiableJs<String>> (
	val options: SortableFilterOptions<*>
) : SortableFilterOptionsJs<T_JS> {
	@Suppress("UNCHECKED_CAST")
	internal fun <T : Identifiable<String>> castOptions(): SortableFilterOptions<T> = options as SortableFilterOptions<T>
}

internal class BaseFilterOptionsJsImpl<T_JS : IdentifiableJs<String>> (
	val options: BaseFilterOptions<*>
) : BaseFilterOptionsJs<T_JS> {
	@Suppress("UNCHECKED_CAST")
	internal fun <T : Identifiable<String>> castOptions(): BaseFilterOptions<T> = options as BaseFilterOptions<T>
}

internal class BaseSortableFilterOptionsJsImpl<T_JS : IdentifiableJs<String>> (
	val options: BaseSortableFilterOptions<*>
) : BaseSortableFilterOptionsJs<T_JS> {
	@Suppress("UNCHECKED_CAST")
	internal fun <T : Identifiable<String>> castOptions(): BaseSortableFilterOptions<T> = options as BaseSortableFilterOptions<T>
}

internal fun <T : Identifiable<String>> baseSortableFilterOptions_fromJs(
	filterOptions: BaseSortableFilterOptionsJs<*>
): BaseSortableFilterOptions<T> = when (filterOptions) {
	is BaseSortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is BaseFilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options are not sortable")
	is SortableFilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options can't be used with base sdks")
	is FilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options can't be used with base sdks and are not sortable")
	else -> throw IllegalArgumentException("The provided filter options could not be recognised by the SDK")
}

internal fun <T : Identifiable<String>> baseFilterOptions_fromJs(filterOptions: BaseFilterOptionsJs<*>): BaseFilterOptions<T> = when (filterOptions) {
	is BaseSortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is BaseFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is SortableFilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options can't be used with base sdks")
	is FilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options can't be used with base sdks")
	else -> throw IllegalArgumentException("The provided filter options could not be recognised by the SDK")
}

internal fun <T : Identifiable<String>> sortableFilterOptions_fromJs(
	filterOptions: SortableFilterOptionsJs<*>
): SortableFilterOptions<T> = when (filterOptions) {
	is BaseSortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is BaseFilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options are not sortable")
	is SortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is FilterOptionsJsImpl<*> -> throw IllegalArgumentException("The provided filter options can't be used with base sdks and are not sortable")
	else -> throw IllegalArgumentException("The provided filter options could not be recognised by the SDK")
}

internal fun <T : Identifiable<String>> filterOptions_fromJs(
	filterOptions: FilterOptionsJs<*>
): FilterOptions<T> = when (filterOptions) {
	is BaseSortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is BaseFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is SortableFilterOptionsJsImpl<*> -> filterOptions.castOptions()
	is FilterOptionsJsImpl<*> -> filterOptions.castOptions()
	else -> throw IllegalArgumentException("The provided filter options could not be recognised by the SDK")
}

/**
 * Internal implementation of meta-filters-options.
 * There is nothing really wrong in using these implementations directly from typescript, but we are going to provide
 * also more user-friendly versions of the methods, with typescript style overloads and varargs.
 * Those user-friendly methods are implemented using these methods under the hood.
 */
@JsExport
@OptIn(InternalIcureApi::class)
object InternalFilterOptions {
	private fun <T : IdentifiableJs<String>> dispatchedFilterOptions_toJs(filterOptions: FilterOptions<*>): FilterOptionsJs<T> =
		when (filterOptions) {
			is BaseSortableFilterOptions<*> -> BaseSortableFilterOptionsJsImpl(filterOptions)
			is BaseFilterOptions<*> -> BaseFilterOptionsJsImpl(filterOptions)
			is SortableFilterOptions<*> -> SortableFilterOptionsJsImpl(filterOptions)
			else -> FilterOptionsJsImpl(filterOptions)
		}

	fun <T : IdentifiableJs<String>> union(
		a: FilterOptionsJs<T>,
		b: FilterOptionsJs<T>,
		vararg others: FilterOptionsJs<T>
	): FilterOptionsJs<T> =
		dispatchedFilterOptions_toJs(
			DispatchedMetaFilterOptions.union(
				filterOptions_fromJs(a),
				filterOptions_fromJs(b),
				*Array(others.size) { filterOptions_fromJs(others[it]) }
			)
		)


	fun <T : IdentifiableJs<String>> intersection(
		a: FilterOptionsJs<T>,
		b: FilterOptionsJs<T>,
		vararg others: FilterOptionsJs<T>
	): FilterOptionsJs<T> =
		dispatchedFilterOptions_toJs(
			DispatchedMetaFilterOptions.intersection(
				filterOptions_fromJs(a),
				filterOptions_fromJs(b),
				*Array(others.size) { filterOptions_fromJs(others[it]) }
			)
		)


	fun <T : IdentifiableJs<String>> difference(
		of: FilterOptionsJs<T>,
		subtracting: FilterOptionsJs<T>
	): FilterOptionsJs<T> =
		dispatchedFilterOptions_toJs(
			DispatchedMetaFilterOptions.union(
				filterOptions_fromJs(of),
				filterOptions_fromJs(subtracting)
			)
		)

}