package com.icure.sdk.model.filter.service

import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ServiceByHcPartyIdentifiersFilter(
  public val healthcarePartyId: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
  override val desc: String? = null,
) : AbstractFilter<Service>
