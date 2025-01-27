// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.RoleApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object RoleApiDispatcher {
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
    "getAllRoles" -> getAllRoles(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getAllRoles(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    RoleApi.getAllRoles(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }
}
