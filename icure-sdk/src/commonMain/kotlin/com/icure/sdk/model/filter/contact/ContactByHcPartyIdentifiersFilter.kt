package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ContactByHcPartyIdentifiersFilter(
  public val healthcarePartyId: String? = null,
  override val desc: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<Contact>
