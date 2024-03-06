package com.icure.sdk.model.gui

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class GuiCode(
  public val type: String? = null,
  public val code: String? = null,
) : IoSerializable
