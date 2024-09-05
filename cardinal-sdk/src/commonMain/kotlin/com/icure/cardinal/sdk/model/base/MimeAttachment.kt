package com.icure.cardinal.sdk.model.base

import com.icure.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.String
import com.icure.cardinal.sdk.serialization.ByteArraySerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class MimeAttachment(
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: ByteArray? = null,
	public val fileName: String? = null,
	public val mimeType: String? = null,
) {
	// region MimeAttachment-MimeAttachment

	// endregion
}
