package com.icure.sdk.model

import kotlin.Any
import kotlin.Int
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class PaginatedList<T : IoSerializable?>(
  public val pageSize: Int,
  public val totalSize: Int,
  public val rows: List<T> = emptyList(),
  public val nextKeyPair: PaginatedDocumentKeyIdPair<Any?>? = null,
) : IoSerializable
