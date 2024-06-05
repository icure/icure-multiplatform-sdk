// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.message

import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("LatestMessageByHcPartyTransportGuidFilter")
public external class LatestMessageByHcPartyTransportGuidFilterJs(
	partial: dynamic,
) : AbstractFilterJs<MessageJs> {
	public val healthcarePartyId: String

	public val transportGuid: String

	override val desc: String?

	override val ktClass: String
}
