package com.icure.sdk.model.gui.type

import kotlin.String
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class Dictionary(
  public val `value`: Map<String, IoSerializable>? = null,
) : Data
