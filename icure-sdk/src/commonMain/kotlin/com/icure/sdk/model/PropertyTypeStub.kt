package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.constants.TypedValuesType

@Serializable
public data class PropertyTypeStub(
  public val identifier: String? = null,
  public val type: TypedValuesType? = null,
)
