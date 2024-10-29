// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.FrontEndMigrationApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object FrontEndMigrationApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getFrontEndMigration" -> getFrontEndMigration(parameters, resultCallback)
    "createFrontEndMigration" -> createFrontEndMigration(parameters, resultCallback)
    "getFrontEndMigrations" -> getFrontEndMigrations(parameters, resultCallback)
    "deleteFrontEndMigration" -> deleteFrontEndMigration(parameters, resultCallback)
    "getFrontEndMigrationByName" -> getFrontEndMigrationByName(parameters, resultCallback)
    "modifyFrontEndMigration" -> modifyFrontEndMigration(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getFrontEndMigration(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.getFrontEndMigration(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigrationId"),
    )
  }

  private fun createFrontEndMigration(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.createFrontEndMigration(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigration"),
    )
  }

  private fun getFrontEndMigrations(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.getFrontEndMigrations(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun deleteFrontEndMigration(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.deleteFrontEndMigration(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigrationId"),
    )
  }

  private fun getFrontEndMigrationByName(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.getFrontEndMigrationByName(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigrationName"),
    )
  }

  private fun modifyFrontEndMigration(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    FrontEndMigrationApi.modifyFrontEndMigration(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("frontEndMigration"),
    )
  }
}
