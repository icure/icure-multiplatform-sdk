import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class Range:
	low: Optional[float] = None
	high: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"low": self.low,
			"high": self.high,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Range':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low = deserialized_dict.get("low"),
			high = deserialized_dict.get("high"),
		)

__all__ = ['Range']