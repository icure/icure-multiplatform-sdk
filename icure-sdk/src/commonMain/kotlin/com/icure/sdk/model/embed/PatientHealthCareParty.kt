package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface PatientHealthCareParty : Encryptable {
  public val type: PatientHealthCarePartyType?

  public val healthcarePartyId: String?

  public val sendFormats: Map<TelecomType, String>

  public val referralPeriods: List<ReferralPeriod>

  public val referral: Boolean

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedPatientHealthCareParty(
  override val type: PatientHealthCarePartyType? = null,
  override val healthcarePartyId: String? = null,
  override val sendFormats: Map<TelecomType, String> = emptyMap(),
  override val referralPeriods: List<ReferralPeriod> = emptyList(),
  override val referral: Boolean = false,
  override val encryptedSelf: String? = null,
) : PatientHealthCareParty

@SerialName
public data class EncryptedPatientHealthCareParty(
  override val type: PatientHealthCarePartyType? = null,
  override val healthcarePartyId: String? = null,
  override val sendFormats: Map<TelecomType, String> = emptyMap(),
  override val referralPeriods: List<ReferralPeriod> = emptyList(),
  override val referral: Boolean = false,
  override val encryptedSelf: String? = null,
) : PatientHealthCareParty

public fun PatientHealthCareParty.copy(
  type: PatientHealthCarePartyType? = this.type,
  healthcarePartyId: String? = this.healthcarePartyId,
  sendFormats: Map<TelecomType, String> = this.sendFormats,
  referralPeriods: List<ReferralPeriod> = this.referralPeriods,
  referral: Boolean = this.referral,
  encryptedSelf: String? = this.encryptedSelf,
): PatientHealthCareParty {
                                      return when(this) {
                                          is DecryptedPatientHealthCareParty -> copy(type = type,
          healthcarePartyId = healthcarePartyId, sendFormats = sendFormats, referralPeriods =
          referralPeriods, referral = referral, encryptedSelf = encryptedSelf)
      is EncryptedPatientHealthCareParty -> copy(type = type, healthcarePartyId = healthcarePartyId,
          sendFormats = sendFormats, referralPeriods = referralPeriods, referral = referral,
          encryptedSelf = encryptedSelf)
                                          }
}
