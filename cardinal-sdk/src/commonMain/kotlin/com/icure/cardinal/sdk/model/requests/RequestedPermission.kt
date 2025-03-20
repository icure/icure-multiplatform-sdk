package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class RequestedPermission() {
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
