package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByContactsAndSubcontactsFilter")
@Serializable
data class ServiceByContactsAndSubcontactsFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val contacts: Set<String> = emptySet(),
  public val subContacts: Set<String>? = null,
  public val startValueDate: Long? = null,
  public val endValueDate: Long? = null,
) : AbstractFilter<Service> {
	// region ServiceByContactsAndSubcontactsFilter-ServiceByContactsAndSubcontactsFilter
	// endregion
}