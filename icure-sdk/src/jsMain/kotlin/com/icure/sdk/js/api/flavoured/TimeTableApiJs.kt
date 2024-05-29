// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TimeTableShareOptionsJs
import com.icure.sdk.js.model.DecryptedTimeTableJs
import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TimeTableJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
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
		delegates: Record<String, String>,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedTimeTableJs>

	public fun getEncryptionKeysOf(timeTable: TimeTableJs): Promise<Array<String>>

	public fun hasWriteAccess(timeTable: TimeTableJs): Promise<Boolean>

	public fun decryptPatientIdOf(timeTable: TimeTableJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: TimeTableJs, delegates: Array<String>):
			Promise<Unit>

	public fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		timeTable: DecryptedTimeTableJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedTimeTableJs>>

	public fun tryShareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedTimeTableJs>>

	public fun shareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>): Promise<DecryptedTimeTableJs>

	public fun modifyTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs>

	public fun getTimeTable(entityId: String): Promise<DecryptedTimeTableJs>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedTimeTableJs>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<DecryptedTimeTableJs>>
}
