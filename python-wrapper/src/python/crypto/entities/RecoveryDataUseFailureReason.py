from typing import Union, Dict
from enum import Enum

class RecoveryDataUseFailureReason(Enum):
	Missing = "Missing"
	Unauthorized = "Unauthorized"
	InvalidType = "InvalidType"
	InvalidContent = "InvalidContent"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryDataUseFailureReason':
		if data == "Missing":
			return RecoveryDataUseFailureReason.Missing
		elif data == "Unauthorized":
			return RecoveryDataUseFailureReason.Unauthorized
		elif data == "InvalidType":
			return RecoveryDataUseFailureReason.InvalidType
		elif data == "InvalidContent":
			return RecoveryDataUseFailureReason.InvalidContent
		else:
			raise Exception(f"{data} is not a valid value for RecoveryDataUseFailureReason enum.")

__all__ = ['RecoveryDataUseFailureReason']