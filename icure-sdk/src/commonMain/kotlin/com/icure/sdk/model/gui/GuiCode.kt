package com.icure.sdk.model.gui

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class GuiCode(
  public val type: String? = null,
  public val code: String? = null,
)
