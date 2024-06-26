import json
from typing import List, Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class IdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			ids = [x0 for x0 in deserialized_dict["ids"]],
		)

__all__ = ['IdsFilter']