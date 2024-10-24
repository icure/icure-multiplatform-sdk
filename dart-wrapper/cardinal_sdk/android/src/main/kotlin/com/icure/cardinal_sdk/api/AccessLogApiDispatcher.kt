// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.AccessLogApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object AccessLogApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createAccessLog" -> createAccessLog(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "matchAccessLogsBy" -> matchAccessLogsBy(parameters, resultCallback)
    "matchAccessLogsBySorted" -> matchAccessLogsBySorted(parameters, resultCallback)
    "deleteAccessLogById" -> deleteAccessLogById(parameters, resultCallback)
    "deleteAccessLogsByIds" -> deleteAccessLogsByIds(parameters, resultCallback)
    "purgeAccessLogById" -> purgeAccessLogById(parameters, resultCallback)
    "deleteAccessLog" -> deleteAccessLog(parameters, resultCallback)
    "deleteAccessLogs" -> deleteAccessLogs(parameters, resultCallback)
    "purgeAccessLog" -> purgeAccessLog(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterAccessLogsBy" -> filterAccessLogsBy(parameters, resultCallback)
    "filterAccessLogsBySorted" -> filterAccessLogsBySorted(parameters, resultCallback)
    "undeleteAccessLogById" -> undeleteAccessLogById(parameters, resultCallback)
    "undeleteAccessLog" -> undeleteAccessLog(parameters, resultCallback)
    "modifyAccessLog" -> modifyAccessLog(parameters, resultCallback)
    "getAccessLog" -> getAccessLog(parameters, resultCallback)
    "getAccessLogs" -> getAccessLogs(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterAccessLogsBy" -> encrypted_filterAccessLogsBy(parameters, resultCallback)
    "encrypted.filterAccessLogsBySorted" -> encrypted_filterAccessLogsBySorted(parameters, resultCallback)
    "encrypted.undeleteAccessLogById" -> encrypted_undeleteAccessLogById(parameters, resultCallback)
    "encrypted.undeleteAccessLog" -> encrypted_undeleteAccessLog(parameters, resultCallback)
    "encrypted.modifyAccessLog" -> encrypted_modifyAccessLog(parameters, resultCallback)
    "encrypted.getAccessLog" -> encrypted_getAccessLog(parameters, resultCallback)
    "encrypted.getAccessLogs" -> encrypted_getAccessLogs(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterAccessLogsBy" -> tryAndRecover_filterAccessLogsBy(parameters, resultCallback)
    "tryAndRecover.filterAccessLogsBySorted" -> tryAndRecover_filterAccessLogsBySorted(parameters, resultCallback)
    "tryAndRecover.undeleteAccessLogById" -> tryAndRecover_undeleteAccessLogById(parameters, resultCallback)
    "tryAndRecover.undeleteAccessLog" -> tryAndRecover_undeleteAccessLog(parameters, resultCallback)
    "tryAndRecover.modifyAccessLog" -> tryAndRecover_modifyAccessLog(parameters, resultCallback)
    "tryAndRecover.getAccessLog" -> tryAndRecover_getAccessLog(parameters, resultCallback)
    "tryAndRecover.getAccessLogs" -> tryAndRecover_getAccessLogs(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.createAccessLog(
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
    AccessLogApi.withEncryptionMetadata(
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
    AccessLogApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.createDelegationDeAnonymizationMetadata(
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
    AccessLogApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun matchAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.matchAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.matchAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.deleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAccessLogsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.deleteAccessLogsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.purgeAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.deleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun deleteAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.deleteAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLogs"),
    )
  }

  private fun purgeAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.purgeAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("accessLog"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.filterAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.filterAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun undeleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.undeleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.undeleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun modifyAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.modifyAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun getAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.getAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.getAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("accessLog"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.filterAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterAccessLogsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.filterAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_undeleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.undeleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.undeleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun encrypted_modifyAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.modifyAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_getAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.getAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.encrypted.getAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("accessLog"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterAccessLogsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.filterAccessLogsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterAccessLogsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.filterAccessLogsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_undeleteAccessLogById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.undeleteAccessLogById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.undeleteAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("accessLog"),
    )
  }

  private fun tryAndRecover_modifyAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.modifyAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_getAccessLog(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.getAccessLog(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getAccessLogs(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    AccessLogApi.tryAndRecover.getAccessLogs(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
