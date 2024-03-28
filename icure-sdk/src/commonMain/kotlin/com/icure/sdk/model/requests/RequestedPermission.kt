package com.icure.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class RequestedPermission() {
	@SerialName("MAX_READ")
	MaxRead,

	@SerialName("FULL_READ")
	FullRead,

	@SerialName("MAX_WRITE")
	MaxWrite,

	@SerialName("FULL_WRITE")
	FullWrite,

	@SerialName("ROOT")
	Root,
}
