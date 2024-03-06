package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class SchoolingInfo(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val school: String? = null,
  public val typeOfEducation: CodeStub? = null,
) : IoSerializable
