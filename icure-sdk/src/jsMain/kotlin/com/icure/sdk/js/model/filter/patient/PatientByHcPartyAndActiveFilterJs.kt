// auto-generated file
package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName

@JsName("PatientByHcPartyAndActiveFilter")
public external class PatientByHcPartyAndActiveFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val active: Boolean

	public val healthcarePartyId: String?

	override val ktClass: String
}
