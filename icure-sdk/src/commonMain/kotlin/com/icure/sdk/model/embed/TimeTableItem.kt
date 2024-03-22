package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class TimeTableItem(
  public val rruleStartDate: Long? = null,
  public val rrule: String? = null,
  public val notBeforeInMinutes: Int? = null,
  public val notAfterInMinutes: Int? = null,
  public val zoneId: String? = null,
  public val days: List<String> = emptyList(),
  public val recurrenceTypes: List<String> = emptyList(),
  public val hours: List<TimeTableHour> = emptyList(),
  public val calendarItemTypeId: String? = null,
  public val homeVisit: Boolean,
  public val placeId: String? = null,
  public val publicTimeTableItem: Boolean,
  public val acceptsNewPatient: Boolean,
  public val unavailable: Boolean,
)
