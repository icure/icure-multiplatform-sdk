// auto-generated file
package com.icure.sdk.js.model.filter.device

import com.icure.sdk.js.model.DeviceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("DeviceByIdsFilter")
public external class DeviceByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<DeviceJs>, FilterJs_IdsFilterJs<String, DeviceJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
