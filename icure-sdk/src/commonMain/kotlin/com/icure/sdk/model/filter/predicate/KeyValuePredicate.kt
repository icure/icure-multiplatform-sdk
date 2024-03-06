package com.icure.sdk.model.filter.predicate

import kotlin.Any
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class KeyValuePredicate(
  public val key: String? = null,
  public val `operator`: KeyValuePredicate.Operator? = null,
  public val `value`: Any? = null,
) : Predicate
