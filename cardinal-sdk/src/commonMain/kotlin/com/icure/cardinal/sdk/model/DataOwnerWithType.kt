package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.CryptoActorDto
import com.icure.cardinal.sdk.model.base.CryptoActor
import org.taktik.icure.services.`external`.rest.v2.dto.base.CryptoActorDto

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface DataOwnerWithType {
	public val dataOwner: CryptoActorDto

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
