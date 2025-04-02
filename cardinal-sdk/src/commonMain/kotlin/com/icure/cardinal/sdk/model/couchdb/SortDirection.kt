package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SortDirection() {
	@SerialName("asc")
	Asc,

	@SerialName("desc")
	Desc,
}
