// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicBasicApi")
public external interface TopicBasicApiJs {
	public fun matchTopicsBy(filter: BaseFilterOptionsJs<TopicJs>): Promise<Array<String>>

	public fun matchTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>>

	public fun filterTopicsBy(filter: BaseFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>>

	public fun filterTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>>

	public fun deleteTopic(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs>

	public fun getTopic(entityId: String): Promise<EncryptedTopicJs>

	public fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<TopicJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedTopicJs>>
}
