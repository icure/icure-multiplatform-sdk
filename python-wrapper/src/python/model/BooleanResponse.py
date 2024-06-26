import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class BooleanResponse:
	response: bool

	def __serialize__(self) -> object:
		return {
			"response": self.response,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'BooleanResponse':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			response = deserialized_dict["response"],
		)

__all__ = ['BooleanResponse']