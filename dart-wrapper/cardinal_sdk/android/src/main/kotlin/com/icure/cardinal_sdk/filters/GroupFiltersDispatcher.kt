// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.GroupFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object GroupFiltersDispatcher {
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
    "bySuperGroup" -> bySuperGroup(parameters, resultCallback)
    "withContent" -> withContent(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupFilters.all(
      resultCallback,
    )
  }

  private fun bySuperGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupFilters.bySuperGroup(
      resultCallback,
      parameters.getValue("superGroupId"),
    )
  }

  private fun withContent(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    GroupFilters.withContent(
      resultCallback,
      parameters.getValue("superGroupId"),
      parameters.getValue("searchString"),
    )
  }
}
