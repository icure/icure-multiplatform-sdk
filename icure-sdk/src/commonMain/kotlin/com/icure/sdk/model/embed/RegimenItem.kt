package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Int
import kotlin.Long
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class RegimenItem(
  public val date: Long? = null,
  public val dayNumber: Int? = null,
  public val weekday: Weekday? = null,
  public val dayPeriod: CodeStub? = null,
  public val timeOfDay: Long? = null,
  public val administratedQuantity: AdministrationQuantity? = null,
) : IoSerializable
