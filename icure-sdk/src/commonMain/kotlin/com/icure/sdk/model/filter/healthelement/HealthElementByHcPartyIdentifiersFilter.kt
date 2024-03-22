package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyIdentifiersFilter")
@Serializable
data class HealthElementByHcPartyIdentifiersFilter(
  override val desc: String? = null,
  public val hcPartyId: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyIdentifiersFilter-HealthElementByHcPartyIdentifiersFilter
	// endregion
}