// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.HealthcarePartyFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object HealthcarePartyFiltersDispatcher {
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
    "all" -> all(parameters, resultCallback)
    "byIdentifiers" -> byIdentifiers(parameters, resultCallback)
    "byCode" -> byCode(parameters, resultCallback)
    "byTag" -> byTag(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byName" -> byName(parameters, resultCallback)
    "byNationalIdentifier" -> byNationalIdentifier(parameters, resultCallback)
    "byParentId" -> byParentId(parameters, resultCallback)
    "byTypeSpecialtyPostCode" -> byTypeSpecialtyPostCode(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.all(
      resultCallback,
    )
  }

  private fun byIdentifiers(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byIdentifiers(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun byCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byCode(
      resultCallback,
      parameters.getValue("codeType"),
      parameters.getValue("codeCode"),
    )
  }

  private fun byTag(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byTag(
      resultCallback,
      parameters.getValue("tagType"),
      parameters.getValue("tagCode"),
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byName(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byName(
      resultCallback,
      parameters.getValue("searchString"),
      parameters.getValue("descending"),
    )
  }

  private fun byNationalIdentifier(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byNationalIdentifier(
      resultCallback,
      parameters.getValue("searchString"),
      parameters.getValue("descending"),
    )
  }

  private fun byParentId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byParentId(
      resultCallback,
      parameters.getValue("parentId"),
    )
  }

  private fun byTypeSpecialtyPostCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthcarePartyFilters.byTypeSpecialtyPostCode(
      resultCallback,
      parameters.getValue("specialty"),
      parameters.getValue("specCode"),
      parameters.getValue("startPostCode"),
      parameters.getValue("endPostCode"),
    )
  }
}
