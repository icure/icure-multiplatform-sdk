// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.IndexingInfoJs
import com.icure.sdk.js.model.ReplicationInfoJs
import com.icure.sdk.js.model.couchdb.ReplicatorDocumentJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ICureApi")
public external interface ICureApiJs {
	public fun getVersion(): Promise<String>

	public fun isReady(): Promise<String>

	public fun getProcessInfo(): Promise<String>

	public fun getIndexingInfo(): Promise<IndexingInfoJs>

	public fun getReplicationInfo(): Promise<ReplicationInfoJs>

	public fun updateDesignDoc(entityName: String, options: dynamic): Promise<Boolean>

	public fun resolvePatientsConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveContactsConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveFormsConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveHealthElementsConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveInvoicesConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveMessagesConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun resolveDocumentsConflicts(options: dynamic): Promise<Array<IdWithRevJs>>

	public fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs>

	public fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs>

	public fun evictAllFromMap(mapName: String): Promise<String>
}
