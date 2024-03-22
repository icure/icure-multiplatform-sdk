package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Long
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EmploymentInfo(
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val professionType: CodeStub? = null,
  public val employer: Employer? = null,
) {
	// region EmploymentInfo-EmploymentInfo
	// endregion
}