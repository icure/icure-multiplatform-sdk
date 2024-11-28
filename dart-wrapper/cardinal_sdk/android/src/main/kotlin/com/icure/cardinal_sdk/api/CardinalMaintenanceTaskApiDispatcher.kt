// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.CardinalMaintenanceTaskApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CardinalMaintenanceTaskApiDispatcher {
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
    "applyKeyPairUpdate" -> applyKeyPairUpdate(parameters, resultCallback)
    "createKeyPairUpdateNotificationsToAllDelegationCounterparts" -> createKeyPairUpdateNotificationsToAllDelegationCounterparts(parameters, resultCallback)
    "createKeyPairUpdateNotificationTo" -> createKeyPairUpdateNotificationTo(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun applyKeyPairUpdate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CardinalMaintenanceTaskApi.applyKeyPairUpdate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("updateRequest"),
    )
  }

  private
      fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CardinalMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("key"),
      parameters.getValue("requestToOwnerTypes"),
    )
  }

  private fun createKeyPairUpdateNotificationTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    CardinalMaintenanceTaskApi.createKeyPairUpdateNotificationTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("dataOwnerId"),
      parameters.getValue("key"),
    )
  }
}
