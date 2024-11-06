// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.PermissionApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PermissionApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "modifyUserPermissions" -> modifyUserPermissions(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun modifyUserPermissions(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PermissionApi.modifyUserPermissions(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("permissions"),
    )
  }
}
