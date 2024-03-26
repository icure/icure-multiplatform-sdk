package com.icure.sdk.model.filter.predicate

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class OrPredicate(
  public val predicates: List<Predicate> = emptyList(),
) : Predicate
