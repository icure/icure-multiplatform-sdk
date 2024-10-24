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
    else -> null
  }?.let { true } ?: false

  private fun matchPatientsBy(parameters: Map<String, String>, resultCallback: (
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
  ) -> Unit) {
    PatientBasicApi.getDataOwnersWithAccessTo(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("patient"),
    )
  }

  private fun undeletePatient(parameters: Map<String, String>, resultCallback: (
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
  ) -> Unit) {
    PatientBasicApi.getPatients(
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
    PatientBasicApi.modifyPatients(
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
  ) -> Unit) {
    PatientBasicApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
