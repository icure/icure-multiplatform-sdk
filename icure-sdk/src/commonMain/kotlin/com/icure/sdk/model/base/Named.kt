package com.icure.sdk.model.base

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface Named {
  public val name: String?
}
