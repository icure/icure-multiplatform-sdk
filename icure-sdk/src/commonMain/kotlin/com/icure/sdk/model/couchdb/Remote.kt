package com.icure.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Remote(
	public val url: String,
	public val auth: RemoteAuthentication? = null,
) {
	// region Remote-Remote

	// endregion
}
