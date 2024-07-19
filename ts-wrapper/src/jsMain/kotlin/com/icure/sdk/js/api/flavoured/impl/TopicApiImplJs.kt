// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TopicApi
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.TopicApiJs
import com.icure.sdk.js.api.flavoured.TopicFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.crypto.entities.topicShareOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
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
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.topic_fromJs
import com.icure.sdk.js.model.topic_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
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
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedTopicJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: EncryptedTopic = topic_fromJs(topic)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = topicApi.encrypted.shareWith(
					delegateIdConverted,
					topicConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedTopic ->
						topic_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(topic: EncryptedTopicJs,
				delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<EncryptedTopicJs>>
				= GlobalScope.promise {
			val topicConverted: EncryptedTopic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.encrypted.tryShareWithMany(
				topicConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun shareWithMany(topic: EncryptedTopicJs,
				delegates: Record<String, TopicShareOptionsJs>): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			val topicConverted: EncryptedTopic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.encrypted.shareWithMany(
				topicConverted,
				delegatesConverted,
			)
			topic_toJs(result)
		}

		override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedTopic = topic_fromJs(entity)
			val result = topicApi.encrypted.modifyTopic(
				entityConverted,
			)
			topic_toJs(result)
		}

		override fun getTopic(entityId: String): Promise<EncryptedTopicJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = topicApi.encrypted.getTopic(
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
			val result = topicApi.encrypted.getTopics(
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
				val result = topicApi.encrypted.filterTopicsBy(
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
			val result = topicApi.encrypted.addParticipant(
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
			val result = topicApi.encrypted.removeParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
			)
			topic_toJs(result)
		}
	}

	override val tryAndRecover: TopicFlavouredApiJs<TopicJs> = object : TopicFlavouredApiJs<TopicJs> {
		override fun shareWith(
			delegateId: String,
			topic: TopicJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<TopicJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: Topic = topic_fromJs(topic)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = topicApi.tryAndRecover.shareWith(
					delegateIdConverted,
					topicConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(topic: TopicJs, delegates: Record<String, TopicShareOptionsJs>):
				Promise<SimpleShareResultJs<TopicJs>> = GlobalScope.promise {
			val topicConverted: Topic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.tryShareWithMany(
				topicConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun shareWithMany(topic: TopicJs, delegates: Record<String, TopicShareOptionsJs>):
				Promise<TopicJs> = GlobalScope.promise {
			val topicConverted: Topic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.shareWithMany(
				topicConverted,
				delegatesConverted,
			)
			topic_toJs(result)
		}

		override fun modifyTopic(entity: TopicJs): Promise<TopicJs> = GlobalScope.promise {
			val entityConverted: Topic = topic_fromJs(entity)
			val result = topicApi.tryAndRecover.modifyTopic(
				entityConverted,
			)
			topic_toJs(result)
		}

		override fun getTopic(entityId: String): Promise<TopicJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = topicApi.tryAndRecover.getTopic(
				entityIdConverted,
			)
			topic_toJs(result)
		}

		override fun getTopics(entityIds: Array<String>): Promise<Array<TopicJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = topicApi.tryAndRecover.getTopics(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>, options: dynamic):
				Promise<PaginatedListJs<TopicJs>> {
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
				val result = topicApi.tryAndRecover.filterTopicsBy(
					startDocumentIdConverted,
					limitConverted,
					filterChainConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}
		}

		override fun addParticipant(
			entityId: String,
			dataOwnerId: String,
			topicRole: String,
		): Promise<TopicJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val dataOwnerIdConverted: String = dataOwnerId
			val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
			val result = topicApi.tryAndRecover.addParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
				topicRoleConverted,
			)
			topic_toJs(result)
		}

		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<TopicJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val dataOwnerIdConverted: String = dataOwnerId
			val result = topicApi.tryAndRecover.removeParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
			)
			topic_toJs(result)
		}
	}

	override fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTopic = topic_fromJs(entity)
		val result = topicApi.createTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedTopicJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedTopic? = base?.let { nonNull1 ->
				topic_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId: SecretIdOptionJs ->
				secretIdOption_fromJs(secretId)
			}
			val result = topicApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			topic_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(topic: TopicJs): Promise<Array<String>> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.getEncryptionKeysOf(
			topicConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(topic: TopicJs): Promise<Boolean> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.hasWriteAccess(
			topicConverted,
		)
		result
	}

	override fun decryptPatientIdOf(topic: TopicJs): Promise<Array<String>> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.decryptPatientIdOf(
			topicConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: TopicJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Topic = topic_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		topicApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteTopic(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicApi.deleteTopic(
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
		val result = topicApi.deleteTopics(
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
		val result = topicApi.matchTopicsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<TopicJs>,
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
			val filterConverted: AbstractFilter<Topic> = abstractFilter_fromJs(
				filter,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
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
			val result = topicApi.subscribeToEvents(
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

	override fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedTopicJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val topicConverted: DecryptedTopic = topic_fromJs(topic)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareEncryptionKeys",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys: String ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareOwningEntityIds",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds: String ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
				_options,
				"requestedPermission",
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission: String ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = topicApi.shareWith(
				delegateIdConverted,
				topicConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<SimpleShareResultJs<DecryptedTopicJs>> =
			GlobalScope.promise {
		val topicConverted: DecryptedTopic = topic_fromJs(topic)
		val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: TopicShareOptionsJs ->
				topicShareOptions_fromJs(x1)
			},
		)
		val result = topicApi.tryShareWithMany(
			topicConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun shareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val topicConverted: DecryptedTopic = topic_fromJs(topic)
		val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: TopicShareOptionsJs ->
				topicShareOptions_fromJs(x1)
			},
		)
		val result = topicApi.shareWithMany(
			topicConverted,
			delegatesConverted,
		)
		topic_toJs(result)
	}

	override fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTopic = topic_fromJs(entity)
		val result = topicApi.modifyTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun getTopic(entityId: String): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicApi.getTopic(
			entityIdConverted,
		)
		topic_toJs(result)
	}

	override fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicApi.getTopics(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBy(filterChain: FilterChainJs<TopicJs>, options: dynamic):
			Promise<PaginatedListJs<DecryptedTopicJs>> {
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
			val result = topicApi.filterTopicsBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}
	}

	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
		val result = topicApi.addParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
			topicRoleConverted,
		)
		topic_toJs(result)
	}

	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val result = topicApi.removeParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
		)
		topic_toJs(result)
	}
}
