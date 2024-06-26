import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class LetterValue:
	letter: Optional[str] = None
	index: Optional[str] = None
	coefficient: Optional[float] = None
	value: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"letter": self.letter,
			"index": self.index,
			"coefficient": self.coefficient,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LetterValue':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			letter = deserialized_dict.get("letter"),
			index = deserialized_dict.get("index"),
			coefficient = deserialized_dict.get("coefficient"),
			value = deserialized_dict.get("value"),
		)

__all__ = ['LetterValue']