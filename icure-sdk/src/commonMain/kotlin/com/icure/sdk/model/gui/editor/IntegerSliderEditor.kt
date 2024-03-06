package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public class IntegerSliderEditor(
  public val maxValue: Int,
  public val minValue: Int,
  public val increment: Int? = null,
) : Editor
