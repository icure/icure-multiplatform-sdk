// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Insurance")
public external class InsuranceJs(
	partial: dynamic,
) : StoredDocumentJs {
	override val id: String

	override val rev: String?

	override val deletionDate: Double?

	public val name: Record<String, String>

	public val privateInsurance: Boolean

	public val hospitalisationInsurance: Boolean

	public val ambulatoryInsurance: Boolean

	public val code: String?

	public val agreementNumber: String?

	public val parent: String?

	public val address: DecryptedAddressJs
}
