package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UserType() {
	@SerialName("HCP")
	Hcp,

	@SerialName("PATIENT")
	Patient,

	@SerialName("DEVICE")
	Device,

	@SerialName("USER")
	User,
}
