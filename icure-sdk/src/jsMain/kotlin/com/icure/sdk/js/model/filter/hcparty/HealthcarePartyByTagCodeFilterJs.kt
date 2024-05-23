// auto-generated file
package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("HealthcarePartyByTagCodeFilter")
public external class HealthcarePartyByTagCodeFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthcarePartyJs> {
	public val tagType: String?

	public val tagCode: String?

	public val codeType: String?

	public val codeCode: String?

	override val desc: String?

	override val ktClass: String
}
