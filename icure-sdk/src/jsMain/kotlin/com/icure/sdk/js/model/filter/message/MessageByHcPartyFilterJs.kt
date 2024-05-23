// auto-generated file
package com.icure.sdk.js.model.filter.message

import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_ByHcpartyFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("MessageByHcPartyFilter")
public external class MessageByHcPartyFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MessageJs>, FilterJs_ByHcpartyFilterJs<MessageJs> {
	override val hcpId: String

	override val desc: String?

	override val ktClass: String
}
