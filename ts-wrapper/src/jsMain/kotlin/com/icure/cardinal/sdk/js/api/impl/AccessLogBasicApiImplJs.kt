// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.AccessLogBasicApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.accessLog_fromJs
import com.icure.cardinal.sdk.js.model.accessLog_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AccessLogBasicApiImplJs(
	private val accessLogBasicApi: AccessLogBasicApi,
) : AccessLogBasicApiJs {
	override fun matchAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.matchAccessLogsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<AccessLog> =
				baseSortableFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.matchAccessLogsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.filterAccessLogsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun filterAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<AccessLog> =
				baseSortableFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.filterAccessLogsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogBasicApi.deleteAccessLog(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogBasicApi.deleteAccessLogs(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteAccessLogById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = accessLogBasicApi.deleteAccessLogById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAccessLogsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.deleteAccessLogsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAccessLogById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		accessLogBasicApi.purgeAccessLogById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteAccessLog(accessLog: AccessLogJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogBasicApi.deleteAccessLog(
			accessLogConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAccessLogs(accessLogs: Array<AccessLogJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val accessLogsConverted: List<AccessLog> = arrayToList(
			accessLogs,
			"accessLogs",
			{ x1: AccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.deleteAccessLogs(
			accessLogsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAccessLog(accessLog: AccessLogJs): Promise<Unit> = GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		accessLogBasicApi.purgeAccessLog(
			accessLogConverted,
		)

	}

	override fun undeleteAccessLogById(id: String, rev: String): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = accessLogBasicApi.undeleteAccessLogById(
			idConverted,
			revConverted,
		)
		accessLog_toJs(result)
	}

	override fun undeleteAccessLog(accessLog: AccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogBasicApi.undeleteAccessLog(
			accessLogConverted,
		)
		accessLog_toJs(result)
	}

	override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogBasicApi.modifyAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogBasicApi.getAccessLog(
			entityIdConverted,
		)
		accessLog_toJs(result)
	}

	override fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogBasicApi.getAccessLogs(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
		val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
		val startKeyConverted: Long? = numberToLong(startKey, "startKey")
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = accessLogBasicApi.findAccessLogsBy(
			fromEpochConverted,
			toEpochConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val accessTypeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"accessType",
				null
			) { accessType: String? ->
				undefinedToNull(accessType)
			}
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = accessLogBasicApi.findAccessLogsByUserAfterDate(
				userIdConverted,
				accessTypeConverted,
				startDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descendingConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun findAccessLogsInGroup(groupId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val fromEpochConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"fromEpoch",
				null
			) { fromEpoch: Double? ->
				numberToLong(fromEpoch, "fromEpoch")
			}
			val toEpochConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"toEpoch",
				null
			) { toEpoch: Double? ->
				numberToLong(toEpoch, "toEpoch")
			}
			val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: Double? ->
				numberToLong(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = accessLogBasicApi.findAccessLogsInGroup(
				groupIdConverted,
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}
}
