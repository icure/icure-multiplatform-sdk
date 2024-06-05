// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthElementByHcPartyTagCodeFilter")
public external class HealthElementByHcPartyTagCodeFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthElementJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val codeType: String?

	public val codeCode: String?

	public val tagType: String?

	public val tagCode: String?

	public val status: Double?

	override val ktClass: String
}
