package com.icure.sdk.model.filter.predicate

import com.icure.sdk.model.specializations.AnyPrimitive
import com.icure.sdk.serialization.AnyPrimitiveSerializer
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class KeyValuePredicate(
  public val key: String? = null,
  public val `operator`: Operator? = null,
  @Serializable(with = AnyPrimitiveSerializer::class)
  public val `value`: AnyPrimitive? = null,
) : Predicate
