package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class KeywordSubword(
	public val `value`: String? = null,
	public val subWords: List<KeywordSubword>? = null,
) {
	// region KeywordSubword-KeywordSubword

	// endregion
}
