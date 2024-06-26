from typing import Union, Dict
from enum import Enum

class DocumentLocation(Enum):
	Annex = "annex"
	Body = "body"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentLocation':
		if data == "annex":
			return DocumentLocation.Annex
		elif data == "body":
			return DocumentLocation.Body
		else:
			raise Exception(f"{data} is not a valid value for DocumentLocation enum.")

__all__ = ['DocumentLocation']