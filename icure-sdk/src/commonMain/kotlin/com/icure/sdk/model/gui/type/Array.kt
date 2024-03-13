package com.icure.sdk.model.gui.type

import kotlin.Any
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class Array(
  public val `value`: List<Any?>? = null,
) : Data
