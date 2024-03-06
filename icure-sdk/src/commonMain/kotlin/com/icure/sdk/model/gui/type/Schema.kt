package com.icure.sdk.model.gui.type

import kotlin.ByteArray
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class Schema(
  public val `data`: ByteArray,
) : Data, IoSerializable
