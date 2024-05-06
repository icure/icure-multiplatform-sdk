package com.icure.sdk.model.filter.service

import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.sdk.model.embed.Service

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyIdentifiersFilter")
@Serializable
data class ServiceByHcPartyIdentifiersFilter(
	public val healthcarePartyId: String? = null,
	public val identifiers: List<Identifier> = emptyList(),
	override val desc: String? = null,
) : AbstractFilter<O> {
	// region ServiceByHcPartyIdentifiersFilter-ServiceByHcPartyIdentifiersFilter

	// endregion
}
