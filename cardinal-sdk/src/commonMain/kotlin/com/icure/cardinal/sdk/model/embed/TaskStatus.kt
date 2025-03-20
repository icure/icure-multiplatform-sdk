package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TaskStatus() {
	@SerialName("pending")
	Pending,

	@SerialName("ongoing")
	Ongoing,

	@SerialName("cancelled")
	Cancelled,

	@SerialName("completed")
	Completed,
}
