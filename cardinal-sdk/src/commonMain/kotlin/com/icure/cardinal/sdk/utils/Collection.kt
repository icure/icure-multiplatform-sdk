package com.icure.cardinal.sdk.utils

/**
 * Given to [Collection] of [T], returns a [List] of [Pair]s of all the possible combination
 * between the elements of the two collections.
 *
 * @receiver a [Collection] of [T].
 * @param other a [Collection] of [T].
 * @return a [List] of the [Pair]s containing all the possible combinations between the elements of the receiver and [other]-
 */
internal infix fun <T> Collection<T>.vectorProduct(other: Collection<T>): List<Pair<T, T>> = flatMap { a -> other.map { b -> a to b } }

internal fun <T> List<T>.requireUniqueElements(collectionName: String = "Collection") {
	require (this.size == this.toSet().size) {
		"$collectionName contains duplicate elements: ${this.groupingBy { it }.eachCount().filter { it.value > 1 }.keys}"
	}
}