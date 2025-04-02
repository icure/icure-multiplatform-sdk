package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class GroupType() {
	@SerialName("root")
	Root,

	@SerialName("app")
	App,

	@SerialName("database")
	Database,
}
