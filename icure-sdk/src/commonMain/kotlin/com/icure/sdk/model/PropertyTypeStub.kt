package com.icure.sdk.model

import com.icure.sdk.model.embed.TypedValuesType
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PropertyTypeStub(
  public val identifier: String? = null,
  public val type: TypedValuesType? = null,
)
