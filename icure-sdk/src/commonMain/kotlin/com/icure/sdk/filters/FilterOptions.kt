package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.base.Identifiable

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 */
sealed interface FilterOptions<E : Identifiable<String>>

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 */
sealed interface SortableFilterOptions<E : Identifiable<String>> : FilterOptions<E>

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
sealed interface BaseFilterOptions<E : Identifiable<String>> : FilterOptions<E>

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
sealed interface BaseSortableFilterOptions<E : Identifiable<String>> : BaseFilterOptions<E>, SortableFilterOptions<E>
