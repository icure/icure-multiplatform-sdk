package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class PersonName(
  public val lastName: String? = null,
  public val firstNames: List<String> = emptyList(),
  public val start: Long? = null,
  public val end: Long? = null,
  public val prefix: List<String> = emptyList(),
  public val suffix: List<String> = emptyList(),
  public val text: String? = null,
  public val use: PersonNameUse? = null,
)
