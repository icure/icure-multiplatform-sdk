package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class HealthElementByHcPartyFilter(
  override val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.ByHcpartyFilter<HealthElement>
