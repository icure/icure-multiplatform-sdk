// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.api.ContactFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ContactFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "allContactsForDataOwner" -> allContactsForDataOwner(parameters, resultCallback)
    "allContactsForSelf" -> allContactsForSelf(parameters, resultCallback)
    "byFormIdsForDataOwner" -> byFormIdsForDataOwner(parameters, resultCallback)
    "byFormIdsForSelf" -> byFormIdsForSelf(parameters, resultCallback)
    "byPatientsOpeningDateForDataOwner" -> byPatientsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientsOpeningDateForSelf" -> byPatientsOpeningDateForSelf(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForDataOwner" -> byPatientSecretIdsOpeningDateForDataOwner(parameters, resultCallback)
    "byPatientSecretIdsOpeningDateForSelf" -> byPatientSecretIdsOpeningDateForSelf(parameters, resultCallback)
    "byExternalId" -> byExternalId(parameters, resultCallback)
    "byIdentifiersForSelf" -> byIdentifiersForSelf(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "byCodeAndOpeningDateForDataOwner" -> byCodeAndOpeningDateForDataOwner(parameters, resultCallback)
    "byCodeAndOpeningDateForSelf" -> byCodeAndOpeningDateForSelf(parameters, resultCallback)
    "byTagAndOpeningDateForDataOwner" -> byTagAndOpeningDateForDataOwner(parameters, resultCallback)
    "byOpeningDateForDataOwner" -> byOpeningDateForDataOwner(parameters, resultCallback)
    "byOpeningDateForSelf" -> byOpeningDateForSelf(parameters, resultCallback)
    "byServiceTagForSelf" -> byServiceTagForSelf(parameters, resultCallback)
    "byServiceTagForDataOwner" -> byServiceTagForDataOwner(parameters, resultCallback)
    "byServiceCodeForSelf" -> byServiceCodeForSelf(parameters, resultCallback)
    "byServiceCodeForDataOwner" -> byServiceCodeForDataOwner(parameters, resultCallback)
    "byTagAndOpeningDateForSelf" -> byTagAndOpeningDateForSelf(parameters, resultCallback)
    "byPatientsForDataOwner" -> byPatientsForDataOwner(parameters, resultCallback)
    "byPatientsForSelf" -> byPatientsForSelf(parameters, resultCallback)
    "byPatientsSecretIdsForDataOwner" -> byPatientsSecretIdsForDataOwner(parameters, resultCallback)
    "byPatientsSecretIdsForSelf" -> byPatientsSecretIdsForSelf(parameters, resultCallback)
    "byServiceIds" -> byServiceIds(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allContactsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.allContactsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allContactsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.allContactsForSelf(
      resultCallback,
    )
  }

  private fun byFormIdsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byFormIdsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("formIds"),
    )
  }

  private fun byFormIdsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byFormIdsForSelf(
      resultCallback,
      parameters.getValue("formIds"),
    )
  }

  private fun byPatientsOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byPatientsOpeningDateForDataOwner(
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
    ContactFilters.byPatientsOpeningDateForSelf(
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
    ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
    ContactFilters.byPatientSecretIdsOpeningDateForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byExternalId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byExternalId(
      resultCallback,
      parameters.getValue("externalId"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byIdentifiersForSelf(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun byIdentifiersForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun byCodeAndOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byCodeAndOpeningDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
      parameters.getValue("startOfContactOpeningDate"),
      parameters.getValue("endOfContactOpeningDate"),
    )
  }

  private fun byCodeAndOpeningDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byCodeAndOpeningDateForSelf(
      resultCallback,
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
      parameters.getValue("startOfContactOpeningDate"),
      parameters.getValue("endOfContactOpeningDate"),
    )
  }

  private fun byTagAndOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byTagAndOpeningDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
      parameters.getValue("startOfContactOpeningDate"),
      parameters.getValue("endOfContactOpeningDate"),
    )
  }

  private fun byOpeningDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byOpeningDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("startDate"),
      parameters.getValue("endDate"),
      parameters.getValue("descending"),
    )
  }

  private fun byOpeningDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byOpeningDateForSelf(
      resultCallback,
      parameters.getValue("startDate"),
      parameters.getValue("endDate"),
      parameters.getValue("descending"),
    )
  }

  private fun byServiceTagForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byServiceTagForSelf(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byServiceTagForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byServiceTagForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byServiceCodeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byServiceCodeForSelf(
      resultCallback,
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
    )
  }

  private fun byServiceCodeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byServiceCodeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
    )
  }

  private fun byTagAndOpeningDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byTagAndOpeningDateForSelf(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
      parameters.getValue("startOfContactOpeningDate"),
      parameters.getValue("endOfContactOpeningDate"),
    )
  }

  private fun byPatientsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byPatientsForDataOwner(
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
    ContactFilters.byPatientsForSelf(
      resultCallback,
      parameters.getValue("patients"),
    )
  }

  private fun byPatientsSecretIdsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byPatientsSecretIdsForDataOwner(
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
    ContactFilters.byPatientsSecretIdsForSelf(
      resultCallback,
      parameters.getValue("secretIds"),
    )
  }

  private fun byServiceIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ContactFilters.byServiceIds(
      resultCallback,
      parameters.getValue("serviceIds"),
    )
  }
}
