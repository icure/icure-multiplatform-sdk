// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.ClassificationFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ClassificationFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "byPatientsCreatedForDataOwner" -> byPatientsCreatedForDataOwner(parameters, resultCallback)
    "byPatientsCreatedForSelf" -> byPatientsCreatedForSelf(parameters, resultCallback)
    "byPatientSecretIdsCreatedForDataOwner" -> byPatientSecretIdsCreatedForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsCreatedForSelf" -> byPatientSecretIdsCreatedForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byPatientsCreatedForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationFilters.byPatientsCreatedForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsCreatedForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationFilters.byPatientsCreatedForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsCreatedForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationFilters.byPatientSecretIdsCreatedForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsCreatedForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationFilters.byPatientSecretIdsCreatedForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }
}
