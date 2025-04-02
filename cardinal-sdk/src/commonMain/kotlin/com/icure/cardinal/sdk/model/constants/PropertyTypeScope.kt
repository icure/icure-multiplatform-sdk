package com.icure.cardinal.sdk.model.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PropertyTypeScope() {
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
