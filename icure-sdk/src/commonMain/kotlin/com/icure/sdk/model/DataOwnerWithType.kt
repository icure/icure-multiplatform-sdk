package com.icure.sdk.model

import com.icure.sdk.model.base.CryptoActor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface DataOwnerWithType {
	public val dataOwner: CryptoActor

	@Serializable
	@SerialName("hcp")
	public data class HcpDataOwner(
		override val dataOwner: HealthcareParty,
	) : DataOwnerWithType

	@Serializable
	@SerialName("patient")
	public data class PatientDataOwner(
		override val dataOwner: EncryptedPatient,
	) : DataOwnerWithType

	@Serializable
	@SerialName("device")
	public data class DeviceDataOwner(
		override val dataOwner: Device,
	) : DataOwnerWithType
	// region DataOwnerWithType-DataOwnerWithType

	// endregion
}
