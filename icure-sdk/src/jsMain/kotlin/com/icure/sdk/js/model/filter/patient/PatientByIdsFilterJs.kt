// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientByIdsFilter")
public external class PatientByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<PatientJs>, FilterJs_IdsFilterJs<String, PatientJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
