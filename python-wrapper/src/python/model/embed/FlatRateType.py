from typing import Union, Dict
from enum import Enum

class FlatRateType(Enum):
	Physician = "physician"
	Physiotherapist = "physiotherapist"
	Nurse = "nurse"
	Ptd = "ptd"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FlatRateType':
		if data == "physician":
			return FlatRateType.Physician
		elif data == "physiotherapist":
			return FlatRateType.Physiotherapist
		elif data == "nurse":
			return FlatRateType.Nurse
		elif data == "ptd":
			return FlatRateType.Ptd
		else:
			raise Exception(f"{data} is not a valid value for FlatRateType enum.")

__all__ = ['FlatRateType']