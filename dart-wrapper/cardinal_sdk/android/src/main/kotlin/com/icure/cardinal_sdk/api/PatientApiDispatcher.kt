// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.PatientApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PatientApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getSecretIdsOf" -> getSecretIdsOf(parameters, resultCallback)
    "getEncryptionKeysOf" -> getEncryptionKeysOf(parameters, resultCallback)
    "createPatient" -> createPatient(parameters, resultCallback)
    "withEncryptionMetadata" -> withEncryptionMetadata(parameters, resultCallback)
    "hasWriteAccess" -> hasWriteAccess(parameters, resultCallback)
    "createDelegationDeAnonymizationMetadata" -> createDelegationDeAnonymizationMetadata(parameters, resultCallback)
    "decrypt" -> decrypt(parameters, resultCallback)
    "tryDecrypt" -> tryDecrypt(parameters, resultCallback)
    "createPatients" -> createPatients(parameters, resultCallback)
    "shareAllDataOfPatient" -> shareAllDataOfPatient(parameters, resultCallback)
    "getConfidentialSecretIdsOf" -> getConfidentialSecretIdsOf(parameters, resultCallback)
    "forceInitializeExchangeDataToNewlyInvitedPatient" -> forceInitializeExchangeDataToNewlyInvitedPatient(parameters, resultCallback)
    "matchPatientsBy" -> matchPatientsBy(parameters, resultCallback)
    "matchPatientsBySorted" -> matchPatientsBySorted(parameters, resultCallback)
    "ensureEncryptionMetadataForSelfIsInitialized" -> ensureEncryptionMetadataForSelfIsInitialized(parameters, resultCallback)
    "deletePatientById" -> deletePatientById(parameters, resultCallback)
    "deletePatientsByIds" -> deletePatientsByIds(parameters, resultCallback)
    "purgePatientById" -> purgePatientById(parameters, resultCallback)
    "deletePatient" -> deletePatient(parameters, resultCallback)
    "deletePatients" -> deletePatients(parameters, resultCallback)
    "purgePatient" -> purgePatient(parameters, resultCallback)
    "getDataOwnersWithAccessTo" -> getDataOwnersWithAccessTo(parameters, resultCallback)
    "shareWith" -> shareWith(parameters, resultCallback)
    "shareWithMany" -> shareWithMany(parameters, resultCallback)
    "initializeConfidentialSecretId" -> initializeConfidentialSecretId(parameters, resultCallback)
    "filterPatientsBy" -> filterPatientsBy(parameters, resultCallback)
    "filterPatientsBySorted" -> filterPatientsBySorted(parameters, resultCallback)
    "undeletePatient" -> undeletePatient(parameters, resultCallback)
    "modifyPatient" -> modifyPatient(parameters, resultCallback)
    "undeletePatientById" -> undeletePatientById(parameters, resultCallback)
    "undeletePatients" -> undeletePatients(parameters, resultCallback)
    "getPatient" -> getPatient(parameters, resultCallback)
    "getPatientResolvingMerges" -> getPatientResolvingMerges(parameters, resultCallback)
    "getPatients" -> getPatients(parameters, resultCallback)
    "modifyPatients" -> modifyPatients(parameters, resultCallback)
    "mergePatients" -> mergePatients(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "encrypted.shareWith" -> encrypted_shareWith(parameters, resultCallback)
    "encrypted.shareWithMany" -> encrypted_shareWithMany(parameters, resultCallback)
    "encrypted.initializeConfidentialSecretId" -> encrypted_initializeConfidentialSecretId(parameters, resultCallback)
    "encrypted.filterPatientsBy" -> encrypted_filterPatientsBy(parameters, resultCallback)
    "encrypted.filterPatientsBySorted" -> encrypted_filterPatientsBySorted(parameters, resultCallback)
    "encrypted.undeletePatient" -> encrypted_undeletePatient(parameters, resultCallback)
    "encrypted.modifyPatient" -> encrypted_modifyPatient(parameters, resultCallback)
    "encrypted.undeletePatientById" -> encrypted_undeletePatientById(parameters, resultCallback)
    "encrypted.undeletePatients" -> encrypted_undeletePatients(parameters, resultCallback)
    "encrypted.getPatient" -> encrypted_getPatient(parameters, resultCallback)
    "encrypted.getPatientResolvingMerges" -> encrypted_getPatientResolvingMerges(parameters, resultCallback)
    "encrypted.getPatients" -> encrypted_getPatients(parameters, resultCallback)
    "encrypted.modifyPatients" -> encrypted_modifyPatients(parameters, resultCallback)
    "encrypted.mergePatients" -> encrypted_mergePatients(parameters, resultCallback)
    "tryAndRecover.shareWith" -> tryAndRecover_shareWith(parameters, resultCallback)
    "tryAndRecover.shareWithMany" -> tryAndRecover_shareWithMany(parameters, resultCallback)
    "tryAndRecover.initializeConfidentialSecretId" -> tryAndRecover_initializeConfidentialSecretId(parameters, resultCallback)
    "tryAndRecover.filterPatientsBy" -> tryAndRecover_filterPatientsBy(parameters, resultCallback)
    "tryAndRecover.filterPatientsBySorted" -> tryAndRecover_filterPatientsBySorted(parameters, resultCallback)
    "tryAndRecover.undeletePatient" -> tryAndRecover_undeletePatient(parameters, resultCallback)
    "tryAndRecover.modifyPatient" -> tryAndRecover_modifyPatient(parameters, resultCallback)
    "tryAndRecover.undeletePatientById" -> tryAndRecover_undeletePatientById(parameters, resultCallback)
    "tryAndRecover.undeletePatients" -> tryAndRecover_undeletePatients(parameters, resultCallback)
    "tryAndRecover.getPatient" -> tryAndRecover_getPatient(parameters, resultCallback)
    "tryAndRecover.getPatientResolvingMerges" -> tryAndRecover_getPatientResolvingMerges(parameters, resultCallback)
    "tryAndRecover.getPatients" -> tryAndRecover_getPatients(parameters, resultCallback)
    "tryAndRecover.modifyPatients" -> tryAndRecover_modifyPatients(parameters, resultCallback)
    "tryAndRecover.mergePatients" -> tryAndRecover_mergePatients(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun getEncryptionKeysOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getEncryptionKeysOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun withEncryptionMetadata(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.withEncryptionMetadata(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("base"),
      parameters.getValue("user"),
      parameters.getValue("delegates"),
    )
  }

  private fun hasWriteAccess(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.hasWriteAccess(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createDelegationDeAnonymizationMetadata(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createDelegationDeAnonymizationMetadata(
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
    PatientApi.decrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryDecrypt(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryDecrypt(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientDtos"),
    )
  }

  private fun shareAllDataOfPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareAllDataOfPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("delegatesWithShareType"),
    )
  }

  private fun getConfidentialSecretIdsOf(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getConfidentialSecretIdsOf(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun forceInitializeExchangeDataToNewlyInvitedPatient(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.forceInitializeExchangeDataToNewlyInvitedPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
    )
  }

  private fun matchPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.matchPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.matchPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun ensureEncryptionMetadataForSelfIsInitialized(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.ensureEncryptionMetadataForSelfIsInitialized(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("sharingWith"),
    )
  }

  private fun deletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deletePatientsByIds(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatientsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.purgePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun deletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.deletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun purgePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.purgePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun getDataOwnersWithAccessTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun initializeConfidentialSecretId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientDtos"),
    )
  }

  private fun mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.subscribeToEvents(
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
    PatientApi.encrypted.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun encrypted_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun encrypted_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun encrypted_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun encrypted_undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun encrypted_modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun encrypted_undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun encrypted_undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun encrypted_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun encrypted_getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun encrypted_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun encrypted_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientDtos"),
    )
  }

  private fun encrypted_mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.encrypted.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }

  private fun tryAndRecover_shareWith(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.shareWith(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("delegateId"),
      parameters.getValue("patient"),
      parameters.getValue("options"),
    )
  }

  private fun tryAndRecover_shareWithMany(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.shareWithMany(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
      parameters.getValue("delegates"),
    )
  }

  private fun tryAndRecover_initializeConfidentialSecretId(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.initializeConfidentialSecretId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryAndRecover_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_filterPatientsBySorted(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun tryAndRecover_undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun tryAndRecover_modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun tryAndRecover_undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatientById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun tryAndRecover_undeletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun tryAndRecover_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun tryAndRecover_getPatientResolvingMerges(parameters: Map<String, String>,
      resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun tryAndRecover_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun tryAndRecover_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientDtos"),
    )
  }

  private fun tryAndRecover_mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientApi.tryAndRecover.mergePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("from"),
      parameters.getValue("mergedInto"),
    )
  }
}
