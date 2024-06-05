// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TopicApi
import com.icure.sdk.js.api.flavoured.TopicApiJs
import com.icure.sdk.js.api.flavoured.TopicFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.setToArray
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
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Topic
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
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
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)}


		override fun tryShareWithMany(topic: EncryptedTopicJs,
				delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<EncryptedTopicJs>>
				= GlobalScope.promise {
			simpleShareResult_toJs(
				topicApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)}


		override fun shareWithMany(topic: EncryptedTopicJs,
				delegates: Record<String, TopicShareOptionsJs>): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.encrypted.shareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
			  },
			)))}


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
			filterChain: FilterChainJs<TopicJs>,
		): Promise<PaginatedListJs<EncryptedTopicJs>> = GlobalScope.promise {
			paginatedList_toJs(
				topicApi.encrypted.filterTopicsBy(startDocumentId,
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
			topic_toJs(topicApi.encrypted.addParticipant(entityId, dataOwnerId,
					com.icure.sdk.model.TopicRole.valueOf(topicRole)))}


		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.encrypted.removeParticipant(entityId, dataOwnerId))}


		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<TopicJs>,
			onConnected: () -> Promise<Unit>,
			channelCapacity: Double,
			retryDelay: Double,
			retryDelayExponentFactor: Double,
			maxRetries: Double,
			eventFired: (EncryptedTopicJs) -> Promise<Unit>,
		): Promise<ConnectionJs> = GlobalScope.promise {
			val onConnectedConverted: suspend () -> Unit = {  ->
				onConnected(
				).await()
			}
			val eventFiredConverted: suspend (EncryptedTopic) -> Unit = { arg0 ->
				eventFired(
					topic_toJs(arg0)).await()
			}
			connection_toJs(topicApi.encrypted.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  events,
			  "events",
			  { x1: kotlin.String ->
			    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
			  },
			), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
			  filter,
			  { x1: com.icure.sdk.js.model.TopicJs ->
			    com.icure.sdk.js.model.topic_fromJs(x1)
			  },
			), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
					"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
					"retryDelay"), retryDelayExponentFactor,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
					eventFiredConverted))}

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
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)}


		override fun tryShareWithMany(topic: TopicJs, delegates: Record<String, TopicShareOptionsJs>):
				Promise<SimpleShareResultJs<TopicJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				topicApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
				  },
				)),
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)}


		override fun shareWithMany(topic: TopicJs, delegates: Record<String, TopicShareOptionsJs>):
				Promise<TopicJs> = GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
			  },
			)))}


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
			filterChain: FilterChainJs<TopicJs>,
		): Promise<PaginatedListJs<TopicJs>> = GlobalScope.promise {
			paginatedList_toJs(
				topicApi.tryAndRecover.filterTopicsBy(startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.TopicJs ->
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
					com.icure.sdk.model.TopicRole.valueOf(topicRole)))}


		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<TopicJs> =
				GlobalScope.promise {
			topic_toJs(topicApi.tryAndRecover.removeParticipant(entityId, dataOwnerId))}


		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<TopicJs>,
			onConnected: () -> Promise<Unit>,
			channelCapacity: Double,
			retryDelay: Double,
			retryDelayExponentFactor: Double,
			maxRetries: Double,
			eventFired: (TopicJs) -> Promise<Unit>,
		): Promise<ConnectionJs> = GlobalScope.promise {
			val onConnectedConverted: suspend () -> Unit = {  ->
				onConnected(
				).await()
			}
			val eventFiredConverted: suspend (Topic) -> Unit = { arg0 ->
				eventFired(
					topic_toJs(arg0)).await()
			}
			connection_toJs(topicApi.tryAndRecover.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  events,
			  "events",
			  { x1: kotlin.String ->
			    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
			  },
			), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
			  filter,
			  { x1: com.icure.sdk.js.model.TopicJs ->
			    com.icure.sdk.js.model.topic_fromJs(x1)
			  },
			), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
					"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
					"retryDelay"), retryDelayExponentFactor,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
					eventFiredConverted))}

	}

	override fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.createTopic(com.icure.sdk.js.model.topic_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: Record<String, String>,
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
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun getEncryptionKeysOf(topic: TopicJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			topicApi.getEncryptionKeysOf(topic_fromJs(topic)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(topic: TopicJs): Promise<Boolean> = GlobalScope.promise {
		topicApi.hasWriteAccess(topic_fromJs(topic))}


	override fun decryptPatientIdOf(topic: TopicJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			topicApi.decryptPatientIdOf(topic_fromJs(topic)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: TopicJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		topicApi.createDelegationDeAnonymizationMetadata(topic_fromJs(entity), arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


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


	override fun matchTopicsBy(filter: AbstractFilterJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			topicApi.matchTopicsBy(abstractFilter_fromJs(
				filter,
				{ x1: TopicJs ->
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
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun tryShareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<DecryptedTopicJs>> =
			GlobalScope.promise {
		simpleShareResult_toJs(
			topicApi.tryShareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)}


	override fun shareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.shareWithMany(com.icure.sdk.js.model.topic_fromJs(topic),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.TopicShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs(x1)
		  },
		)))}


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
		filterChain: FilterChainJs<TopicJs>,
	): Promise<PaginatedListJs<DecryptedTopicJs>> = GlobalScope.promise {
		paginatedList_toJs(
			topicApi.filterTopicsBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.TopicJs ->
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
				com.icure.sdk.model.TopicRole.valueOf(topicRole)))}


	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		topic_toJs(topicApi.removeParticipant(entityId, dataOwnerId))}


	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
		onConnected: () -> Promise<Unit>,
		channelCapacity: Double,
		retryDelay: Double,
		retryDelayExponentFactor: Double,
		maxRetries: Double,
		eventFired: (DecryptedTopicJs) -> Promise<Unit>,
	): Promise<ConnectionJs> = GlobalScope.promise {
		val onConnectedConverted: suspend () -> Unit = {  ->
			onConnected(
			).await()
		}
		val eventFiredConverted: suspend (DecryptedTopic) -> Unit = { arg0 ->
			eventFired(
				topic_toJs(arg0)).await()
		}
		connection_toJs(topicApi.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
		  events,
		  "events",
		  { x1: kotlin.String ->
		    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
		  },
		), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
		  filter,
		  { x1: com.icure.sdk.js.model.TopicJs ->
		    com.icure.sdk.js.model.topic_fromJs(x1)
		  },
		), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
				"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
				"retryDelay"), retryDelayExponentFactor,
				com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
				eventFiredConverted))}

}
