package com.icure.sdk.model.gui.type

import kotlin.Any
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class Array(
  public val `value`: List<Any?>? = null,
) : Data, IoSerializable
