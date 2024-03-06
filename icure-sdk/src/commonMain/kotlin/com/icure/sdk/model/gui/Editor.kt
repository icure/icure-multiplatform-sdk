package com.icure.sdk.model.gui

import com.icure.sdk.model.gui.type.Data
import kotlin.Boolean
import kotlin.Double
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public abstract class Editor(
  public val left: Double? = null,
  public val top: Double? = null,
  public val width: Double? = null,
  public val height: Double? = null,
  public val isMultiline: Boolean,
  public val labelPosition: LabelPosition? = null,
  public val isReadOnly: Boolean,
  public val defaultValue: Data? = null,
) : IoSerializable
