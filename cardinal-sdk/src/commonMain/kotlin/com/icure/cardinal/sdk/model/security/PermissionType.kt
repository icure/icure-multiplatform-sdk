package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PermissionType() {
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
