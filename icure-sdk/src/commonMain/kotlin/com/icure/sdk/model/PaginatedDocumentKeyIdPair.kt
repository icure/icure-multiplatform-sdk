package com.icure.sdk.model

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class PaginatedDocumentKeyIdPair<K>(
  public val startKey: K? = null,
  public val startKeyDocId: String? = null,
) : IoSerializable
