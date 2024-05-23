// auto-generated file
package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("PatientByHcPartyDateOfBirthFilter")
public external class PatientByHcPartyDateOfBirthFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val dateOfBirth: Double

	public val healthcarePartyId: String?

	override val ktClass: String
}
