from typing import Union, Dict
from enum import Enum

class PatientHealthCarePartyType(Enum):
	Doctor = "doctor"
	Referral = "referral"
	Medicalhouse = "medicalhouse"
	Retirementhome = "retirementhome"
	Hospital = "hospital"
	Other = "other"
	Referringphysician = "referringphysician"
	Managingorganization = "managingorganization"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientHealthCarePartyType':
		if data == "doctor":
			return PatientHealthCarePartyType.Doctor
		elif data == "referral":
			return PatientHealthCarePartyType.Referral
		elif data == "medicalhouse":
			return PatientHealthCarePartyType.Medicalhouse
		elif data == "retirementhome":
			return PatientHealthCarePartyType.Retirementhome
		elif data == "hospital":
			return PatientHealthCarePartyType.Hospital
		elif data == "other":
			return PatientHealthCarePartyType.Other
		elif data == "referringphysician":
			return PatientHealthCarePartyType.Referringphysician
		elif data == "managingorganization":
			return PatientHealthCarePartyType.Managingorganization
		else:
			raise Exception(f"{data} is not a valid value for PatientHealthCarePartyType enum.")

__all__ = ['PatientHealthCarePartyType']