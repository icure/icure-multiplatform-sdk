// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.base.IdentifiableJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("IdsFilter")
public external class IdsFilterJs<O : IdentifiableJs<String>>(
	partial: dynamic,
) : AbstractFilterJs<O>, FilterJs_IdsFilterJs<String, O> {
	override val desc: String?

	override val ids: Array<String>

	override val ktClass: String
}
