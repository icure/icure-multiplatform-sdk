package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CalendarItemTag(
  public val code: String? = null,
  public val date: Long? = null,
  public val userId: String? = null,
  public val userName: String? = null,
)
