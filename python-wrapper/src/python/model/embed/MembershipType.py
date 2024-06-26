from typing import Union, Dict
from enum import Enum

class MembershipType(Enum):
	Doctor = "doctor"
	Mutuality = "mutuality"
	Patient = "patient"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MembershipType':
		if data == "doctor":
			return MembershipType.Doctor
		elif data == "mutuality":
			return MembershipType.Mutuality
		elif data == "patient":
			return MembershipType.Patient
		elif data == "specialist":
			return MembershipType.Specialist
		elif data == "other":
			return MembershipType.Other
		else:
			raise Exception(f"{data} is not a valid value for MembershipType enum.")

__all__ = ['MembershipType']