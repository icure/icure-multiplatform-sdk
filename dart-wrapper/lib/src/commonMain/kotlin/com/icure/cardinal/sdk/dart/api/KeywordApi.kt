// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object KeywordApi {
  public fun getKeyword(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).keyword.getKeyword(
        frontEndMigrationId,
      )
    }
  }

  public fun createKeyword(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).keyword.createKeyword(
        frontEndMigration,
      )
    }
  }

  public fun modifyKeyword(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).keyword.modifyKeyword(
        keyword,
      )
    }
  }

  public fun getKeywordsByUser(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).keyword.getKeywordsByUser(
        userId,
      )
    }
  }

  public fun deleteKeywords(
    dartResultCallback: (
      String?,
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).keyword.deleteKeywords(
        keywordIds,
      )
    }
  }
}
