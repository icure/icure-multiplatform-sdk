// auto-generated file
package com.icure.sdk.js.model.embed.form.template

import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Field")
public sealed external interface FieldJs : StructureElementJs {
	public val `field`: String

	public val shortLabel: String?

	public val rows: Double?

	public val columns: Double?

	public val grows: Boolean?

	public val schema: String?

	public val tags: Array<out String>?

	public val codifications: Array<out String>?

	public val options: dynamic

	public val hideCondition: String?

	public val required: Boolean?

	public val multiline: Boolean?

	public val `value`: String?

	public val labels: dynamic

	public val unit: String?

	public val now: Boolean?

	public val translate: Boolean?
}
