// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.serialization.MapAsArraySerializer
import com.icure.cardinal.sdk.serialization.Pkcs8BytesAsBase64Serializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object CryptoApi {
  public fun forceReload(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.forceReload()
    }
  }

  public fun currentDataOwnerKeys(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterTrustedKeysString: String,
  ) {
    val filterTrustedKeys = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      filterTrustedKeysString
    )
    ApiScope.execute(
      dartResultCallback,
      MapSerializer(String.serializer(),
          MapAsArraySerializer(KeypairFingerprintV1String.serializer(),
          Pkcs8BytesAsBase64Serializer))) {
      NativeReferences.get<CardinalApis>(sdkId).crypto.currentDataOwnerKeys(
        filterTrustedKeys,
      )
    }
  }
}
