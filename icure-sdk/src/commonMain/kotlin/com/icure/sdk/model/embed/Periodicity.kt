package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Periodicity(
  public val relatedCode: CodeStub? = null,
  public val relatedPeriodicity: CodeStub? = null,
) : IoSerializable
