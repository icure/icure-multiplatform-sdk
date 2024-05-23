// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.StoredDocumentJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("EntityTemplate")
public external class EntityTemplateJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val userId: String?

	public val descr: String?

	public val keywords: Array<String>?

	public val entityType: String?

	public val subType: String?

	public val defaultTemplate: Boolean?

	public val entity: Array<dynamic>
}
