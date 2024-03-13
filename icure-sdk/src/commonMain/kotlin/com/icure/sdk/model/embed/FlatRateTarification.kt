package com.icure.sdk.model.embed

import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class FlatRateTarification(
  public val code: String? = null,
  public val flatRateType: FlatRateType? = null,
  public val label: Map<String, String>? = null,
  public val valorisations: List<Valorisation> = emptyList(),
  override val encryptedSelf: String? = null,
) : Encrypted
