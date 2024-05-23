// auto-generated file
package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("PatientByHcPartyAndSsinFilter")
public external class PatientByHcPartyAndSsinFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val ssin: String

	public val healthcarePartyId: String?

	override val ktClass: String
}
