package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DocumentLocation() {
	@SerialName("annex")
	Annex,

	@SerialName("body")
	Body,
}
