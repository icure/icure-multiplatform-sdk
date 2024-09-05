package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue

interface Subscribable<EntityBaseType : Identifiable<String>, EntityEventType : EntityBaseType, FilterOptionsType : FilterOptions<EntityBaseType>> {
	/**
	 * Subscribe to receive real-time notifications when an entity is updated.
	 * @param events the type of events that will be notified to the subscription
	 * @param filter the subscription will receive notifications only for entities matching this filter, you should
	 * make the filter as restrictive as possible.
	 * @param subscriptionConfig customize the configuration for the subscription
	 * @return a subscription that receives notifications for the configured events.
	 */
	suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptionsType,
		@DefaultValue("null")
		subscriptionConfig: EntitySubscriptionConfiguration? = null
	): EntitySubscription<EntityEventType>
}
