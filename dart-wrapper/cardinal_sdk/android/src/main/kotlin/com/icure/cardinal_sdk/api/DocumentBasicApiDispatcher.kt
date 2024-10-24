// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.DocumentBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object DocumentBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchDocumentsBy" -> matchDocumentsBy(parameters, resultCallback)
    "matchDocumentsBySorted" -> matchDocumentsBySorted(parameters, resultCallback)
    "filterDocumentsBy" -> filterDocumentsBy(parameters, resultCallback)
    "filterDocumentsBySorted" -> filterDocumentsBySorted(parameters, resultCallback)
    "deleteDocumentById" -> deleteDocumentById(parameters, resultCallback)
    "deleteDocumentsByIds" -> deleteDocumentsByIds(parameters, resultCallback)
    "purgeDocumentById" -> purgeDocumentById(parameters, resultCallback)
    "deleteDocument" -> deleteDocument(parameters, resultCallback)
    "deleteDocuments" -> deleteDocuments(parameters, resultCallback)
    "purgeDocument" -> purgeDocument(parameters, resultCallback)
    "getRawMainAttachment" -> getRawMainAttachment(parameters, resultCallback)
    "getRawSecondaryAttachment" -> getRawSecondaryAttachment(parameters, resultCallback)
    "setRawMainAttachment" -> setRawMainAttachment(parameters, resultCallback)
    "setRawSecondaryAttachment" -> setRawSecondaryAttachment(parameters, resultCallback)
    "deleteMainAttachment" -> deleteMainAttachment(parameters, resultCallback)
    "deleteSecondaryAttachment" -> deleteSecondaryAttachment(parameters, resultCallback)
    "undeleteDocumentById" -> undeleteDocumentById(parameters, resultCallback)
    "undeleteDocument" -> undeleteDocument(parameters, resultCallback)
    "modifyDocument" -> modifyDocument(parameters, resultCallback)
    "getDocument" -> getDocument(parameters, resultCallback)
    "getDocuments" -> getDocuments(parameters, resultCallback)
    "modifyDocuments" -> modifyDocuments(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.matchDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchDocumentsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.matchDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterDocumentsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.filterDocumentsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterDocumentsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.filterDocumentsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDocumentsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteDocumentsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.purgeDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun deleteDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documents"),
    )
  }

  private fun purgeDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.purgeDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun getRawMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.getRawMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
    )
  }

  private fun getRawSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.getRawSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
    )
  }

  private fun setRawMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.setRawMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("rev"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
      parameters.getValue("encrypted"),
    )
  }

  private fun setRawSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.setRawSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
      parameters.getValue("rev"),
      parameters.getValue("utis"),
      parameters.getValue("attachment"),
      parameters.getValue("encrypted"),
    )
  }

  private fun deleteMainAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteMainAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteSecondaryAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.deleteSecondaryAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentId"),
      parameters.getValue("key"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteDocumentById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.undeleteDocumentById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.undeleteDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("document"),
    )
  }

  private fun modifyDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.modifyDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getDocument(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.getDocument(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.getDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun modifyDocuments(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DocumentBasicApi.modifyDocuments(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }
}
