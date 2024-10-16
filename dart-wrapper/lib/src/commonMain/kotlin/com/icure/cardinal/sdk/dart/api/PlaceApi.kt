// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Place
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

public object PlaceApi {
  public fun getPlace(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    placeIdString: String,
  ) {
    val placeId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      placeIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Place.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).place.getPlace(
        placeId,
      )
    }
  }

  public fun createPlace(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    placeString: String,
  ) {
    val place = fullLanguageInteropJson.decodeFromString(
      Place.serializer(),
      placeString
    )
    ApiScope.execute(
      dartResultCallback,
      Place.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).place.createPlace(
        place,
      )
    }
  }

  public fun modifyPlace(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    placeString: String,
  ) {
    val place = fullLanguageInteropJson.decodeFromString(
      Place.serializer(),
      placeString
    )
    ApiScope.execute(
      dartResultCallback,
      Place.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).place.modifyPlace(
        place,
      )
    }
  }

  public fun deletePlaces(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    placeIdsString: String,
  ) {
    val placeIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      placeIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).place.deletePlaces(
        placeIds,
      )
    }
  }

  public fun getPlaces(
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
      PaginatedList.serializer(Place.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).place.getPlaces(
        startDocumentId,
        limit,
      )
    }
  }
}
