// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogBasicApi")
public external interface AccessLogBasicApiJs {
	public fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs>

	public fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs>

	public fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>>

	public fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>>

	public fun findAccessLogsByUserAfterDate(userId: String,
			options: AccessLogBasicApi_findAccessLogsByUserAfterDate_Options?):
			Promise<PaginatedListJs<EncryptedAccessLogJs>>

	public fun findAccessLogsInGroup(groupId: String,
			options: AccessLogBasicApi_findAccessLogsInGroup_Options?):
			Promise<PaginatedListJs<EncryptedAccessLogJs>>
}

public external interface AccessLogBasicApi_findAccessLogsByUserAfterDate_Options {
	public val accessType: String?

	public val startDate: Double?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val descending: Boolean?
}

public external interface AccessLogBasicApi_findAccessLogsInGroup_Options {
	public val fromEpoch: Double?

	public val toEpoch: Double?

	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}
