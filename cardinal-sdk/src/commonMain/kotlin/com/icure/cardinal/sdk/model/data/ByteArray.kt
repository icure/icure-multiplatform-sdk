package com.icure.cardinal.sdk.model.data

import com.icure.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable
import com.icure.cardinal.sdk.serialization.ByteArraySerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ByteArray(
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: kotlin.ByteArray,
) {
	// region ByteArray-ByteArray

	// endregion
}
