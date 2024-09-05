package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Long

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
