package com.icure.sdk.model.`data`

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class LabelledOccurence(
  public val label: String,
  public val occurence: Long,
)