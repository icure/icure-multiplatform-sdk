// auto-generated file
package com.icure.sdk.js.model.filter.user

import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.FilterJs_IdsFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("UserByIdsFilter")
public external class UserByIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<UserJs>, FilterJs_IdsFilterJs<String, UserJs> {
	override val ids: Array<String>

	override val desc: String?

	override val ktClass: String
}
