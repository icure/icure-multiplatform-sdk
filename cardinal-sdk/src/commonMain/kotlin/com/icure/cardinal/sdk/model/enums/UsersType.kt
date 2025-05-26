package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class UsersType() {
	@SerialName("database")
	Database("database"),

	@SerialName("ldap")
	Ldap("ldap"),

	@SerialName("token")
	Token("token"),
	;

	public val dtoSerialName: String
}
