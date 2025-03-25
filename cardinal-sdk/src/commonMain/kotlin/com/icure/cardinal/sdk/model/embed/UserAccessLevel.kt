package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UserAccessLevel() {
	@SerialName("Admin")
	Admin,

	@SerialName("Read")
	Read,

	@SerialName("Write")
	Write,
}
