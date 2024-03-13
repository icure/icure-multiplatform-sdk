package com.icure.sdk.model

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class AuthenticationResponse(
  public val healthcarePartyId: String? = null,
  public val reason: String? = null,
  public val successful: Boolean,
  public val username: String? = null,
)
