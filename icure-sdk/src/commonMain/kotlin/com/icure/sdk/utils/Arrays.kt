package com.icure.sdk.utils

fun Iterable<ByteArray>.concat(): ByteArray {
	val totalSize = sumOf { it.size }
	val result = ByteArray(totalSize)
	var offset = 0
	for (array in this) {
		array.copyInto(result, destinationOffset = offset)
		offset += array.size
	}
	return result
}