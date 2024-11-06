// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.PatientFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PatientFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "allPatientsForDataOwner" -> allPatientsForDataOwner(parameters, resultCallback)
    "allPatientsForSelf" -> allPatientsForSelf(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "bySsinsForDataOwner" -> bySsinsForDataOwner(parameters, resultCallback)
    "byDateOfBirthBetweenForDataOwner" -> byDateOfBirthBetweenForDataOwner(parameters, resultCallback)
    "byFuzzyNameForDataOwner" -> byFuzzyNameForDataOwner(parameters, resultCallback)
    "byGenderEducationProfessionForDataOwner" -> byGenderEducationProfessionForDataOwner(parameters, resultCallback)
    "byActiveForDataOwner" -> byActiveForDataOwner(parameters, resultCallback)
    "byTelecomForDataOwner" -> byTelecomForDataOwner(parameters, resultCallback)
    "byAddressPostalCodeHouseNumberForDataOwner" -> byAddressPostalCodeHouseNumberForDataOwner(parameters, resultCallback)
    "byAddressForDataOwner" -> byAddressForDataOwner(parameters, resultCallback)
    "byExternalIdForDataOwner" -> byExternalIdForDataOwner(parameters, resultCallback)
    "byIdentifiersForSelf" -> byIdentifiersForSelf(parameters, resultCallback)
    "bySsinsForSelf" -> bySsinsForSelf(parameters, resultCallback)
    "byDateOfBirthBetweenForSelf" -> byDateOfBirthBetweenForSelf(parameters, resultCallback)
    "byNameForSelf" -> byNameForSelf(parameters, resultCallback)
    "byGenderEducationProfessionForSelf" -> byGenderEducationProfessionForSelf(parameters, resultCallback)
    "byActiveForSelf" -> byActiveForSelf(parameters, resultCallback)
    "byTelecomForSelf" -> byTelecomForSelf(parameters, resultCallback)
    "byAddressPostalCodeHouseNumberForSelf" -> byAddressPostalCodeHouseNumberForSelf(parameters, resultCallback)
    "byAddressForSelf" -> byAddressForSelf(parameters, resultCallback)
    "byExternalIdForSelf" -> byExternalIdForSelf(parameters, resultCallback)
    "byModificationDateForDataOwner" -> byModificationDateForDataOwner(parameters, resultCallback)
    "byModificationDateForSelf" -> byModificationDateForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allPatientsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.allPatientsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allPatientsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.allPatientsForSelf(
      resultCallback,
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byIdentifiersForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun bySsinsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.bySsinsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("ssins"),
    )
  }

  private fun byDateOfBirthBetweenForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byDateOfBirthBetweenForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("fromDate"),
      parameters.getValue("toDate"),
    )
  }

  private fun byFuzzyNameForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byFuzzyNameForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("searchString"),
    )
  }

  private fun byGenderEducationProfessionForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byGenderEducationProfessionForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("gender"),
      parameters.getValue("education"),
      parameters.getValue("profession"),
    )
  }

  private fun byActiveForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byActiveForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("active"),
    )
  }

  private fun byTelecomForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTelecomForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("searchString"),
    )
  }

  private fun byAddressPostalCodeHouseNumberForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("searchString"),
      parameters.getValue("postalCode"),
      parameters.getValue("houseNumber"),
    )
  }

  private fun byAddressForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("searchString"),
    )
  }

  private fun byExternalIdForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byExternalIdForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("externalIdPrefix"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byIdentifiersForSelf(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun bySsinsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.bySsinsForSelf(
      resultCallback,
      parameters.getValue("ssins"),
    )
  }

  private fun byDateOfBirthBetweenForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byDateOfBirthBetweenForSelf(
      resultCallback,
      parameters.getValue("fromDate"),
      parameters.getValue("toDate"),
    )
  }

  private fun byNameForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byNameForSelf(
      resultCallback,
      parameters.getValue("searchString"),
    )
  }

  private fun byGenderEducationProfessionForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byGenderEducationProfessionForSelf(
      resultCallback,
      parameters.getValue("gender"),
      parameters.getValue("education"),
      parameters.getValue("profession"),
    )
  }

  private fun byActiveForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byActiveForSelf(
      resultCallback,
      parameters.getValue("active"),
    )
  }

  private fun byTelecomForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTelecomForSelf(
      resultCallback,
      parameters.getValue("searchString"),
    )
  }

  private fun byAddressPostalCodeHouseNumberForSelf(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressPostalCodeHouseNumberForSelf(
      resultCallback,
      parameters.getValue("searchString"),
      parameters.getValue("postalCode"),
      parameters.getValue("houseNumber"),
    )
  }

  private fun byAddressForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressForSelf(
      resultCallback,
      parameters.getValue("searchString"),
    )
  }

  private fun byExternalIdForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byExternalIdForSelf(
      resultCallback,
      parameters.getValue("externalIdPrefix"),
    )
  }

  private fun byModificationDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byModificationDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }

  private fun byModificationDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byModificationDateForSelf(
      resultCallback,
      parameters.getValue("from"),
      parameters.getValue("to"),
      parameters.getValue("descending"),
    )
  }
}
