package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class GroupDeletionReport(
  public val type: String,
  public val id: String,
  public val server: String,
)
