// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.HealthElementBasicApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.HealthElementBasicApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.healthElement_fromJs
import com.icure.sdk.js.model.healthElement_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
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

	override fun deleteHealthElement(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementBasicApi.deleteHealthElement(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementBasicApi.deleteHealthElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementBasicApi.findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)
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

	override fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedHealthElementJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementBasicApi.findHealthElementsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
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
