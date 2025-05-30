// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Annotation")
public external class AnnotationJs(
	partial: dynamic,
) : IdentifiableJs<String> {
	override val id: String

	public val author: String?

	public val created: Double?

	public val modified: Double?

	public val text: String?

	public val markdown: Record<String, String>

	public val location: String?

	public val confidential: Boolean?

	public val tags: Array<CodeStubJs>

	public val encryptedSelf: String?
}
