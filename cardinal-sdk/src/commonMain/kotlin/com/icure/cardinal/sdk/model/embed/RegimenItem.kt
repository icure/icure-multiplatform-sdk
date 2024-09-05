package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class RegimenItem(
	public val date: Long? = null,
	public val dayNumber: Int? = null,
	public val weekday: Weekday? = null,
	public val dayPeriod: CodeStub? = null,
	public val timeOfDay: Long? = null,
	public val administratedQuantity: AdministrationQuantity? = null,
) {
	// region RegimenItem-RegimenItem

	// endregion
}
