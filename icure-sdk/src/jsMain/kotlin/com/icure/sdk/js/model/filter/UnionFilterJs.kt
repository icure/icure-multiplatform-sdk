// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.base.IdentifiableJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("UnionFilter")
public external class UnionFilterJs<O : IdentifiableJs<String>>(
	partial: dynamic,
) : AbstractFilterJs<O>, FilterJs_UnionFilterJs<O> {
	override val desc: String?

	override val filters: Array<AbstractFilterJs<O>>

	override val ktClass: String
}
