// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicFlavouredApi")
public external interface TopicFlavouredApiJs<E : TopicJs> {
	public fun shareWith(
		delegateId: String,
		topic: E,
		options: dynamic,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(topic: E, delegates: Record<String, TopicShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(topic: E, delegates: Record<String, TopicShareOptionsJs>): Promise<E>

	public fun modifyTopic(entity: E): Promise<E>

	public fun getTopic(entityId: String): Promise<E>

	public fun getTopics(entityIds: Array<String>): Promise<Array<E>>

	public fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>, options: dynamic):
			Promise<PaginatedListJs<E>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<E>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<E>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
		eventFired: (E) -> Promise<Unit>,
		options: dynamic,
	): Promise<ConnectionJs>
}