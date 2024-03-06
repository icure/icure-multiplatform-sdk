package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Column
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public class MedicationTableEditor(
  override val columns: List<Column>? = null,
) : StringTableEditor
