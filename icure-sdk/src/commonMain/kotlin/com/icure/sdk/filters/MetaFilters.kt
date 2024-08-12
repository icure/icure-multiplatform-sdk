package com.icure.sdk.filters

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.ComplementFilter
import com.icure.sdk.model.filter.IntersectionFilter
import com.icure.sdk.model.filter.UnionFilter
import kotlin.js.JsName

/**
 * Get filter options that allow to create a filter which matches only entities that match all the provided filters
 * ([a], [b] and any filters in [others]).
 * [a] must be sortable options, and the returned options will also be sortable, using the same order given by [a].
 * @param a some sortable filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as intersection and are sortable
 * by [a]
 */
@JsName("sortableIntersection")
fun <E : Identifiable<String>> intersection(
	a: SortableFilterOptions<E>,
	b: FilterOptions<E>,
	vararg others: FilterOptions<E>
): SortableFilterOptions<E> {
	val sortableFilter = if (a is SortableIntersectionFilterOptions) {
		a.sortFilter
	} else {
		a
	}
	val otherOptions = if (a is SortableIntersectionFilterOptions) {
		a.otherOptions
	} else {
		emptyList()
	} + b + others
	return SortableIntersectionFilterOptions(
		sortableFilter,
		otherOptions.flattenedIntersection()
	)
}

/**
 * Get filter options that allow to create a filter which matches only entities that match all the provided filters
 * ([a], [b] and any filters in [others]).
 * The returned filter options are not sortable.
 * @param a some filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as intersection
 */
fun <E : Identifiable<String>> intersection(
	a: FilterOptions<E>,
	b: FilterOptions<E>,
	vararg others: FilterOptions<E>
): FilterOptions<E> = IntersectionFilterOptions((listOf(a, b) + others).flattenedIntersection())

/**
 * Get filter options that allow to create a filter which matches only entities that match at least one of the provided
 * filters ([a], [b] or any filter in [others]).
 * The returned filter options are not sortable.
 * @param a some filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as union
 */
fun <E : Identifiable<String>> union(
	a: FilterOptions<E>,
	b: FilterOptions<E>,
	vararg others: FilterOptions<E>
): FilterOptions<E> = UnionFilterOptions((listOf(a, b) + others).flatMap {
	if (it is UnionFilterOptions) {
		it.options
	} else listOf(it)
})

/**
 * Get filter options that allow to create a filter which matches all entities matched by [of] but not matched by
 * [subtracting].
 * The returned filter options are not sortable.
 * @param of some filter options, on the left side of the difference
 * @param subtracting some filter options, on the right side of the difference
 * @return filter options that combine the requirements of all the input filter options as set difference
 */
fun <E : Identifiable<String>> difference(
	of: FilterOptions<E>,
	subtracting: FilterOptions<E>
): FilterOptions<E> = DifferenceFilterOptions(of = of, subtracting = subtracting)

/**
 * Get filter options that allow to create a filter which matches all entities matched by [of] but not matched by
 * [subtracting].
 * [of] must be sortable options, and the returned options will also be sortable, using the same order given by [of].
 * @param of some sortable filter options, on the left side of the difference
 * @param subtracting some filter options, on the right side of the difference
 * @return filter options that combine the requirements of all the input filter options as set difference and are
 * sortable by [of]
 */
@JsName("sortableDifference")
fun <E : Identifiable<String>> difference(
	of: SortableFilterOptions<E>,
	subtracting: FilterOptions<E>
): SortableFilterOptions<E> = SortableDifferenceFilterOptions(of = of, subtracting = subtracting)

internal class SortableIntersectionFilterOptions<E : Identifiable<String>> (
	val sortFilter: SortableFilterOptions<E>,
	val otherOptions: List<FilterOptions<E>>
) : SortableFilterOptions<E>

internal class IntersectionFilterOptions<E : Identifiable<String>> (
	val options: List<FilterOptions<E>>
) : FilterOptions<E>

internal class UnionFilterOptions<E : Identifiable<String>> (
	val options: List<FilterOptions<E>>
) : FilterOptions<E>

internal class DifferenceFilterOptions<E : Identifiable<String>> (
	val of: FilterOptions<E>,
	val subtracting: FilterOptions<E>,
) : FilterOptions<E>

internal class SortableDifferenceFilterOptions<E : Identifiable<String>> (
	val of: SortableFilterOptions<E>,
	val subtracting: FilterOptions<E>,
) : SortableFilterOptions<E>

private fun <E : Identifiable<String>> List<FilterOptions<E>>.flattenedIntersection() = flatMap {
	when (it) {
		is SortableIntersectionFilterOptions -> listOf(it.sortFilter) + it.otherOptions
		is IntersectionFilterOptions -> it.options
		else -> listOf(it)
	}
}

/**
 * Maps filter options to abstract filter if they are meta filters, returns null otherwise
 */
internal suspend fun <E : Identifiable<String>> mapIfMetaFilterOptions(
	filterOptions: FilterOptions<E>,
	mapTypedOptions: suspend (FilterOptions<E>) -> AbstractFilter<E>
): AbstractFilter<E>? = when (filterOptions) {
	is SortableIntersectionFilterOptions ->
		IntersectionFilter(filters = (listOf(filterOptions.sortFilter) + filterOptions.otherOptions).map { mapTypedOptions(it) })
	is IntersectionFilterOptions ->
		IntersectionFilter(filters = filterOptions.options.map { mapTypedOptions(it) })
	is UnionFilterOptions ->
		UnionFilter(filters = filterOptions.options.map { mapTypedOptions(it) })
	is DifferenceFilterOptions ->
		ComplementFilter(superSet = mapTypedOptions(filterOptions.of), subSet = mapTypedOptions(filterOptions.subtracting))
	is SortableDifferenceFilterOptions ->
		ComplementFilter(superSet = mapTypedOptions(filterOptions.of), subSet = mapTypedOptions(filterOptions.subtracting))
	else -> null
}