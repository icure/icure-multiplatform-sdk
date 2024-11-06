// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.CodeApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object CodeApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "listCodesByRegionTypeCodeVersion" -> listCodesByRegionTypeCodeVersion(parameters, resultCallback)
    "listCodeTypesBy" -> listCodeTypesBy(parameters, resultCallback)
    "listTagTypesBy" -> listTagTypesBy(parameters, resultCallback)
    "createCode" -> createCode(parameters, resultCallback)
    "createCodes" -> createCodes(parameters, resultCallback)
    "createCodesInGroup" -> createCodesInGroup(parameters, resultCallback)
    "isCodeValid" -> isCodeValid(parameters, resultCallback)
    "getCodeByRegionLanguageTypeLabel" -> getCodeByRegionLanguageTypeLabel(parameters, resultCallback)
    "getCodes" -> getCodes(parameters, resultCallback)
    "getCodesInGroup" -> getCodesInGroup(parameters, resultCallback)
    "getCode" -> getCode(parameters, resultCallback)
    "getCodeWithParts" -> getCodeWithParts(parameters, resultCallback)
    "modifyCode" -> modifyCode(parameters, resultCallback)
    "modifyCodes" -> modifyCodes(parameters, resultCallback)
    "modifyCodesInGroup" -> modifyCodesInGroup(parameters, resultCallback)
    "filterCodesBy" -> filterCodesBy(parameters, resultCallback)
    "filterCodesBySorted" -> filterCodesBySorted(parameters, resultCallback)
    "matchCodesBy" -> matchCodesBy(parameters, resultCallback)
    "matchCodesBySorted" -> matchCodesBySorted(parameters, resultCallback)
    "importCodes" -> importCodes(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun listCodesByRegionTypeCodeVersion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.listCodesByRegionTypeCodeVersion(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("region"),
      parameters.getValue("type"),
      parameters.getValue("code"),
      parameters.getValue("version"),
    )
  }

  private fun listCodeTypesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.listCodeTypesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("region"),
      parameters.getValue("type"),
    )
  }

  private fun listTagTypesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.listTagTypesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("region"),
      parameters.getValue("type"),
    )
  }

  private fun createCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.createCode(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("c"),
    )
  }

  private fun createCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.createCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeBatch"),
    )
  }

  private fun createCodesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.createCodesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("codeBatch"),
    )
  }

  private fun isCodeValid(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.isCodeValid(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("code"),
      parameters.getValue("version"),
    )
  }

  private fun getCodeByRegionLanguageTypeLabel(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.getCodeByRegionLanguageTypeLabel(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("region"),
      parameters.getValue("label"),
      parameters.getValue("type"),
      parameters.getValue("languages"),
    )
  }

  private fun getCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.getCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeIds"),
    )
  }

  private fun getCodesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.getCodesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("codeIds"),
    )
  }

  private fun getCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.getCode(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeId"),
    )
  }

  private fun getCodeWithParts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.getCodeWithParts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("type"),
      parameters.getValue("code"),
      parameters.getValue("version"),
    )
  }

  private fun modifyCode(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.modifyCode(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeDto"),
    )
  }

  private fun modifyCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.modifyCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeBatch"),
    )
  }

  private fun modifyCodesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.modifyCodesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("codeBatch"),
    )
  }

  private fun filterCodesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.filterCodesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterCodesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.filterCodesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchCodesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.matchCodesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchCodesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.matchCodesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun importCodes(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    CodeApi.importCodes(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("codeType"),
    )
  }
}
