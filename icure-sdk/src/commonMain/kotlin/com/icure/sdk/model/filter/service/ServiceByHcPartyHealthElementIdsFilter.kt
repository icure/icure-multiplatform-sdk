package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ServiceByHcPartyHealthElementIdsFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service>
