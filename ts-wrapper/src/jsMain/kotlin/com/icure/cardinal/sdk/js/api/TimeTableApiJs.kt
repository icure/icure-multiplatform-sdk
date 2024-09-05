// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.crypto.entities.TimeTableShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedTimeTableJs
import com.icure.cardinal.sdk.js.model.EncryptedTimeTableJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.TimeTableJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
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
		options: dynamic,
	): Promise<DecryptedTimeTableJs>

	public fun getEncryptionKeysOf(timeTable: TimeTableJs): Promise<Array<String>>

	public fun hasWriteAccess(timeTable: TimeTableJs): Promise<Boolean>

	public fun decryptPatientIdOf(timeTable: TimeTableJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: TimeTableJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(timeTable: EncryptedTimeTableJs): Promise<DecryptedTimeTableJs>

	public fun tryDecrypt(timeTable: EncryptedTimeTableJs): Promise<TimeTableJs>

	public fun matchTimeTablesBy(filter: FilterOptionsJs<TimeTableJs>): Promise<Array<String>>

	public fun matchTimeTablesBySorted(filter: SortableFilterOptionsJs<TimeTableJs>):
			Promise<Array<String>>

	public fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		timeTable: DecryptedTimeTableJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedTimeTableJs>>

	public fun tryShareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedTimeTableJs>>

	public fun shareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>): Promise<DecryptedTimeTableJs>

	public fun filterTimeTablesBy(filter: FilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<DecryptedTimeTableJs>>

	public fun filterTimeTablesBySorted(filter: SortableFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<DecryptedTimeTableJs>>

	public fun modifyTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs>

	public fun getTimeTable(entityId: String): Promise<DecryptedTimeTableJs>

	public fun getTimeTables(timeTableIds: Array<String>): Promise<Array<DecryptedTimeTableJs>>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedTimeTableJs>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<DecryptedTimeTableJs>>
}
