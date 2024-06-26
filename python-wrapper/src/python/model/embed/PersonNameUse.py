from typing import Union, Dict
from enum import Enum

class PersonNameUse(Enum):
	Usual = "usual"
	Official = "official"
	Temp = "temp"
	Nickname = "nickname"
	Anonymous = "anonymous"
	Maiden = "maiden"
	Old = "old"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonNameUse':
		if data == "usual":
			return PersonNameUse.Usual
		elif data == "official":
			return PersonNameUse.Official
		elif data == "temp":
			return PersonNameUse.Temp
		elif data == "nickname":
			return PersonNameUse.Nickname
		elif data == "anonymous":
			return PersonNameUse.Anonymous
		elif data == "maiden":
			return PersonNameUse.Maiden
		elif data == "old":
			return PersonNameUse.Old
		elif data == "other":
			return PersonNameUse.Other
		else:
			raise Exception(f"{data} is not a valid value for PersonNameUse enum.")

__all__ = ['PersonNameUse']