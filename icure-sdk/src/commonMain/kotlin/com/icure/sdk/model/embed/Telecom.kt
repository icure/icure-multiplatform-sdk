package com.icure.sdk.model.embed

import kotlin.Comparable
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Telecom(
  public val telecomType: TelecomType? = null,
  public val telecomNumber: String? = null,
  public val telecomDescription: String? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable, Comparable<Telecom>
