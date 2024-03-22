package com.icure.sdk.model.filter.topic

import com.icure.sdk.model.Topic
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("TopicByParticipantFilter")
@Serializable
public data class TopicByParticipantFilter(
  public val participantId: String,
  override val desc: String? = null,
) : AbstractFilter<Topic>
