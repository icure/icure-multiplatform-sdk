package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RoleConfiguration(
	public val source: Source,
	@DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
) {
	@Serializable
	public enum class Source() {
		@SerialName("CONFIGURATION")
		Configuration,

		@SerialName("INHERITED")
		Inherited,

		@SerialName("DEFAULT")
		Default,
	}
  // region RoleConfiguration-RoleConfiguration

  // endregion
}
