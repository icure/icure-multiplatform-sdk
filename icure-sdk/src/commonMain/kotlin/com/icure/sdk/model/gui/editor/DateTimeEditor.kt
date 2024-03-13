package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public class DateTimeEditor(
  public val isDisplayTime: Boolean,
  public val isShowPicker: Boolean,
  public val isWebAgenda: Boolean,
  public val isFullDateMode: Boolean,
) : Editor
