// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ContactByHcPartyIdentifiersFilter")
public external class ContactByHcPartyIdentifiersFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ContactJs> {
	public val healthcarePartyId: String?

	override val desc: String?

	public val identifiers: Array<IdentifierJs>

	override val ktClass: String
}
