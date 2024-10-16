// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object CardinalMaintenanceTaskApi {
  public fun applyKeyPairUpdate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    updateRequestString: String,
  ) {
    val updateRequest = fullLanguageInteropJson.decodeFromString(
      KeyPairUpdateNotification.serializer(),
      updateRequestString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).cardinalMaintenanceTask.applyKeyPairUpdate(
        updateRequest,
      )
    }
  }

  public fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    keyString: String,
    requestToOwnerTypesString: String,
  ) {
    val key = fullLanguageInteropJson.decodeFromString(
      SpkiHexString.serializer(),
      keyString
    )
    val requestToOwnerTypes = fullLanguageInteropJson.decodeFromString(
      SetSerializer(DataOwnerType.serializer()).nullable,
      requestToOwnerTypesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
        key,
        requestToOwnerTypes,
      )
    }
  }

  public fun createKeyPairUpdateNotificationTo(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    dataOwnerIdString: String,
    keyString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      SpkiHexString.serializer(),
      keyString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).cardinalMaintenanceTask.createKeyPairUpdateNotificationTo(
        dataOwnerId,
        key,
      )
    }
  }
}
