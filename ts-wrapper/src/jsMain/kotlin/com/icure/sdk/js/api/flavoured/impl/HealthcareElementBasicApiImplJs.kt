// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.HealthcareElementBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.flavoured.HealthcareElementBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.healthElement_fromJs
import com.icure.sdk.js.model.healthElement_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
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
internal class HealthcareElementBasicApiImplJs(
	private val healthcareElementBasicApi: HealthcareElementBasicApi,
) : HealthcareElementBasicApiJs {
	override fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
			filter,
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthcareElementBasicApi.matchHealthcareElementsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthcareElementBasicApi.deleteHealthcareElement(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcareElementBasicApi.deleteHealthcareElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result =
				healthcareElementBasicApi.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
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

	override fun modifyHealthcareElement(entity: EncryptedHealthElementJs):
			Promise<EncryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
		val result = healthcareElementBasicApi.modifyHealthcareElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun modifyHealthcareElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthcareElementBasicApi.modifyHealthcareElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun getHealthcareElement(entityId: String): Promise<EncryptedHealthElementJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthcareElementBasicApi.getHealthcareElement(
			entityIdConverted,
		)
		healthElement_toJs(result)
	}

	override fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcareElementBasicApi.getHealthcareElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedHealthElementJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<HealthElement> = filterChain_fromJs(
			filterChain,
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = healthcareElementBasicApi.filterHealthcareElementsBy(
			filterChainConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
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
		val result = healthcareElementBasicApi.findHealthcareElementsByHcPartyPatientForeignKeys(
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
		filter: AbstractFilterJs<HealthElementJs>,
		eventFired: (EncryptedHealthElementJs) -> Promise<Unit>,
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
			val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
				filter,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
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
			val eventFiredConverted: suspend (EncryptedHealthElement) -> Unit = { arg0 ->
				eventFired(
					healthElement_toJs(arg0),
				).await()
			}
			val result = healthcareElementBasicApi.subscribeToEvents(
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
