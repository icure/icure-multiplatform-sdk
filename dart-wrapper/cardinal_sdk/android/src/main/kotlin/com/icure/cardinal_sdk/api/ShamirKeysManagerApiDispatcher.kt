// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ShamirKeysManagerApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ShamirKeysManagerApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getExistingSplitsInfo" -> getExistingSplitsInfo(parameters, resultCallback)
    "updateSelfSplits" -> updateSelfSplits(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getExistingSplitsInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ShamirKeysManagerApi.getExistingSplitsInfo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("dataOwner"),
    )
  }

  private fun updateSelfSplits(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ShamirKeysManagerApi.updateSelfSplits(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("keySplitsToUpdate"),
      parameters.getValue("keySplitsToDelete"),
    )
  }
}
