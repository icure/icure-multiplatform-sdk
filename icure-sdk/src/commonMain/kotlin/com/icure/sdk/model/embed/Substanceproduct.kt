package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Substanceproduct(
  public val intendedcds: List<CodeStub> = emptyList(),
  public val deliveredcds: List<CodeStub> = emptyList(),
  public val intendedname: String? = null,
  public val deliveredname: String? = null,
  public val productId: String? = null,
) : IoSerializable
