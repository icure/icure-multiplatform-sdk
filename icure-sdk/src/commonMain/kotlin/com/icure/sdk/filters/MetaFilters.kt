/**
 * Meta filter options classes and methods to create them.
 *
 * # Wrappers considerations
 *
 * The behaviors of the factory methods changes slightly when using the sdk from a wrapper for languages where there
 * is no actual method overloads (e.g. typescript and python).
 *
 * When using directly kotlin (including kotlin js), the compile-time and run-time types of the filter options will match.
 * For example, calling the method `intersection(sortableFilterOptions as FilterOptions, filterOptions)` in kotlin gives
 * at some `FilterOptions` that at runtime ar actually just `IntersectionFilterOptions`.
 *
 * When using the sdk from typescript, instead, there is no real support for method overloads.
 * When the user calls the intersection method we check the runtime type of the first filter, see that it is sortable
 * and then create a `SortableIntersectionFilterOptions`, even though the compile time type is going to be only `FilterOptions`.
 *
 * Both situations perfectly respect the contract, but the implementation details are different.
 *
 * If users rely on these implementation details and use both sdks they might be confused at the differences.
 *
 * For example consider the following completely legitimate method which could be created by a user, which returns some
 * filter options:
 * ```kotlin
 * fun getAFilterForPatient(patient: Patient) = intersection(
 *   if (conditionOnPatient(patient)) getSortableFilter(patient) else getUnsortableFilter(patient),
 *   anotherFilterForPatient(patient)
 * )
 * ```
 * If the user inspects the compile time type of the returned filter options it will never be `SortableFilterOptions`,
 * regardless of whether the condition on patient returns true or false (of course this would be different if the
 * implementation was slightly different by putting the if outside the intersection)-
 *
 * The same implementation ot the method in typescript instead will return an instance of `SortableFilterOptions` if the
 * condition is true or an instance of only `FilterOptions` if the condition is false.
 */
package com.icure.sdk.filters

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.ComplementFilter
import com.icure.sdk.model.filter.IntersectionFilter
import com.icure.sdk.model.filter.UnionFilter
import com.icure.sdk.utils.InternalIcureApi

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
fun <E : Identifiable<String>> intersection(
	a: SortableFilterOptions<E>,
	b: FilterOptions<E>,
	vararg others: FilterOptions<E>
): SortableFilterOptions<E> {
	val sortableFilter = when (a) {
		is SortableIntersectionFilterOptions -> a.sortFilter
		is BaseSortableIntersectionFilterOptions -> a.sortFilter
		else -> a
	}
	val otherOptions = when (a) {
		is SortableIntersectionFilterOptions -> a.otherOptions
		is BaseSortableIntersectionFilterOptions -> a.otherOptions
		else -> emptyList()
	} + b + others
	return SortableIntersectionFilterOptions(
		sortableFilter,
		otherOptions.flattenedIntersection()
	)
}

/**
 * Get filter options that allow to create a filter which matches only entities that match all the provided filters
 * ([a], [b] and any filters in [others]).
 * [a] must be sortable options, and the returned options will also be sortable, using the same order given by [a].
 * These filter options can be used with base apis.
 * @param a some sortable filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as intersection and are sortable
 * by [a]
 */
fun <E : Identifiable<String>> intersection(
	a: BaseSortableFilterOptions<E>,
	b: BaseFilterOptions<E>,
	vararg others: BaseFilterOptions<E>
): BaseSortableFilterOptions<E> {
	val sortableFilter = when (a) {
		is BaseSortableIntersectionFilterOptions -> a.sortFilter
		else -> a
	}
	val otherOptions = when (a) {
		is BaseSortableIntersectionFilterOptions -> a.otherOptions
		else -> emptyList()
	} + b + others
	return BaseSortableIntersectionFilterOptions(
		sortableFilter,
		otherOptions.baseFlattenedIntersection()
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
 * Get filter options that allow to create a filter which matches only entities that match all the provided filters
 * ([a], [b] and any filters in [others]).
 * The returned filter options are not sortable.
 * These filter options can be used with base apis.
 * @param a some filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as intersection
 */
fun <E : Identifiable<String>> intersection(
	a: BaseFilterOptions<E>,
	b: BaseFilterOptions<E>,
	vararg others: BaseFilterOptions<E>
): BaseFilterOptions<E> = BaseIntersectionFilterOptions((listOf(a, b) + others).baseFlattenedIntersection())

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
	when (it) {
		is UnionFilterOptions -> it.options
		is BaseUnionFilterOptions -> it.options
		else -> listOf(it)
	}
})

