// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TopicApi
import com.icure.sdk.js.api.flavoured.TopicApiJs
import com.icure.sdk.js.api.flavoured.TopicFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DecryptedTopicJs
import com.icure.sdk.js.model.EncryptedTopicJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
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
internal class TopicApiImplJs(
	private val topicApi: TopicApi,
) : TopicApiJs {
	override val encrypted: TopicFlavouredApiJs<EncryptedTopicJs> = object :
			TopicFlavouredApiJs<EncryptedTopicJs> {
		override fun shareWith(
			delegateId: String,
			topic: EncryptedTopicJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedTopicJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				topicApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.topic_fromJs(topic),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)}


		override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.encrypted.modifyTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


		override fun getTopic(entityId: String): Promise<EncryptedTopicJs> = GlobalScope.promise {
			topic_toJs(topicApi.encrypted.getTopic(entityId))}


		override fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>> =
				GlobalScope.promise {
			listToArray(
				topicApi.encrypted.getTopics(arrayToList(
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
			filterChain: FilterChainJs<EncryptedTopicJs>,
		): Promise<PaginatedListJs<EncryptedTopicJs>> = GlobalScope.promise {
			paginatedList_toJs(
				topicApi.encrypted.filterTopicsBy(startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.EncryptedTopicJs ->
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
			topic_toJs(topicApi.encrypted.addParticipant(entityId, dataOwnerId,
					com.icure.sdk.js.model.topicRole_fromJs(topicRole)))}


		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.encrypted.removeParticipant(entityId, dataOwnerId))}

	}

	override val tryAndRecover: TopicFlavouredApiJs<TopicJs> = object : TopicFlavouredApiJs<TopicJs> {
		override fun shareWith(
			delegateId: String,
			topic: TopicJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<TopicJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				topicApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.topic_fromJs(topic),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)}


		override fun modifyTopic(entity: TopicJs): Promise<TopicJs> = GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.modifyTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


		override fun getTopic(entityId: String): Promise<TopicJs> = GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.getTopic(entityId))}


		override fun getTopics(entityIds: Array<String>): Promise<Array<TopicJs>> = GlobalScope.promise {
			listToArray(
				topicApi.tryAndRecover.getTopics(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)}


		override fun filterTopicsBy(
			startDocumentId: String?,
			limit: Double?,
			filterChain: FilterChainJs<EncryptedTopicJs>,
		): Promise<PaginatedListJs<TopicJs>> = GlobalScope.promise {
			paginatedList_toJs(
				topicApi.tryAndRecover.filterTopicsBy(startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.EncryptedTopicJs ->
				    com.icure.sdk.js.model.topic_fromJs(x1)
				  },
				)),
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)}


		override fun addParticipant(
			entityId: String,
			dataOwnerId: String,
			topicRole: String,
		): Promise<TopicJs> = GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.addParticipant(entityId, dataOwnerId,
					com.icure.sdk.js.model.topicRole_fromJs(topicRole)))}


		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<TopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.removeParticipant(entityId, dataOwnerId))}

	}

	override fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.createTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedTopicJs> = GlobalScope.promise {
		topic_toJs(topicApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.topic_fromJs(nonNull1)
		}, patient?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun deleteTopic(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(topicApi.deleteTopic(entityId))}


	override fun deleteTopics(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			topicApi.deleteTopics(arrayToList(
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


	override fun matchTopicsBy(filter: AbstractFilterJs<EncryptedTopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			topicApi.matchTopicsBy(abstractFilter_fromJs(
				filter,
				{ x1: EncryptedTopicJs ->
					topic_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedTopicJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			topicApi.shareWith(delegateId, com.icure.sdk.js.model.topic_fromJs(topic),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.modifyTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


	override fun getTopic(entityId: String): Promise<DecryptedTopicJs> = GlobalScope.promise {
		topic_toJs(topicApi.getTopic(entityId))}


	override fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		listToArray(
			topicApi.getTopics(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun filterTopicsBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<EncryptedTopicJs>,
	): Promise<PaginatedListJs<DecryptedTopicJs>> = GlobalScope.promise {
		paginatedList_toJs(
			topicApi.filterTopicsBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.EncryptedTopicJs ->
			    com.icure.sdk.js.model.topic_fromJs(x1)
			  },
			)),
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<DecryptedTopicJs> = GlobalScope.promise {
		topic_toJs(topicApi.addParticipant(entityId, dataOwnerId,
				com.icure.sdk.js.model.topicRole_fromJs(topicRole)))}


	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.removeParticipant(entityId, dataOwnerId))}

}
