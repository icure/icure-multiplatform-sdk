package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class StateToUpdate(
	internal val dtoSerialName: String,
) {
	@SerialName("VALUE")
	Value("VALUE"),

	@SerialName("VISIBLE")
	Visible("VISIBLE"),

	@SerialName("READONLY")
	Readonly("READONLY"),

	@SerialName("CLAZZ")
	Clazz("CLAZZ"),

	@SerialName("REQUIRED")
	Required("REQUIRED"),
}
