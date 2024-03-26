package com.icure.sdk.model.security

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class OperationToken(
  public val tokenHash: String,
  public val creationTime: Long,
  public val validity: Long,
  public val operation: Operation,
  public val description: String? = null,
)
