// auto-generated file
package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("HealthcarePartyByIdentifiersFilter")
public external class HealthcarePartyByIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthcarePartyJs> {
	public val identifiers: Array<IdentifierJs>

	override val desc: String?

	override val ktClass: String
}
