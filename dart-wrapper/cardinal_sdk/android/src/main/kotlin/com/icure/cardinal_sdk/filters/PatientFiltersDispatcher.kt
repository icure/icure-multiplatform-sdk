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
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "allPatientsForDataOwner" -> allPatientsForDataOwner(parameters, resultCallback)
    "allPatientsForDataOwnerInGroup" -> allPatientsForDataOwnerInGroup(parameters, resultCallback)
    "allPatientsForSelf" -> allPatientsForSelf(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "byIdentifiersForDataOwnerInGroup" -> byIdentifiersForDataOwnerInGroup(parameters, resultCallback)
    "bySsinsForDataOwner" -> bySsinsForDataOwner(parameters, resultCallback)
    "bySsinsForDataOwnerInGroup" -> bySsinsForDataOwnerInGroup(parameters, resultCallback)
    "byDateOfBirthBetweenForDataOwner" -> byDateOfBirthBetweenForDataOwner(parameters, resultCallback)
    "byDateOfBirthBetweenForDataOwnerInGroup" -> byDateOfBirthBetweenForDataOwnerInGroup(parameters, resultCallback)
    "byFuzzyNameForDataOwner" -> byFuzzyNameForDataOwner(parameters, resultCallback)
    "byFuzzyNameForDataOwnerInGroup" -> byFuzzyNameForDataOwnerInGroup(parameters, resultCallback)
    "byGenderEducationProfessionForDataOwner" -> byGenderEducationProfessionForDataOwner(parameters, resultCallback)
    "byGenderEducationProfessionForDataOwnerInGroup" -> byGenderEducationProfessionForDataOwnerInGroup(parameters, resultCallback)
    "byActiveForDataOwner" -> byActiveForDataOwner(parameters, resultCallback)
    "byActiveForDataOwnerInGroup" -> byActiveForDataOwnerInGroup(parameters, resultCallback)
    "byTelecomForDataOwner" -> byTelecomForDataOwner(parameters, resultCallback)
    "byTelecomForDataOwnerInGroup" -> byTelecomForDataOwnerInGroup(parameters, resultCallback)
    "byAddressPostalCodeHouseNumberForDataOwner" -> byAddressPostalCodeHouseNumberForDataOwner(parameters, resultCallback)
    "byAddressPostalCodeHouseNumberForDataOwnerInGroup" -> byAddressPostalCodeHouseNumberForDataOwnerInGroup(parameters, resultCallback)
    "byAddressForDataOwner" -> byAddressForDataOwner(parameters, resultCallback)
    "byAddressForDataOwnerInGroup" -> byAddressForDataOwnerInGroup(parameters, resultCallback)
    "byExternalIdForDataOwner" -> byExternalIdForDataOwner(parameters, resultCallback)
    "byExternalIdForDataOwnerInGroup" -> byExternalIdForDataOwnerInGroup(parameters, resultCallback)
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
    "byTagForSelf" -> byTagForSelf(parameters, resultCallback)
    "byTagForDataOwner" -> byTagForDataOwner(parameters, resultCallback)
    "byTagForDataOwnerInGroup" -> byTagForDataOwnerInGroup(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allPatientsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.allPatientsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allPatientsForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.allPatientsForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
    )
  }

  private fun allPatientsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
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
    String?,
  ) -> Unit) {
    PatientFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun byIdentifiersForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byIdentifiersForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("identifiers"),
    )
  }

  private fun bySsinsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun bySsinsForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.bySsinsForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("ssins"),
    )
  }

  private fun byDateOfBirthBetweenForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byDateOfBirthBetweenForDataOwnerInGroup(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byDateOfBirthBetweenForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("fromDate"),
      parameters.getValue("toDate"),
    )
  }

  private fun byFuzzyNameForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byFuzzyNameForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byFuzzyNameForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("searchString"),
    )
  }

  private fun byGenderEducationProfessionForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
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

  private fun byGenderEducationProfessionForDataOwnerInGroup(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byGenderEducationProfessionForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("gender"),
      parameters.getValue("education"),
      parameters.getValue("profession"),
    )
  }

  private fun byActiveForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byActiveForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byActiveForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("active"),
    )
  }

  private fun byTelecomForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byTelecomForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTelecomForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("searchString"),
    )
  }

  private fun byAddressPostalCodeHouseNumberForDataOwner(parameters: Map<String, String>,
      resultCallback: (
    String?,
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

  private fun byAddressPostalCodeHouseNumberForDataOwnerInGroup(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("searchString"),
      parameters.getValue("postalCode"),
      parameters.getValue("houseNumber"),
    )
  }

  private fun byAddressForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byAddressForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byAddressForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("searchString"),
    )
  }

  private fun byExternalIdForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
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

  private fun byExternalIdForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byExternalIdForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("externalIdPrefix"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
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
    String?,
  ) -> Unit) {
    PatientFilters.byExternalIdForSelf(
      resultCallback,
      parameters.getValue("externalIdPrefix"),
    )
  }

  private fun byTagForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTagForSelf(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byTagForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTagForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byTagForDataOwnerInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientFilters.byTagForDataOwnerInGroup(
      resultCallback,
      parameters.getValue("dataOwner"),
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }
}
