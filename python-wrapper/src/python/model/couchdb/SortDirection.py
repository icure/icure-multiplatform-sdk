from typing import Union, Dict
from enum import Enum

class SortDirection(Enum):
	Asc = "asc"
	Desc = "desc"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SortDirection':
		if data == "asc":
			return SortDirection.Asc
		elif data == "desc":
			return SortDirection.Desc
		else:
			raise Exception(f"{data} is not a valid value for SortDirection enum.")

__all__ = ['SortDirection']