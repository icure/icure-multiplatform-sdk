// auto-generated file
package com.icure.sdk.js.model.filter.topic

import com.icure.sdk.js.model.TopicJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_ByHcpartyFilterJs
import kotlin.String
import kotlin.js.JsName

@JsName("TopicByHcPartyFilter")
public external class TopicByHcPartyFilterJs(
	partial: dynamic,
) : AbstractFilterJs<TopicJs>, FilterJs_ByHcpartyFilterJs<TopicJs> {
	override val hcpId: String

	override val desc: String?

	override val ktClass: String
}
