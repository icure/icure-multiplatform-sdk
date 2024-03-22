package com.icure.sdk.model

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class PaginatedList<T, O>(
  public val pageSize: Int,
  public val totalSize: Int,
  public val rows: List<T> = emptyList(),
  public val nextKeyPair: PaginatedDocumentKeyIdPair<O>? = null,
)
