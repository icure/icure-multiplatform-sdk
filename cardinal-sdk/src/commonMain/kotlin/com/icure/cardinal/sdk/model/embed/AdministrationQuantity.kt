package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AdministrationQuantity(
	public val quantity: Double? = null,
	public val administrationUnit: CodeStub? = null,
	public val unit: String? = null,
) {
	public val dtoSerialName: String
	// region AdministrationQuantity-AdministrationQuantity

	// endregion
}
