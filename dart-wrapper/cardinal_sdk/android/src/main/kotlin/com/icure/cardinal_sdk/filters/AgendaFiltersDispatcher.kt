// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.AgendaFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AgendaFiltersDispatcher {
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
    "all" -> all(parameters, resultCallback)
    "byUser" -> byUser(parameters, resultCallback)
    "byUserInGroup" -> byUserInGroup(parameters, resultCallback)
    "readableByUser" -> readableByUser(parameters, resultCallback)
    "readableByUserInGroup" -> readableByUserInGroup(parameters, resultCallback)
    "readableByUserRights" -> readableByUserRights(parameters, resultCallback)
    "readableByUserRightsInGroup" -> readableByUserRightsInGroup(parameters, resultCallback)
    "byStringProperty" -> byStringProperty(parameters, resultCallback)
    "byBooleanProperty" -> byBooleanProperty(parameters, resultCallback)
    "byLongProperty" -> byLongProperty(parameters, resultCallback)
    "byDoubleProperty" -> byDoubleProperty(parameters, resultCallback)
    "withProperty" -> withProperty(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.all(
      resultCallback,
    )
  }

  private fun byUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byUser(
      resultCallback,
      parameters.getValue("userId"),
    )
  }

  private fun byUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byUserInGroup(
      resultCallback,
      parameters.getValue("userReference"),
    )
  }

  private fun readableByUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.readableByUser(
      resultCallback,
      parameters.getValue("userId"),
    )
  }

  private fun readableByUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.readableByUserInGroup(
      resultCallback,
      parameters.getValue("userReference"),
    )
  }

  private fun readableByUserRights(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.readableByUserRights(
      resultCallback,
      parameters.getValue("userId"),
    )
  }

  private fun readableByUserRightsInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.readableByUserRightsInGroup(
      resultCallback,
      parameters.getValue("userReference"),
    )
  }

  private fun byStringProperty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byStringProperty(
      resultCallback,
      parameters.getValue("propertyId"),
      parameters.getValue("propertyValue"),
    )
  }

  private fun byBooleanProperty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byBooleanProperty(
      resultCallback,
      parameters.getValue("propertyId"),
      parameters.getValue("propertyValue"),
    )
  }

  private fun byLongProperty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byLongProperty(
      resultCallback,
      parameters.getValue("propertyId"),
      parameters.getValue("propertyValue"),
    )
  }

  private fun byDoubleProperty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byDoubleProperty(
      resultCallback,
      parameters.getValue("propertyId"),
      parameters.getValue("propertyValue"),
    )
  }

  private fun withProperty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.withProperty(
      resultCallback,
      parameters.getValue("propertyId"),
    )
  }
}
