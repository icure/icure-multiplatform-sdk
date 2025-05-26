package com.icure.cardinal.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class SubscriptionEventType(
	internal val dtoSerialName: String,
) {
	@SerialName("CREATE")
	Create("CREATE"),

	@SerialName("UPDATE")
	Update("UPDATE"),

	@SerialName("DELETE")
	Delete("DELETE"),
}
