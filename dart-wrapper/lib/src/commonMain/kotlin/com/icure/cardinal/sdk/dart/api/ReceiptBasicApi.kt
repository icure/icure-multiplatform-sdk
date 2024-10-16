// auto-generated file
@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

public object ReceiptBasicApi {
  public fun deleteReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.deleteReceipt(
        entityId,
      )
    }
  }

  public fun deleteReceipts(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.deleteReceipts(
        entityIds,
      )
    }
  }

  public fun getRawReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptIdString: String,
    attachmentIdString: String,
  ) {
    val receiptId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      receiptIdString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.getRawReceiptAttachment(
        receiptId,
        attachmentId,
      )
    }
  }

  public fun setRawReceiptAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    receiptIdString: String,
    revString: String,
    blobTypeString: String,
    attachmentString: String,
  ) {
    val receiptId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      receiptIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val blobType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      blobTypeString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedReceipt.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.setRawReceiptAttachment(
        receiptId,
        rev,
        blobType,
        attachment,
      )
    }
  }

  public fun modifyReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedReceipt.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedReceipt.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.modifyReceipt(
        entity,
      )
    }
  }

  public fun getReceipt(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedReceipt.serializer()) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.getReceipt(
        entityId,
      )
    }
  }

  public fun listByReference(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    referenceString: String,
  ) {
    val reference = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      referenceString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedReceipt.serializer())) {
      NativeReferences.get<CardinalBaseSdk>(sdkId).receipt.listByReference(
        reference,
      )
    }
  }
}
