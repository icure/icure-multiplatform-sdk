package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.HealthElementBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object HealthElementBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchHealthElementsBy" -> matchHealthElementsBy(parameters, resultCallback)
    "matchHealthElementsBySorted" -> matchHealthElementsBySorted(parameters, resultCallback)
    "filterHealthElementsBy" -> filterHealthElementsBy(parameters, resultCallback)
    "filterHealthElementsBySorted" -> filterHealthElementsBySorted(parameters, resultCallback)
    "deleteHealthElementById" -> deleteHealthElementById(parameters, resultCallback)
    "deleteHealthElementsByIds" -> deleteHealthElementsByIds(parameters, resultCallback)
    "purgeHealthElementById" -> purgeHealthElementById(parameters, resultCallback)
    "deleteHealthElement" -> deleteHealthElement(parameters, resultCallback)
    "deleteHealthElements" -> deleteHealthElements(parameters, resultCallback)
    "purgeHealthElement" -> purgeHealthElement(parameters, resultCallback)
    "undeleteHealthElementById" -> undeleteHealthElementById(parameters, resultCallback)
    "undeleteHealthElement" -> undeleteHealthElement(parameters, resultCallback)
    "modifyHealthElement" -> modifyHealthElement(parameters, resultCallback)
    "modifyHealthElements" -> modifyHealthElements(parameters, resultCallback)
    "getHealthElement" -> getHealthElement(parameters, resultCallback)
    "getHealthElements" -> getHealthElements(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchHealthElementsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.matchHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchHealthElementsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.matchHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterHealthElementsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.filterHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterHealthElementsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.filterHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.deleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthElementsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.deleteHealthElementsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.purgeHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.deleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun deleteHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.deleteHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElements"),
    )
  }

  private fun purgeHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.purgeHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun undeleteHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.undeleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.undeleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun modifyHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.modifyHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.modifyHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.getHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.getHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
