// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Measure")
public external class MeasureJs(
	partial: dynamic,
) {
	public val `value`: Double?

	public val ref: Double?

	public val severity: Double?

	public val severityCode: String?

	public val evolution: Double?

	public val unit: String?

	public val unitCodes: Array<CodeStubJs>?

	public val comment: String?

	public val comparator: String?

	public val sign: String?

	public val referenceRanges: Array<ReferenceRangeJs>

	public val valueWithPrecision: ValueWithPrecisionJs?
}
