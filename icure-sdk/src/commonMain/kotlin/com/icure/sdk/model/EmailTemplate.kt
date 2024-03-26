package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class EmailTemplate(
  public val subject: String? = null,
  public val body: String? = null,
)
