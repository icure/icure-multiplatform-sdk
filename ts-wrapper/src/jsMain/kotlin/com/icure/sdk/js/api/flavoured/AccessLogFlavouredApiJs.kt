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
		options: AccessLogFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(accessLog: E, delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<E>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: AccessLogFlavouredApi_findAccessLogsByHcPartyPatient_Options?,
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

	public fun findAccessLogsByUserAfterDate(userId: String,
			options: AccessLogFlavouredApi_findAccessLogsByUserAfterDate_Options?):
			Promise<PaginatedListJs<E>>

	public fun findAccessLogsInGroup(groupId: String,
			options: AccessLogFlavouredApi_findAccessLogsInGroup_Options?): Promise<PaginatedListJs<E>>
}

public external interface AccessLogFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface AccessLogFlavouredApi_findAccessLogsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface AccessLogFlavouredApi_findAccessLogsByUserAfterDate_Options {
	public val accessType: String?

	public val startDate: Double?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val descending: Boolean?
}

public external interface AccessLogFlavouredApi_findAccessLogsInGroup_Options {
	public val fromEpoch: Double?

	public val toEpoch: Double?

	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}
