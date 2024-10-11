package com.icure.cardinal.sdk.model.data

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class LabelledOccurence(
	public val label: String,
	public val occurence: Long,
) {
	// region LabelledOccurence-LabelledOccurence

	// endregion
}
