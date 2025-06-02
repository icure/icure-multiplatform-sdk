package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.utils.generation.RequireHashable
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@RequireHashable
@Serializable
@RequireHashable
data class Periodicity(
	public val relatedCode: CodeStub? = null,
	public val relatedPeriodicity: CodeStub? = null,
) {
	// region Periodicity-Periodicity

	// endregion
}
