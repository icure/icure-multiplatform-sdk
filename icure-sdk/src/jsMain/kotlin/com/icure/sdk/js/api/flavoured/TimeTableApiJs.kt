// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedTimeTableJs
import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TimeTableJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("TimeTableApi")
public external interface TimeTableApiJs {
	public val encrypted: TimeTableFlavouredApiJs<EncryptedTimeTableJs>

	public val tryAndRecover: TimeTableFlavouredApiJs<TimeTableJs>

	public fun createTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs>

	public fun withEncryptionMetadata(
		base: DecryptedTimeTableJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedTimeTableJs>

	public fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		timeTable: DecryptedTimeTableJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedTimeTableJs>>
}
