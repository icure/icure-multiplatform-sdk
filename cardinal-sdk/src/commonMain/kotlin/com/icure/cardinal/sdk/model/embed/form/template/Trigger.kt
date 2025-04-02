package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Trigger() {
	@SerialName("INIT")
	Init,

	@SerialName("CHANGE")
	Change,

	@SerialName("CLICK")
	Click,

	@SerialName("VISIBLE")
	Visible,

	@SerialName("ERROR")
	Error,

	@SerialName("VALID")
	Valid,

	@SerialName("EVENT")
	Event,
}
