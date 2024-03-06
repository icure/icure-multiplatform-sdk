package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class ActionButton(
  public val action: String? = null,
) : Editor
