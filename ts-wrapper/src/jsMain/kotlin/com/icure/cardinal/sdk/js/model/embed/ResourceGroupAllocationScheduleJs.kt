// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ResourceGroupAllocationSchedule")
public external class ResourceGroupAllocationScheduleJs(
	partial: dynamic,
) {
	public val resourceGroup: CodeStubJs?

	public val tags: Array<CodeStubJs>

	public val codes: Array<CodeStubJs>

	public val name: String?

	public val startDateTime: Double?

	public val endDateTime: Double?

	public val items: Array<EmbeddedTimeTableItemJs>
}
