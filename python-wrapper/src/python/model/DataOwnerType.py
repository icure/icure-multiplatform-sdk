from typing import Union, Dict
from enum import Enum

class DataOwnerType(Enum):
	Hcp = "hcp"
	Device = "device"
	Patient = "patient"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerType':
		if data == "hcp":
			return DataOwnerType.Hcp
		elif data == "device":
			return DataOwnerType.Device
		elif data == "patient":
			return DataOwnerType.Patient
		else:
			raise Exception(f"{data} is not a valid value for DataOwnerType enum.")

__all__ = ['DataOwnerType']