// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.SystemApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object SystemApiDispatcher {
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
    "getVersion" -> getVersion(parameters, resultCallback)
    "isReady" -> isReady(parameters, resultCallback)
    "getProcessInfo" -> getProcessInfo(parameters, resultCallback)
    "getIndexingInfo" -> getIndexingInfo(parameters, resultCallback)
    "getReplicationInfo" -> getReplicationInfo(parameters, resultCallback)
    "updateDesignDoc" -> updateDesignDoc(parameters, resultCallback)
    "resolvePatientsConflicts" -> resolvePatientsConflicts(parameters, resultCallback)
    "resolveContactsConflicts" -> resolveContactsConflicts(parameters, resultCallback)
    "resolveFormsConflicts" -> resolveFormsConflicts(parameters, resultCallback)
    "resolveHealthElementsConflicts" -> resolveHealthElementsConflicts(parameters, resultCallback)
    "resolveInvoicesConflicts" -> resolveInvoicesConflicts(parameters, resultCallback)
    "resolveMessagesConflicts" -> resolveMessagesConflicts(parameters, resultCallback)
    "resolveDocumentsConflicts" -> resolveDocumentsConflicts(parameters, resultCallback)
    "getIndexingInfoByGroup" -> getIndexingInfoByGroup(parameters, resultCallback)
    "getReplicatorInfo" -> getReplicatorInfo(parameters, resultCallback)
    "evictAllFromMap" -> evictAllFromMap(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getVersion(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getVersion(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun isReady(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.isReady(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getProcessInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getProcessInfo(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getIndexingInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getIndexingInfo(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getReplicationInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getReplicationInfo(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun updateDesignDoc(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.updateDesignDoc(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityName"),
      parameters.getValue("warmup"),
    )
  }

  private fun resolvePatientsConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolvePatientsConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveContactsConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveContactsConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveFormsConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveFormsConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveHealthElementsConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveHealthElementsConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveInvoicesConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveInvoicesConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveMessagesConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveMessagesConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("limit"),
    )
  }

  private fun resolveDocumentsConflicts(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.resolveDocumentsConflicts(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
      parameters.getValue("limit"),
    )
  }

  private fun getIndexingInfoByGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getIndexingInfoByGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
    )
  }

  private fun getReplicatorInfo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.getReplicatorInfo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun evictAllFromMap(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    SystemApi.evictAllFromMap(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("mapName"),
    )
  }
}
