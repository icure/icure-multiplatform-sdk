// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TimeTableBasicApi")
public external interface TimeTableBasicApiJs {
	public fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs>

	public fun getTimeTable(entityId: String): Promise<EncryptedTimeTableJs>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedTimeTableJs>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<EncryptedTimeTableJs>>
}
