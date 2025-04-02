package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class StateToUpdate() {
	@SerialName("VALUE")
	Value,

	@SerialName("VISIBLE")
	Visible,

	@SerialName("READONLY")
	Readonly,

	@SerialName("CLAZZ")
	Clazz,

	@SerialName("REQUIRED")
	Required,
}
