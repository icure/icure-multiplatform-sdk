package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.FormBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object FormBasicApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "matchFormsBy" -> matchFormsBy(parameters, resultCallback)
    "matchFormsBySorted" -> matchFormsBySorted(parameters, resultCallback)
    "filterFormsBy" -> filterFormsBy(parameters, resultCallback)
    "filterFormsBySorted" -> filterFormsBySorted(parameters, resultCallback)
    "deleteFormById" -> deleteFormById(parameters, resultCallback)
    "deleteFormsByIds" -> deleteFormsByIds(parameters, resultCallback)
    "purgeFormById" -> purgeFormById(parameters, resultCallback)
    "deleteForm" -> deleteForm(parameters, resultCallback)
    "deleteForms" -> deleteForms(parameters, resultCallback)
    "purgeForm" -> purgeForm(parameters, resultCallback)
    "getFormTemplate" -> getFormTemplate(parameters, resultCallback)
    "createFormTemplate" -> createFormTemplate(parameters, resultCallback)
    "deleteFormTemplate" -> deleteFormTemplate(parameters, resultCallback)
    "updateFormTemplate" -> updateFormTemplate(parameters, resultCallback)
    "setTemplateAttachment" -> setTemplateAttachment(parameters, resultCallback)
    "modifyForm" -> modifyForm(parameters, resultCallback)
    "undeleteFormById" -> undeleteFormById(parameters, resultCallback)
    "undeleteForm" -> undeleteForm(parameters, resultCallback)
    "modifyForms" -> modifyForms(parameters, resultCallback)
    "getForm" -> getForm(parameters, resultCallback)
    "getForms" -> getForms(parameters, resultCallback)
    "getLatestFormByLogicalUuid" -> getLatestFormByLogicalUuid(parameters, resultCallback)
    "getLatestFormByUniqueId" -> getLatestFormByUniqueId(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.matchFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.matchFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterFormsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.filterFormsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterFormsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.filterFormsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.deleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteFormsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.deleteFormsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.purgeFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.deleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun deleteForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.deleteForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("forms"),
    )
  }

  private fun purgeForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.purgeForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun getFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.getFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
      parameters.getValue("raw"),
    )
  }

  private fun createFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.createFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplate"),
    )
  }

  private fun deleteFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.deleteFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
    )
  }

  private fun updateFormTemplate(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.updateFormTemplate(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplate"),
    )
  }

  private fun setTemplateAttachment(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.setTemplateAttachment(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("formTemplateId"),
      parameters.getValue("payload"),
    )
  }

  private fun modifyForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.modifyForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteFormById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.undeleteFormById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.undeleteForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("form"),
    )
  }

  private fun modifyForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.modifyForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getForm(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.getForm(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getForms(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.getForms(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun getLatestFormByLogicalUuid(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.getLatestFormByLogicalUuid(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("logicalUuid"),
    )
  }

  private fun getLatestFormByUniqueId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FormBasicApi.getLatestFormByUniqueId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("uniqueId"),
    )
  }
}
