package com.icure.sdk.model.filter.calendarItem

import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CalendarItemByPeriodAndAgendaIdFilter")
@Serializable
data class CalendarItemByPeriodAndAgendaIdFilter(
	public val agendaId: String,
	public val startTime: Long,
	public val endTime: Long,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByPeriodAndAgendaIdFilter-CalendarItemByPeriodAndAgendaIdFilter
	// endregion
}
