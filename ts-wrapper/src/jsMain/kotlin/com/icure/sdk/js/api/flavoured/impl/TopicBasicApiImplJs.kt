// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.TopicBasicApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.TopicBasicApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TopicBasicApiImplJs(
	private val topicBasicApi: TopicBasicApi,
) : TopicBasicApiJs {
	override fun matchTopicsBy(filter: BaseFilterOptionsJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
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

	override fun matchTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
		val result = topicBasicApi.matchTopicsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterTopicsBy(filter: BaseFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
		val result = topicBasicApi.filterTopicsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
		val result = topicBasicApi.filterTopicsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

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
		filter: BaseFilterOptionsJs<TopicJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedTopicJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = topicBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}
	}
}
