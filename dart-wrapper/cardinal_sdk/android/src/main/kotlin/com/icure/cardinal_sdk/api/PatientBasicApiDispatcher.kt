// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.PatientBasicApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object PatientBasicApiDispatcher {
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
    "matchPatientsBy" -> matchPatientsBy(parameters, resultCallback)
    "matchPatientsBySorted" -> matchPatientsBySorted(parameters, resultCallback)
    "filterPatientsBy" -> filterPatientsBy(parameters, resultCallback)
    "filterPatientsBySorted" -> filterPatientsBySorted(parameters, resultCallback)
    "deletePatientById" -> deletePatientById(parameters, resultCallback)
    "deletePatientsByIds" -> deletePatientsByIds(parameters, resultCallback)
    "purgePatientById" -> purgePatientById(parameters, resultCallback)
    "deletePatient" -> deletePatient(parameters, resultCallback)
    "deletePatients" -> deletePatients(parameters, resultCallback)
    "purgePatient" -> purgePatient(parameters, resultCallback)
    "getDataOwnersWithAccessTo" -> getDataOwnersWithAccessTo(parameters, resultCallback)
    "createPatient" -> createPatient(parameters, resultCallback)
    "createPatientsMinimal" -> createPatientsMinimal(parameters, resultCallback)
    "createPatients" -> createPatients(parameters, resultCallback)
    "undeletePatient" -> undeletePatient(parameters, resultCallback)
    "modifyPatient" -> modifyPatient(parameters, resultCallback)
    "undeletePatientById" -> undeletePatientById(parameters, resultCallback)
    "undeletePatients" -> undeletePatients(parameters, resultCallback)
    "getPatient" -> getPatient(parameters, resultCallback)
    "getPatientResolvingMerges" -> getPatientResolvingMerges(parameters, resultCallback)
    "getPatients" -> getPatients(parameters, resultCallback)
    "modifyPatientsMinimal" -> modifyPatientsMinimal(parameters, resultCallback)
    "modifyPatients" -> modifyPatients(parameters, resultCallback)
    "mergePatients" -> mergePatients(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    "inGroup.matchPatientsBy" -> inGroup_matchPatientsBy(parameters, resultCallback)
    "inGroup.matchPatientsBySorted" -> inGroup_matchPatientsBySorted(parameters, resultCallback)
    "inGroup.filterPatientsBy" -> inGroup_filterPatientsBy(parameters, resultCallback)
    "inGroup.filterPatientsBySorted" -> inGroup_filterPatientsBySorted(parameters, resultCallback)
    "inGroup.getDataOwnersWithAccessTo" -> inGroup_getDataOwnersWithAccessTo(parameters, resultCallback)
    "inGroup.createPatient" -> inGroup_createPatient(parameters, resultCallback)
    "inGroup.createPatientsMinimal" -> inGroup_createPatientsMinimal(parameters, resultCallback)
    "inGroup.createPatients" -> inGroup_createPatients(parameters, resultCallback)
    "inGroup.getPatient" -> inGroup_getPatient(parameters, resultCallback)
    "inGroup.getPatientResolvingMerges" -> inGroup_getPatientResolvingMerges(parameters, resultCallback)
    "inGroup.getPatients" -> inGroup_getPatients(parameters, resultCallback)
    "inGroup.modifyPatientsMinimal" -> inGroup_modifyPatientsMinimal(parameters, resultCallback)
    "inGroup.modifyPatients" -> inGroup_modifyPatients(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun matchPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.matchPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.matchPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun deletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.deletePatientById(
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
    String?,
  ) -> Unit) {
    PatientBasicApi.deletePatientsByIds(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityIds"),
    )
  }

  private fun purgePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.purgePatientById(
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
    String?,
  ) -> Unit) {
    PatientBasicApi.deletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun deletePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.deletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun purgePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.purgePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun getDataOwnersWithAccessTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun undeletePatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.undeletePatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun modifyPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.modifyPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entity"),
    )
  }

  private fun undeletePatientById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.undeletePatientById(
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
    String?,
  ) -> Unit) {
    PatientBasicApi.undeletePatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("ids"),
    )
  }

  private fun getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
    )
  }

  private fun getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.getPatientResolvingMerges(
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
    String?,
  ) -> Unit) {
    PatientBasicApi.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun mergePatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.mergePatients(
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
    String?,
  ) -> Unit) {
    PatientBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }

  private fun inGroup_matchPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.matchPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_matchPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.matchPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterPatientsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.filterPatientsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_filterPatientsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.filterPatientsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun inGroup_getDataOwnersWithAccessTo(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_createPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.createPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun inGroup_createPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.createPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_createPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.createPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_getPatient(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.getPatient(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
    )
  }

  private fun inGroup_getPatientResolvingMerges(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.getPatientResolvingMerges(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientId"),
      parameters.getValue("maxMergeDepth"),
    )
  }

  private fun inGroup_getPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.getPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("patientIds"),
    )
  }

  private fun inGroup_modifyPatientsMinimal(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.modifyPatientsMinimal(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }

  private fun inGroup_modifyPatients(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    PatientBasicApi.inGroup.modifyPatients(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patients"),
    )
  }
}
