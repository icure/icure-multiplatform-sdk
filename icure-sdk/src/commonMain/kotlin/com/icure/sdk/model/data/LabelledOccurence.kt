package com.icure.sdk.model.`data`

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

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