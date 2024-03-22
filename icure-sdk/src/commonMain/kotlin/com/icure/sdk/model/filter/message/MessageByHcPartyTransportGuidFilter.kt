package com.icure.sdk.model.filter.message

import com.icure.sdk.model.Message
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("MessageByHcPartyTransportGuidFilter")
@Serializable
public data class MessageByHcPartyTransportGuidFilter(
  public val healthcarePartyId: String,
  public val transportGuid: String,
  override val desc: String? = null,
) : AbstractFilter<Message>
