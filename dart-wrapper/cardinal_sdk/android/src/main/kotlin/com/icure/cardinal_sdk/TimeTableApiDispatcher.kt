package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.TimeTableApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object TimeTableApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createTimeTable" -> createTimeTable(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "matchTimeTablesBy" -> matchTimeTablesBy(parameters, resultCallback)
    "matchTimeTablesBySorted" -> matchTimeTablesBySorted(parameters, resultCallback)
    "deleteTimeTableById" -> deleteTimeTableById(parameters, resultCallback)
    "deleteTimeTablesByIds" -> deleteTimeTablesByIds(parameters, resultCallback)
    "purgeTimeTableById" -> purgeTimeTableById(parameters, resultCallback)
    "deleteTimeTable" -> deleteTimeTable(parameters, resultCallback)
    "deleteTimeTables" -> deleteTimeTables(parameters, resultCallback)
    "purgeTimeTable" -> purgeTimeTable(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterTimeTablesBy" -> filterTimeTablesBy(parameters, resultCallback)
    "filterTimeTablesBySorted" -> filterTimeTablesBySorted(parameters, resultCallback)
    "undeleteTimeTable" -> undeleteTimeTable(parameters, resultCallback)
    "modifyTimeTable" -> modifyTimeTable(parameters, resultCallback)
    "undeleteTimeTableById" -> undeleteTimeTableById(parameters, resultCallback)
    "getTimeTable" -> getTimeTable(parameters, resultCallback)
    "getTimeTables" -> getTimeTables(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterTimeTablesBy" -> encrypted_filterTimeTablesBy(parameters, resultCallback)
    "encrypted.filterTimeTablesBySorted" -> encrypted_filterTimeTablesBySorted(parameters, resultCallback)
    "encrypted.undeleteTimeTable" -> encrypted_undeleteTimeTable(parameters, resultCallback)
    "encrypted.modifyTimeTable" -> encrypted_modifyTimeTable(parameters, resultCallback)
    "encrypted.undeleteTimeTableById" -> encrypted_undeleteTimeTableById(parameters, resultCallback)
    "encrypted.getTimeTable" -> encrypted_getTimeTable(parameters, resultCallback)
    "encrypted.getTimeTables" -> encrypted_getTimeTables(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterTimeTablesBy" -> tryAndRecover_filterTimeTablesBy(parameters, resultCallback)
    "tryAndRecover.filterTimeTablesBySorted" -> tryAndRecover_filterTimeTablesBySorted(parameters, resultCallback)
    "tryAndRecover.undeleteTimeTable" -> tryAndRecover_undeleteTimeTable(parameters, resultCallback)
    "tryAndRecover.modifyTimeTable" -> tryAndRecover_modifyTimeTable(parameters, resultCallback)
    "tryAndRecover.undeleteTimeTableById" -> tryAndRecover_undeleteTimeTableById(parameters, resultCallback)
    "tryAndRecover.getTimeTable" -> tryAndRecover_getTimeTable(parameters, resultCallback)
    "tryAndRecover.getTimeTables" -> tryAndRecover_getTimeTables(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.createTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("patient"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
      parameters.getValue("secretId"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.createDelegationDeAnonymizationMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
      parameters.getValue("delegates"),
    )
  }

  private fun decrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun matchTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.matchTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchTimeTablesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.matchTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.deleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTimeTablesByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.deleteTimeTablesByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.purgeTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.deleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun deleteTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.deleteTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTables"),
    )
  }

  private fun purgeTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.purgeTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("timeTable"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.filterTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterTimeTablesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.filterTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun undeleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.undeleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun modifyTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.modifyTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.undeleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun getTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.getTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.getTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTableIds"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("timeTable"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.filterTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterTimeTablesBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.filterTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_undeleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.undeleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun encrypted_modifyTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.modifyTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.undeleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_getTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.getTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.encrypted.getTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTableIds"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("timeTable"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterTimeTablesBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.filterTimeTablesBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterTimeTablesBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.filterTimeTablesBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_undeleteTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.undeleteTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTable"),
    )
  }

  private fun tryAndRecover_modifyTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.modifyTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeleteTimeTableById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.undeleteTimeTableById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_getTimeTable(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.getTimeTable(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getTimeTables(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    TimeTableApi.tryAndRecover.getTimeTables(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("timeTableIds"),
    )
  }
}
