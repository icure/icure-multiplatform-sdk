package com.icure.sdk.model

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class PublicKey(
  public val hcPartyId: String? = null,
  public val hexString: String? = null,
) : IoSerializable
