package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public data class Weekday(
  public val weekday: CodeStub? = null,
  public val weekNumber: Int? = null,
)
