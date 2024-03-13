package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class ServiceByContactsAndSubcontactsFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val contacts: Set<String> = emptySet(),
  public val subContacts: Set<String>? = null,
  public val startValueDate: Long? = null,
  public val endValueDate: Long? = null,
) : AbstractFilter<Service>
