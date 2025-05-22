// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.CalendarItemTypeApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CalendarItemTypeApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createCalendarItemType" -> createCalendarItemType(parameters, resultCallback)
    "deleteCalendarItemTypes" -> deleteCalendarItemTypes(parameters, resultCallback)
    "getCalendarItemType" -> getCalendarItemType(parameters, resultCallback)
    "modifyCalendarItemType" -> modifyCalendarItemType(parameters, resultCallback)
    "listCalendarItemTypesByAgendaId" -> listCalendarItemTypesByAgendaId(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createCalendarItemType(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemTypeApi.createCalendarItemType(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItemTypeDto"),
    )
  }

  private fun deleteCalendarItemTypes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemTypeApi.deleteCalendarItemTypes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItemTypeIds"),
    )
  }

  private fun getCalendarItemType(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemTypeApi.getCalendarItemType(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItemTypeId"),
    )
  }

  private fun modifyCalendarItemType(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemTypeApi.modifyCalendarItemType(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("calendarItemTypeDto"),
    )
  }

  private fun listCalendarItemTypesByAgendaId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemTypeApi.listCalendarItemTypesByAgendaId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("agendaId"),
    )
  }
}
