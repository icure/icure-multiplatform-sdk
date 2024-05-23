// auto-generated file
package com.icure.sdk.js.model.filter.message

import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("MessageByHcPartyTransportGuidFilter")
public external class MessageByHcPartyTransportGuidFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MessageJs> {
	public val healthcarePartyId: String

	public val transportGuid: String

	override val desc: String?

	override val ktClass: String
}
