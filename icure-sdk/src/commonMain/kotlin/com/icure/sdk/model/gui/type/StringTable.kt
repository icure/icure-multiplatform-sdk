package com.icure.sdk.model.gui.type

import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class StringTable(
  public val values: List<String>? = null,
) : Data, IoSerializable
