package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Long
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class EmploymentInfo(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val professionType: CodeStub? = null,
  public val employer: Employer? = null,
) : IoSerializable
