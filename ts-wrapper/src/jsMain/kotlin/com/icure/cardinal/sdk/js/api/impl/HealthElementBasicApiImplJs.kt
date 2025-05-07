// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthElementBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.healthElement_fromJs
import com.icure.cardinal.sdk.js.model.healthElement_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
internal class HealthElementBasicApiImplJs(
	private val healthElementBasicApi: HealthElementBasicApi,
) : HealthElementBasicApiJs {
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

	override fun deleteHealthElementUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementBasicApi.deleteHealthElementUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthElementsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>
			= GlobalScope.promise {
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
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteHealthElementById(entityId: String, rev: String?): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String? = undefinedToNull(rev)
		val result = healthElementBasicApi.deleteHealthElementById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthElementsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = healthElementBasicApi.deleteHealthElementsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
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

	override fun deleteHealthElement(healthElement: HealthElementJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementBasicApi.deleteHealthElement(
			healthElementConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
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
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
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

	override fun getHealthElement(entityId: String): Promise<EncryptedHealthElementJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementBasicApi.getHealthElement(
			entityIdConverted,
		)
		healthElement_toJs(result)
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
