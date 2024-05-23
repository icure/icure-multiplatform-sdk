// auto-generated file
package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("CodeIdsByTypeCodeVersionIntervalFilter")
public external class CodeIdsByTypeCodeVersionIntervalFilterJs(
	partial: dynamic,
) : AbstractFilterJs<CodeJs> {
	override val desc: String?

	public val startType: String?

	public val startCode: String?

	public val startVersion: String?

	public val endType: String?

	public val endCode: String?

	public val endVersion: String?

	override val ktClass: String
}
