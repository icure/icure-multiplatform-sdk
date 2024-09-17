// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.TopicApiJs
import com.icure.cardinal.sdk.js.api.TopicFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.topicShareOptions_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.DecryptedTopicJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.topic_fromJs
import com.icure.cardinal.sdk.js.model.topic_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
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
		): Promise<EncryptedTopicJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: EncryptedTopic = topic_fromJs(topic)
				val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TopicShareOptionsJs? ->
					options?.let { nonNull1 ->
						topicShareOptions_fromJs(nonNull1)
					}
				}
				val result = topicApi.encrypted.shareWith(
					delegateIdConverted,
					topicConverted,
					optionsConverted,
				)
				topic_toJs(result)
			}
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

		override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.encrypted.filterTopicsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.encrypted.filterTopicsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
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
		): Promise<TopicJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: Topic = topic_fromJs(topic)
				val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TopicShareOptionsJs? ->
					options?.let { nonNull1 ->
						topicShareOptions_fromJs(nonNull1)
					}
				}
				val result = topicApi.tryAndRecover.shareWith(
					delegateIdConverted,
					topicConverted,
					optionsConverted,
				)
				topic_toJs(result)
			}
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

		override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<TopicJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.tryAndRecover.filterTopicsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<TopicJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.tryAndRecover.filterTopicsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
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
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
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

	override fun decrypt(topic: EncryptedTopicJs): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val topicConverted: EncryptedTopic = topic_fromJs(topic)
		val result = topicApi.decrypt(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun tryDecrypt(topic: EncryptedTopicJs): Promise<TopicJs> = GlobalScope.promise {
		val topicConverted: EncryptedTopic = topic_fromJs(topic)
		val result = topicApi.tryDecrypt(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun matchTopicsBy(filter: FilterOptionsJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
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

	override fun matchTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>): Promise<Array<String>>
			= GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
		val result = topicApi.matchTopicsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
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

	override fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		options: dynamic,
	): Promise<DecryptedTopicJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val topicConverted: DecryptedTopic = topic_fromJs(topic)
			val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: TopicShareOptionsJs? ->
				options?.let { nonNull1 ->
					topicShareOptions_fromJs(nonNull1)
				}
			}
			val result = topicApi.shareWith(
				delegateIdConverted,
				topicConverted,
				optionsConverted,
			)
			topic_toJs(result)
		}
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

	override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
		val result = topicApi.filterTopicsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
		val result = topicApi.filterTopicsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<TopicJs>,
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
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
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
}
