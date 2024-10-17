package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.TopicBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TopicBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchTopicsBy" -> matchTopicsBy(parameters, resultCallback)
    "matchTopicsBySorted" -> matchTopicsBySorted(parameters, resultCallback)
    "filterTopicsBy" -> filterTopicsBy(parameters, resultCallback)
    "filterTopicsBySorted" -> filterTopicsBySorted(parameters, resultCallback)
    "deleteTopicById" -> deleteTopicById(parameters, resultCallback)
    "deleteTopicsByIds" -> deleteTopicsByIds(parameters, resultCallback)
    "purgeTopicById" -> purgeTopicById(parameters, resultCallback)
    "deleteTopic" -> deleteTopic(parameters, resultCallback)
    "deleteTopics" -> deleteTopics(parameters, resultCallback)
    "purgeTopic" -> purgeTopic(parameters, resultCallback)
    "undeleteTopic" -> undeleteTopic(parameters, resultCallback)
    "modifyTopic" -> modifyTopic(parameters, resultCallback)
    "undeleteTopicById" -> undeleteTopicById(parameters, resultCallback)
    "getTopic" -> getTopic(parameters, resultCallback)
    "getTopics" -> getTopics(parameters, resultCallback)
    "addParticipant" -> addParticipant(parameters, resultCallback)
    "removeParticipant" -> removeParticipant(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.matchTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.matchTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTopicsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.filterTopicsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTopicsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.filterTopicsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.deleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTopicsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.deleteTopicsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.purgeTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.deleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun deleteTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.deleteTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topics"),
    )
  }

  private fun purgeTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.purgeTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun undeleteTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.undeleteTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("topic"),
    )
  }

  private fun modifyTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.modifyTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteTopicById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.undeleteTopicById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getTopic(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.getTopic(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTopics(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.getTopics(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun addParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.addParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
      parameters.getValue("topicRole"),
    )
  }

  private fun removeParticipant(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.removeParticipant(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("dataOwnerId"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TopicBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
