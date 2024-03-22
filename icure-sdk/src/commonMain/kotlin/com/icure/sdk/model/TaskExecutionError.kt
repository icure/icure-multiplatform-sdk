package com.icure.sdk.model

import java.util.Date
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class TaskExecutionError() {
  public val date: Date? = null

  public val error: String? = null
}
