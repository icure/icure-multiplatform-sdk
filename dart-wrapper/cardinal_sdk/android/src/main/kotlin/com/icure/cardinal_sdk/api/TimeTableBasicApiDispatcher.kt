// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.TimeTableBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TimeTableBasicApiDispatcher {
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
    "matchTimeTablesBy" -> matchTimeTablesBy(parameters, resultCallback)
    "matchTimeTablesBySorted" -> matchTimeTablesBySorted(parameters, resultCallback)
    "filterTimeTablesBy" -> filterTimeTablesBy(parameters, resultCallback)
    "filterTimeTablesBySorted" -> filterTimeTablesBySorted(parameters, resultCallback)
    "deleteTimeTableById" -> deleteTimeTableById(parameters, resultCallback)
    "deleteTimeTablesByIds" -> deleteTimeTablesByIds(parameters, resultCallback)
    "purgeTimeTableById" -> purgeTimeTableById(parameters, resultCallback)
    "deleteTimeTable" -> deleteTimeTable(parameters, resultCallback)
    "deleteTimeTables" -> deleteTimeTables(parameters, resultCallback)
    "purgeTimeTable" -> purgeTimeTable(parameters, resultCallback)
    "undeleteTimeTable" -> undeleteTimeTable(parameters, resultCallback)
    "modifyTimeTable" -> modifyTimeTable(parameters, resultCallback)
    "undeleteTimeTableById" -> undeleteTimeTableById(parameters, resultCallback)
    "getTimeTable" -> getTimeTable(parameters, resultCallback)
    "getTimeTables" -> getTimeTables(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.matchTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchTimeTablesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.matchTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.filterTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTimeTablesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.filterTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.deleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTimeTablesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.deleteTimeTablesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.purgeTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.deleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun deleteTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.deleteTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTables"),
    )
  }

  private fun purgeTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.purgeTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun undeleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.undeleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun modifyTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.modifyTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.undeleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.getTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableBasicApi.getTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTableIds"),
    )
  }
}
