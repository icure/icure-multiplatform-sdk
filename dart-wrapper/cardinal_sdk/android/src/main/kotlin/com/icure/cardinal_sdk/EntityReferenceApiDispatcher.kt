package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.EntityReferenceApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object EntityReferenceApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getLatest" -> getLatest(parameters, resultCallback)
    "createEntityReference" -> createEntityReference(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getLatest(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityReferenceApi.getLatest(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("prefix"),
    )
  }

  private fun createEntityReference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityReferenceApi.createEntityReference(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityReference"),
    )
  }
}
