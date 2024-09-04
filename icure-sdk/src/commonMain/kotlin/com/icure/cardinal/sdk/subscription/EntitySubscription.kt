package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.coroutines.channels.ReceiveChannel

/**
 * A subscription allows to get realtime updates on entities of type [E].
 * Note that subscriptions need to be closed explicitly.
 */
interface EntitySubscription<E : Identifiable<String>> {
	/**
	 * Closes the subscription. A closed subscription will not receive any new events, but any existing event may still
	 * be consumed after closing.
	 */
	suspend fun close()

	/**
	 * If the subscription is permanently closed. Even if this is true there may still be some unconsumed events
	 */
	val isClosed: Boolean get() = closeReason != null

	/**
	 * If the subscription is closed the reason for closure, null otherwise. Even if this is not null there may still be
	 * some unconsumed events
	 */
	val closeReason: EntitySubscriptionCloseReason?

	/**
	 * The events observed by this subscription.
	 */
	val eventChannel: ReceiveChannel<EntitySubscriptionEvent<E>>


}