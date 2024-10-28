// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.ServiceFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ServiceFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "allServicesForDataOwner" -> allServicesForDataOwner(parameters, resultCallback)
    "allServicesForSelf" -> allServicesForSelf(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "byCodeAndValueDateForDataOwner" -> byCodeAndValueDateForDataOwner(parameters, resultCallback)
    "byTagAndValueDateForDataOwner" -> byTagAndValueDateForDataOwner(parameters, resultCallback)
    "byPatientsForDataOwner" -> byPatientsForDataOwner(parameters, resultCallback)
    "byPatientsSecretIdsForDataOwner" -> byPatientsSecretIdsForDataOwner(parameters, resultCallback)
    "byHealthElementIdFromSubContactForDataOwner" -> byHealthElementIdFromSubContactForDataOwner(parameters, resultCallback)
    "byIdentifiersForSelf" -> byIdentifiersForSelf(parameters, resultCallback)
    "byCodeAndValueDateForSelf" -> byCodeAndValueDateForSelf(parameters, resultCallback)
    "byTagAndValueDateForSelf" -> byTagAndValueDateForSelf(parameters, resultCallback)
    "byPatientsForSelf" -> byPatientsForSelf(parameters, resultCallback)
    "byPatientsSecretIdsForSelf" -> byPatientsSecretIdsForSelf(parameters, resultCallback)
    "byHealthElementIdFromSubContactForSelf" -> byHealthElementIdFromSubContactForSelf(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byAssociationId" -> byAssociationId(parameters, resultCallback)
    "byQualifiedLink" -> byQualifiedLink(parameters, resultCallback)
    "byPatientsDateForDataOwner" -> byPatientsDateForDataOwner(parameters, resultCallback)
    "byPatientsDateForSelf" -> byPatientsDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsDateForDataOwner" -> byPatientSecretIdsDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsDateForSelf" -> byPatientSecretIdsDateForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allServicesForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.allServicesForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allServicesForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.allServicesForSelf(
      resultCallback,
    )
  }

  private fun byIdentifiersForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun byCodeAndValueDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byCodeAndValueDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
      parameters.getValue("startOfServiceValueDate"),
      parameters.getValue("endOfServiceValueDate"),
    )
  }

  private fun byTagAndValueDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byTagAndValueDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
      parameters.getValue("startOfServiceValueDate"),
      parameters.getValue("endOfServiceValueDate"),
    )
  }

  private fun byPatientsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byPatientsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsSecretIdsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byPatientsSecretIdsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("secretIds"),
    )
  }

  private fun byHealthElementIdFromSubContactForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("healthElementIds"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byIdentifiersForSelf(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun byCodeAndValueDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byCodeAndValueDateForSelf(
      resultCallback,
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
      parameters.getValue("startOfServiceValueDate"),
      parameters.getValue("endOfServiceValueDate"),
    )
  }

  private fun byTagAndValueDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byTagAndValueDateForSelf(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
      parameters.getValue("startOfServiceValueDate"),
      parameters.getValue("endOfServiceValueDate"),
    )
  }

  private fun byPatientsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byPatientsForSelf(
      resultCallback,
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsSecretIdsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byPatientsSecretIdsForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
    )
  }

  private fun byHealthElementIdFromSubContactForSelf(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byHealthElementIdFromSubContactForSelf(
      resultCallback,
      parameters.getValue("healthElementIds"),
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byAssociationId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byAssociationId(
      resultCallback,
      parameters.getValue("associationId"),
    )
  }

  private fun byQualifiedLink(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byQualifiedLink(
      resultCallback,
      parameters.getValue("linkValues"),
      parameters.getValue("linkQualification"),
    )
  }

  private fun byPatientsDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ServiceFilters.byPatientsDateForDataOwner(
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
  ) -> Unit) {
    ServiceFilters.byPatientsDateForSelf(
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
  ) -> Unit) {
    ServiceFilters.byPatientSecretIdsDateForDataOwner(
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
  ) -> Unit) {
    ServiceFilters.byPatientSecretIdsDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }
}
