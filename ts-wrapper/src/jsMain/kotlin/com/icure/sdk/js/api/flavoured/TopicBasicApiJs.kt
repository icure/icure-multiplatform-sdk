// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicBasicApi")
public external interface TopicBasicApiJs {
	public fun deleteTopic(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun matchTopicsBy(filter: AbstractFilterJs<TopicJs>): Promise<Array<String>>

	public fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs>

	public fun getTopic(entityId: String): Promise<EncryptedTopicJs>

	public fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>>

	public fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>,
			options: TopicBasicApi_filterTopicsBy_Options?): Promise<PaginatedListJs<EncryptedTopicJs>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
		eventFired: (EncryptedTopicJs) -> Promise<Unit>,
		options: TopicBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface TopicBasicApi_filterTopicsBy_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface TopicBasicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
