// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Role
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer

@OptIn(InternalIcureApi::class)
public object RoleApi {
  public fun getAllRoles(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Role.serializer())) {
      NativeReferences.get<CardinalApis>(sdkId).role.getAllRoles()
    }
  }
}
