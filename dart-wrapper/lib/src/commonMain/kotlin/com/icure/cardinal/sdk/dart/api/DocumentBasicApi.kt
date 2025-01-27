// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object DocumentBasicApi {
  public fun matchDocumentsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.matchDocumentsBy(
        filter,
      )
    }
  }

  public fun matchDocumentsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.matchDocumentsBySorted(
        filter,
      )
    }
  }

  public fun filterDocumentsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).document.filterDocumentsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedDocument.serializer()
      ))
    }
  }

  public fun filterDocumentsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Document::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalBaseApis>(sdkId).document.filterDocumentsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedDocument.serializer()
      ))
    }
  }

  public fun deleteDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteDocumentById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteDocumentsByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteDocumentsByIds(
        entityIds,
      )
    }
  }

  public fun purgeDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.purgeDocumentById(
        id,
        rev,
      )
    }
  }

  public fun deleteDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteDocument(
        document,
      )
    }
  }

  public fun deleteDocuments(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentsString: String,
  ) {
    val documents = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Document::class)),
      documentsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteDocuments(
        documents,
      )
    }
  }

  public fun purgeDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.purgeDocument(
        document,
      )
    }
  }

  public fun getRawMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.getRawMainAttachment(
        documentId,
      )
    }
  }

  public fun getRawSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.getRawSecondaryAttachment(
        documentId,
        key,
      )
    }
  }

  public fun setRawMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    revString: String,
    utisString: String,
    attachmentString: String,
    encryptedString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    val encrypted = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      encryptedString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.setRawMainAttachment(
        documentId,
        rev,
        utis,
        attachment,
        encrypted,
      )
    }
  }

  public fun setRawSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
    revString: String,
    utisString: String,
    attachmentString: String,
    encryptedString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val utis = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()).nullable,
      utisString
    )
    val attachment = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      attachmentString
    )
    val encrypted = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      encryptedString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.setRawSecondaryAttachment(
        documentId,
        key,
        rev,
        utis,
        attachment,
        encrypted,
      )
    }
  }

  public fun deleteMainAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteMainAttachment(
        entityId,
        rev,
      )
    }
  }

  public fun deleteSecondaryAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    keyString: String,
    revString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.deleteSecondaryAttachment(
        documentId,
        key,
        rev,
      )
    }
  }

  public fun undeleteDocumentById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.undeleteDocumentById(
        id,
        rev,
      )
    }
  }

  public fun undeleteDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentString: String,
  ) {
    val document = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Document::class),
      documentString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.undeleteDocument(
        document,
      )
    }
  }

  public fun modifyDocument(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedDocument.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.modifyDocument(
        entity,
      )
    }
  }

  public fun getDocument(
    dartResultCallback: (
      String?,
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
      EncryptedDocument.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.getDocument(
        entityId,
      )
    }
  }

  public fun getDocuments(
    dartResultCallback: (
      String?,
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
      ListSerializer(EncryptedDocument.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.getDocuments(
        entityIds,
      )
    }
  }

  public fun modifyDocuments(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entitiesString: String,
  ) {
    val entities = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedDocument.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedDocument.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).document.modifyDocuments(
        entities,
      )
    }
  }
}
