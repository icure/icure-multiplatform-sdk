package com.icure.sdk.model

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class AuthenticationResponse(
  public val healthcarePartyId: String? = null,
  public val reason: String? = null,
  public val successful: Boolean,
  public val username: String? = null,
) {
	// region AuthenticationResponse-AuthenticationResponse
	// endregion
}