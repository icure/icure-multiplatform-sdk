package com.icure.sdk.model.gui.type

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class MenuOption(
  public val key: String? = null,
  public val display: String? = null,
) : Data
