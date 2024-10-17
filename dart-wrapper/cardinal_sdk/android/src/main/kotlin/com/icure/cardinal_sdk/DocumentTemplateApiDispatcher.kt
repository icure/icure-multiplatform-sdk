package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.DocumentTemplateApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DocumentTemplateApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getDocumentTemplate" -> getDocumentTemplate(parameters, resultCallback)
    "createDocumentTemplate" -> createDocumentTemplate(parameters, resultCallback)
    "modifyDocumentTemplate" -> modifyDocumentTemplate(parameters, resultCallback)
    "deleteDocumentTemplates" -> deleteDocumentTemplates(parameters, resultCallback)
    "listDocumentTemplatesBySpeciality" -> listDocumentTemplatesBySpeciality(parameters, resultCallback)
    "listDocumentTemplatesByDocumentType" -> listDocumentTemplatesByDocumentType(parameters, resultCallback)
    "listDocumentTemplatesByDocumentTypeForCurrentUser" -> listDocumentTemplatesByDocumentTypeForCurrentUser(parameters, resultCallback)
    "listDocumentTemplates" -> listDocumentTemplates(parameters, resultCallback)
    "findAllDocumentTemplates" -> findAllDocumentTemplates(parameters, resultCallback)
    "getDocumentTemplateAttachment" -> getDocumentTemplateAttachment(parameters, resultCallback)
    "getAttachmentText" -> getAttachmentText(parameters, resultCallback)
    "setDocumentTemplateAttachment" -> setDocumentTemplateAttachment(parameters, resultCallback)
    "getAttachmentUrl" -> getAttachmentUrl(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getDocumentTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.getDocumentTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateId"),
    )
  }

  private fun createDocumentTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.createDocumentTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplate"),
    )
  }

  private fun modifyDocumentTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.modifyDocumentTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplate"),
    )
  }

  private fun deleteDocumentTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.deleteDocumentTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateIds"),
    )
  }

  private fun listDocumentTemplatesBySpeciality(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.listDocumentTemplatesBySpeciality(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("specialityCode"),
    )
  }

  private fun listDocumentTemplatesByDocumentType(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.listDocumentTemplatesByDocumentType(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTypeCode"),
    )
  }

  private fun listDocumentTemplatesByDocumentTypeForCurrentUser(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTypeCode"),
    )
  }

  private fun listDocumentTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.listDocumentTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun findAllDocumentTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.findAllDocumentTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("startKey"),
      parameters.getValue("startDocumentId"),
      parameters.getValue("limit"),
    )
  }

  private fun getDocumentTemplateAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.getDocumentTemplateAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateId"),
      parameters.getValue("attachmentId"),
    )
  }

  private fun getAttachmentText(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.getAttachmentText(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateId"),
      parameters.getValue("attachmentId"),
    )
  }

  private fun setDocumentTemplateAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.setDocumentTemplateAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateId"),
      parameters.getValue("payload"),
    )
  }

  private fun getAttachmentUrl(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentTemplateApi.getAttachmentUrl(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("attachmentId"),
    )
  }
}
