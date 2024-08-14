package com.icure.sdk.filters

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.NothingSerializer
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 */
@Serializable
sealed interface FilterOptions<E : Identifiable<String>> {
	infix fun and(other: FilterOptions<E>): FilterOptions<E> = intersection(this, other)
	infix fun or(other: FilterOptions<E>): FilterOptions<E> = union(this, other)
	operator fun minus(other: FilterOptions<E>): FilterOptions<E> = difference(this, other)

	companion object {
		@Suppress("UNCHECKED_CAST")
		@OptIn(ExperimentalSerializationApi::class)
		fun <E : Identifiable<String>> serializer(): KSerializer<FilterOptions<E>> =
			serializer(NothingSerializer() as KSerializer<E>)
	}
}

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 */
@Serializable
sealed interface SortableFilterOptions<E : Identifiable<String>> : FilterOptions<E> {
	override infix fun and(other: FilterOptions<E>): SortableFilterOptions<E> = intersection(this, other)
	override operator fun minus(other: FilterOptions<E>): SortableFilterOptions<E> = difference(this, other)

	companion object {
		@Suppress("UNCHECKED_CAST")
		@OptIn(ExperimentalSerializationApi::class)
		fun <E : Identifiable<String>> serializer(): KSerializer<SortableFilterOptions<E>> =
			serializer(NothingSerializer() as KSerializer<E>)
	}
}

/**
 * Options that allow to create an unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
@Serializable
sealed interface BaseFilterOptions<E : Identifiable<String>> : FilterOptions<E> {
	infix fun and(other: BaseFilterOptions<E>): BaseFilterOptions<E> = intersection(this, other)
	infix fun or(other: BaseFilterOptions<E>): BaseFilterOptions<E> = union(this, other)
	operator fun minus(other: BaseFilterOptions<E>): BaseFilterOptions<E> = difference(this, other)

	companion object {
		@Suppress("UNCHECKED_CAST")
		@OptIn(ExperimentalSerializationApi::class)
		fun <E : Identifiable<String>> serializer(): KSerializer<BaseFilterOptions<E>> =
			serializer(NothingSerializer() as KSerializer<E>)
	}
}

/**
 * Options that allow to create a sorted or unsorted filter for entities of type [E].
 * These options can be used also with [IcureBaseApis]
 */
@Serializable
sealed interface BaseSortableFilterOptions<E : Identifiable<String>> : BaseFilterOptions<E>, SortableFilterOptions<E> {
	override infix fun and(other: FilterOptions<E>): SortableFilterOptions<E> = intersection(this, other)
	override infix fun and(other: BaseFilterOptions<E>): BaseFilterOptions<E> = intersection(this, other)
	override operator fun minus(other: BaseFilterOptions<E>): BaseSortableFilterOptions<E> = difference(this, other)

	companion object {
		@Suppress("UNCHECKED_CAST")
		@OptIn(ExperimentalSerializationApi::class)
		fun <E : Identifiable<String>> serializer(): KSerializer<BaseSortableFilterOptions<E>> =
			serializer(NothingSerializer() as KSerializer<E>)
	}
}

@OptIn(ExperimentalContracts::class)
@InternalIcureApi
internal fun FilterOptions<*>.ensureNonBaseEnvironment(
	selfId: String?,
	encryptionService: EntityEncryptionService?,
) {
	contract {
		returns() implies (selfId != null && encryptionService != null)
	}
	// Internal exception because the compiler should have caught the user mistake...
	// We may have made a mistake in the typings somewhere
	if (selfId == null || encryptionService == null) throw InternalIcureException(
		"Filter options ${this::class.simpleName} should not be usable with base apis."
	)
}