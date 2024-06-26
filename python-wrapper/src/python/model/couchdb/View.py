import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class View:
	map: str
	reduce: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"map": self.map,
			"reduce": self.reduce,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'View':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			map = deserialized_dict["map"],
			reduce = deserialized_dict.get("reduce"),
		)

__all__ = ['View']