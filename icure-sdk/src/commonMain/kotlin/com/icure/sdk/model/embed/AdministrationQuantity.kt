package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AdministrationQuantity(
  public val quantity: Double? = null,
  public val administrationUnit: CodeStub? = null,
  public val unit: String? = null,
) {
	// region AdministrationQuantity-AdministrationQuantity
	// endregion
}