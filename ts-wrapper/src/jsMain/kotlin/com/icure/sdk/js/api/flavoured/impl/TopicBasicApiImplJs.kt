// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TopicBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.TopicBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TopicBasicApiImplJs(
	private val topicBasicApi: TopicBasicApi,
) : TopicBasicApiJs {
	override fun deleteTopic(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicBasicApi.deleteTopic(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicBasicApi.deleteTopics(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun matchTopicsBy(filter: AbstractFilterJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Topic> = abstractFilter_fromJs(
			filter,
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.matchTopicsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTopic = topic_fromJs(entity)
		val result = topicBasicApi.modifyTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun getTopic(entityId: String): Promise<EncryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicBasicApi.getTopic(
			entityIdConverted,
		)
		topic_toJs(result)
	}

	override fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicBasicApi.getTopics(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>, options: dynamic):
			Promise<PaginatedListJs<EncryptedTopicJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<Topic> = filterChain_fromJs(
				filterChain,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicBasicApi.filterTopicsBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}
	}

	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
		val result = topicBasicApi.addParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
			topicRoleConverted,
		)
		topic_toJs(result)
	}

	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val result = topicBasicApi.removeParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
		)
		topic_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
		eventFired: (EncryptedTopicJs) -> Promise<Unit>,
		options: dynamic,
	): Promise<ConnectionJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: AbstractFilter<Topic> = abstractFilter_fromJs(
				filter,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefaultNonNull(
				_options,
				"onConnected",
				{}
			) { onConnected: () -> Promise<Unit> ->
				{  ->
					onConnected().await()
				}
			}
			val channelCapacityConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"channelCapacity",
				kotlinx.coroutines.channels.Channel.BUFFERED
			) { channelCapacity: Double ->
				numberToInt(channelCapacity, "channelCapacity")
			}
			val retryDelayConverted: Duration = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelay",
				2.seconds
			) { retryDelay: Double ->
				numberToDuration(retryDelay, "retryDelay")
			}
			val retryDelayExponentFactorConverted: Double = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelayExponentFactor",
				2.0
			) { retryDelayExponentFactor: Double ->
				retryDelayExponentFactor
			}
			val maxRetriesConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"maxRetries",
				5
			) { maxRetries: Double ->
				numberToInt(maxRetries, "maxRetries")
			}
			val eventFiredConverted: suspend (EncryptedTopic) -> Unit = { arg0 ->
				eventFired(
					topic_toJs(arg0),
				).await()
			}
			val result = topicBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				onConnectedConverted,
				channelCapacityConverted,
				retryDelayConverted,
				retryDelayExponentFactorConverted,
				maxRetriesConverted,
				eventFiredConverted,
			)
			connection_toJs(result)
		}
	}
}
