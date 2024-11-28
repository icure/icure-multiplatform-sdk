// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.serialization.CryptoActorAsStubDeserializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object ShamirKeysManagerApi {
  public fun getExistingSplitsInfo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    dataOwnerString: String,
  ) {
    val dataOwner = fullLanguageInteropJson.decodeFromString(
      CryptoActorAsStubDeserializer,
      dataOwnerString
    )
    ApiScope.execute(
      dartResultCallback,
      MapSerializer(KeypairFingerprintV1String.serializer(), SetSerializer(String.serializer()))) {
      NativeReferences.get<CardinalSdk>(sdkId).crypto.shamirKeysManager.getExistingSplitsInfo(
        dataOwner,
      )
    }
  }

  public fun updateSelfSplits(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    keySplitsToUpdateString: String,
    keySplitsToDeleteString: String,
  ) {
    val keySplitsToUpdate = fullLanguageInteropJson.decodeFromString(
      MapSerializer(KeypairFingerprintV1String.serializer(), ShamirUpdateRequest.serializer()),
      keySplitsToUpdateString
    )
    val keySplitsToDelete = fullLanguageInteropJson.decodeFromString(
      SetSerializer(KeypairFingerprintV1String.serializer()),
      keySplitsToDeleteString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).crypto.shamirKeysManager.updateSelfSplits(
        keySplitsToUpdate,
        keySplitsToDelete,
      )
    }
  }
}
