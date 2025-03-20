package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Visibility() {
	@SerialName("maskedfromsummary")
	Maskedfromsummary,

	@SerialName("maskedfromexportedfile")
	Maskedfromexportedfile,

	@SerialName("proeminent")
	Proeminent,

	@SerialName("highlighted")
	Highlighted,

	@SerialName("visible")
	Visible,
}
