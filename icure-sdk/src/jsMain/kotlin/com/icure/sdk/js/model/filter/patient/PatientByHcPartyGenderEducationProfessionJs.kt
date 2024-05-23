// auto-generated file
package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("PatientByHcPartyGenderEducationProfession")
public external class PatientByHcPartyGenderEducationProfessionJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val gender: String?

	public val education: String?

	public val profession: String?

	override val ktClass: String
}
