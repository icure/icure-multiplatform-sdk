package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public class MeasureEditor(
  override val displayValueDate: Boolean,
) : Editor, ValueDateEditor
