package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Medicinalproduct(
	public val intendedcds: List<CodeStub> = emptyList(),
	public val deliveredcds: List<CodeStub> = emptyList(),
	public val intendedname: String? = null,
	public val deliveredname: String? = null,
	public val productId: String? = null,
) {
	// region Medicinalproduct-Medicinalproduct

	// endregion
}
