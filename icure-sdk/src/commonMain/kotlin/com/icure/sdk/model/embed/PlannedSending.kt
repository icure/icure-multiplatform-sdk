package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class PlannedSending(
  public val cronExpression: String? = null,
)
