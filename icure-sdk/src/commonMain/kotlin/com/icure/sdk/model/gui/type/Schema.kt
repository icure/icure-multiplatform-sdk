package com.icure.sdk.model.gui.type

import kotlin.ByteArray
import kotlinx.serialization.Serializable

@Serializable
public class Schema(
  public val `data`: ByteArray,
) : Data
