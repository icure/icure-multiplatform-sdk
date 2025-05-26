package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DatabaseSynchronization(
	public val source: String? = null,
	public val target: String? = null,
	public val filter: String? = null,
	public val localTarget: Target? = null,
	internal val dtoSerialName: String,
) {
	@Serializable
	public enum class Target(
		internal val dtoSerialName: String,
	) {
		@SerialName("base")
		Base("base"),

		@SerialName("healthdata")
		Healthdata("healthdata"),

		@SerialName("patient")
		Patient("patient"),
	}
  // region DatabaseSynchronization-DatabaseSynchronization

  // endregion
}
