// This file is auto-generated


enum DelegationTag {
	all,
	administrativeData,
	anonymousMedicalInformation,
	generalInformation,
	financialInformation,
	medicalInformation,
	sensitiveInformation,
	confidentialInformation,
	cdItemRisk,
	cdItemFamilyRisk,
	cdItemHealthcareelement,
	cdItemHealthcareapproach,
	cdItemAllergy,
	cdItemDiagnosis,
	cdItemLab,
	cdItemResult,
	cdItemParameter,
	cdItemMedication,
	cdItemTreatment,
	cdItemVaccine;

	static String encode(DelegationTag value) {
		switch (value) {
			case DelegationTag.all:
				return '"All"';
			case DelegationTag.administrativeData:
				return '"AdministrativeData"';
			case DelegationTag.anonymousMedicalInformation:
				return '"AnonymousMedicalInformation"';
			case DelegationTag.generalInformation:
				return '"GeneralInformation"';
			case DelegationTag.financialInformation:
				return '"FinancialInformation"';
			case DelegationTag.medicalInformation:
				return '"MedicalInformation"';
			case DelegationTag.sensitiveInformation:
				return '"SensitiveInformation"';
			case DelegationTag.confidentialInformation:
				return '"ConfidentialInformation"';
			case DelegationTag.cdItemRisk:
				return '"CdItemRisk"';
			case DelegationTag.cdItemFamilyRisk:
				return '"CdItemFamilyRisk"';
			case DelegationTag.cdItemHealthcareelement:
				return '"CdItemHealthcareelement"';
			case DelegationTag.cdItemHealthcareapproach:
				return '"CdItemHealthcareapproach"';
			case DelegationTag.cdItemAllergy:
				return '"CdItemAllergy"';
			case DelegationTag.cdItemDiagnosis:
				return '"CdItemDiagnosis"';
			case DelegationTag.cdItemLab:
				return '"CdItemLab"';
			case DelegationTag.cdItemResult:
				return '"CdItemResult"';
			case DelegationTag.cdItemParameter:
				return '"CdItemParameter"';
			case DelegationTag.cdItemMedication:
				return '"CdItemMedication"';
			case DelegationTag.cdItemTreatment:
				return '"CdItemTreatment"';
			case DelegationTag.cdItemVaccine:
				return '"CdItemVaccine"';
			}
	}

}