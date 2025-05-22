// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.TopicBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.topic_fromJs
import com.icure.cardinal.sdk.js.model.topic_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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

	override fun deleteTopicUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicBasicApi.deleteTopicUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTopicsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicBasicApi.deleteTopicsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteTopicById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = topicBasicApi.deleteTopicById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = topicBasicApi.deleteTopicsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTopicById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		topicBasicApi.purgeTopicById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteTopic(topic: TopicJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicBasicApi.deleteTopic(
			topicConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTopics(topics: Array<TopicJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val topicsConverted: List<Topic> = arrayToList(
			topics,
			"topics",
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.deleteTopics(
			topicsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTopic(topic: TopicJs): Promise<Unit> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		topicBasicApi.purgeTopic(
			topicConverted,
		)

	}

	override fun createTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTopic = topic_fromJs(entity)
		val result = topicBasicApi.createTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopic(topic: TopicJs): Promise<TopicJs> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicBasicApi.undeleteTopic(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTopic = topic_fromJs(entity)
		val result = topicBasicApi.modifyTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopicById(id: String, rev: String): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = topicBasicApi.undeleteTopicById(
			idConverted,
			revConverted,
		)
		topic_toJs(result)
	}

	override fun getTopic(entityId: String): Promise<EncryptedTopicJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicBasicApi.getTopic(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				topic_toJs(nonNull1)
			}
		)
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
