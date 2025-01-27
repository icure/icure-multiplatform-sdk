// auto-generated file
package com.icure.cardinal_sdk.filters

import com.icure.cardinal.sdk.dart.filters.TopicFilters
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TopicFiltersDispatcher {
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
    "allTopicsForDataOwner" -> allTopicsForDataOwner(parameters, resultCallback)
    "allTopicsForSelf" -> allTopicsForSelf(parameters, resultCallback)
    "byParticipant" -> byParticipant(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun allTopicsForDataOwner(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicFilters.allTopicsForDataOwner(
      resultCallback,
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun allTopicsForSelf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicFilters.allTopicsForSelf(
      resultCallback,
    )
  }

  private fun byParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicFilters.byParticipant(
      resultCallback,
      parameters.getValue("participantId"),
    )
  }
}
