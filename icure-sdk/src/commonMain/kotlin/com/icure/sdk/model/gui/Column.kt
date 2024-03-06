package com.icure.sdk.model.gui

import kotlin.Double
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class Column(
  public val label: String? = null,
  public val width: Double? = null,
) : IoSerializable
