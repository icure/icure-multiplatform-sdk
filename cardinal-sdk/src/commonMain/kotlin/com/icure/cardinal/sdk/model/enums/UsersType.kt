package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UsersType() {
	@SerialName("database")
	Database,

	@SerialName("ldap")
	Ldap,

	@SerialName("token")
	Token,
}
