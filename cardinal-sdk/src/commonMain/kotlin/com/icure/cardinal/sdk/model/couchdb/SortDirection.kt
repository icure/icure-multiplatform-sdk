package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class SortDirection() {
	@SerialName("asc")
	Asc,

	@SerialName("desc")
	Desc,
}