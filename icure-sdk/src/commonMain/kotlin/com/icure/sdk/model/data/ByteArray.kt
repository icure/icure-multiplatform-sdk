package com.icure.sdk.model.`data`

import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class ByteArray(
  public val `data`: kotlin.ByteArray,
) : IoSerializable
