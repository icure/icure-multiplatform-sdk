// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CodeByIdsFilter")
public external class CodeByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<CodeJs>, FilterJs_IdsFilterJs<String, CodeJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
