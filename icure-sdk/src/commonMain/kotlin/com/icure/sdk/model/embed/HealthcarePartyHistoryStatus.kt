package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class HealthcarePartyHistoryStatus(
  public val status: HealthcarePartyStatus,
  public val specialisationCode: String,
  public val startDate: Long,
  public val active: Boolean,
)
