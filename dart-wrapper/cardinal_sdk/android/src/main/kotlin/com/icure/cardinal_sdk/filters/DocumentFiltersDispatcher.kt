// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.DocumentFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DocumentFiltersDispatcher {
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
    "byPatientsCreatedForDataOwner" -> byPatientsCreatedForDataOwner(parameters, resultCallback)
    "byPatientsCreatedForSelf" -> byPatientsCreatedForSelf(parameters, resultCallback)
    "byPatientSecretIdsCreatedForDataOwner" -> byPatientSecretIdsCreatedForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsCreatedForSelf" -> byPatientSecretIdsCreatedForSelf(parameters, resultCallback)
    "byPatientsAndTypeForDataOwner" -> byPatientsAndTypeForDataOwner(parameters, resultCallback)
    "byPatientsAndTypeForSelf" -> byPatientsAndTypeForSelf(parameters, resultCallback)
    "byPatientSecretIdsAndTypeForDataOwner" -> byPatientSecretIdsAndTypeForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsAndTypeForSelf" -> byPatientSecretIdsAndTypeForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byPatientsCreatedForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsCreatedForDataOwner(
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
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsCreatedForSelf(
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
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientSecretIdsCreatedForDataOwner(
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
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientSecretIdsCreatedForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsAndTypeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsAndTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("documentType"),
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsAndTypeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientsAndTypeForSelf(
      resultCallback,
      parameters.getValue("documentType"),
      parameters.getValue("patients"),
    )
  }

  private fun byPatientSecretIdsAndTypeForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientSecretIdsAndTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("documentType"),
      parameters.getValue("secretIds"),
    )
  }

  private fun byPatientSecretIdsAndTypeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentFilters.byPatientSecretIdsAndTypeForSelf(
      resultCallback,
      parameters.getValue("documentType"),
      parameters.getValue("secretIds"),
    )
  }
}
