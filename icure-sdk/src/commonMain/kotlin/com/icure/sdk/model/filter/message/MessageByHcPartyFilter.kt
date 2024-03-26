package com.icure.sdk.model.filter.message

import com.icure.sdk.model.Message
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("MessageByHcPartyFilter")
@Serializable
public data class MessageByHcPartyFilter(
  override val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<Message>, Filter.ByHcpartyFilter<Message>
