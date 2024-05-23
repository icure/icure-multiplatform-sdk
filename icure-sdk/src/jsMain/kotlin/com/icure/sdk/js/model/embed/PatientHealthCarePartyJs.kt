// auto-generated file
package com.icure.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName

@JsName("PatientHealthCareParty")
public sealed external interface PatientHealthCarePartyJs : EncryptableJs {
	public val type: String?

	public val healthcarePartyId: String?

	public val sendFormats: dynamic

	public val referralPeriods: Array<out ReferralPeriodJs>

	public val referral: Boolean

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedPatientHealthCareParty")
public external class DecryptedPatientHealthCarePartyJs(
	partial: dynamic,
) : PatientHealthCarePartyJs {
	override val type: String?

	override val healthcarePartyId: String?

	override val sendFormats: dynamic

	override val referralPeriods: Array<ReferralPeriodJs>

	override val referral: Boolean

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedPatientHealthCareParty")
public external class EncryptedPatientHealthCarePartyJs(
	partial: dynamic,
) : PatientHealthCarePartyJs {
	override val type: String?

	override val healthcarePartyId: String?

	override val sendFormats: dynamic

	override val referralPeriods: Array<ReferralPeriodJs>

	override val referral: Boolean

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
