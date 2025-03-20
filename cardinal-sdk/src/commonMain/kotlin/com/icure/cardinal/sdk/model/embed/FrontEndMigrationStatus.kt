package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FrontEndMigrationStatus() {
	@SerialName("STARTED")
	Started,

	@SerialName("PAUSED")
	Paused,

	@SerialName("ERROR")
	Error,

	@SerialName("SUCCESS")
	Success,
}
