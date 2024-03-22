package com.icure.sdk.model.filter.topic

import com.icure.sdk.model.Topic
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("TopicByHcPartyFilter")
@Serializable
public data class TopicByHcPartyFilter(
  override val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic>
