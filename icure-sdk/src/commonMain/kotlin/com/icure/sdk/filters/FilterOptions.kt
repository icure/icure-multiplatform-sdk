package com.icure.sdk.filters

import com.icure.sdk.model.base.Identifiable

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 */
sealed interface FilterOptions<E : Identifiable<String>>

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 */
sealed interface SortableFilterOptions<E : Identifiable<String>> : FilterOptions<E>
