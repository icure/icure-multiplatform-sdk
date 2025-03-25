package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DataOwnerType() {
	@SerialName("hcp")
	Hcp,

	@SerialName("device")
	Device,

	@SerialName("patient")
	Patient,
}
