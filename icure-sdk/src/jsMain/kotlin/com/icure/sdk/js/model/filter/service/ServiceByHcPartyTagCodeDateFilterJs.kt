// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ServiceByHcPartyTagCodeDateFilter")
public external class ServiceByHcPartyTagCodeDateFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ServiceJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val patientSecretForeignKey: String?

	public val tagType: String?

	public val tagCode: String?

	public val codeType: String?

	public val codeCode: String?

	public val startValueDate: Double?

	public val endValueDate: Double?

	public val descending: Boolean

	override val ktClass: String
}
