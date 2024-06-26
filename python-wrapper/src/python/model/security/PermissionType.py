from typing import Union, Dict
from enum import Enum

class PermissionType(Enum):
	Authenticate = "AUTHENTICATE"
	Hcp = "HCP"
	Physician = "PHYSICIAN"
	Admin = "ADMIN"
	PatientView = "PATIENT_VIEW"
	PatientCreate = "PATIENT_CREATE"
	PatientChangeDelete = "PATIENT_CHANGE_DELETE"
	MedicalDataView = "MEDICAL_DATA_VIEW"
	MedicalDataCreate = "MEDICAL_DATA_CREATE"
	MedicalChangeDelete = "MEDICAL_CHANGE_DELETE"
	FinancialDataView = "FINANCIAL_DATA_VIEW"
	FinancialDataCreate = "FINANCIAL_DATA_CREATE"
	FinancialChangeDelete = "FINANCIAL_CHANGE_DELETE"
	LegacyDataView = "LEGACY_DATA_VIEW"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PermissionType':
		if data == "AUTHENTICATE":
			return PermissionType.Authenticate
		elif data == "HCP":
			return PermissionType.Hcp
		elif data == "PHYSICIAN":
			return PermissionType.Physician
		elif data == "ADMIN":
			return PermissionType.Admin
		elif data == "PATIENT_VIEW":
			return PermissionType.PatientView
		elif data == "PATIENT_CREATE":
			return PermissionType.PatientCreate
		elif data == "PATIENT_CHANGE_DELETE":
			return PermissionType.PatientChangeDelete
		elif data == "MEDICAL_DATA_VIEW":
			return PermissionType.MedicalDataView
		elif data == "MEDICAL_DATA_CREATE":
			return PermissionType.MedicalDataCreate
		elif data == "MEDICAL_CHANGE_DELETE":
			return PermissionType.MedicalChangeDelete
		elif data == "FINANCIAL_DATA_VIEW":
			return PermissionType.FinancialDataView
		elif data == "FINANCIAL_DATA_CREATE":
			return PermissionType.FinancialDataCreate
		elif data == "FINANCIAL_CHANGE_DELETE":
			return PermissionType.FinancialChangeDelete
		elif data == "LEGACY_DATA_VIEW":
			return PermissionType.LegacyDataView
		else:
			raise Exception(f"{data} is not a valid value for PermissionType enum.")

__all__ = ['PermissionType']