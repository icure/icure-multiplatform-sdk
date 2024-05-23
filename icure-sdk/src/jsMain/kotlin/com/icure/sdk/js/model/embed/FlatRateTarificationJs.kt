// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FlatRateTarification")
public sealed external interface FlatRateTarificationJs : EncryptableJs {
	public val code: String?

	public val flatRateType: String?

	public val label: dynamic

	public val valorisations: Array<out ValorisationJs>

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedFlatRateTarification")
public external class DecryptedFlatRateTarificationJs(
	partial: dynamic,
) : FlatRateTarificationJs {
	override val code: String?

	override val flatRateType: String?

	override val label: dynamic

	override val valorisations: Array<DecryptedValorisationJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedFlatRateTarification")
public external class EncryptedFlatRateTarificationJs(
	partial: dynamic,
) : FlatRateTarificationJs {
	override val code: String?

	override val flatRateType: String?

	override val label: dynamic

	override val valorisations: Array<EncryptedValorisationJs>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
