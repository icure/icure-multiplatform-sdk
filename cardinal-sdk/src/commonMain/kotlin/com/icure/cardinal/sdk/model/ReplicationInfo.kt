package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicationInfo(
	@DefaultValue("false")
	public val active: Boolean = false,
	@DefaultValue("false")
	public val running: Boolean = false,
	public val pendingFrom: Int? = null,
	public val pendingTo: Int? = null,
) {
	public val dtoSerialName: String
	// region ReplicationInfo-ReplicationInfo

	// endregion
}
