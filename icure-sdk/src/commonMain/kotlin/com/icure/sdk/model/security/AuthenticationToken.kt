package com.icure.sdk.model.security

import kotlin.Cloneable
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AuthenticationToken(
  public val token: String? = null,
  public val creationTime: Long,
  public val validity: Long,
  public val deletionDate: Long? = null,
) : Cloneable
