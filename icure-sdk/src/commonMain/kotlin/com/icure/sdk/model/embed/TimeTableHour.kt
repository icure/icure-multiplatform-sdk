package com.icure.sdk.model.embed

import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public data class TimeTableHour(
  public val startHour: Long? = null,
  public val endHour: Long? = null,
)
