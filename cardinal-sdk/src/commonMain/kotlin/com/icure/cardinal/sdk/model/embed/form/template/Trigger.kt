package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Trigger() {
	@SerialName("INIT")
	Init("INIT"),

	@SerialName("CHANGE")
	Change("CHANGE"),

	@SerialName("CLICK")
	Click("CLICK"),

	@SerialName("VISIBLE")
	Visible("VISIBLE"),

	@SerialName("ERROR")
	Error("ERROR"),

	@SerialName("VALID")
	Valid("VALID"),

	@SerialName("EVENT")
	Event("EVENT"),
	;

	public val dtoSerialName: String
}
