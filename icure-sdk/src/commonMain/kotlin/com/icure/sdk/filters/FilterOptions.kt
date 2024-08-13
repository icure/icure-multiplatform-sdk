package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.base.Identifiable

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 */
sealed interface FilterOptions<E : Identifiable<String>> {
	infix fun and(other: FilterOptions<E>): FilterOptions<E> = intersection(this, other)
	infix fun or(other: FilterOptions<E>): FilterOptions<E> = union(this, other)
	operator fun minus(other: FilterOptions<E>): FilterOptions<E> = difference(this, other)
}

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 */
sealed interface SortableFilterOptions<E : Identifiable<String>> : FilterOptions<E> {
	override infix fun and(other: FilterOptions<E>): SortableFilterOptions<E> = intersection(this, other)
	override operator fun minus(other: FilterOptions<E>): SortableFilterOptions<E> = difference(this, other)
}

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
sealed interface BaseFilterOptions<E : Identifiable<String>> : FilterOptions<E> {
	infix fun and(other: BaseFilterOptions<E>): BaseFilterOptions<E> = intersection(this, other)
	infix fun or(other: BaseFilterOptions<E>): BaseFilterOptions<E> = union(this, other)
	operator fun minus(other: BaseFilterOptions<E>): BaseFilterOptions<E> = difference(this, other)
}

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
sealed interface BaseSortableFilterOptions<E : Identifiable<String>> : BaseFilterOptions<E>, SortableFilterOptions<E> {
	override infix fun and(other: FilterOptions<E>): SortableFilterOptions<E> = intersection(this, other)
	override infix fun and(other: BaseFilterOptions<E>): BaseFilterOptions<E> = intersection(this, other)
	override operator fun minus(other: BaseFilterOptions<E>): BaseSortableFilterOptions<E> = difference(this, other)
}
