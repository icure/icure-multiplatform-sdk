// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TimeTableShareOptionsJs
import com.icure.sdk.js.model.TimeTableJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TimeTableFlavouredApi")
public external interface TimeTableFlavouredApiJs<E : TimeTableJs> {
	public fun shareWith(
		delegateId: String,
		timeTable: E,
		options: TimeTableFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(timeTable: E, delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(timeTable: E, delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<E>

	public fun modifyTimeTable(entity: E): Promise<E>

	public fun getTimeTable(entityId: String): Promise<E>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<E>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<E>>
}

public external interface TimeTableFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}
