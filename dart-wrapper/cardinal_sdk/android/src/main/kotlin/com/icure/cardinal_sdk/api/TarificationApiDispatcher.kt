// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.TarificationApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TarificationApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getTarification" -> getTarification(parameters, resultCallback)
    "createTarification" -> createTarification(parameters, resultCallback)
    "getTarifications" -> getTarifications(parameters, resultCallback)
    "modifyTarification" -> modifyTarification(parameters, resultCallback)
    "getTarificationWithParts" -> getTarificationWithParts(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getTarification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TarificationApi.getTarification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("tarificationId"),
    )
  }

  private fun createTarification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TarificationApi.createTarification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("tarification"),
    )
  }

  private fun getTarifications(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TarificationApi.getTarifications(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("tarificationIds"),
    )
  }

  private fun modifyTarification(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TarificationApi.modifyTarification(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("tarification"),
    )
  }

  private fun getTarificationWithParts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TarificationApi.getTarificationWithParts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("tarification"),
      parameters.getValue("version"),
    )
  }
}
