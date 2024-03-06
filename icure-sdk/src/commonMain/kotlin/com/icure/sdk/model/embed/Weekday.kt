package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Int
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Weekday(
  public val weekday: CodeStub? = null,
  public val weekNumber: Int? = null,
) : IoSerializable
