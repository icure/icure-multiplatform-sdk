package com.icure.sdk.model

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public class WsException(
  public val level: String,
  public val error: String,
  public val translations: Map<String, String> = emptyMap(),
)
