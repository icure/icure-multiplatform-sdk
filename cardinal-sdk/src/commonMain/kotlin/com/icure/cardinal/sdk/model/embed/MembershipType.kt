package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class MembershipType() {
	@SerialName("doctor")
	Doctor("doctor"),

	@SerialName("mutuality")
	Mutuality("mutuality"),

	@SerialName("patient")
	Patient("patient"),

	@SerialName("specialist")
	Specialist("specialist"),

	@SerialName("other")
	Other("other"),
	;

	public val dtoSerialName: String
}
