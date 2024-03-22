package com.icure.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class UsersType() {
  @SerialName("database")
  Database,
  @SerialName("ldap")
  Ldap,
  @SerialName("token")
  Token,

}