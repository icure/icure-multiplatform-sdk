package com.icure.sdk.websocket

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.utils.DefaultValue
import kotlinx.coroutines.channels.Channel
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

interface Subscribable<BaseType: Identifiable<String>, MaybeDecryptedType: BaseType> {
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<BaseType>,
		@DefaultValue("{}")
		onConnected: suspend () -> Unit = {},
		@DefaultValue("kotlinx.coroutines.channels.Channel.BUFFERED")
		channelCapacity: Int = Channel.BUFFERED,
		@DefaultValue("2.seconds")
		retryDelay: Duration = 2.seconds,
		@DefaultValue("2.0")
		retryDelayExponentFactor: Double = 2.0,
		@DefaultValue("5")
		maxRetries: Int = 5,
		eventFired: suspend (MaybeDecryptedType) -> Unit,
	): Connection
}
