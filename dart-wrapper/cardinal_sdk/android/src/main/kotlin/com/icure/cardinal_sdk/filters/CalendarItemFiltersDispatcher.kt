// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.CalendarItemFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CalendarItemFiltersDispatcher {
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
    "byPatientsStartTimeForDataOwner" -> byPatientsStartTimeForDataOwner(parameters, resultCallback)
    "byPatientsStartTimeForDataOwnerInGroup" -> byPatientsStartTimeForDataOwnerInGroup(parameters, resultCallback)
    "byPatientsStartTimeForSelf" -> byPatientsStartTimeForSelf(parameters, resultCallback)
    "byPatientSecretIdsStartTimeForDataOwner" -> byPatientSecretIdsStartTimeForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsStartTimeForDataOwnerInGroup" -> byPatientSecretIdsStartTimeForDataOwnerInGroup(parameters, resultCallback)
    "byPatientSecretIdsStartTimeForSelf" -> byPatientSecretIdsStartTimeForSelf(parameters, resultCallback)
    "byPeriodAndAgenda" -> byPeriodAndAgenda(parameters, resultCallback)
    "byPeriodForDataOwner" -> byPeriodForDataOwner(parameters, resultCallback)
    "byPeriodForDataOwnerInGroup" -> byPeriodForDataOwnerInGroup(parameters, resultCallback)
    "byPeriodForSelf" -> byPeriodForSelf(parameters, resultCallback)
    "byRecurrenceId" -> byRecurrenceId(parameters, resultCallback)
    "lifecycleBetweenForDataOwner" -> lifecycleBetweenForDataOwner(parameters, resultCallback)
    "lifecycleBetweenForDataOwnerInGroup" -> lifecycleBetweenForDataOwnerInGroup(parameters, resultCallback)
    "lifecycleBetweenForSelf" -> lifecycleBetweenForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byPatientsStartTimeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientsStartTimeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsStartTimeForDataOwnerInGroup(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientsStartTimeForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsStartTimeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientsStartTimeForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsStartTimeForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsStartTimeForDataOwnerInGroup(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsStartTimeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPeriodAndAgenda(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPeriodAndAgenda(
      resultCallback,
      parameters.getValue("agendaId"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPeriodForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPeriodForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun byPeriodForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPeriodForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun byPeriodForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byPeriodForSelf(
      resultCallback,
      parameters.getValue("from"),
      parameters.getValue("to"),
    )
  }

  private fun byRecurrenceId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.byRecurrenceId(
      resultCallback,
      parameters.getValue("recurrenceId"),
    )
  }

  private fun lifecycleBetweenForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.lifecycleBetweenForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }

  private fun lifecycleBetweenForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.lifecycleBetweenForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }

  private fun lifecycleBetweenForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CalendarItemFilters.lifecycleBetweenForSelf(
      resultCallback,
      parameters.getValue("startTimestamp"),
      parameters.getValue("endTimestamp"),
      parameters.getValue("descending"),
    )
  }
}
