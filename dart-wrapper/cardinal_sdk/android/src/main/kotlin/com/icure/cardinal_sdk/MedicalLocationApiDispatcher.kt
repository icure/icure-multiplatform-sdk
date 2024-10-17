package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.MedicalLocationApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object MedicalLocationApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "createMedicalLocation" -> createMedicalLocation(parameters, resultCallback)
    "deleteMedicalLocations" -> deleteMedicalLocations(parameters, resultCallback)
    "getMedicalLocation" -> getMedicalLocation(parameters, resultCallback)
    "modifyMedicalLocation" -> modifyMedicalLocation(parameters, resultCallback)
    "getMedicalLocations" -> getMedicalLocations(parameters, resultCallback)
    "matchMedicalLocationsBy" -> matchMedicalLocationsBy(parameters, resultCallback)
    "matchMedicalLocationsBySorted" -> matchMedicalLocationsBySorted(parameters, resultCallback)
    "filterMedicalLocationsBy" -> filterMedicalLocationsBy(parameters, resultCallback)
    "filterMedicalLocationsBySorted" -> filterMedicalLocationsBySorted(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun createMedicalLocation(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.createMedicalLocation(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("medicalLocationDto"),
    )
  }

  private fun deleteMedicalLocations(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.deleteMedicalLocations(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("locationIds"),
    )
  }

  private fun getMedicalLocation(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.getMedicalLocation(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("locationId"),
    )
  }

  private fun modifyMedicalLocation(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.modifyMedicalLocation(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("medicalLocationDto"),
    )
  }

  private fun getMedicalLocations(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.getMedicalLocations(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("medicalLocationIds"),
    )
  }

  private fun matchMedicalLocationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.matchMedicalLocationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchMedicalLocationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.matchMedicalLocationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMedicalLocationsBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.filterMedicalLocationsBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterMedicalLocationsBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    MedicalLocationApi.filterMedicalLocationsBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }
}
