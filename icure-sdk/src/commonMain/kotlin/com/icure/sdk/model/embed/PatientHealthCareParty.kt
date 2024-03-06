package com.icure.sdk.model.embed

import java.util.SortedSet
import kotlin.Boolean
import kotlin.String
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class PatientHealthCareParty(
  public val type: PatientHealthCarePartyType? = null,
  public val healthcarePartyId: String? = null,
  public val sendFormats: Map<TelecomType, String> = emptyMap(),
  public val referralPeriods: SortedSet<ReferralPeriod> = sortedSetOf(),
  public val referral: Boolean = false,
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable
