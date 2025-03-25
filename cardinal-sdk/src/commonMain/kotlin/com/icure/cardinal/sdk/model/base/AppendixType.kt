package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AppendixType() {
	@SerialName("externalLink")
	ExternalLink,

	@SerialName("video")
	Video,

	@SerialName("description")
	Description,
}
