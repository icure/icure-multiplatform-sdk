// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthElementByHcPartyIdentifiersFilter")
public external class HealthElementByHcPartyIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthElementJs> {
	override val desc: String?

	public val hcPartyId: String?

	public val identifiers: Array<IdentifierJs>

	override val ktClass: String
}
