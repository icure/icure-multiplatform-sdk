// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientByHcPartyAndIdentifiersFilter")
public external class PatientByHcPartyAndIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs> {
	public val healthcarePartyId: String?

	public val identifiers: Array<IdentifierJs>

	override val desc: String?

	override val ktClass: String
}
