package com.icure.sdk.model.embed

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class RevisionInfo(
  public val rev: String? = null,
  public val status: String? = null,
) : IoSerializable
