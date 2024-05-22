package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DelegationTag
import kotlin.String

public fun delegationTag_toJs(obj: DelegationTag): String = obj.name

public fun delegationTag_fromJs(obj: String): DelegationTag = when (obj) {
	"All" -> DelegationTag.All
	"AdministrativeData" -> DelegationTag.AdministrativeData
	"AnonymousMedicalInformation" -> DelegationTag.AnonymousMedicalInformation
	"GeneralInformation" -> DelegationTag.GeneralInformation
	"FinancialInformation" -> DelegationTag.FinancialInformation
	"MedicalInformation" -> DelegationTag.MedicalInformation
	"SensitiveInformation" -> DelegationTag.SensitiveInformation
	"ConfidentialInformation" -> DelegationTag.ConfidentialInformation
	"CdItemRisk" -> DelegationTag.CdItemRisk
	"CdItemFamilyRisk" -> DelegationTag.CdItemFamilyRisk
	"CdItemHealthcareelement" -> DelegationTag.CdItemHealthcareelement
	"CdItemHealthcareapproach" -> DelegationTag.CdItemHealthcareapproach
	"CdItemAllergy" -> DelegationTag.CdItemAllergy
	"CdItemDiagnosis" -> DelegationTag.CdItemDiagnosis
	"CdItemLab" -> DelegationTag.CdItemLab
	"CdItemResult" -> DelegationTag.CdItemResult
	"CdItemParameter" -> DelegationTag.CdItemParameter
	"CdItemMedication" -> DelegationTag.CdItemMedication
	"CdItemTreatment" -> DelegationTag.CdItemTreatment
	"CdItemVaccine" -> DelegationTag.CdItemVaccine
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DelegationTag: $obj""")
}
