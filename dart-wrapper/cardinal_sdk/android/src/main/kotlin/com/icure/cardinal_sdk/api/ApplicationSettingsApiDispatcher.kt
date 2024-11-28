// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ApplicationSettingsApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ApplicationSettingsApiDispatcher {
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
    "getApplicationSettings" -> getApplicationSettings(parameters, resultCallback)
    "createApplicationSettings" -> createApplicationSettings(parameters, resultCallback)
    "updateApplicationSettings" -> updateApplicationSettings(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getApplicationSettings(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApplicationSettingsApi.getApplicationSettings(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun createApplicationSettings(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApplicationSettingsApi.createApplicationSettings(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("applicationSettings"),
    )
  }

  private fun updateApplicationSettings(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApplicationSettingsApi.updateApplicationSettings(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("applicationSettings"),
    )
  }
}
