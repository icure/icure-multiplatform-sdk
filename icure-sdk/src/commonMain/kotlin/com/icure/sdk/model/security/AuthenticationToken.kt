package com.icure.sdk.model.security

import kotlin.Cloneable
import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class AuthenticationToken(
  public val token: String? = null,
  public val creationTime: Long,
  public val validity: Long,
  public val deletionDate: Long? = null,
) : Cloneable, IoSerializable
