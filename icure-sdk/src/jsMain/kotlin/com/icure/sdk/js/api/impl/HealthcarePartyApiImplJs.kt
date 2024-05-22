// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.js.api.HealthcarePartyApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PublicKeyJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.dataOwnerRegistrationSuccess_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.healthcareParty_fromJs
import com.icure.sdk.js.model.healthcareParty_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.publicKey_toJs
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class HealthcarePartyApiImplJs private constructor(
	private val healthcarePartyApi: HealthcarePartyApi,
) : HealthcarePartyApiJs {
	override fun getHealthcareParty(deviceId: String): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.getHealthcareParty(deviceId))}


	override fun createHealthcareParty(p: HealthcarePartyJs): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.createHealthcareParty(com.icure.sdk.js.model.healthcareParty_fromJs(p)))}


	override fun deleteHealthcareParty(deviceId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(healthcarePartyApi.deleteHealthcareParty(deviceId))}


	override fun modifyHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.modifyHealthcarePartyInGroup(groupId,
				com.icure.sdk.js.model.healthcareParty_fromJs(device)))}


	override fun createHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.createHealthcarePartyInGroup(groupId,
				com.icure.sdk.js.model.healthcareParty_fromJs(device)))}


	override fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs> = GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.getCurrentHealthcareParty())}


	override fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		desc: Boolean?,
	): Promise<PaginatedListJs<HealthcarePartyJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcarePartyApi.findHealthcarePartiesBy(startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), desc),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		desc: Boolean?,
	): Promise<PaginatedListJs<HealthcarePartyJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcarePartyApi.findHealthcarePartiesByName(name, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), desc),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		desc: Boolean,
	): Promise<PaginatedListJs<HealthcarePartyJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcarePartyApi.findHealthcarePartiesBySsinOrNihii(searchValue, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), desc),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		listToArray(
			healthcarePartyApi.listHealthcarePartiesByName(name),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<HealthcarePartyJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcarePartyApi.findHealthcarePartiesBySpecialityAndPostCode(type, spec, firstCode, lastCode,
					startKey, startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit")),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		listToArray(
			healthcarePartyApi.getHealthcareParties(arrayToList(
				healthcarePartyIds,
				"healthcarePartyIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		listToArray(
			healthcarePartyApi.listHealthcarePartiesByParentId(parentId),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs> = GlobalScope.promise {
		publicKey_toJs(healthcarePartyApi.getPublicKey(healthcarePartyId))}


	override fun deleteHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			healthcarePartyApi.deleteHealthcareParties(arrayToList(
				healthcarePartyIds,
				"healthcarePartyIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyHealthcareParty(healthcarePartyDto: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		healthcareParty_toJs(healthcarePartyApi.modifyHealthcareParty(com.icure.sdk.js.model.healthcareParty_fromJs(healthcarePartyDto)))}


	override fun matchHealthcarePartiesBy(filter: AbstractFilterJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			healthcarePartyApi.matchHealthcarePartiesBy(abstractFilter_fromJs(
				filter,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun filterHealthPartiesBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<HealthcarePartyJs>,
	): Promise<PaginatedListJs<HealthcarePartyJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcarePartyApi.filterHealthPartiesBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.HealthcarePartyJs ->
			    com.icure.sdk.js.model.healthcareParty_fromJs(x1)
			  },
			)),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun getHealthcarePartiesInGroup(groupId: String, healthcarePartyIds: Array<String>?):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		listToArray(
			healthcarePartyApi.getHealthcarePartiesInGroup(groupId, arrayToList(
				healthcarePartyIds,
				"healthcarePartyIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)}


	override fun deleteHealthcarePartiesInGroup(groupId: String, healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			healthcarePartyApi.deleteHealthcarePartiesInGroup(groupId, arrayToList(
				healthcarePartyIds,
				"healthcarePartyIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun deleteHealthcarePartyInGroup(healthcarePartyId: String, groupId: String):
			Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(healthcarePartyApi.deleteHealthcarePartyInGroup(healthcarePartyId, groupId))}


	override fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
		hcp: HealthcarePartyJs,
	): Promise<DataOwnerRegistrationSuccessJs> = GlobalScope.promise {
		dataOwnerRegistrationSuccess_toJs(healthcarePartyApi.registerPatient(groupId, parentHcPartyId,
				token, useShortToken, com.icure.sdk.js.model.healthcareParty_fromJs(hcp)))}

}
