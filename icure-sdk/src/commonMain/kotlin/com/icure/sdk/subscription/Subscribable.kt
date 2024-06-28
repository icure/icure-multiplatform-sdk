package com.icure.sdk.subscription

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType

interface Subscribable<EntityBaseType : Identifiable<String>, EntityEventType : EntityBaseType> {
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<EntityBaseType>,
		subscriptionConfig: Subscription.Configuration
	): Subscription<EntityEventType>
}
