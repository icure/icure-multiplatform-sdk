package com.icure.cardinal.sdk.py.subscription.EntitySubscription

import com.icure.cardinal.sdk.py.utils.toPyJson
import com.icure.cardinal.sdk.py.utils.toPyJsonAsyncCallback
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.utils.InternalIcureApi
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
import kotlinx.serialization.json.JsonNull

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun close(subscriptionPtr: COpaquePointer) = kotlin.runCatching {
	runBlocking { subscriptionPtr.get().close() }
	JsonNull
}.toPyJson()

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun getCloseReason(subscriptionPtr: COpaquePointer): String = kotlin.runCatching {
	subscriptionPtr.get().closeReason
}.toPyJson()

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun getEvent(subscriptionPtr: COpaquePointer): String = kotlin.runCatching {
	subscriptionPtr.get().getEvent()
}.toPyJson()

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
fun waitForEventBlocking(subscriptionPtr: COpaquePointer, timeoutMs: Int): String = kotlin.runCatching {
	runBlocking {
		subscriptionPtr.get().waitForEvent(timeoutMs)
	}
}.toPyJson()

@OptIn(ExperimentalForeignApi::class, DelicateCoroutinesApi::class, InternalIcureApi::class)
fun waitForEventAsync(
	subscriptionPtr: COpaquePointer,
	timeoutMs: Int,
	resultCallback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>
) {
	GlobalScope.launch {
		kotlin.runCatching {
			subscriptionPtr.get().waitForEvent(timeoutMs)
		}.toPyJsonAsyncCallback(resultCallback)
	}
}

@OptIn(ExperimentalForeignApi::class, InternalIcureApi::class)
private fun COpaquePointer.get(): EntitySubscriptionWithSerializer<*> =
	asStableRef<EntitySubscriptionWithSerializer<*>>().get()
