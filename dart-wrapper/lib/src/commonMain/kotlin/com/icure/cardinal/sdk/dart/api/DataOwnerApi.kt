// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

public object DataOwnerApi {
  public fun getCurrentDataOwner(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      DataOwnerWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwner()
    }
  }

  public fun getCurrentDataOwnerStub(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerStub()
    }
  }

  public fun getCurrentDataOwnerId(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerId()
    }
  }

  public fun getCurrentDataOwnerHierarchyIds(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerHierarchyIds()
    }
  }

  public fun getDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    ownerIdString: String,
  ) {
    val ownerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      ownerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DataOwnerWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getDataOwner(
        ownerId,
      )
    }
  }

  public fun getCryptoActorStub(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    ownerIdString: String,
  ) {
    val ownerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      ownerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCryptoActorStub(
        ownerId,
      )
    }
  }

  public fun getCurrentDataOwnerHierarchyIdsFrom(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    parentIdString: String,
  ) {
    val parentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      parentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerHierarchyIdsFrom(
        parentId,
      )
    }
  }

  public fun getCurrentDataOwnerHierarchy(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DataOwnerWithType.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerHierarchy()
    }
  }

  public fun modifyDataOwnerStub(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    cryptoActorStubWithTypeDtoString: String,
  ) {
    val cryptoActorStubWithTypeDto = fullLanguageInteropJson.decodeFromString(
      CryptoActorStubWithType.serializer(),
      cryptoActorStubWithTypeDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      CryptoActorStubWithType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.modifyDataOwnerStub(
        cryptoActorStubWithTypeDto,
      )
    }
  }

  public fun getCurrentDataOwnerType(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      DataOwnerType.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.getCurrentDataOwnerType()
    }
  }

  public fun clearCurrentDataOwnerIdsCache(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).dataOwner.clearCurrentDataOwnerIdsCache()
    }
  }
}
