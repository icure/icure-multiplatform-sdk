package com.icure.sdk.model.embed

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class FormGroup(
  public val guid: String? = null,
  public val name: String? = null,
) : IoSerializable
