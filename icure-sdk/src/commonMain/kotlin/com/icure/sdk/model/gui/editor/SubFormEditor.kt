package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class SubFormEditor(
  public val optionalFormGuids: List<String>? = null,
  public val compulsoryFormGuids: List<String>? = null,
  public val growsHorizontally: Boolean? = null,
  public val collapsed: Boolean? = null,
  public val showHeader: Boolean,
) : Editor
