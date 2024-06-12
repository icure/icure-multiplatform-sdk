// auto-generated file
@file:JsQualifier("api")

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
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ICureApi")
public external interface ICureApiJs {
	public fun getVersion(): Promise<String>

	public fun isReady(): Promise<String>

	public fun getProcessInfo(): Promise<String>

	public fun getIndexingInfo(): Promise<IndexingInfoJs>

	public fun getReplicationInfo(): Promise<ReplicationInfoJs>

	public fun updateDesignDoc(entityName: String, options: ICureApi_updateDesignDoc_Options?):
			Promise<Boolean>

	public fun resolvePatientsConflicts(options: ICureApi_resolvePatientsConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun resolveContactsConflicts(options: ICureApi_resolveContactsConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun resolveFormsConflicts(options: ICureApi_resolveFormsConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public
			fun resolveHealthElementsConflicts(options: ICureApi_resolveHealthElementsConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun resolveInvoicesConflicts(options: ICureApi_resolveInvoicesConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun resolveMessagesConflicts(options: ICureApi_resolveMessagesConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun resolveDocumentsConflicts(options: ICureApi_resolveDocumentsConflicts_Options?):
			Promise<Array<IdWithRevJs>>

	public fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs>

	public fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs>

	public fun evictAllFromMap(mapName: String): Promise<String>
}

public external interface ICureApi_updateDesignDoc_Options {
	public val warmup: Boolean?
}

public external interface ICureApi_resolvePatientsConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveContactsConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveFormsConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveHealthElementsConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveInvoicesConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveMessagesConflicts_Options {
	public val limit: Double?
}

public external interface ICureApi_resolveDocumentsConflicts_Options {
	public val ids: String?

	public val limit: Double?
}
