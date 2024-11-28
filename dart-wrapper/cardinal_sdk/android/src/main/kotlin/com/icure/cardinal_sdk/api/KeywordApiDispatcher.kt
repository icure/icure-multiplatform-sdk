// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.KeywordApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object KeywordApiDispatcher {
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
    "getKeyword" -> getKeyword(parameters, resultCallback)
    "createKeyword" -> createKeyword(parameters, resultCallback)
    "modifyKeyword" -> modifyKeyword(parameters, resultCallback)
    "getKeywordsByUser" -> getKeywordsByUser(parameters, resultCallback)
    "deleteKeywords" -> deleteKeywords(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getKeyword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    KeywordApi.getKeyword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigrationId"),
    )
  }

  private fun createKeyword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    KeywordApi.createKeyword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigration"),
    )
  }

  private fun modifyKeyword(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    KeywordApi.modifyKeyword(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("keyword"),
    )
  }

  private fun getKeywordsByUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    KeywordApi.getKeywordsByUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
    )
  }

  private fun deleteKeywords(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    KeywordApi.deleteKeywords(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("keywordIds"),
    )
  }
}
