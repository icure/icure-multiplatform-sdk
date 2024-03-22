package com.icure.sdk.model

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RegistrationInformation(
  public val firstName: String,
  public val lastName: String,
  public val emailAddress: String,
  public val userOptions: String? = null,
  public val userRoles: Set<String> = emptySet(),
  public val minimumKrakenVersion: String? = null,
) {
	// region RegistrationInformation-RegistrationInformation
	// endregion
}