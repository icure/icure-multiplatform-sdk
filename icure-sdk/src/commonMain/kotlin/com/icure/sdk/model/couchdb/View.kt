package com.icure.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class View(
	public val map: String,
	public val reduce: String? = null,
) {
	// region View-View

	// endregion
}
