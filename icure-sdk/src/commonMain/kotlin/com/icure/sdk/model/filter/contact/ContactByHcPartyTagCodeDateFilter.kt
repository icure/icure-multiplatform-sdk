package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ContactByHcPartyTagCodeDateFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val tagType: String? = null,
  public val tagCode: String? = null,
  public val codeType: String? = null,
  public val codeCode: String? = null,
  public val startOfContactOpeningDate: Long? = null,
  public val endOfContactOpeningDate: Long? = null,
) : AbstractFilter<Contact>
