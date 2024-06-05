// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ContactByServiceIdsFilter")
public external class ContactByServiceIdsFilterJs(
	partial: dynamic,
) : AbstractFilterJs<ContactJs> {
	override val desc: String?

	public val ids: Array<String>?

	override val ktClass: String
}