/**
 * Get filter options that allow to create a filter which matches only entities that match at least one of the provided
 * filters ([a], [b] or any filter in [others]).
 * The returned filter options are not sortable.
 * These filter options can be used with base apis.
 * @param a some filter options
 * @param b some filter options
 * @param others additional filter options
 * @return filter options that combine the requirements of all the input filter options as union
 */
fun <E : Identifiable<String>> union(
	a: BaseFilterOptions<E>,
	b: BaseFilterOptions<E>,
	vararg others: BaseFilterOptions<E>
): BaseFilterOptions<E> = BaseUnionFilterOptions((listOf(a, b) + others).flatMap {
	when (it) {
		is BaseUnionFilterOptions -> it.options
		else -> listOf(it)
	}
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
fun <E : Identifiable<String>> difference(
	of: SortableFilterOptions<E>,
	subtracting: FilterOptions<E>
): SortableFilterOptions<E> = SortableDifferenceFilterOptions(of = of, subtracting = subtracting)

/**
 * Get filter options that allow to create a filter which matches all entities matched by [of] but not matched by
 * [subtracting].
 * The returned filter options are not sortable.
 * These filter options can be used with base apis.
 * @param of some filter options, on the left side of the difference
 * @param subtracting some filter options, on the right side of the difference
 * @return filter options that combine the requirements of all the input filter options as set difference
 */
fun <E : Identifiable<String>> difference(
	of: BaseFilterOptions<E>,
	subtracting: BaseFilterOptions<E>
): BaseFilterOptions<E> = BaseDifferenceFilterOptions(of = of, subtracting = subtracting)

/**
 * Get filter options that allow to create a filter which matches all entities matched by [of] but not matched by
 * [subtracting].
 * [of] must be sortable options, and the returned options will also be sortable, using the same order given by [of].
 * These filter options can be used with base apis.
 * @param of some sortable filter options, on the left side of the difference
 * @param subtracting some filter options, on the right side of the difference
 * @return filter options that combine the requirements of all the input filter options as set difference and are
 * sortable by [of]
 */
fun <E : Identifiable<String>> difference(
	of: BaseSortableFilterOptions<E>,
	subtracting: BaseFilterOptions<E>
): BaseSortableFilterOptions<E> = BaseSortableDifferenceFilterOptions(of = of, subtracting = subtracting)

internal class SortableIntersectionFilterOptions<E : Identifiable<String>> (
	val sortFilter: SortableFilterOptions<E>,
	val otherOptions: List<FilterOptions<E>>
) : SortableFilterOptions<E>

internal class IntersectionFilterOptions<E : Identifiable<String>> (
	val options: List<FilterOptions<E>>
) : FilterOptions<E>

internal class BaseSortableIntersectionFilterOptions<E : Identifiable<String>> (
	val sortFilter: BaseSortableFilterOptions<E>,
	val otherOptions: List<BaseFilterOptions<E>>
) : BaseSortableFilterOptions<E>

internal class BaseIntersectionFilterOptions<E : Identifiable<String>> (
	val options: List<BaseFilterOptions<E>>
) : BaseFilterOptions<E>

internal class UnionFilterOptions<E : Identifiable<String>> (
	val options: List<FilterOptions<E>>
) : FilterOptions<E>

internal class BaseUnionFilterOptions<E : Identifiable<String>> (
	val options: List<BaseFilterOptions<E>>
) : BaseFilterOptions<E>

internal class DifferenceFilterOptions<E : Identifiable<String>> (
	val of: FilterOptions<E>,
	val subtracting: FilterOptions<E>,
) : FilterOptions<E>

internal class SortableDifferenceFilterOptions<E : Identifiable<String>> (
	val of: SortableFilterOptions<E>,
	val subtracting: FilterOptions<E>,
) : SortableFilterOptions<E>

internal class BaseDifferenceFilterOptions<E : Identifiable<String>> (
	val of: BaseFilterOptions<E>,
	val subtracting: BaseFilterOptions<E>,
) : BaseFilterOptions<E>

internal class BaseSortableDifferenceFilterOptions<E : Identifiable<String>> (
	val of: BaseSortableFilterOptions<E>,
	val subtracting: BaseFilterOptions<E>,
) : BaseSortableFilterOptions<E>

private fun <E : Identifiable<String>> List<FilterOptions<E>>.flattenedIntersection() = flatMap {
	when (it) {
		is SortableIntersectionFilterOptions -> listOf(it.sortFilter) + it.otherOptions
		is BaseSortableIntersectionFilterOptions -> listOf(it.sortFilter) + it.otherOptions
		is IntersectionFilterOptions -> it.options
		is BaseIntersectionFilterOptions -> it.options
		else -> listOf(it)
	}
}

private fun <E : Identifiable<String>> List<BaseFilterOptions<E>>.baseFlattenedIntersection() = flatMap {
	when (it) {
		is BaseSortableIntersectionFilterOptions -> listOf(it.sortFilter) + it.otherOptions
		is BaseIntersectionFilterOptions -> it.options
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
	is BaseSortableIntersectionFilterOptions ->
		IntersectionFilter(filters = (listOf(filterOptions.sortFilter) + filterOptions.otherOptions).map { mapTypedOptions(it) })
	is BaseIntersectionFilterOptions ->
		IntersectionFilter(filters = filterOptions.options.map { mapTypedOptions(it) })
	is BaseUnionFilterOptions ->
		UnionFilter(filters = filterOptions.options.map { mapTypedOptions(it) })
	is BaseDifferenceFilterOptions ->
		ComplementFilter(superSet = mapTypedOptions(filterOptions.of), subSet = mapTypedOptions(filterOptions.subtracting))
	is BaseSortableDifferenceFilterOptions ->
		ComplementFilter(superSet = mapTypedOptions(filterOptions.of), subSet = mapTypedOptions(filterOptions.subtracting))
	else -> null
}

/**
 * Dispatched versions of meta-filters-options factory methods, for internal use.
 * Useful for the implementation of wrappers in languages where real overloads with different implementations are not
 * supported (ts, python)
 */
@InternalIcureApi
object DispatchedMetaFilterOptions {
	fun <T : Identifiable<String>> union(
		a: FilterOptions<T>,
		b: FilterOptions<T>,
		vararg others: FilterOptions<T>
	): FilterOptions<T> =
		if (a is BaseFilterOptions && b is BaseFilterOptions && others.all { it is BaseFilterOptions }) {
				com.icure.sdk.filters.union(
					a,
					b,
					*Array(others.size) { others[it] as BaseFilterOptions }
				)
		} else {
				com.icure.sdk.filters.union(
					a,
					b,
					*Array(others.size) { others[it] }
				)
		}

	fun <T : Identifiable<String>> intersection(
		a: FilterOptions<T>,
		b: FilterOptions<T>,
		vararg others: FilterOptions<T>
	): FilterOptions<T> =
		if (a is BaseFilterOptions && b is BaseFilterOptions && others.all { it is BaseFilterOptions }) {
			if (a is BaseSortableFilterOptions) {
					com.icure.sdk.filters.intersection(
						a,
						b,
						*Array(others.size) { others[it] as BaseFilterOptions }
					)
			} else {
					com.icure.sdk.filters.intersection(
						a,
						b,
						*Array(others.size) { others[it] as BaseFilterOptions }
					)
			}
		} else {
			if (a is SortableFilterOptions) {
					com.icure.sdk.filters.intersection(
						a,
						b,
						*Array(others.size) { others[it] }
					)
			} else {
					com.icure.sdk.filters.intersection(
						a,
						b,
						*Array(others.size) { others[it] }
					)
			}
		}

	fun <T : Identifiable<String>> difference(
		of: FilterOptions<T>,
		subtracting: FilterOptions<T>
	): FilterOptions<T> =
		if (of is BaseFilterOptions && subtracting is BaseFilterOptions) {
			if (of is BaseSortableFilterOptions) {
					com.icure.sdk.filters.difference(
						of = of,
						subtracting = subtracting
					)
			} else {
					com.icure.sdk.filters.difference(
						of = of,
						subtracting = subtracting
					)
			}
		} else {
			if (of is SortableFilterOptions) {
					com.icure.sdk.filters.difference(
						of = of,
						subtracting = subtracting
					)
			} else {
					com.icure.sdk.filters.difference(
						of = of,
						subtracting = subtracting
					)
			}
		}
}