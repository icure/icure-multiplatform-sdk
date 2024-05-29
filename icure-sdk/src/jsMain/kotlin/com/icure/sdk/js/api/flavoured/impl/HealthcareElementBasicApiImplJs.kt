// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.HealthcareElementBasicApi
import com.icure.sdk.js.api.flavoured.HealthcareElementBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.healthElement_fromJs
import com.icure.sdk.js.model.healthElement_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.IcureStub
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
internal class HealthcareElementBasicApiImplJs(
	private val healthcareElementBasicApi: HealthcareElementBasicApi,
) : HealthcareElementBasicApiJs {
	override fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.matchHealthcareElementsBy(abstractFilter_fromJs(
				filter,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(healthcareElementBasicApi.deleteHealthcareElement(entityId))}


	override fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.deleteHealthcareElements(arrayToList(
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


	override fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId,
					arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)}


	override fun modifyHealthcareElement(entity: EncryptedHealthElementJs):
			Promise<EncryptedHealthElementJs> = GlobalScope.promise {
		healthElement_toJs(healthcareElementBasicApi.modifyHealthcareElement(com.icure.sdk.js.model.healthElement_fromJs(entity)))}


	override fun modifyHealthcareElements(entities: Array<EncryptedHealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.modifyHealthcareElements(arrayToList(
				entities,
				"entities",
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)),
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun getHealthcareElement(entityId: String): Promise<EncryptedHealthElementJs> =
			GlobalScope.promise {
		healthElement_toJs(healthcareElementBasicApi.getHealthcareElement(entityId))}


	override fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.getHealthcareElements(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedHealthElementJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcareElementBasicApi.filterHealthcareElementsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.HealthElementJs ->
			    com.icure.sdk.js.model.healthElement_fromJs(x1)
			  },
			), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedHealthElementJs>> =
			GlobalScope.promise {
		listToArray(
			healthcareElementBasicApi.findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId,
					arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}

}
