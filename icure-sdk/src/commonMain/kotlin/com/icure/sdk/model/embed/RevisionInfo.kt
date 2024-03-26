package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RevisionInfo(
  public val rev: String? = null,
  public val status: String? = null,
)
