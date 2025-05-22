// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.TimeTableApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TimeTableApiDispatcher {
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
    "filterTimeTablesBy" -> filterTimeTablesBy(parameters, resultCallback)
    "filterTimeTablesBySorted" -> filterTimeTablesBySorted(parameters, resultCallback)
    "createTimeTable" -> createTimeTable(parameters, resultCallback)
    "matchTimeTablesBy" -> matchTimeTablesBy(parameters, resultCallback)
    "matchTimeTablesBySorted" -> matchTimeTablesBySorted(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun deleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.deleteTimeTableById(
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
    TimeTableApi.deleteTimeTablesByIds(
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
    TimeTableApi.purgeTimeTableById(
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
    TimeTableApi.deleteTimeTable(
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
    TimeTableApi.deleteTimeTables(
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
    TimeTableApi.purgeTimeTable(
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
    TimeTableApi.undeleteTimeTable(
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
    TimeTableApi.modifyTimeTable(
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
    TimeTableApi.undeleteTimeTableById(
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
    TimeTableApi.getTimeTable(
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
    TimeTableApi.getTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTableIds"),
    )
  }

  private fun filterTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.filterTimeTablesBy(
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
    TimeTableApi.filterTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun createTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.createTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun matchTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.matchTimeTablesBy(
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
    TimeTableApi.matchTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }
}
