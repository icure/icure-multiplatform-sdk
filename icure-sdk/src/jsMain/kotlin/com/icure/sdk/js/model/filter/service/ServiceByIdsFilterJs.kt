// auto-generated file
package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("ServiceByIdsFilter")
public external class ServiceByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ServiceJs>, FilterJs_IdsFilterJs<String, ServiceJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
