from typing import Union, Dict
from enum import Enum

class Operation(Enum):
	TransferGroup = "TRANSFER_GROUP"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Operation':
		if data == "TRANSFER_GROUP":
			return Operation.TransferGroup
		else:
			raise Exception(f"{data} is not a valid value for Operation enum.")

__all__ = ['Operation']