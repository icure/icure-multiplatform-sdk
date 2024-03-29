package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface PatientHealthCareParty : Encryptable {
	public val type: PatientHealthCarePartyType?

	public val healthcarePartyId: String?

	public val sendFormats: Map<TelecomType, String>

	public val referralPeriods: List<ReferralPeriod>

	public val referral: Boolean

	override val encryptedSelf: Base64String?
	// region PatientHealthCareParty-PatientHealthCareParty

	// endregion
}

@Serializable
data class DecryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	override val referral: Boolean = false,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty {
	// region PatientHealthCareParty-DecryptedPatientHealthCareParty

	// endregion
}

@Serializable
data class EncryptedPatientHealthCareParty(
	override val type: PatientHealthCarePartyType? = null,
	override val healthcarePartyId: String? = null,
	override val sendFormats: Map<TelecomType, String> = emptyMap(),
	override val referralPeriods: List<ReferralPeriod> = emptyList(),
	override val referral: Boolean = false,
	override val encryptedSelf: Base64String? = null,
) : PatientHealthCareParty {
	// region PatientHealthCareParty-EncryptedPatientHealthCareParty

	// endregion
}
