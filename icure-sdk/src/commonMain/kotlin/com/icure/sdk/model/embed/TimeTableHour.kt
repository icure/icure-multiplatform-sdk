package com.icure.sdk.model.embed

import kotlin.Long
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class TimeTableHour(
  public val startHour: Long? = null,
  public val endHour: Long? = null,
) : IoSerializable
