// auto-generated file
package com.icure.sdk.js.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName

@JsName("Insurability")
public sealed external interface InsurabilityJs : EncryptableJs {
	public val parameters: dynamic

	public val hospitalisation: Boolean?

	public val ambulatory: Boolean?

	public val dental: Boolean?

	public val identificationNumber: String?

	public val insuranceId: String?

	public val startDate: Double?

	public val endDate: Double?

	public val titularyId: String?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedInsurability")
public external class DecryptedInsurabilityJs(
	partial: dynamic,
) : InsurabilityJs {
	override val parameters: dynamic

	override val hospitalisation: Boolean?

	override val ambulatory: Boolean?

	override val dental: Boolean?

	override val identificationNumber: String?

	override val insuranceId: String?

	override val startDate: Double?

	override val endDate: Double?

	override val titularyId: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedInsurability")
public external class EncryptedInsurabilityJs(
	partial: dynamic,
) : InsurabilityJs {
	override val parameters: dynamic

	override val hospitalisation: Boolean?

	override val ambulatory: Boolean?

	override val dental: Boolean?

	override val identificationNumber: String?

	override val insuranceId: String?

	override val startDate: Double?

	override val endDate: Double?

	override val titularyId: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
