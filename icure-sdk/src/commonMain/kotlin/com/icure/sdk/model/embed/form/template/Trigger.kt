package com.icure.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Trigger() {
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
