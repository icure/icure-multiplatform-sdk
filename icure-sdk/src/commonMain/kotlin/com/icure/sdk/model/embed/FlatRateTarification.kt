package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class FlatRateTarification(
  public val code: String? = null,
  public val flatRateType: FlatRateType? = null,
  public val label: Map<String, String>? = null,
  public val valorisations: List<Valorisation> = emptyList(),
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable
