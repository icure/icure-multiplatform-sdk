package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PublicAgendasAndCalendarItemTypes(
	public val agendas: List<Agenda>,
	public val calendarItemTypes: List<CalendarItemType>,
) {
	// region PublicAgendasAndCalendarItemTypes-PublicAgendasAndCalendarItemTypes
	// endregion
}
