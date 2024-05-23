// auto-generated file
package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("UsersByPatientIdFilter")
public external class UsersByPatientIdFilterJs(
	partial: dynamic,
) : AbstractFilterJs<UserJs> {
	public val patientId: String

	override val desc: String?

	override val ktClass: String
}
