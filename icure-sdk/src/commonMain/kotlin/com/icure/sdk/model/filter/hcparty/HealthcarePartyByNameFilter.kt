package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("HealthcarePartyByNameFilter")
@Serializable
public data class HealthcarePartyByNameFilter(
  override val desc: String? = null,
  public val name: String,
  public val descending: Boolean? = null,
) : AbstractFilter<HealthcareParty>
