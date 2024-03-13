package com.icure.sdk.model.gui

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Column(
  public val label: String? = null,
  public val width: Double? = null,
)
