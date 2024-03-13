package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ContactByHcPartyFilter(
  override val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<Contact>, Filter.ByHcpartyFilter<Contact>
