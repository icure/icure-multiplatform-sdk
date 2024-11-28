// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object TarificationApi {
  public fun getTarification(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    tarificationIdString: String,
  ) {
    val tarificationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tarificationIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Tarification.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.getTarification(
        tarificationId,
      )
    }
  }

  public fun createTarification(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    tarificationString: String,
  ) {
    val tarification = fullLanguageInteropJson.decodeFromString(
      Tarification.serializer(),
      tarificationString
    )
    ApiScope.execute(
      dartResultCallback,
      Tarification.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.createTarification(
        tarification,
      )
    }
  }

  public fun getTarifications(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    tarificationIdsString: String,
  ) {
    val tarificationIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      tarificationIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Tarification.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.getTarifications(
        tarificationIds,
      )
    }
  }

  public fun modifyTarification(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    tarificationString: String,
  ) {
    val tarification = fullLanguageInteropJson.decodeFromString(
      Tarification.serializer(),
      tarificationString
    )
    ApiScope.execute(
      dartResultCallback,
      Tarification.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.modifyTarification(
        tarification,
      )
    }
  }

  public fun getTarificationWithParts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    tarificationString: String,
    versionString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val tarification = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tarificationString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      versionString
    )
    ApiScope.execute(
      dartResultCallback,
      Tarification.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.getTarificationWithParts(
        type,
        tarification,
        version,
      )
    }
  }
}
