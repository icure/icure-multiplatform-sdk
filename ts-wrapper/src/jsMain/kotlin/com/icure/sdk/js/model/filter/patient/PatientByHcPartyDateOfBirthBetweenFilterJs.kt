// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientByHcPartyDateOfBirthBetweenFilter")
public external class PatientByHcPartyDateOfBirthBetweenFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val minDateOfBirth: Double?

	public val maxDateOfBirth: Double?

	public val healthcarePartyId: String?

	override val ktClass: String
}
