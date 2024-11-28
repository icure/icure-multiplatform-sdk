// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object PermissionApi {
  public fun modifyUserPermissions(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    permissionsString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val permissions = fullLanguageInteropJson.decodeFromString(
      Permission.serializer(),
      permissionsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Permission.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).permission.modifyUserPermissions(
        userId,
        permissions,
      )
    }
  }
}
