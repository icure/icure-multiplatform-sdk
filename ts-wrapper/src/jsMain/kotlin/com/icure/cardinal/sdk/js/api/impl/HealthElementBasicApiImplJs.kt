// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthElementBasicApiJs
import com.icure.cardinal.sdk.js.api.HealthElementBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.healthElement_fromJs
import com.icure.cardinal.sdk.js.model.healthElement_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
internal class HealthElementBasicApiImplJs(
	private val healthElementBasicApi: HealthElementBasicApi,
) : HealthElementBasicApiJs {
	override val inGroup: HealthElementBasicInGroupApiJs = object : HealthElementBasicInGroupApiJs {
		override fun createHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
				Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementBasicApi.inGroup.createHealthElement(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun modifyHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
				Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementBasicApi.inGroup.modifyHealthElement(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun getHealthElement(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedHealthElementJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = healthElementBasicApi.inGroup.getHealthElement(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedHealthElement ->
							healthElement_toJs(x1)
						},
					)
				}
			)
		}
	}

	override fun matchHealthElementsBy(filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthElement> = baseFilterOptions_fromJs(filter)
		val result = healthElementBasicApi.matchHealthElementsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchHealthElementsBySorted(filter: BaseSortableFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthElement> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthElementBasicApi.matchHealthElementsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterHealthElementsBy(filter: BaseFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthElement> = baseFilterOptions_fromJs(filter)
		val result = healthElementBasicApi.filterHealthElementsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun filterHealthElementsBySorted(filter: BaseSortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthElement> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthElementBasicApi.filterHealthElementsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun deleteHealthElementUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementBasicApi.deleteHealthElementUnsafe(
			entityIdConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthElementsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementBasicApi.deleteHealthElementsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteHealthElementById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = healthElementBasicApi.deleteHealthElementById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthElementBasicApi.deleteHealthElementsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthElementById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		healthElementBasicApi.purgeHealthElementById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteHealthElement(healthElement: HealthElementJs):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementBasicApi.deleteHealthElement(
			healthElementConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val healthElementsConverted: List<HealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementBasicApi.deleteHealthElements(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthElement(healthElement: HealthElementJs): Promise<Unit> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		healthElementBasicApi.purgeHealthElement(
			healthElementConverted,
		)

	}

	override fun createHealthElement(entity: EncryptedHealthElementJs):
			Promise<EncryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
		val result = healthElementBasicApi.createHealthElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun createHealthElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementBasicApi.createHealthElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun undeleteHealthElementById(id: String, rev: String): Promise<EncryptedHealthElementJs>
			= GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = healthElementBasicApi.undeleteHealthElementById(
			idConverted,
			revConverted,
		)
		healthElement_toJs(result)
	}

	override fun undeleteHealthElement(healthElement: HealthElementJs):
			Promise<EncryptedHealthElementJs> = GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementBasicApi.undeleteHealthElement(
			healthElementConverted,
		)
		healthElement_toJs(result)
	}

	override fun modifyHealthElement(entity: EncryptedHealthElementJs):
			Promise<EncryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
		val result = healthElementBasicApi.modifyHealthElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun modifyHealthElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementBasicApi.modifyHealthElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun getHealthElement(entityId: String): Promise<EncryptedHealthElementJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementBasicApi.getHealthElement(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				healthElement_toJs(nonNull1)
			}
		)
	}

	override fun getHealthElements(entityIds: Array<String>): Promise<Array<EncryptedHealthElementJs>>
			= GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementBasicApi.getHealthElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<HealthElementJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedHealthElementJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<HealthElement> = baseFilterOptions_fromJs(filter)
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
			val result = healthElementBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}
}
