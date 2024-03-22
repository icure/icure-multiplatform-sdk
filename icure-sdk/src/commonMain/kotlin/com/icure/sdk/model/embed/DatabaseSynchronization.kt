package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseSynchronization(
  public val source: String? = null,
  public val target: String? = null,
  public val filter: String? = null,
  public val localTarget: DatabaseSynchronization.Target? = null,
)
