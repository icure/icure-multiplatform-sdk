from typing import Union, Dict
from enum import Enum

class Operator(Enum):
	Equal = "EQUAL"
	Notequal = "NOTEQUAL"
	Greaterthan = "GREATERTHAN"
	Smallerthan = "SMALLERTHAN"
	Greaterthanorequal = "GREATERTHANOREQUAL"
	Smallerthanorequal = "SMALLERTHANOREQUAL"
	Like = "LIKE"
	Ilike = "ILIKE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Operator':
		if data == "EQUAL":
			return Operator.Equal
		elif data == "NOTEQUAL":
			return Operator.Notequal
		elif data == "GREATERTHAN":
			return Operator.Greaterthan
		elif data == "SMALLERTHAN":
			return Operator.Smallerthan
		elif data == "GREATERTHANOREQUAL":
			return Operator.Greaterthanorequal
		elif data == "SMALLERTHANOREQUAL":
			return Operator.Smallerthanorequal
		elif data == "LIKE":
			return Operator.Like
		elif data == "ILIKE":
			return Operator.Ilike
		else:
			raise Exception(f"{data} is not a valid value for Operator enum.")

__all__ = ['Operator']