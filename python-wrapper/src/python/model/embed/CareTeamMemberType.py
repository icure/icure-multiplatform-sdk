from typing import Union, Dict
from enum import Enum

class CareTeamMemberType(Enum):
	Physician = "physician"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CareTeamMemberType':
		if data == "physician":
			return CareTeamMemberType.Physician
		elif data == "specialist":
			return CareTeamMemberType.Specialist
		elif data == "other":
			return CareTeamMemberType.Other
		else:
			raise Exception(f"{data} is not a valid value for CareTeamMemberType enum.")

__all__ = ['CareTeamMemberType']