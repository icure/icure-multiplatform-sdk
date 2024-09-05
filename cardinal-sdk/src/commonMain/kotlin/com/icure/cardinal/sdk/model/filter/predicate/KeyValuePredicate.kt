package com.icure.cardinal.sdk.model.filter.predicate

import com.icure.cardinal.sdk.model.specializations.AnyPrimitive
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.cardinal.sdk.serialization.AnyPrimitiveSerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class KeyValuePredicate(
	public val key: String? = null,
	public val `operator`: Operator? = null,
	public val `value`: AnyPrimitive? = null,
) : Predicate {
	// region KeyValuePredicate-KeyValuePredicate

	// endregion
}
