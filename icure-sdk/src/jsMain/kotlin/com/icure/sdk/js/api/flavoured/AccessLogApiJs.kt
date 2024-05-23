// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.DecryptedAccessLogJs
import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
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
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedAccessLogJs>

	public fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs>

	public fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		accessLog: DecryptedAccessLogJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedAccessLogJs>>

	public fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>>
}
