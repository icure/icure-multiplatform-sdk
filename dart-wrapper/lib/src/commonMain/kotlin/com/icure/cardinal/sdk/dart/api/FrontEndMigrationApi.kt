// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.FrontEndMigration
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

public object FrontEndMigrationApi {
  public fun getFrontEndMigration(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationIdString: String,
  ) {
    val frontEndMigrationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      frontEndMigrationIdString
    )
    ApiScope.execute(
      dartResultCallback,
      FrontEndMigration.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.getFrontEndMigration(
        frontEndMigrationId,
      )
    }
  }

  public fun createFrontEndMigration(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationString: String,
  ) {
    val frontEndMigration = fullLanguageInteropJson.decodeFromString(
      FrontEndMigration.serializer(),
      frontEndMigrationString
    )
    ApiScope.execute(
      dartResultCallback,
      FrontEndMigration.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.createFrontEndMigration(
        frontEndMigration,
      )
    }
  }

  public fun getFrontEndMigrations(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(FrontEndMigration.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.getFrontEndMigrations()
    }
  }

  public fun deleteFrontEndMigration(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationIdString: String,
  ) {
    val frontEndMigrationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      frontEndMigrationIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.deleteFrontEndMigration(
        frontEndMigrationId,
      )
    }
  }

  public fun getFrontEndMigrationByName(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationNameString: String,
  ) {
    val frontEndMigrationName = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      frontEndMigrationNameString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(FrontEndMigration.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.getFrontEndMigrationByName(
        frontEndMigrationName,
      )
    }
  }

  public fun modifyFrontEndMigration(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationString: String,
  ) {
    val frontEndMigration = fullLanguageInteropJson.decodeFromString(
      FrontEndMigration.serializer(),
      frontEndMigrationString
    )
    ApiScope.execute(
      dartResultCallback,
      FrontEndMigration.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).frontEndMigration.modifyFrontEndMigration(
        frontEndMigration,
      )
    }
  }
}