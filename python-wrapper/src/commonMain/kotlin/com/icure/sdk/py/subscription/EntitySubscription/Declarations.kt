package com.icure.sdk.py.subscription.EntitySubscription

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.py.utils.toPyJson
import com.icure.sdk.py.utils.toPyJsonAsyncCallback
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionCloseReason
import com.icure.sdk.subscription.EntitySubscriptionEvent
import com.icure.sdk.utils.Serialization
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.asStableRef
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalForeignApi::class)
fun close(subscriptionPtr: COpaquePointer) = kotlin.runCatching {
	subscriptionPtr.get().close()
	JsonNull
}.toPyJson()

@OptIn(ExperimentalForeignApi::class)
fun getCloseReason(subscriptionPtr: COpaquePointer): String = kotlin.runCatching {
	subscriptionPtr.get().closeReason
}.toPyJson()

@OptIn(ExperimentalForeignApi::class)
fun receiveEventBlocking(subscriptionPtr: COpaquePointer, timeoutMs: Int): String = kotlin.runCatching {
	runBlocking {
		subscriptionPtr.get().receiveEvent(timeoutMs)
	}
}.toPyJson()

@OptIn(ExperimentalForeignApi::class)
fun receiveEventAsync(
	subscriptionPtr: COpaquePointer,
	timeoutMs: Int,
	resultCallback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>
) {
	GlobalScope.launch {
		kotlin.runCatching {
			subscriptionPtr.get().receiveEvent(timeoutMs)
		}.toPyJsonAsyncCallback(resultCallback)
	}
}

internal data class EntitySubscriptionWithSerializer<E : Identifiable<String>>(
	private val subscription: EntitySubscription<E>,
	private val eSerializer: KSerializer<E>
) {
	private val eventSerializer = EntitySubscriptionEvent.serializer(eSerializer)
	private val closeReasonSerializer = EntitySubscriptionCloseReason.serializer()

	fun close() {
		runBlocking { subscription.close() }
	}

	val closeReason get(): JsonElement = subscription.closeReason?.let {
		Serialization.fullJson.encodeToJsonElement(closeReasonSerializer, it)
	} ?: JsonNull

	suspend fun receiveEvent(timeoutMs: Int): JsonElement =
		withTimeoutOrNull(timeoutMs.milliseconds) {
			subscription.eventChannel.receiveCatching().getOrNull()
		}?.let { event ->
			Serialization.fullJson.encodeToJsonElement(eventSerializer, event)
		} ?: JsonNull
}

@OptIn(ExperimentalForeignApi::class)
private fun COpaquePointer.get(): EntitySubscriptionWithSerializer<*> =
	asStableRef<EntitySubscriptionWithSerializer<*>>().get()
