// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.HealthElementFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object HealthElementFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "allHealthElementsForDataOwner" -> allHealthElementsForDataOwner(parameters, resultCallback)
    "allHealthElementsForSelf" -> allHealthElementsForSelf(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "byIdentifiersForSelf" -> byIdentifiersForSelf(parameters, resultCallback)
    "byCodeForDataOwner" -> byCodeForDataOwner(parameters, resultCallback)
    "byCodeForSelf" -> byCodeForSelf(parameters, resultCallback)
    "byTagForDataOwner" -> byTagForDataOwner(parameters, resultCallback)
    "byTagForSelf" -> byTagForSelf(parameters, resultCallback)
    "byPatientsForDataOwner" -> byPatientsForDataOwner(parameters, resultCallback)
    "byPatientsForSelf" -> byPatientsForSelf(parameters, resultCallback)
    "byPatientsSecretIdsForDataOwner" -> byPatientsSecretIdsForDataOwner(parameters, resultCallback)
    "byPatientsSecretIdsForSelf" -> byPatientsSecretIdsForSelf(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byPatientsOpeningDateForDataOwner" -> byPatientsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientsOpeningDateForSelf" -> byPatientsOpeningDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForDataOwner" -> byPatientSecretIdsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForSelf" -> byPatientSecretIdsOpeningDateForSelf(parameters, resultCallback)
    "byStatusForDataOwner" -> byStatusForDataOwner(parameters, resultCallback)
    "byStatusForSelf" -> byStatusForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allHealthElementsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.allHealthElementsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allHealthElementsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.allHealthElementsForSelf(
      resultCallback,
    )
  }

  private fun byIdentifiersForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byIdentifiersForSelf(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun byCodeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byCodeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
    )
  }

  private fun byCodeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byCodeForSelf(
      resultCallback,
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
    )
  }

  private fun byTagForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byTagForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byTagForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byTagForSelf(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byPatientsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byPatientsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byPatientsForSelf(
      resultCallback,
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsSecretIdsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byPatientsSecretIdsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
    )
  }

  private fun byPatientsSecretIdsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byPatientsSecretIdsForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byPatientsOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byPatientsOpeningDateForDataOwner(
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
  ) -> Unit) {
    HealthElementFilters.byPatientsOpeningDateForSelf(
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
  ) -> Unit) {
    HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
  ) -> Unit) {
    HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byStatusForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byStatusForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("status"),
    )
  }

  private fun byStatusForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementFilters.byStatusForSelf(
      resultCallback,
      parameters.getValue("status"),
    )
  }
}
