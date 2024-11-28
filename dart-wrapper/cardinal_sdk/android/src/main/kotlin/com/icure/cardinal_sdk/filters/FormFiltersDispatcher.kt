// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.FormFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object FormFiltersDispatcher {
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
    "byParentIdForDataOwner" -> byParentIdForDataOwner(parameters, resultCallback)
    "byParentIdForSelf" -> byParentIdForSelf(parameters, resultCallback)
    "byPatientsOpeningDateForDataOwner" -> byPatientsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientsOpeningDateForSelf" -> byPatientsOpeningDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForDataOwner" -> byPatientSecretIdsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForSelf" -> byPatientSecretIdsOpeningDateForSelf(parameters, resultCallback)
    "byLogicalUuid" -> byLogicalUuid(parameters, resultCallback)
    "byUniqueId" -> byUniqueId(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byParentIdForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byParentIdForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("parentId"),
    )
  }

  private fun byParentIdForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byParentIdForSelf(
      resultCallback,
      parameters.getValue("parentId"),
    )
  }

  private fun byPatientsOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byPatientsOpeningDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientsOpeningDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byPatientsOpeningDateForSelf(
      resultCallback,
      parameters.getValue("patients"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsOpeningDateForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byPatientSecretIdsOpeningDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byPatientSecretIdsOpeningDateForSelf(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byPatientSecretIdsOpeningDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byLogicalUuid(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byLogicalUuid(
      resultCallback,
      parameters.getValue("logicalUuid"),
      parameters.getValue("descending"),
    )
  }

  private fun byUniqueId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormFilters.byUniqueId(
      resultCallback,
      parameters.getValue("uniqueId"),
      parameters.getValue("descending"),
    )
  }
}
