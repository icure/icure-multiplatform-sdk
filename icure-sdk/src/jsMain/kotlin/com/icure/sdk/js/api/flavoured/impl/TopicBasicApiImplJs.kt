// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TopicBasicApi
import com.icure.sdk.js.api.flavoured.TopicBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TopicBasicApiImplJs(
	private val topicBasicApi: TopicBasicApi,
) : TopicBasicApiJs {
	override fun deleteTopic(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(topicBasicApi.deleteTopic(entityId))}


	override fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			topicBasicApi.deleteTopics(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun matchTopicsBy(filter: AbstractFilterJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			topicBasicApi.matchTopicsBy(abstractFilter_fromJs(
				filter,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicBasicApi.modifyTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


	override fun getTopic(entityId: String): Promise<EncryptedTopicJs> = GlobalScope.promise {
		topic_toJs(topicBasicApi.getTopic(entityId))}


	override fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		listToArray(
			topicBasicApi.getTopics(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun filterTopicsBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<TopicJs>,
	): Promise<PaginatedListJs<EncryptedTopicJs>> = GlobalScope.promise {
		paginatedList_toJs(
			topicBasicApi.filterTopicsBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.TopicJs ->
			    com.icure.sdk.js.model.topic_fromJs(x1)
			  },
			)),
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs> = GlobalScope.promise {
		topic_toJs(topicBasicApi.addParticipant(entityId, dataOwnerId,
				com.icure.sdk.model.TopicRole.valueOf(topicRole)))}


	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicBasicApi.removeParticipant(entityId, dataOwnerId))}

}
