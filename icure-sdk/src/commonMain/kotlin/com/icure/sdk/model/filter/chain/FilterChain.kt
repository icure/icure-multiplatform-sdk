package com.icure.sdk.model.filter.chain

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class FilterChain<O : Identifiable<String>>(
  public val filter: AbstractFilter<O>,
  public val predicate: Predicate? = null,
)
