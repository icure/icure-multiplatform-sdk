// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.AccessLogApi
import com.icure.sdk.js.api.flavoured.AccessLogApiJs
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DecryptedAccessLogJs
import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.accessLog_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.DecryptedAccessLog
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
public class AccessLogApiImplJs private constructor(
	private val accessLogApi: AccessLogApi,
) : AccessLogApiJs {
	override val encrypted: AccessLogFlavouredApiJs<EncryptedAccessLogJs> = object :
			AccessLogFlavouredApiJs<EncryptedAccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: EncryptedAccessLogJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				accessLogApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.accessLog_fromJs(accessLog),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)}


		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				accessLogApi.encrypted.findAccessLogsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)}


		override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			accessLog_toJs(accessLogApi.encrypted.modifyAccessLog(com.icure.sdk.js.model.accessLog_fromJs(entity)))}


		override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs> = GlobalScope.promise {
			accessLog_toJs(accessLogApi.encrypted.getAccessLog(entityId))}


		override fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>> =
				GlobalScope.promise {
			listToArray(
				accessLogApi.encrypted.getAccessLogs(arrayToList(
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
				accessLogApi.encrypted.findAccessLogsBy(com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch,
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
				accessLogApi.encrypted.findAccessLogsByUserAfterDate(userId, accessType,
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
				accessLogApi.encrypted.findAccessLogsInGroup(groupId,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch, "fromEpoch"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(toEpoch, "toEpoch"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: AccessLogFlavouredApiJs<AccessLogJs> = object :
			AccessLogFlavouredApiJs<AccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: AccessLogJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<AccessLogJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				accessLogApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.accessLog_fromJs(accessLog),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)}


		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<AccessLogJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				accessLogApi.tryAndRecover.findAccessLogsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)}


		override fun modifyAccessLog(entity: AccessLogJs): Promise<AccessLogJs> = GlobalScope.promise {
			accessLog_toJs(accessLogApi.tryAndRecover.modifyAccessLog(com.icure.sdk.js.model.accessLog_fromJs(entity)))}


		override fun getAccessLog(entityId: String): Promise<AccessLogJs> = GlobalScope.promise {
			accessLog_toJs(accessLogApi.tryAndRecover.getAccessLog(entityId))}


		override fun getAccessLogs(entityIds: Array<String>): Promise<Array<AccessLogJs>> =
				GlobalScope.promise {
			listToArray(
				accessLogApi.tryAndRecover.getAccessLogs(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)}


		override fun findAccessLogsBy(
			fromEpoch: Double?,
			toEpoch: Double?,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<AccessLogJs>> = GlobalScope.promise {
			paginatedList_toJs(
				accessLogApi.tryAndRecover.findAccessLogsBy(com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch,
						"fromEpoch"), com.icure.sdk.js.model.CheckedConverters.numberToLong(toEpoch, "toEpoch"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: AccessLog ->
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
		): Promise<PaginatedListJs<AccessLogJs>> = GlobalScope.promise {
			paginatedList_toJs(
				accessLogApi.tryAndRecover.findAccessLogsByUserAfterDate(userId, accessType,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"), startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						descending),
				{ x1: AccessLog ->
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
		): Promise<PaginatedListJs<AccessLogJs>> = GlobalScope.promise {
			paginatedList_toJs(
				accessLogApi.tryAndRecover.findAccessLogsInGroup(groupId,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(fromEpoch, "fromEpoch"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(toEpoch, "toEpoch"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)}

	}

	override fun createAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		accessLog_toJs(accessLogApi.createAccessLog(com.icure.sdk.js.model.accessLog_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedAccessLogJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedAccessLogJs> = GlobalScope.promise {
		accessLog_toJs(accessLogApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.accessLog_fromJs(nonNull1)
		}, com.icure.sdk.js.model.patient_fromJs(patient), user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(accessLogApi.deleteAccessLog(entityId))}


	override fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			accessLogApi.deleteAccessLogs(arrayToList(
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


	override fun shareWith(
		delegateId: String,
		accessLog: DecryptedAccessLogJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			accessLogApi.shareWith(delegateId, com.icure.sdk.js.model.accessLog_fromJs(accessLog),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}


	override fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			accessLogApi.findAccessLogsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)}

}
