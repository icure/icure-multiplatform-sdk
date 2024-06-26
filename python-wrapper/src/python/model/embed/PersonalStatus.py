from typing import Union, Dict
from enum import Enum

class PersonalStatus(Enum):
	Single = "single"
	InCouple = "in_couple"
	Married = "married"
	Separated = "separated"
	Divorced = "divorced"
	Divorcing = "divorcing"
	Widowed = "widowed"
	Widower = "widower"
	Complicated = "complicated"
	Unknown = "unknown"
	Contract = "contract"
	Other = "other"
	Annulled = "annulled"
	Polygamous = "polygamous"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonalStatus':
		if data == "single":
			return PersonalStatus.Single
		elif data == "in_couple":
			return PersonalStatus.InCouple
		elif data == "married":
			return PersonalStatus.Married
		elif data == "separated":
			return PersonalStatus.Separated
		elif data == "divorced":
			return PersonalStatus.Divorced
		elif data == "divorcing":
			return PersonalStatus.Divorcing
		elif data == "widowed":
			return PersonalStatus.Widowed
		elif data == "widower":
			return PersonalStatus.Widower
		elif data == "complicated":
			return PersonalStatus.Complicated
		elif data == "unknown":
			return PersonalStatus.Unknown
		elif data == "contract":
			return PersonalStatus.Contract
		elif data == "other":
			return PersonalStatus.Other
		elif data == "annulled":
			return PersonalStatus.Annulled
		elif data == "polygamous":
			return PersonalStatus.Polygamous
		else:
			raise Exception(f"{data} is not a valid value for PersonalStatus enum.")

__all__ = ['PersonalStatus']