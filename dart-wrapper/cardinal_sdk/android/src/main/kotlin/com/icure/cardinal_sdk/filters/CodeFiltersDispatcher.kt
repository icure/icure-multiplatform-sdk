// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.api.CodeFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CodeFiltersDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "all" -> all(parameters, resultCallback)
    "byIds" -> byIds(parameters, resultCallback)
    "byQualifiedLink" -> byQualifiedLink(parameters, resultCallback)
    "byRegionTypeCodeVersion" -> byRegionTypeCodeVersion(parameters, resultCallback)
    "byLanguageTypeLabelRegion" -> byLanguageTypeLabelRegion(parameters, resultCallback)
    "byLanguageTypesLabelRegionVersion" -> byLanguageTypesLabelRegionVersion(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.all(
      resultCallback,
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byQualifiedLink(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.byQualifiedLink(
      resultCallback,
      parameters.getValue("linkType"),
      parameters.getValue("linkedId"),
    )
  }

  private fun byRegionTypeCodeVersion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.byRegionTypeCodeVersion(
      resultCallback,
      parameters.getValue("region"),
      parameters.getValue("type"),
      parameters.getValue("code"),
      parameters.getValue("version"),
    )
  }

  private fun byLanguageTypeLabelRegion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.byLanguageTypeLabelRegion(
      resultCallback,
      parameters.getValue("language"),
      parameters.getValue("type"),
      parameters.getValue("label"),
      parameters.getValue("region"),
    )
  }

  private fun byLanguageTypesLabelRegionVersion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeFilters.byLanguageTypesLabelRegionVersion(
      resultCallback,
      parameters.getValue("language"),
      parameters.getValue("types"),
      parameters.getValue("label"),
      parameters.getValue("region"),
      parameters.getValue("version"),
    )
  }
}
