package com.icure.cardinal.sdk.py.subscription.EntitySubscription

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.py.utils.toPyJson
import com.icure.cardinal.sdk.py.utils.toPyJsonAsyncCallback
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionCloseReason
import com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent
import com.icure.cardinal.sdk.utils.Serialization
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
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SealedClassSerializer
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
fun getEvent(subscriptionPtr: COpaquePointer): String = kotlin.runCatching {
	subscriptionPtr.get().getEvent()
}.toPyJson()

@OptIn(ExperimentalForeignApi::class)
fun waitForEventBlocking(subscriptionPtr: COpaquePointer, timeoutMs: Int): String = kotlin.runCatching {
	runBlocking {
		subscriptionPtr.get().waitForEvent(timeoutMs)
	}
}.toPyJson()

@OptIn(ExperimentalForeignApi::class)
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

internal data class EntitySubscriptionWithSerializer<E : Identifiable<String>>(
	private val subscription: EntitySubscription<E>,
	private val eSerializer: KSerializer<E>
) {
	/*
	 * There is a bug with the generated sealed class serializer where even if we explicitly provide the eSerializer
	 * we get an error because E is not part of the polymorphic scope of Identifiable...
	 * If this internal serializer is going to not be supported anymore we can always implement the serializer
	 * ourselves.
	 */
	@OptIn(InternalSerializationApi::class)
	@Suppress("UNCHECKED_CAST")
	private val eventSerializer = SealedClassSerializer(
		"EntitySubscriptionEvent",
		EntitySubscriptionEvent::class,
		arrayOf(
			EntitySubscriptionEvent.Connected::class,
			EntitySubscriptionEvent.Reconnected::class,
			EntitySubscriptionEvent.UnexpectedError::class,
			EntitySubscriptionEvent.ConnectionError.MissedPing::class,
			EntitySubscriptionEvent.ConnectionError.ClosedByServer::class,
			EntitySubscriptionEvent.EntityNotification::class,
			EntitySubscriptionEvent.EntityError.DeserializationError::class,
		),
		arrayOf(
			EntitySubscriptionEvent.Connected.serializer(),
			EntitySubscriptionEvent.Reconnected.serializer(),
			EntitySubscriptionEvent.UnexpectedError.serializer(),
			EntitySubscriptionEvent.ConnectionError.MissedPing.serializer(),
			EntitySubscriptionEvent.ConnectionError.ClosedByServer.serializer(),
			EntitySubscriptionEvent.EntityNotification.serializer(eSerializer),
			EntitySubscriptionEvent.EntityError.DeserializationError.serializer(),
		),
	) as KSerializer<EntitySubscriptionEvent<E>>
	private val closeReasonSerializer = EntitySubscriptionCloseReason.serializer()

	fun close() {
		runBlocking { subscription.close() }
	}

	val closeReason get(): JsonElement = subscription.closeReason?.let {
		Serialization.fullJson.encodeToJsonElement(closeReasonSerializer, it)
	} ?: JsonNull

	suspend fun waitForEvent(timeoutMs: Int): JsonElement =
		withTimeoutOrNull(timeoutMs.milliseconds) {
			subscription.eventChannel.receiveCatching().getOrNull()
		}.json()

	fun getEvent(): JsonElement =
		subscription.eventChannel.tryReceive().getOrNull().json()

	private fun EntitySubscriptionEvent<E>?.json() = if (this != null) {
		Serialization.fullJson.encodeToJsonElement(eventSerializer, this)
	} else JsonNull
}

@OptIn(ExperimentalForeignApi::class)
private fun COpaquePointer.get(): EntitySubscriptionWithSerializer<*> =
	asStableRef<EntitySubscriptionWithSerializer<*>>().get()
