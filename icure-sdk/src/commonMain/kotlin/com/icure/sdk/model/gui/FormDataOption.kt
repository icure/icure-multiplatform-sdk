package com.icure.sdk.model.gui

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class FormDataOption(
  public val key: String? = null,
  public val `value`: String? = null,
) : IoSerializable
