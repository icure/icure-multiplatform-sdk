package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class DashboardEditor(
  public val guid: String? = null,
) : Editor
