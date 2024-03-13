package com.icure.sdk.model.`data`

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface DisplayableContent {
  public val id: String?

  public val label: String?

  public val entityClass: String?

  public val entityId: String?
}
