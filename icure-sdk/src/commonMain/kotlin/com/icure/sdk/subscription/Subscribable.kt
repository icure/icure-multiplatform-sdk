package com.icure.sdk.subscription

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.utils.DefaultValue

interface Subscribable<EntityBaseType : Identifiable<String>, EntityEventType : EntityBaseType> {
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<EntityBaseType>,
		@DefaultValue("null")
		subscriptionConfig: EntityEventSubscription.Configuration? = null
	): EntityEventSubscription<EntityEventType>
}
