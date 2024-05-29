// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
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
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(accessLog: E, delegates: dynamic): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(accessLog: E, delegates: dynamic): Promise<E>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
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

	public fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Double?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		descending: Boolean?,
	): Promise<PaginatedListJs<E>>

	public fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>
}
