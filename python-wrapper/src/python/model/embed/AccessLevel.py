from typing import Union, Dict
from enum import Enum

class AccessLevel(Enum):
	Read = "READ"
	Write = "WRITE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AccessLevel':
		if data == "READ":
			return AccessLevel.Read
		elif data == "WRITE":
			return AccessLevel.Write
		else:
			raise Exception(f"{data} is not a valid value for AccessLevel enum.")

__all__ = ['AccessLevel']