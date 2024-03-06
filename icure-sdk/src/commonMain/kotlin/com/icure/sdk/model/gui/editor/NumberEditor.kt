package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public class NumberEditor(
  override val displayValueDate: Boolean,
  public val precision: Int,
) : Editor, ValueDateEditor
