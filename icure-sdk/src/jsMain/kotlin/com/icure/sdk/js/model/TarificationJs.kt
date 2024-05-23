// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeIdentificationJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.DecryptedValorisationJs
import com.icure.sdk.js.model.embed.LetterValueJs
import com.icure.sdk.js.model.embed.PeriodicityJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Tarification")
public external class TarificationJs(
	partial: dynamic,
) : StoredDocumentJs, CodeIdentificationJs<String> {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	override val label: dynamic

	override val context: String?

	override val type: String?

	override val code: String?

	override val version: String?

	public val author: String?

	public val regions: Array<String>

	public val periodicity: Array<PeriodicityJs>

	public val level: Double?

	public val links: Array<String>

	public val qualifiedLinks: dynamic

	public val flags: Array<String>

	public val searchTerms: dynamic

	public val `data`: String?

	public val appendices: dynamic

	public val disabled: Boolean

	public val valorisations: Array<DecryptedValorisationJs>

	public val category: dynamic

	public val consultationCode: Boolean?

	public val hasRelatedCode: Boolean?

	public val needsPrescriber: Boolean?

	public val relatedCodes: Array<String>

	public val ngroup: String?

	public val letterValues: Array<LetterValueJs>
}
