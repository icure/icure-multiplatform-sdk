package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class PopupMenuEditor(
  public val menuOptions: List<String>? = null,
  override val displayValueDate: Boolean,
  public val displayAllAlways: Boolean,
  public val isFreeText: Boolean,
) : Editor, ValueDateEditor
