// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ServiceByHcPartyIdentifiersFilter")
public external class ServiceByHcPartyIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ServiceJs> {
	public val healthcarePartyId: String?

	public val identifiers: Array<IdentifierJs>

	override val desc: String?

	override val ktClass: String
}
