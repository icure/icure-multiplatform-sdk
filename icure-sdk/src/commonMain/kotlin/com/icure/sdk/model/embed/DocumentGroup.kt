package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DocumentGroup(
  public val guid: String? = null,
  public val name: String? = null,
)
