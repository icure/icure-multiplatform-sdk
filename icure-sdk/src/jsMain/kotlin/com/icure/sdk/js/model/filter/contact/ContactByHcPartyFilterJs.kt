// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_ByHcpartyFilterJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ContactByHcPartyFilter")
public external class ContactByHcPartyFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ContactJs>, FilterJs_ByHcpartyFilterJs<ContactJs> {
	override val hcpId: String

	override val desc: String?

	override val ktClass: String
}
