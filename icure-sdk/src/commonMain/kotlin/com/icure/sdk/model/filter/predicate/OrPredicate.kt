package com.icure.sdk.model.filter.predicate

import kotlin.collections.List
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class OrPredicate(
  public val predicates: List<Predicate> = emptyList(),
) : Predicate {
	// region OrPredicate-OrPredicate
	// endregion
}