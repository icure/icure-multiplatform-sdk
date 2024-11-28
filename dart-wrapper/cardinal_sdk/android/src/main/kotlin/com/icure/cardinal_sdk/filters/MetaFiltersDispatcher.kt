// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.MetaFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MetaFiltersDispatcher {
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
    "intersection" -> intersection(parameters, resultCallback)
    "sortableIntersection" -> sortableIntersection(parameters, resultCallback)
    "baseIntersection" -> baseIntersection(parameters, resultCallback)
    "baseSortableIntersection" -> baseSortableIntersection(parameters, resultCallback)
    "difference" -> difference(parameters, resultCallback)
    "sortableDifference" -> sortableDifference(parameters, resultCallback)
    "baseDifference" -> baseDifference(parameters, resultCallback)
    "baseSortableDifference" -> baseSortableDifference(parameters, resultCallback)
    "union" -> union(parameters, resultCallback)
    "baseUnion" -> baseUnion(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun intersection(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.intersection(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun sortableIntersection(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.sortableIntersection(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun baseIntersection(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.baseIntersection(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun baseSortableIntersection(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.baseSortableIntersection(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun difference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.difference(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun sortableDifference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.sortableDifference(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun baseDifference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.baseDifference(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun baseSortableDifference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.baseSortableDifference(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun union(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.union(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }

  private fun baseUnion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MetaFilters.baseUnion(
      resultCallback,
      parameters.getValue("left"),
      parameters.getValue("right")
    )
  }
}
