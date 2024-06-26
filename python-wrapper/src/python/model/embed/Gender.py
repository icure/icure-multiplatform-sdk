from typing import Union, Dict
from enum import Enum

class Gender(Enum):
	Male = "male"
	Female = "female"
	Indeterminate = "indeterminate"
	Changed = "changed"
	ChangedToMale = "changedToMale"
	ChangedToFemale = "changedToFemale"
	Unknown = "unknown"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Gender':
		if data == "male":
			return Gender.Male
		elif data == "female":
			return Gender.Female
		elif data == "indeterminate":
			return Gender.Indeterminate
		elif data == "changed":
			return Gender.Changed
		elif data == "changedToMale":
			return Gender.ChangedToMale
		elif data == "changedToFemale":
			return Gender.ChangedToFemale
		elif data == "unknown":
			return Gender.Unknown
		else:
			raise Exception(f"{data} is not a valid value for Gender enum.")

__all__ = ['Gender']