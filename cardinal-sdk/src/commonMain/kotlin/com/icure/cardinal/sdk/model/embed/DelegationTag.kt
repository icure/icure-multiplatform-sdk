package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class DelegationTag(
	internal val dtoSerialName: String,
) {
	@SerialName("all")
	All("all"),

	@SerialName("administrativeData")
	AdministrativeData("administrativeData"),

	@SerialName("anonymousMedicalInformation")
	AnonymousMedicalInformation("anonymousMedicalInformation"),

	@SerialName("generalInformation")
	GeneralInformation("generalInformation"),

	@SerialName("financialInformation")
	FinancialInformation("financialInformation"),

	@SerialName("medicalInformation")
	MedicalInformation("medicalInformation"),

	@SerialName("sensitiveInformation")
	SensitiveInformation("sensitiveInformation"),

	@SerialName("confidentialInformation")
	ConfidentialInformation("confidentialInformation"),

	@SerialName("cdItemRisk")
	CdItemRisk("cdItemRisk"),

	@SerialName("cdItemFamilyRisk")
	CdItemFamilyRisk("cdItemFamilyRisk"),

	@SerialName("cdItemHealthcareelement")
	CdItemHealthcareelement("cdItemHealthcareelement"),

	@SerialName("cdItemHealthcareapproach")
	CdItemHealthcareapproach("cdItemHealthcareapproach"),

	@SerialName("cdItemAllergy")
	CdItemAllergy("cdItemAllergy"),

	@SerialName("cdItemDiagnosis")
	CdItemDiagnosis("cdItemDiagnosis"),

	@SerialName("cdItemLab")
	CdItemLab("cdItemLab"),

	@SerialName("cdItemResult")
	CdItemResult("cdItemResult"),

	@SerialName("cdItemParameter")
	CdItemParameter("cdItemParameter"),

	@SerialName("cdItemMedication")
	CdItemMedication("cdItemMedication"),

	@SerialName("cdItemTreatment")
	CdItemTreatment("cdItemTreatment"),

	@SerialName("cdItemVaccine")
	CdItemVaccine("cdItemVaccine"),
}
