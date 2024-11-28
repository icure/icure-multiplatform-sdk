// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.MessageBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MessageBasicApiDispatcher {
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
    "matchMessagesBy" -> matchMessagesBy(parameters, resultCallback)
    "matchMessagesBySorted" -> matchMessagesBySorted(parameters, resultCallback)
    "filterMessagesBy" -> filterMessagesBy(parameters, resultCallback)
    "filterMessagesBySorted" -> filterMessagesBySorted(parameters, resultCallback)
    "deleteMessageById" -> deleteMessageById(parameters, resultCallback)
    "deleteMessagesByIds" -> deleteMessagesByIds(parameters, resultCallback)
    "purgeMessageById" -> purgeMessageById(parameters, resultCallback)
    "deleteMessage" -> deleteMessage(parameters, resultCallback)
    "deleteMessages" -> deleteMessages(parameters, resultCallback)
    "purgeMessage" -> purgeMessage(parameters, resultCallback)
    "undeleteMessage" -> undeleteMessage(parameters, resultCallback)
    "modifyMessage" -> modifyMessage(parameters, resultCallback)
    "undeleteMessageById" -> undeleteMessageById(parameters, resultCallback)
    "getMessage" -> getMessage(parameters, resultCallback)
    "getMessages" -> getMessages(parameters, resultCallback)
    "setMessagesReadStatus" -> setMessagesReadStatus(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.matchMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchMessagesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.matchMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMessagesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.filterMessagesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMessagesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.filterMessagesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.deleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMessagesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.deleteMessagesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.purgeMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.deleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun deleteMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.deleteMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("messages"),
    )
  }

  private fun purgeMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.purgeMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun undeleteMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.undeleteMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("message"),
    )
  }

  private fun modifyMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.modifyMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteMessageById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.undeleteMessageById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getMessage(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.getMessage(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getMessages(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.getMessages(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun setMessagesReadStatus(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.setMessagesReadStatus(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
      parameters.getValue("time"),
      parameters.getValue("readStatus"),
      parameters.getValue("userId"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    MessageBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
