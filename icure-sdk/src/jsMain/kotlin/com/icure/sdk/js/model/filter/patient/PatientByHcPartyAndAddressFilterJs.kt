// auto-generated file
package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("PatientByHcPartyAndAddressFilter")
public external class PatientByHcPartyAndAddressFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val searchString: String?

	public val healthcarePartyId: String?

	public val postalCode: String?

	public val houseNumber: String?

	override val ktClass: String
}
