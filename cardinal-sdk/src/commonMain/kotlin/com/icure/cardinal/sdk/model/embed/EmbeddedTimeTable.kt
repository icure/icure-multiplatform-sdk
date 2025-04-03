package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EmbeddedTimeTable(
	public val id: String,
	public val medicalLocationId: String? = null,
	public val endOfLife: Long? = null,
	public val name: String? = null,
	public val startTime: Long? = null,
	public val endTime: Long? = null,
	@DefaultValue("emptyList()")
	public val items: List<TimeTableItem> = emptyList(),
) {
	// region EmbeddedTimeTable-EmbeddedTimeTable

	// endregion
}
