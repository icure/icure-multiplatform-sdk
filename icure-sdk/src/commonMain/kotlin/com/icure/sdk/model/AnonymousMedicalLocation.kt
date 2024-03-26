package com.icure.sdk.model

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class AnonymousMedicalLocation(
  public val id: String,
  public val publicInformations: Map<String, String> = emptyMap(),
)
