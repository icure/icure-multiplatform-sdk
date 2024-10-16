// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Role
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer

public object RoleApi {
  public fun getAllRoles(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Role.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).role.getAllRoles()
    }
  }
}
