package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PaginatedDocumentKeyIdPair<K>(
  public val startKey: K? = null,
  public val startKeyDocId: String? = null,
)
