package com.icure.sdk.model.filter.predicate

import kotlinx.serialization.Serializable
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AndPredicate(
	public val predicates: List<Predicate> = emptyList(),
) : Predicate {
	// region AndPredicate-AndPredicate

	// endregion
}
