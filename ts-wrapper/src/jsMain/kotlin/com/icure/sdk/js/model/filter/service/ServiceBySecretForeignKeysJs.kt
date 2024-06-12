// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ServiceBySecretForeignKeys")
public external class ServiceBySecretForeignKeysJs(
	partial: dynamic,
) : AbstractFilterJs<ServiceJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val patientSecretForeignKeys: Array<String>

	override val ktClass: String
}
