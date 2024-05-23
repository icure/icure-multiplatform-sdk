// auto-generated file
package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("ContactByHcPartyTagCodeDateFilter")
public external class ContactByHcPartyTagCodeDateFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ContactJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val tagType: String?

	public val tagCode: String?

	public val codeType: String?

	public val codeCode: String?

	public val startOfContactOpeningDate: Double?

	public val endOfContactOpeningDate: Double?

	override val ktClass: String
}
