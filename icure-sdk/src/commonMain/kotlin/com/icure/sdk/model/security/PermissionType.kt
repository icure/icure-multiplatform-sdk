package com.icure.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class PermissionType() {
  @SerialName("AUTHENTICATE")
  Authenticate,
  @SerialName("HCP")
  Hcp,
  @SerialName("PHYSICIAN")
  Physician,
  @SerialName("ADMIN")
  Admin,
  @SerialName("PATIENT_VIEW")
  PatientView,
  @SerialName("PATIENT_CREATE")
  PatientCreate,
  @SerialName("PATIENT_CHANGE_DELETE")
  PatientChangeDelete,
  @SerialName("MEDICAL_DATA_VIEW")
  MedicalDataView,
  @SerialName("MEDICAL_DATA_CREATE")
  MedicalDataCreate,
  @SerialName("MEDICAL_CHANGE_DELETE")
  MedicalChangeDelete,
  @SerialName("FINANCIAL_DATA_VIEW")
  FinancialDataView,
  @SerialName("FINANCIAL_DATA_CREATE")
  FinancialDataCreate,
  @SerialName("FINANCIAL_CHANGE_DELETE")
  FinancialChangeDelete,
  @SerialName("LEGACY_DATA_VIEW")
  LegacyDataView,

}