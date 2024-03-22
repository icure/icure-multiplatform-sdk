package com.icure.sdk.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("type")
sealed interface DataOwnerWithType {
	val type: DataOwnerType
	val dataOwner: CryptoActor

	@Serializable
	@SerialName(DataOwnerType.SerialNames.PATIENT)
	data class PatientDataOwner(override val dataOwner: Patient): DataOwnerWithType {
		override val type: DataOwnerType = DataOwnerType.Patient
	}

	@Serializable
	@SerialName(DataOwnerType.SerialNames.HCP)
	data class HcpDataOwner(override val dataOwner: HealthcareParty): DataOwnerWithType {
		override val type: DataOwnerType = DataOwnerType.Hcp
	}

	@Serializable
	@SerialName(DataOwnerType.SerialNames.DEVICE)
	data class DeviceDataOwner(override val dataOwner: Device): DataOwnerWithType {
		override val type: DataOwnerType = DataOwnerType.Device
	}
}