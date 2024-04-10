package com.icure.sdk.websocket

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import kotlinx.coroutines.channels.Channel
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

interface Subscribable<BaseType: Identifiable<String>, MaybeDecryptedType: BaseType> {
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<BaseType>,
		onConnected: suspend () -> Unit = {},
		channelCapacity: Int = Channel.BUFFERED,
		retryDelay: Duration = 2.seconds,
		retryDelayExponentFactor: Double = 2.0,
		maxRetries: Int = 5,
		eventFired: suspend (MaybeDecryptedType) -> Unit,
	): Connection
}
