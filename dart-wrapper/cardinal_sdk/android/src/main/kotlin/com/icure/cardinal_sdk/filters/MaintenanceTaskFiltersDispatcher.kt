// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.MaintenanceTaskFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MaintenanceTaskFiltersDispatcher {
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
    "byIds" -> byIds(parameters, resultCallback)
    "byIdentifiersForDataOwner" -> byIdentifiersForDataOwner(parameters, resultCallback)
    "byIdentifiersForSelf" -> byIdentifiersForSelf(parameters, resultCallback)
    "byTypeForDataOwner" -> byTypeForDataOwner(parameters, resultCallback)
    "byTypeForSelf" -> byTypeForSelf(parameters, resultCallback)
    "afterDateForDataOwner" -> afterDateForDataOwner(parameters, resultCallback)
    "afterDateForSelf" -> afterDateForSelf(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun byIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.byIds(
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
    MaintenanceTaskFilters.byIdentifiersForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("identifiers"),
    )
  }

  private fun byIdentifiersForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.byIdentifiersForSelf(
      resultCallback,
      parameters.getValue("identifiers"),
    )
  }

  private fun byTypeForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.byTypeForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("type"),
    )
  }

  private fun byTypeForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.byTypeForSelf(
      resultCallback,
      parameters.getValue("type"),
    )
  }

  private fun afterDateForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.afterDateForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
      parameters.getValue("date"),
    )
  }

  private fun afterDateForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MaintenanceTaskFilters.afterDateForSelf(
      resultCallback,
      parameters.getValue("date"),
    )
  }
}
