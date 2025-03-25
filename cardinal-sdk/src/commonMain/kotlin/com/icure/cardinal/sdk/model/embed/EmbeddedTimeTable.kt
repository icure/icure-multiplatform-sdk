package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@Serializable
public data class EmbeddedTimeTable(
	public val id: String,
	public val medicalLocationId: String? = null,
	public val endOfLife: Long? = null,
	public val name: String? = null,
	public val startTime: Long? = null,
	public val endTime: Long? = null,
	@DefaultValue("emptyList()")
	public val items: List<TimeTableItem> = emptyList(),
)
