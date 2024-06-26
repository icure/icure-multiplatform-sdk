import json
from typing import List, Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class HealthElementByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids = [x0 for x0 in deserialized_dict["ids"]],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['HealthElementByIdsFilter']