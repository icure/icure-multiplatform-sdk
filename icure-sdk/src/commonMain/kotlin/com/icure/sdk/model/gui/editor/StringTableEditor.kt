package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Column
import com.icure.sdk.model.gui.Editor
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class StringTableEditor(
  public val columns: List<Column>? = null,
) : Editor
