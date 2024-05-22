// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.AccessLogBasicApi
import com.icure.sdk.js.api.flavoured.AccessLogBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.accessLog_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedAccessLog
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
public class AccessLogBasicApiImplJs private constructor(
	private val accessLogBasicApi: AccessLogBasicApi,
) : AccessLogBasicApiJs {
	override fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(accessLogBasicApi.deleteAccessLog(entityId))}


	override fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			accessLogBasicApi.deleteAccessLogs(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		accessLog_toJs(accessLogBasicApi.modifyAccessLog(com.icure.sdk.js.model.accessLog_fromJs(entity)))}


	override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs> = GlobalScope.promise {
		accessLog_toJs(accessLogBasicApi.getAccessLog(entityId))}


	override fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>> =
			GlobalScope.promise {
		listToArray(
			accessLogBasicApi.getAccessLogs(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}


	override fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		paginatedList_toJs(
			accessLogBasicApi.findAccessLogsBy(com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch,
					"fromEpoch"), com.icure.sdk.js.model.CheckedConverters.numberToLong(toEpoch, "toEpoch"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}


	override fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Double?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		descending: Boolean?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		paginatedList_toJs(
			accessLogBasicApi.findAccessLogsByUserAfterDate(userId, accessType,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"), startKey,
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					descending),
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}


	override fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		paginatedList_toJs(
			accessLogBasicApi.findAccessLogsInGroup(groupId,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch, "fromEpoch"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(toEpoch, "toEpoch"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}

}
