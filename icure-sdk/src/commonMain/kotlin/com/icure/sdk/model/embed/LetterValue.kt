package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class LetterValue(
  public val letter: String? = null,
  public val index: String? = null,
  public val coefficient: Double? = null,
  public val `value`: Double? = null,
)
