from typing import Union, Dict
from enum import Enum

class HealthcarePartyStatus(Enum):
	Trainee = "trainee"
	Withconvention = "withconvention"
	Accreditated = "accreditated"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyStatus':
		if data == "trainee":
			return HealthcarePartyStatus.Trainee
		elif data == "withconvention":
			return HealthcarePartyStatus.Withconvention
		elif data == "accreditated":
			return HealthcarePartyStatus.Accreditated
		else:
			raise Exception(f"{data} is not a valid value for HealthcarePartyStatus enum.")

__all__ = ['HealthcarePartyStatus']