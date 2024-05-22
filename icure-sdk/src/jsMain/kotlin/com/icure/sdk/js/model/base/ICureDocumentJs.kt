// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.base

import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("ICureDocument")
public external interface ICureDocumentJs<T> : IdentifiableJs<T>, HasTagsJs, HasCodesJs {
	public val created: Double?

	public val modified: Double?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val endOfLife: Double?
}
