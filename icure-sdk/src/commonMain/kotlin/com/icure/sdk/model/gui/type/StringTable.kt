package com.icure.sdk.model.gui.type

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class StringTable(
  public val values: List<String>? = null,
) : Data
