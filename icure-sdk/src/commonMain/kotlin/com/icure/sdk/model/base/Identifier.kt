package com.icure.sdk.model.base

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Identifier(
  public val id: String? = null,
  public val assigner: String? = null,
  public val start: String? = null,
  public val end: String? = null,
  public val system: String? = null,
  public val type: CodeStub? = null,
  public val use: String? = null,
  public val `value`: String? = null,
) : IoSerializable
