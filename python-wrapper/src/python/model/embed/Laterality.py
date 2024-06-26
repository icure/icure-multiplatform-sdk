from typing import Union, Dict
from enum import Enum

class Laterality(Enum):
	Left = "left"
	Right = "right"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Laterality':
		if data == "left":
			return Laterality.Left
		elif data == "right":
			return Laterality.Right
		else:
			raise Exception(f"{data} is not a valid value for Laterality enum.")

__all__ = ['Laterality']