package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EntryUpdateType() {
	@SerialName("CREATE")
	Create,

	@SerialName("DELETE")
	Delete,
}
