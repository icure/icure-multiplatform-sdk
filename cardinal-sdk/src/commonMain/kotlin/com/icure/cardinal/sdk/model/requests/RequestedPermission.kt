package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class RequestedPermission() {
	@SerialName("MAX_READ")
	MaxRead("MAX_READ"),

	@SerialName("FULL_READ")
	FullRead("FULL_READ"),

	@SerialName("MAX_WRITE")
	MaxWrite("MAX_WRITE"),

	@SerialName("FULL_WRITE")
	FullWrite("FULL_WRITE"),

	@SerialName("ROOT")
	Root("ROOT"),
	;

	public val dtoSerialName: String
}
