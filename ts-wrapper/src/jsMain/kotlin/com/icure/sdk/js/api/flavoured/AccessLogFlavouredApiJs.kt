// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
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
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<E>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

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
