package com.icure.sdk.model.embed

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class ServiceLink(
  public val serviceId: String? = null,
  public val service: Service? = null,
) : IoSerializable
