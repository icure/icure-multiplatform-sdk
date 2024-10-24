// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.HealthElementApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object HealthElementApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createHealthElement" -> createHealthElement(parameters, resultCallback)
    "createHealthElements" -> createHealthElements(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "decryptPatientIdOf" -> decryptPatientIdOf(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "matchHealthElementsBy" -> matchHealthElementsBy(parameters, resultCallback)
    "matchHealthElementsBySorted" -> matchHealthElementsBySorted(parameters, resultCallback)
    "deleteHealthElementById" -> deleteHealthElementById(parameters, resultCallback)
    "deleteHealthElementsByIds" -> deleteHealthElementsByIds(parameters, resultCallback)
    "purgeHealthElementById" -> purgeHealthElementById(parameters, resultCallback)
    "deleteHealthElement" -> deleteHealthElement(parameters, resultCallback)
    "deleteHealthElements" -> deleteHealthElements(parameters, resultCallback)
    "purgeHealthElement" -> purgeHealthElement(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "filterHealthElementsBy" -> filterHealthElementsBy(parameters, resultCallback)
    "filterHealthElementsBySorted" -> filterHealthElementsBySorted(parameters, resultCallback)
    "undeleteHealthElementById" -> undeleteHealthElementById(parameters, resultCallback)
    "undeleteHealthElement" -> undeleteHealthElement(parameters, resultCallback)
    "modifyHealthElement" -> modifyHealthElement(parameters, resultCallback)
    "modifyHealthElements" -> modifyHealthElements(parameters, resultCallback)
    "getHealthElement" -> getHealthElement(parameters, resultCallback)
    "getHealthElements" -> getHealthElements(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.filterHealthElementsBy" -> encrypted_filterHealthElementsBy(parameters, resultCallback)
    "encrypted.filterHealthElementsBySorted" -> encrypted_filterHealthElementsBySorted(parameters, resultCallback)
    "encrypted.undeleteHealthElementById" -> encrypted_undeleteHealthElementById(parameters, resultCallback)
    "encrypted.undeleteHealthElement" -> encrypted_undeleteHealthElement(parameters, resultCallback)
    "encrypted.modifyHealthElement" -> encrypted_modifyHealthElement(parameters, resultCallback)
    "encrypted.modifyHealthElements" -> encrypted_modifyHealthElements(parameters, resultCallback)
    "encrypted.getHealthElement" -> encrypted_getHealthElement(parameters, resultCallback)
    "encrypted.getHealthElements" -> encrypted_getHealthElements(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.filterHealthElementsBy" -> tryAndRecover_filterHealthElementsBy(parameters, resultCallback)
    "tryAndRecover.filterHealthElementsBySorted" -> tryAndRecover_filterHealthElementsBySorted(parameters, resultCallback)
    "tryAndRecover.undeleteHealthElementById" -> tryAndRecover_undeleteHealthElementById(parameters, resultCallback)
    "tryAndRecover.undeleteHealthElement" -> tryAndRecover_undeleteHealthElement(parameters, resultCallback)
    "tryAndRecover.modifyHealthElement" -> tryAndRecover_modifyHealthElement(parameters, resultCallback)
    "tryAndRecover.modifyHealthElements" -> tryAndRecover_modifyHealthElements(parameters, resultCallback)
    "tryAndRecover.getHealthElement" -> tryAndRecover_getHealthElement(parameters, resultCallback)
    "tryAndRecover.getHealthElements" -> tryAndRecover_getHealthElements(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.createHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun createHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.createHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.withEncryptionMetadata(
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
    HealthElementApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun decryptPatientIdOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.decryptPatientIdOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.createDelegationDeAnonymizationMetadata(
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
    HealthElementApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun matchHealthElementsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.matchHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchHealthElementsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.matchHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deleteHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.deleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthElementsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.deleteHealthElementsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgeHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.purgeHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.deleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun deleteHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.deleteHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElements"),
    )
  }

  private fun purgeHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.purgeHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("healthElement"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
      parameters.getValue("delegates"),
    )
  }

  private fun filterHealthElementsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.filterHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterHealthElementsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.filterHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun undeleteHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.undeleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.undeleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun modifyHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.modifyHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun modifyHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.modifyHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun getHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.getHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.getHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun encrypted_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("healthElement"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_filterHealthElementsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.filterHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterHealthElementsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.filterHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_undeleteHealthElementById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.undeleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.undeleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun encrypted_modifyHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.modifyHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_modifyHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.modifyHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun encrypted_getHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.getHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.encrypted.getHealthElements(
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
    HealthElementApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("healthElement"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_filterHealthElementsBy(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.filterHealthElementsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterHealthElementsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.filterHealthElementsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_undeleteHealthElementById(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.undeleteHealthElementById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeleteHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.undeleteHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthElement"),
    )
  }

  private fun tryAndRecover_modifyHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.modifyHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_modifyHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.modifyHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entities"),
    )
  }

  private fun tryAndRecover_getHealthElement(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.getHealthElement(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getHealthElements(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    HealthElementApi.tryAndRecover.getHealthElements(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }
}
