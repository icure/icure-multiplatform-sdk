// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.api.TimeTableFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TimeTableFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "byAgendaId" -> byAgendaId(parameters, resultCallback)
    "byPeriodAndAgendaId" -> byPeriodAndAgendaId(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byAgendaId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableFilters.byAgendaId(
      resultCallback,
      parameters.getValue("agendaId"),
    )
  }

  private fun byPeriodAndAgendaId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableFilters.byPeriodAndAgendaId(
      resultCallback,
      parameters.getValue("agendaId"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }
}
