// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CodeIdentification")
public external interface CodeIdentificationJs<K> {
	public val id: K

	public val code: String?

	public val context: String?

	public val type: String?

	public val version: String?

	public val label: Record<String, out String>?
}
