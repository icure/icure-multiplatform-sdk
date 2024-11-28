// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.AgendaFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AgendaFiltersDispatcher {
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
    "byUser" -> byUser(parameters, resultCallback)
    "readableByUser" -> readableByUser(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun all(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.all(
      resultCallback,
    )
  }

  private fun byUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.byUser(
      resultCallback,
      parameters.getValue("userId"),
    )
  }

  private fun readableByUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    AgendaFilters.readableByUser(
      resultCallback,
      parameters.getValue("userId"),
    )
  }
}
