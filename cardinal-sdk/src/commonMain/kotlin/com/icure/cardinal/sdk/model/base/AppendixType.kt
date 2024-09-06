package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class AppendixType() {
	@SerialName("externalLink")
	ExternalLink,

	@SerialName("video")
	Video,

	@SerialName("description")
	Description,
}