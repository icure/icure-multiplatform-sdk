package com.icure.sdk.model.filter.topic

import com.icure.sdk.model.Topic
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("TopicByHcPartyFilter")
@Serializable
data class TopicByHcPartyFilter(
  override val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic> {
	// region TopicByHcPartyFilter-TopicByHcPartyFilter
	// endregion
}