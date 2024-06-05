// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthcarePartyByIdsFilter")
public external class HealthcarePartyByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthcarePartyJs>, FilterJs_IdsFilterJs<String, HealthcarePartyJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
