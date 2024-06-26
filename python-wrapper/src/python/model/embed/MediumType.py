from typing import Union, Dict
from enum import Enum

class MediumType(Enum):
	Cdrom = "cdrom"
	Eattest = "eattest"
	Efact = "efact"
	Email = "email"
	Mediprima = "mediprima"
	Paper = "paper"
	Stat = "stat"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MediumType':
		if data == "cdrom":
			return MediumType.Cdrom
		elif data == "eattest":
			return MediumType.Eattest
		elif data == "efact":
			return MediumType.Efact
		elif data == "email":
			return MediumType.Email
		elif data == "mediprima":
			return MediumType.Mediprima
		elif data == "paper":
			return MediumType.Paper
		elif data == "stat":
			return MediumType.Stat
		else:
			raise Exception(f"{data} is not a valid value for MediumType enum.")

__all__ = ['MediumType']