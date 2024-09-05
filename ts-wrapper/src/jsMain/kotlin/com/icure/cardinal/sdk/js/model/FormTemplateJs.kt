// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DocumentGroupJs
import com.icure.cardinal.sdk.js.model.embed.form.template.FormTemplateLayoutJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FormTemplate")
public external class FormTemplateJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val templateLayout: FormTemplateLayoutJs?

	public val rawTemplateLayout: ByteArray?

	public val name: String?

	public val guid: String?

	public val group: DocumentGroupJs?

	public val descr: String?

	public val disabled: String?

	public val specialty: CodeStubJs?

	public val author: String?

	public val formInstancePreferredLocation: String?

	public val keyboardShortcut: String?

	public val shortReport: String?

	public val mediumReport: String?

	public val longReport: String?

	public val reports: Array<String>

	public val tags: Array<CodeStubJs>

	public val layoutAttachmentId: String?

	public val templateLayoutAttachmentId: String?
}
