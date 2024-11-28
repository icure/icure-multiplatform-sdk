// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.PlaceApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PlaceApiDispatcher {
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
    "getPlace" -> getPlace(parameters, resultCallback)
    "createPlace" -> createPlace(parameters, resultCallback)
    "modifyPlace" -> modifyPlace(parameters, resultCallback)
    "deletePlaces" -> deletePlaces(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getPlace(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PlaceApi.getPlace(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("placeId"),
    )
  }

  private fun createPlace(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PlaceApi.createPlace(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("place"),
    )
  }

  private fun modifyPlace(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PlaceApi.modifyPlace(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("place"),
    )
  }

  private fun deletePlaces(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PlaceApi.deletePlaces(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("placeIds"),
    )
  }
}
