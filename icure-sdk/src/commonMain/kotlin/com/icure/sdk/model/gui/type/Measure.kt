package com.icure.sdk.model.gui.type

import kotlin.Number
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Measure(
  public val label: String,
  public val unit: String,
  public val `value`: Number? = null,
  public val minRef: Number? = null,
  public val maxRef: Number? = null,
  public val severity: Number,
) : Data
