package com.icure.sdk.model

import kotlin.String
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class AnonymousMedicalLocation(
  public val id: String,
  public val publicInformations: Map<String, String> = emptyMap(),
) : IoSerializable
