package com.icure.sdk.model

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class RegistrationInformation(
  public val firstName: String,
  public val lastName: String,
  public val emailAddress: String,
  public val userOptions: String? = null,
  public val userRoles: Set<String> = emptySet(),
  public val minimumKrakenVersion: String? = null,
)
