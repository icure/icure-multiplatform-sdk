// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Valorisation")
public sealed external interface ValorisationJs : EncryptableJs {
	public val startOfValidity: Double?

	public val endOfValidity: Double?

	public val predicate: String?

	public val reference: Array<out Double>?

	public val totalAmount: Double?

	public val reimbursement: Double?

	public val patientIntervention: Double?

	public val doctorSupplement: Double?

	public val vat: Double?

	public val label: Record<String, out String>?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedValorisation")
public external class DecryptedValorisationJs(
	partial: dynamic,
) : ValorisationJs {
	override val startOfValidity: Double?

	override val endOfValidity: Double?

	override val predicate: String?

	override val reference: Array<Double>?

	override val totalAmount: Double?

	override val reimbursement: Double?

	override val patientIntervention: Double?

	override val doctorSupplement: Double?

	override val vat: Double?

	override val label: Record<String, String>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedValorisation")
public external class EncryptedValorisationJs(
	partial: dynamic,
) : ValorisationJs {
	override val startOfValidity: Double?

	override val endOfValidity: Double?

	override val predicate: String?

	override val reference: Array<Double>?

	override val totalAmount: Double?

	override val reimbursement: Double?

	override val patientIntervention: Double?

	override val doctorSupplement: Double?

	override val vat: Double?

	override val label: Record<String, String>?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
