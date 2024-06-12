// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_ByHcpartyFilterJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthElementByHcPartyFilter")
public external class HealthElementByHcPartyFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthElementJs>, FilterJs_ByHcpartyFilterJs<HealthElementJs> {
	override val hcpId: String

	override val desc: String?

	override val ktClass: String
}
