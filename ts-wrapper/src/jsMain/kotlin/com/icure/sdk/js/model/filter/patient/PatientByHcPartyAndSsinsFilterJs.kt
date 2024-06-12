// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientByHcPartyAndSsinsFilter")
public external class PatientByHcPartyAndSsinsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	override val desc: String?

	public val ssins: Array<String>?

	public val healthcarePartyId: String?

	override val ktClass: String
}
