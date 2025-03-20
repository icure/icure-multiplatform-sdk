package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DelegationTag() {
	@SerialName("all")
	All,

	@SerialName("administrativeData")
	AdministrativeData,

	@SerialName("anonymousMedicalInformation")
	AnonymousMedicalInformation,

	@SerialName("generalInformation")
	GeneralInformation,

	@SerialName("financialInformation")
	FinancialInformation,

	@SerialName("medicalInformation")
	MedicalInformation,

	@SerialName("sensitiveInformation")
	SensitiveInformation,

	@SerialName("confidentialInformation")
	ConfidentialInformation,

	@SerialName("cdItemRisk")
	CdItemRisk,

	@SerialName("cdItemFamilyRisk")
	CdItemFamilyRisk,

	@SerialName("cdItemHealthcareelement")
	CdItemHealthcareelement,

	@SerialName("cdItemHealthcareapproach")
	CdItemHealthcareapproach,

	@SerialName("cdItemAllergy")
	CdItemAllergy,

	@SerialName("cdItemDiagnosis")
	CdItemDiagnosis,

	@SerialName("cdItemLab")
	CdItemLab,

	@SerialName("cdItemResult")
	CdItemResult,

	@SerialName("cdItemParameter")
	CdItemParameter,

	@SerialName("cdItemMedication")
	CdItemMedication,

	@SerialName("cdItemTreatment")
	CdItemTreatment,

	@SerialName("cdItemVaccine")
	CdItemVaccine,
}
