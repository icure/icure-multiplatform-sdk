// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object TarificationApi {
  public fun getTarification(
    dartResultCallback: (
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

  public fun findTarificationsByLabel(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    regionString: String,
    typesString: String,
    languageString: String,
    labelString: String,
    startKeyString: String,
    startDocumentIdString: String,
    limitString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    val types = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      typesString
    )
    val language = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      languageString
    )
    val label = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      labelString
    )
    val startKey = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      startKeyString
    )
    val startDocumentId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      startDocumentIdString
    )
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      PaginatedList.serializer(Tarification.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.findTarificationsByLabel(
        region,
        types,
        language,
        label,
        startKey,
        startDocumentId,
        limit,
      )
    }
  }

  public fun findTarificationsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    regionString: String,
    typeString: String,
    tarificationString: String,
    versionString: String,
    startDocumentIdString: String,
    startKeyString: String,
    limitString: String,
  ) {
    val region = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      regionString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      typeString
    )
    val tarification = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tarificationString
    )
    val version = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      versionString
    )
    val startDocumentId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      startDocumentIdString
    )
    val startKey = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      startKeyString
    )
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    ApiScope.execute(
      dartResultCallback,
      PaginatedList.serializer(Tarification.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).tarification.findTarificationsBy(
        region,
        type,
        tarification,
        version,
        startDocumentId,
        startKey,
        limit,
      )
    }
  }

  public fun getTarificationWithParts(
    dartResultCallback: (
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
