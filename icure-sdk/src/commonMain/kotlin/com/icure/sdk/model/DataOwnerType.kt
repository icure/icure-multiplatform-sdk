package com.icure.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the type of a data owner
 */
@Serializable
enum class DataOwnerType {
	@SerialName(SerialNames.PATIENT)
	Patient,
	@SerialName(SerialNames.HCP)
	Hcp,
	@SerialName(SerialNames.DEVICE)
	Device;

	object SerialNames {
		const val PATIENT = "patient"
		const val HCP = "hcp"
		const val DEVICE = "device"
	}
}