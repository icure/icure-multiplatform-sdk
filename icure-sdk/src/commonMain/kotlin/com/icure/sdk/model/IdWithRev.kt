package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class IdWithRev(
  public val id: String,
  public val rev: String? = null,
)
