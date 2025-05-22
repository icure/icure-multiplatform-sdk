// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EmbeddedTimeTable")
public external class EmbeddedTimeTableJs(
	partial: dynamic,
) {
	public val id: String

	public val codes: Array<CodeStubJs>

	public val medicalLocationId: String?

	public val endOfLife: Double?

	public val name: String?

	public val startTime: Double?

	public val endTime: Double?

	public val items: Array<TimeTableItemJs>
}
