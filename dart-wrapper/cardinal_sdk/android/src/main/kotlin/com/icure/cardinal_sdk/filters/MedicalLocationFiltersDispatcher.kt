// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.api.MedicalLocationFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MedicalLocationFiltersDispatcher {
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
    "byPostCode" -> byPostCode(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationFilters.all(
      resultCallback,
    )
  }

  private fun byPostCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationFilters.byPostCode(
      resultCallback,
      parameters.getValue("postCode"),
    )
  }
}
