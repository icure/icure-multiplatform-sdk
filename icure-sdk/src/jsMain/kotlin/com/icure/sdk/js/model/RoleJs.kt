// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.StoredDocumentJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Role")
public external class RoleJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val name: String?

	public val permissions: Array<String>
}
