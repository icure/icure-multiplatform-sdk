// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.ReceiptBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object ReceiptBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "deleteReceipt" -> deleteReceipt(parameters, resultCallback)
    "deleteReceipts" -> deleteReceipts(parameters, resultCallback)
    "getRawReceiptAttachment" -> getRawReceiptAttachment(parameters, resultCallback)
    "setRawReceiptAttachment" -> setRawReceiptAttachment(parameters, resultCallback)
    "createReceipt" -> createReceipt(parameters, resultCallback)
    "modifyReceipt" -> modifyReceipt(parameters, resultCallback)
    "getReceipt" -> getReceipt(parameters, resultCallback)
    "listByReference" -> listByReference(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun deleteReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.deleteReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun deleteReceipts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.deleteReceipts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getRawReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.getRawReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receiptId"),
      parameters.getValue("attachmentId"),
    )
  }

  private fun setRawReceiptAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.setRawReceiptAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("receiptId"),
      parameters.getValue("rev"),
      parameters.getValue("blobType"),
      parameters.getValue("attachment"),
    )
  }

  private fun createReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.createReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.modifyReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getReceipt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.getReceipt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun listByReference(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    ReceiptBasicApi.listByReference(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("reference"),
    )
  }
}
