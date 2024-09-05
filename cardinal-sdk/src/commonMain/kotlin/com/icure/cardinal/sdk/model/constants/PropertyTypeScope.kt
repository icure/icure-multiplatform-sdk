package com.icure.cardinal.sdk.model.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PropertyTypeScope() {
	@SerialName("SYSTEM")
	System,

	@SerialName("NODE")
	Node,

	@SerialName("ROLE")
	Role,

	@SerialName("USER")
	User,

	@SerialName("EVENT")
	Event,
}
