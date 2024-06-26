from typing import Union, Dict
from enum import Enum

class DelegationTag(Enum):
	All = "all"
	AdministrativeData = "administrativeData"
	AnonymousMedicalInformation = "anonymousMedicalInformation"
	GeneralInformation = "generalInformation"
	FinancialInformation = "financialInformation"
	MedicalInformation = "medicalInformation"
	SensitiveInformation = "sensitiveInformation"
	ConfidentialInformation = "confidentialInformation"
	CdItemRisk = "cdItemRisk"
	CdItemFamilyRisk = "cdItemFamilyRisk"
	CdItemHealthcareelement = "cdItemHealthcareelement"
	CdItemHealthcareapproach = "cdItemHealthcareapproach"
	CdItemAllergy = "cdItemAllergy"
	CdItemDiagnosis = "cdItemDiagnosis"
	CdItemLab = "cdItemLab"
	CdItemResult = "cdItemResult"
	CdItemParameter = "cdItemParameter"
	CdItemMedication = "cdItemMedication"
	CdItemTreatment = "cdItemTreatment"
	CdItemVaccine = "cdItemVaccine"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DelegationTag':
		if data == "all":
			return DelegationTag.All
		elif data == "administrativeData":
			return DelegationTag.AdministrativeData
		elif data == "anonymousMedicalInformation":
			return DelegationTag.AnonymousMedicalInformation
		elif data == "generalInformation":
			return DelegationTag.GeneralInformation
		elif data == "financialInformation":
			return DelegationTag.FinancialInformation
		elif data == "medicalInformation":
			return DelegationTag.MedicalInformation
		elif data == "sensitiveInformation":
			return DelegationTag.SensitiveInformation
		elif data == "confidentialInformation":
			return DelegationTag.ConfidentialInformation
		elif data == "cdItemRisk":
			return DelegationTag.CdItemRisk
		elif data == "cdItemFamilyRisk":
			return DelegationTag.CdItemFamilyRisk
		elif data == "cdItemHealthcareelement":
			return DelegationTag.CdItemHealthcareelement
		elif data == "cdItemHealthcareapproach":
			return DelegationTag.CdItemHealthcareapproach
		elif data == "cdItemAllergy":
			return DelegationTag.CdItemAllergy
		elif data == "cdItemDiagnosis":
			return DelegationTag.CdItemDiagnosis
		elif data == "cdItemLab":
			return DelegationTag.CdItemLab
		elif data == "cdItemResult":
			return DelegationTag.CdItemResult
		elif data == "cdItemParameter":
			return DelegationTag.CdItemParameter
		elif data == "cdItemMedication":
			return DelegationTag.CdItemMedication
		elif data == "cdItemTreatment":
			return DelegationTag.CdItemTreatment
		elif data == "cdItemVaccine":
			return DelegationTag.CdItemVaccine
		else:
			raise Exception(f"{data} is not a valid value for DelegationTag enum.")

__all__ = ['DelegationTag']