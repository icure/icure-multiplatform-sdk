// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ServiceByContactsAndSubcontactsFilter")
public external class ServiceByContactsAndSubcontactsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ServiceJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val contacts: Array<String>

	public val subContacts: Array<String>?

	public val startValueDate: Double?

	public val endValueDate: Double?

	override val ktClass: String
}
