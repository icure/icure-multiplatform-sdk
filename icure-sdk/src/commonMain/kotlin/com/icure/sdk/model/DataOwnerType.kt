package com.icure.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the type of a data owner
 */
@Serializable
enum class DataOwnerType {
	@SerialName("patient")
	Patient,
	@SerialName("hcp")
	Hcp,
	@SerialName("device")
	Device
}