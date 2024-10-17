package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.CryptoApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CryptoApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "forceReload" -> forceReload(parameters, resultCallback)
    "currentDataOwnerKeys" -> currentDataOwnerKeys(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun forceReload(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.forceReload(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun currentDataOwnerKeys(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CryptoApi.currentDataOwnerKeys(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filterTrustedKeys"),
    )
  }
}
