// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.DocumentTemplate
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object DocumentTemplateApi {
  public fun getDocumentTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdString: String,
  ) {
    val documentTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTemplateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocumentTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.getDocumentTemplate(
        documentTemplateId,
      )
    }
  }

  public fun createDocumentTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateString: String,
  ) {
    val documentTemplate = fullLanguageInteropJson.decodeFromString(
      DocumentTemplate.serializer(),
      documentTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      DocumentTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.createDocumentTemplate(
        documentTemplate,
      )
    }
  }

  public fun modifyDocumentTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateString: String,
  ) {
    val documentTemplate = fullLanguageInteropJson.decodeFromString(
      DocumentTemplate.serializer(),
      documentTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      DocumentTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.modifyDocumentTemplate(
        documentTemplate,
      )
    }
  }

  public fun deleteDocumentTemplates(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdsString: String,
  ) {
    val documentTemplateIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      documentTemplateIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.deleteDocumentTemplates(
        documentTemplateIds,
      )
    }
  }

  public fun listDocumentTemplatesBySpeciality(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    specialityCodeString: String,
  ) {
    val specialityCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      specialityCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocumentTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.listDocumentTemplatesBySpeciality(
        specialityCode,
      )
    }
  }

  public fun listDocumentTemplatesByDocumentType(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTypeCodeString: String,
  ) {
    val documentTypeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTypeCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocumentTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.listDocumentTemplatesByDocumentType(
        documentTypeCode,
      )
    }
  }

  public fun listDocumentTemplatesByDocumentTypeForCurrentUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTypeCodeString: String,
  ) {
    val documentTypeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTypeCodeString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocumentTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.listDocumentTemplatesByDocumentTypeForCurrentUser(
        documentTypeCode,
      )
    }
  }

  public fun listDocumentTemplates(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocumentTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.listDocumentTemplates()
    }
  }

  public fun getDocumentTemplateAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdString: String,
    attachmentIdString: String,
  ) {
    val documentTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTemplateIdString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.getDocumentTemplateAttachment(
        documentTemplateId,
        attachmentId,
      )
    }
  }

  public fun getAttachmentText(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdString: String,
    attachmentIdString: String,
  ) {
    val documentTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTemplateIdString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ByteArraySerializer) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.getAttachmentText(
        documentTemplateId,
        attachmentId,
      )
    }
  }

  public fun setDocumentTemplateAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdString: String,
    payloadString: String,
  ) {
    val documentTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTemplateIdString
    )
    val payload = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      payloadString
    )
    ApiScope.execute(
      dartResultCallback,
      DocumentTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.setDocumentTemplateAttachment(
        documentTemplateId,
        payload,
      )
    }
  }

  public fun getAttachmentUrl(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentIdString: String,
    attachmentIdString: String,
  ) {
    val documentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentIdString
    )
    val attachmentId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      attachmentIdString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).documentTemplate.getAttachmentUrl(
        documentId,
        attachmentId,
      )
    }
  }
}
