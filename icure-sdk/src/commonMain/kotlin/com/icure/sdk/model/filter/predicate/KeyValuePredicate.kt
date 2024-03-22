package com.icure.sdk.model.filter.predicate

import kotlin.Any
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class KeyValuePredicate(
  public val key: String? = null,
  public val `operator`: Operator? = null,
  public val `value`: Any? = null,
) : Predicate
