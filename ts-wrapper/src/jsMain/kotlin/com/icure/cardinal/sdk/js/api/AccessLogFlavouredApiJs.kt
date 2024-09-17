// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogFlavouredApi")
public external interface AccessLogFlavouredApiJs<E : AccessLogJs> {
	public fun shareWith(
		delegateId: String,
		accessLog: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<E>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun modifyAccessLog(entity: E): Promise<E>

	public fun getAccessLog(entityId: String): Promise<E>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<E>>

	public fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
			Promise<PaginatedListJs<E>>

	public fun findAccessLogsInGroup(groupId: String, options: dynamic): Promise<PaginatedListJs<E>>
}
