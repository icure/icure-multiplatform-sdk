// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.MaintenanceTaskBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MaintenanceTaskBasicApiDispatcher {
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
    "matchMaintenanceTasksBy" -> matchMaintenanceTasksBy(parameters, resultCallback)
    "matchMaintenanceTasksBySorted" -> matchMaintenanceTasksBySorted(parameters, resultCallback)
    "filterMaintenanceTasksBy" -> filterMaintenanceTasksBy(parameters, resultCallback)
    "filterMaintenanceTasksBySorted" -> filterMaintenanceTasksBySorted(parameters, resultCallback)
    "deleteMaintenanceTaskById" -> deleteMaintenanceTaskById(parameters, resultCallback)
    "deleteMaintenanceTasksByIds" -> deleteMaintenanceTasksByIds(parameters, resultCallback)
    "purgeMaintenanceTaskById" -> purgeMaintenanceTaskById(parameters, resultCallback)
    "deleteMaintenanceTask" -> deleteMaintenanceTask(parameters, resultCallback)
    "deleteMaintenanceTasks" -> deleteMaintenanceTasks(parameters, resultCallback)
    "purgeMaintenanceTask" -> purgeMaintenanceTask(parameters, resultCallback)
    "undeleteMaintenanceTask" -> undeleteMaintenanceTask(parameters, resultCallback)
    "undeleteMaintenanceTaskById" -> undeleteMaintenanceTaskById(parameters, resultCallback)
    "modifyMaintenanceTask" -> modifyMaintenanceTask(parameters, resultCallback)
    "getMaintenanceTask" -> getMaintenanceTask(parameters, resultCallback)
    "getMaintenanceTasks" -> getMaintenanceTasks(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchMaintenanceTasksBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.matchMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchMaintenanceTasksBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.matchMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMaintenanceTasksBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.filterMaintenanceTasksBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMaintenanceTasksBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.filterMaintenanceTasksBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.deleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMaintenanceTasksByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.deleteMaintenanceTasksByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.purgeMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.deleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun deleteMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.deleteMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTasks"),
    )
  }

  private fun purgeMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.purgeMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun undeleteMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.undeleteMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("maintenanceTask"),
    )
  }

  private fun undeleteMaintenanceTaskById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.undeleteMaintenanceTaskById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun modifyMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.modifyMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getMaintenanceTask(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.getMaintenanceTask(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getMaintenanceTasks(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.getMaintenanceTasks(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
