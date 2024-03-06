package com.icure.sdk.model.security

import kotlin.Cloneable
import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class OperationToken(
  public val tokenHash: String,
  public val creationTime: Long,
  public val validity: Long,
  public val operation: OperationToken.Companion.Operation,
  public val description: String? = null,
) : Cloneable, IoSerializable
