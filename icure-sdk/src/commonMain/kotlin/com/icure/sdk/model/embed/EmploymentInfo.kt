package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Long
import kotlinx.serialization.Serializable

@Serializable
public data class EmploymentInfo(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val professionType: CodeStub? = null,
  public val employer: Employer? = null,
)
