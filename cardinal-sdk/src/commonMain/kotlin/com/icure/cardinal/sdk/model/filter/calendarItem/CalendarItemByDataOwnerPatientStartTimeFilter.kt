package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CalendarItemByDataOwnerPatientStartTimeFilter")
@Serializable
data class CalendarItemByDataOwnerPatientStartTimeFilter(
	public val dataOwnerId: String,
	public val startDate: Long?,
	public val endDate: Long?,
	public val secretPatientIds: Set<String>,
	public val descending: Boolean?,
	override val desc: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByDataOwnerPatientStartTimeFilter-CalendarItemByDataOwnerPatientStartTimeFilter

	// endregion
}
