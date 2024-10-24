// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

public object KeywordApi {
  public fun getKeyword(
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
      Keyword.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.getKeyword(
        frontEndMigrationId,
      )
    }
  }

  public fun createKeyword(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    frontEndMigrationString: String,
  ) {
    val frontEndMigration = fullLanguageInteropJson.decodeFromString(
      Keyword.serializer(),
      frontEndMigrationString
    )
    ApiScope.execute(
      dartResultCallback,
      Keyword.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.createKeyword(
        frontEndMigration,
      )
    }
  }

  public fun getKeywords(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    startDocumentIdString: String,
    limitString: String,
  ) {
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
      PaginatedList.serializer(Keyword.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.getKeywords(
        startDocumentId,
        limit,
      )
    }
  }

  public fun modifyKeyword(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    keywordString: String,
  ) {
    val keyword = fullLanguageInteropJson.decodeFromString(
      Keyword.serializer(),
      keywordString
    )
    ApiScope.execute(
      dartResultCallback,
      Keyword.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.modifyKeyword(
        keyword,
      )
    }
  }

  public fun getKeywordsByUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Keyword.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.getKeywordsByUser(
        userId,
      )
    }
  }

  public fun deleteKeywords(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    keywordIdsString: String,
  ) {
    val keywordIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      keywordIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).keyword.deleteKeywords(
        keywordIds,
      )
    }
  }
}