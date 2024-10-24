// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ClassificationBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ClassificationBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchClassificationsBy" -> matchClassificationsBy(parameters, resultCallback)
    "matchClassificationsBySorted" -> matchClassificationsBySorted(parameters, resultCallback)
    "filterClassificationsBy" -> filterClassificationsBy(parameters, resultCallback)
    "filterClassificationsBySorted" -> filterClassificationsBySorted(parameters, resultCallback)
    "deleteClassification" -> deleteClassification(parameters, resultCallback)
    "deleteClassifications" -> deleteClassifications(parameters, resultCallback)
    "modifyClassification" -> modifyClassification(parameters, resultCallback)
    "getClassification" -> getClassification(parameters, resultCallback)
    "getClassifications" -> getClassifications(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchClassificationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.matchClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchClassificationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.matchClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterClassificationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.filterClassificationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterClassificationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.filterClassificationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.deleteClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun deleteClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.deleteClassifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun modifyClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.modifyClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getClassification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.getClassification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getClassifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ClassificationBasicApi.getClassifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
