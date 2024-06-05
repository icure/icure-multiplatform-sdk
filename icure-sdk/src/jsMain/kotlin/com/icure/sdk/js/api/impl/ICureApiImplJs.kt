// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.ICureApi
import com.icure.sdk.js.api.ICureApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.IndexingInfoJs
import com.icure.sdk.js.model.ReplicationInfoJs
import com.icure.sdk.js.model.couchdb.ReplicatorDocumentJs
import com.icure.sdk.js.model.couchdb.replicatorDocument_toJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.indexingInfo_toJs
import com.icure.sdk.js.model.replicationInfo_toJs
import com.icure.sdk.model.IdWithRev
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
internal class ICureApiImplJs(
	private val iCureApi: ICureApi,
) : ICureApiJs {
	override fun getVersion(): Promise<String> = GlobalScope.promise {
		iCureApi.getVersion()}


	override fun isReady(): Promise<String> = GlobalScope.promise {
		iCureApi.isReady()}


	override fun getProcessInfo(): Promise<String> = GlobalScope.promise {
		iCureApi.getProcessInfo()}


	override fun getIndexingInfo(): Promise<IndexingInfoJs> = GlobalScope.promise {
		indexingInfo_toJs(iCureApi.getIndexingInfo())}


	override fun getReplicationInfo(): Promise<ReplicationInfoJs> = GlobalScope.promise {
		replicationInfo_toJs(iCureApi.getReplicationInfo())}


	override fun updateDesignDoc(entityName: String, warmup: Boolean?): Promise<Boolean> =
			GlobalScope.promise {
		iCureApi.updateDesignDoc(entityName, warmup)}


	override fun resolvePatientsConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolvePatientsConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveContactsConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveContactsConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveFormsConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveFormsConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveHealthElementsConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveHealthElementsConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveInvoicesConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveInvoicesConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveMessagesConflicts(limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveMessagesConflicts(numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resolveDocumentsConflicts(ids: String?, limit: Double?): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			iCureApi.resolveDocumentsConflicts(ids, numberToInt(limit, "limit")),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs> =
			GlobalScope.promise {
		indexingInfo_toJs(iCureApi.getIndexingInfoByGroup(groupId))}


	override fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs> = GlobalScope.promise {
		replicatorDocument_toJs(iCureApi.getReplicatorInfo(id))}


	override fun evictAllFromMap(mapName: String): Promise<String> = GlobalScope.promise {
		iCureApi.evictAllFromMap(mapName)}

}
