package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Named
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Employer(
  override val name: String? = null,
  public val addresse: Address? = null,
) : Named, IoSerializable
