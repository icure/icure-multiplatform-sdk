package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class HealthElementByHcPartyIdentifiersFilter(
  override val desc: String? = null,
  public val hcPartyId: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<HealthElement>
