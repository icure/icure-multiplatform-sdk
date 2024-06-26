from typing import Union, Dict
from enum import Enum

class UsersStatus(Enum):
	Active = "ACTIVE"
	Disabled = "DISABLED"
	Registering = "REGISTERING"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersStatus':
		if data == "ACTIVE":
			return UsersStatus.Active
		elif data == "DISABLED":
			return UsersStatus.Disabled
		elif data == "REGISTERING":
			return UsersStatus.Registering
		else:
			raise Exception(f"{data} is not a valid value for UsersStatus enum.")

__all__ = ['UsersStatus']