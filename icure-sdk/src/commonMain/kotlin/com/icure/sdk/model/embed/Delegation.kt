package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.HexString
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Delegation(
  public val owner: String? = null,
  public val delegatedTo: String? = null,
  public val key: HexString? = null,
  public val tags: List<String> = emptyList(),
)
