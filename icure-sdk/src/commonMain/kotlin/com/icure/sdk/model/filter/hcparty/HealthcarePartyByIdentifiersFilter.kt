package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("HealthcarePartyByIdentifiersFilter")
@Serializable
public data class HealthcarePartyByIdentifiersFilter(
  public val identifiers: List<Identifier> = emptyList(),
  override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
