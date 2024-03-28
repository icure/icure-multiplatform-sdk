package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class SchoolingInfo(
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val school: String? = null,
	public val typeOfEducation: CodeStub? = null,
) {
	// region SchoolingInfo-SchoolingInfo

	// endregion
}
