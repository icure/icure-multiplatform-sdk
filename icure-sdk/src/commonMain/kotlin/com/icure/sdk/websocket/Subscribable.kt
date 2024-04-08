package com.icure.sdk.websocket

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType

interface Subscribable<BaseType: Identifiable<String>, MaybeDecryptedType: BaseType> {
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<BaseType>,
		eventFired: suspend (MaybeDecryptedType) -> Unit,
	): Connection
}
