from typing import Union, Dict
from enum import Enum

class StateToUpdate(Enum):
	Value = "VALUE"
	Visible = "VISIBLE"
	Readonly = "READONLY"
	Clazz = "CLAZZ"
	Required = "REQUIRED"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'StateToUpdate':
		if data == "VALUE":
			return StateToUpdate.Value
		elif data == "VISIBLE":
			return StateToUpdate.Visible
		elif data == "READONLY":
			return StateToUpdate.Readonly
		elif data == "CLAZZ":
			return StateToUpdate.Clazz
		elif data == "REQUIRED":
			return StateToUpdate.Required
		else:
			raise Exception(f"{data} is not a valid value for StateToUpdate enum.")

__all__ = ['StateToUpdate']