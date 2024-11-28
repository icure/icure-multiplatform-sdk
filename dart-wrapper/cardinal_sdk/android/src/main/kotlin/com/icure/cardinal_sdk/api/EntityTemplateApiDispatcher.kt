// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.EntityTemplateApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object EntityTemplateApiDispatcher {
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
    "getEntityTemplate" -> getEntityTemplate(parameters, resultCallback)
    "createEntityTemplate" -> createEntityTemplate(parameters, resultCallback)
    "modifyEntityTemplate" -> modifyEntityTemplate(parameters, resultCallback)
    "listEntityTemplatesBy" -> listEntityTemplatesBy(parameters, resultCallback)
    "listAllEntityTemplatesBy" -> listAllEntityTemplatesBy(parameters, resultCallback)
    "listEntityTemplatesByKeyword" -> listEntityTemplatesByKeyword(parameters, resultCallback)
    "findAllEntityTemplatesByKeyword" -> findAllEntityTemplatesByKeyword(parameters, resultCallback)
    "getEntityTemplates" -> getEntityTemplates(parameters, resultCallback)
    "modifyEntityTemplates" -> modifyEntityTemplates(parameters, resultCallback)
    "createEntityTemplates" -> createEntityTemplates(parameters, resultCallback)
    "deleteEntityTemplates" -> deleteEntityTemplates(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getEntityTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.getEntityTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplateId"),
    )
  }

  private fun createEntityTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.createEntityTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("applicationSettings"),
    )
  }

  private fun modifyEntityTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.modifyEntityTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("documentTemplate"),
    )
  }

  private fun listEntityTemplatesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.listEntityTemplatesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("searchString"),
      parameters.getValue("includeEntities"),
    )
  }

  private fun listAllEntityTemplatesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.listAllEntityTemplatesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("searchString"),
      parameters.getValue("includeEntities"),
    )
  }

  private fun listEntityTemplatesByKeyword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.listEntityTemplatesByKeyword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("type"),
      parameters.getValue("keyword"),
      parameters.getValue("includeEntities"),
    )
  }

  private fun findAllEntityTemplatesByKeyword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.findAllEntityTemplatesByKeyword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("keyword"),
      parameters.getValue("includeEntities"),
    )
  }

  private fun getEntityTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.getEntityTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityTemplateIds"),
    )
  }

  private fun modifyEntityTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.modifyEntityTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityTemplates"),
    )
  }

  private fun createEntityTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.createEntityTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityTemplates"),
    )
  }

  private fun deleteEntityTemplates(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    EntityTemplateApi.deleteEntityTemplates(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityTemplateIds"),
    )
  }
}
