// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.IndexingInfoJs
import com.icure.sdk.js.model.ReplicationInfoJs
import com.icure.sdk.js.model.couchdb.ReplicatorDocumentJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("ICureApi")
public external interface ICureApiJs {
	public fun getVersion(): Promise<String>

	public fun isReady(): Promise<String>

	public fun getProcessInfo(): Promise<String>

	public fun getIndexingInfo(): Promise<IndexingInfoJs>

	public fun getReplicationInfo(): Promise<ReplicationInfoJs>

	public fun updateDesignDoc(entityName: String, warmup: Boolean?): Promise<Boolean>

	public fun resolvePatientsConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveContactsConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveFormsConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveHealthElementsConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveInvoicesConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveMessagesConflicts(limit: Double?): Promise<Array<IdWithRevJs>>

	public fun resolveDocumentsConflicts(ids: String?, limit: Double?): Promise<Array<IdWithRevJs>>

	public fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs>

	public fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs>

	public fun evictAllFromMap(mapName: String): Promise<String>
}
