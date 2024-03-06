package com.icure.sdk.model.gui

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class GuiCodeType(
  public val type: String? = null,
) : IoSerializable
