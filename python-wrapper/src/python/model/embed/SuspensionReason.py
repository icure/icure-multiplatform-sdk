from typing import Union, Dict
from enum import Enum

class SuspensionReason(Enum):
	NotInsured = "notInsured"
	NoReasonGiven = "noReasonGiven"
	IsHospitalized = "isHospitalized"
	OutsideOfCountry = "outsideOfCountry"
	ChangeOfMutuality = "changeOfMutuality"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SuspensionReason':
		if data == "notInsured":
			return SuspensionReason.NotInsured
		elif data == "noReasonGiven":
			return SuspensionReason.NoReasonGiven
		elif data == "isHospitalized":
			return SuspensionReason.IsHospitalized
		elif data == "outsideOfCountry":
			return SuspensionReason.OutsideOfCountry
		elif data == "changeOfMutuality":
			return SuspensionReason.ChangeOfMutuality
		else:
			raise Exception(f"{data} is not a valid value for SuspensionReason enum.")

__all__ = ['SuspensionReason']