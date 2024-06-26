from typing import Union, Dict
from enum import Enum

class UserType(Enum):
	Hcp = "HCP"
	Patient = "PATIENT"
	Device = "DEVICE"
	User = "USER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserType':
		if data == "HCP":
			return UserType.Hcp
		elif data == "PATIENT":
			return UserType.Patient
		elif data == "DEVICE":
			return UserType.Device
		elif data == "USER":
			return UserType.User
		else:
			raise Exception(f"{data} is not a valid value for UserType enum.")

__all__ = ['UserType']