package com.icure.sdk.model.gui

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Tag(
  public val type: String? = null,
  public val tag: String? = null,
)
