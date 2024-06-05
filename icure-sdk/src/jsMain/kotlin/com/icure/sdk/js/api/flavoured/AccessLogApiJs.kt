// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.DecryptedAccessLogJs
import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogApi")
public external interface AccessLogApiJs {
	public val encrypted: AccessLogFlavouredApiJs<EncryptedAccessLogJs>

	public val tryAndRecover: AccessLogFlavouredApiJs<AccessLogJs>

	public fun createAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs>

	public fun withEncryptionMetadata(
		base: DecryptedAccessLogJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: Record<String, String>,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedAccessLogJs>

	public fun getEncryptionKeysOf(accessLog: AccessLogJs): Promise<Array<String>>

	public fun hasWriteAccess(accessLog: AccessLogJs): Promise<Boolean>

	public fun decryptPatientIdOf(accessLog: AccessLogJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: AccessLogJs, delegates: Array<String>):
			Promise<Unit>

	public fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs>

	public fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		accessLog: DecryptedAccessLogJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedAccessLogJs>>

	public fun tryShareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedAccessLogJs>>

	public fun shareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>): Promise<DecryptedAccessLogJs>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>>

	public fun modifyAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs>

	public fun getAccessLog(entityId: String): Promise<DecryptedAccessLogJs>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<DecryptedAccessLogJs>>

	public fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedAccessLogJs>>

	public fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Double?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		descending: Boolean?,
	): Promise<PaginatedListJs<DecryptedAccessLogJs>>

	public fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedAccessLogJs>>
}
