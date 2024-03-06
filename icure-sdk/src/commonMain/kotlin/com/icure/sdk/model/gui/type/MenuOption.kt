package com.icure.sdk.model.gui.type

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class MenuOption(
  public val key: String? = null,
  public val display: String? = null,
) : Data, IoSerializable
