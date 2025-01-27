// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EntityReference
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object EntityReferenceApi {
  public fun getLatest(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    prefixString: String,
  ) {
    val prefix = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      prefixString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityReference.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).entityReference.getLatest(
        prefix,
      )
    }
  }

  public fun createEntityReference(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityReferenceString: String,
  ) {
    val entityReference = fullLanguageInteropJson.decodeFromString(
      EntityReference.serializer(),
      entityReferenceString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityReference.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).entityReference.createEntityReference(
        entityReference,
      )
    }
  }
}
