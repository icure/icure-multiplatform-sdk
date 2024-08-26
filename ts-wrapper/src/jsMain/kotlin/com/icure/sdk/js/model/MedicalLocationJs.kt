// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.NamedJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.DecryptedAddressJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("MedicalLocation")
public external class MedicalLocationJs(
	partial: dynamic,
) : StoredDocumentJs, NamedJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val name: String?

	public val description: String?

	public val responsible: String?

	public val guardPost: Boolean?

	public val cbe: String?

	public val bic: String?

	public val bankAccount: String?

	public val nihii: String?

	public val ssin: String?

	public val address: DecryptedAddressJs?

	public val agendaIds: Array<String>

	public val options: Record<String, String>

	public val publicInformations: Record<String, String>
}
