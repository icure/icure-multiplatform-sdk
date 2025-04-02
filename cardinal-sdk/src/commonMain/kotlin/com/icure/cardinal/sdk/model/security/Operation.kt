package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Operation() {
	@SerialName("TRANSFER_GROUP")
	TransferGroup,
}
