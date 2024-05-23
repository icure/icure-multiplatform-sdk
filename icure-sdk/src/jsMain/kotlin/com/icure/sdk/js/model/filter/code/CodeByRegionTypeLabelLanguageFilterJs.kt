// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CodeByRegionTypeLabelLanguageFilter")
public external class CodeByRegionTypeLabelLanguageFilterJs(
	partial: dynamic,
) : AbstractFilterJs<CodeJs> {
	override val desc: String?

	public val region: String?

	public val type: String

	public val language: String

	public val label: String?

	override val ktClass: String
}
