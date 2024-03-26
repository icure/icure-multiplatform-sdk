package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class KeywordSubword(
  public val `value`: String? = null,
  public val subWords: List<KeywordSubword>? = null,
)
