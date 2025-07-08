// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EmbeddedTimeTableItem")
public external class EmbeddedTimeTableItemJs(
	partial: dynamic,
) {
	public val rrule: String

	public val notBeforeInMinutes: Double?

	public val notAfterInMinutes: Double?

	public val hours: Array<EmbeddedTimeTableHourJs>

	public val calendarItemTypesIds: Array<String>

	public val availabilities: Double

	public val reservingRights: Array<String>

	public val `public`: Boolean
}
