// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.UserFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object UserFiltersDispatcher {
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
    "byPatientId" -> byPatientId(parameters, resultCallback)
    "byHealthcarePartyId" -> byHealthcarePartyId(parameters, resultCallback)
    "byNameEmailOrPhone" -> byNameEmailOrPhone(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserFilters.all(
      resultCallback,
    )
  }

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserFilters.byIds(
      resultCallback,
      parameters.getValue("ids"),
    )
  }

  private fun byPatientId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserFilters.byPatientId(
      resultCallback,
      parameters.getValue("patientId"),
    )
  }

  private fun byHealthcarePartyId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserFilters.byHealthcarePartyId(
      resultCallback,
      parameters.getValue("healthcarePartyId"),
    )
  }

  private fun byNameEmailOrPhone(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserFilters.byNameEmailOrPhone(
      resultCallback,
      parameters.getValue("searchString"),
    )
  }
}
