package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("TimeTableByPeriodAndAgendaIdFilter")
@Serializable
data class TimeTableByPeriodAndAgendaIdFilter(
	public val agendaId: String,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
	override val desc: String? = null,
	internal val dtoSerialName: String,
) : AbstractFilter<TimeTable> {
	// region TimeTableByPeriodAndAgendaIdFilter-TimeTableByPeriodAndAgendaIdFilter

	// endregion
}
