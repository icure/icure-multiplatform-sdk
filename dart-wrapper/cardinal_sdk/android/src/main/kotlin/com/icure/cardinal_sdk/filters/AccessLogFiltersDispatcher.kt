// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.AccessLogFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AccessLogFiltersDispatcher {
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
    "byPatientsDateForDataOwner" -> byPatientsDateForDataOwner(parameters, resultCallback)
    "byPatientsDateForSelf" -> byPatientsDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsDateForDataOwner" -> byPatientSecretIdsDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsDateForSelf" -> byPatientSecretIdsDateForSelf(parameters, resultCallback)
    "byDate" -> byDate(parameters, resultCallback)
    "byUserTypeDate" -> byUserTypeDate(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byPatientsDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byPatientsDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byPatientsDateForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byPatientSecretIdsDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byPatientSecretIdsDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byDate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byDate(
      resultCallback,
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byUserTypeDate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogFilters.byUserTypeDate(
      resultCallback,
      parameters.getValue("userId"),
      parameters.getValue("accessType"),
      parameters.getValue("from"),
      parameters.getValue("descending"),
    )
  }
}
