package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionCloseReason
import com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SealedClassSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlin.time.Duration.Companion.milliseconds

/**
 * Supports implementation of entity subscriptions on wrappers that communicate only through json-encoded objects.
 */
@InternalIcureApi
data class EntitySubscriptionWithSerializer<E : Identifiable<String>>(
	private val subscription: EntitySubscription<E>,
	private val eSerializer: KSerializer<E>,
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

	suspend fun close() {
		subscription.close()
	}

	@OptIn(InternalIcureApi::class)
	val closeReason get(): JsonElement = subscription.closeReason?.let {
		Serialization.fullLanguageInteropJson.encodeToJsonElement(closeReasonSerializer, it)
	} ?: JsonNull

	suspend fun waitForEvent(timeoutMs: Int): JsonElement =
		withTimeoutOrNull(timeoutMs.milliseconds) {
			subscription.eventChannel.receiveCatching().getOrNull()
		}.json()

	fun getEvent(): JsonElement =
		subscription.eventChannel.tryReceive().getOrNull().json()

	@OptIn(InternalIcureApi::class)
	private fun EntitySubscriptionEvent<E>?.json() = if (this != null) {
		Serialization.fullLanguageInteropJson.encodeToJsonElement(eventSerializer, this)
	} else JsonNull
}