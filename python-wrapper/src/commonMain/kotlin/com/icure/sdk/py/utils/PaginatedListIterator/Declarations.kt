@file:OptIn(ExperimentalForeignApi::class)
package com.icure.sdk.py.utils.PaginatedListIterator

import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyJson
import com.icure.sdk.py.utils.toPyJsonAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.pagination.PaginatedListIterator
import com.icure.sdk.utils.pagination.next
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

@OptIn(ExperimentalForeignApi::class, DelicateCoroutinesApi::class)
fun hasNextAsync(
	iteratorAndSerializerPtr: COpaquePointer,
	resultCallback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>
) {
	kotlin.runCatching {
		val iteratorAndSerializer = iteratorAndSerializerPtr.get()
		GlobalScope.launch {
			kotlin.runCatching {
				iteratorAndSerializer.hasNext()
			}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
		}
	}.failureToPyStringAsyncCallback(resultCallback)
}

@OptIn(ExperimentalForeignApi::class)
fun hasNextBlocking(
	iteratorAndSerializerPtr: COpaquePointer
): String = kotlin.runCatching {
	val iteratorAndSerializer = iteratorAndSerializerPtr.get()
	runBlocking {
		iteratorAndSerializer.hasNext()
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
fun nextAsync(
	iteratorAndSerializerPtr: COpaquePointer,
	limit: Int,
	resultCallback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>
) {
	kotlin.runCatching {
		val iteratorAndSerializer = iteratorAndSerializerPtr.get()
		require(limit > 0) { "Limit must be greater than 0" }
		GlobalScope.launch {
			kotlin.runCatching {
				iteratorAndSerializer.nextAsJson(limit)
			}.toPyJsonAsyncCallback(resultCallback)
		}
	}.failureToPyStringAsyncCallback(resultCallback)
}

@OptIn(ExperimentalForeignApi::class)
fun nextBlocking(
	iteratorAndSerializerPtr: COpaquePointer,
	limit: Int
): String = kotlin.runCatching {
	val iteratorAndSerializer = iteratorAndSerializerPtr.get()
	require(limit > 0) { "Limit must be greater than 0" }
	runBlocking {
		iteratorAndSerializer.nextAsJson(limit)
	}
}.toPyJson()

internal class PaginatedListIteratorAndSerializer<T : Any>(
	private val iterator: PaginatedListIterator<T>,
	private val serializer: KSerializer<T>
) {
	suspend fun hasNext(): Boolean =
		hasNext()
	suspend fun nextAsJson(limit: Int): JsonElement =
		Serialization.json.encodeToJsonElement(ListSerializer(serializer), iterator.next(limit))
}

@OptIn(ExperimentalForeignApi::class)
private fun COpaquePointer.get(): PaginatedListIteratorAndSerializer<*> =
	asStableRef<PaginatedListIteratorAndSerializer<*>>().get()