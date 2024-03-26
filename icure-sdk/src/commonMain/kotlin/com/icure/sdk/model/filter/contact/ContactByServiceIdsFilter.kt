package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("ContactByServiceIdsFilter")
@Serializable
public data class ContactByServiceIdsFilter(
  override val desc: String? = null,
  public val ids: List<String>? = null,
) : AbstractFilter<Contact>
