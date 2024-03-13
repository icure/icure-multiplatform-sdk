package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class CheckBoxEditor(
  override val displayValueDate: Boolean,
  public val groupRadio: String? = null,
) : Editor, ValueDateEditor
