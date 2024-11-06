// auto-generated file


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
				return 'all';
			case DelegationTag.administrativeData:
				return 'administrativeData';
			case DelegationTag.anonymousMedicalInformation:
				return 'anonymousMedicalInformation';
			case DelegationTag.generalInformation:
				return 'generalInformation';
			case DelegationTag.financialInformation:
				return 'financialInformation';
			case DelegationTag.medicalInformation:
				return 'medicalInformation';
			case DelegationTag.sensitiveInformation:
				return 'sensitiveInformation';
			case DelegationTag.confidentialInformation:
				return 'confidentialInformation';
			case DelegationTag.cdItemRisk:
				return 'cdItemRisk';
			case DelegationTag.cdItemFamilyRisk:
				return 'cdItemFamilyRisk';
			case DelegationTag.cdItemHealthcareelement:
				return 'cdItemHealthcareelement';
			case DelegationTag.cdItemHealthcareapproach:
				return 'cdItemHealthcareapproach';
			case DelegationTag.cdItemAllergy:
				return 'cdItemAllergy';
			case DelegationTag.cdItemDiagnosis:
				return 'cdItemDiagnosis';
			case DelegationTag.cdItemLab:
				return 'cdItemLab';
			case DelegationTag.cdItemResult:
				return 'cdItemResult';
			case DelegationTag.cdItemParameter:
				return 'cdItemParameter';
			case DelegationTag.cdItemMedication:
				return 'cdItemMedication';
			case DelegationTag.cdItemTreatment:
				return 'cdItemTreatment';
			case DelegationTag.cdItemVaccine:
				return 'cdItemVaccine';
			}
	}


	static DelegationTag fromJSON(String data) {
		switch (data) {
			case "all":
				return DelegationTag.all;
			case "administrativeData":
				return DelegationTag.administrativeData;
			case "anonymousMedicalInformation":
				return DelegationTag.anonymousMedicalInformation;
			case "generalInformation":
				return DelegationTag.generalInformation;
			case "financialInformation":
				return DelegationTag.financialInformation;
			case "medicalInformation":
				return DelegationTag.medicalInformation;
			case "sensitiveInformation":
				return DelegationTag.sensitiveInformation;
			case "confidentialInformation":
				return DelegationTag.confidentialInformation;
			case "cdItemRisk":
				return DelegationTag.cdItemRisk;
			case "cdItemFamilyRisk":
				return DelegationTag.cdItemFamilyRisk;
			case "cdItemHealthcareelement":
				return DelegationTag.cdItemHealthcareelement;
			case "cdItemHealthcareapproach":
				return DelegationTag.cdItemHealthcareapproach;
			case "cdItemAllergy":
				return DelegationTag.cdItemAllergy;
			case "cdItemDiagnosis":
				return DelegationTag.cdItemDiagnosis;
			case "cdItemLab":
				return DelegationTag.cdItemLab;
			case "cdItemResult":
				return DelegationTag.cdItemResult;
			case "cdItemParameter":
				return DelegationTag.cdItemParameter;
			case "cdItemMedication":
				return DelegationTag.cdItemMedication;
			case "cdItemTreatment":
				return DelegationTag.cdItemTreatment;
			case "cdItemVaccine":
				return DelegationTag.cdItemVaccine;
			default:
				throw ArgumentError('Invalid DelegationTag entry value $data');
			}
	}

}