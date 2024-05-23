// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthElementByIdsFilter")
public external class HealthElementByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthElementJs>, FilterJs_IdsFilterJs<String, HealthElementJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
