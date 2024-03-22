package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyHealthElementIdsFilter")
@Serializable
data class ServiceByHcPartyHealthElementIdsFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service> {
	// region ServiceByHcPartyHealthElementIdsFilter-ServiceByHcPartyHealthElementIdsFilter
	// endregion
}