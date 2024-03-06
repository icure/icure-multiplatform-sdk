package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Double
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class AdministrationQuantity(
  public val quantity: Double? = null,
  public val administrationUnit: CodeStub? = null,
  public val unit: String? = null,
) : IoSerializable
