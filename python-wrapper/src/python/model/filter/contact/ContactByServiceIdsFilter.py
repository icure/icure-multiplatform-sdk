import json
from typing import Optional, List, Union, Dict
from dataclasses import dataclass

@dataclass
class ContactByServiceIdsFilter:
	desc: Optional[str] = None
	ids: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ids": [x0 for x0 in self.ids] if self.ids is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByServiceIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			ids = [x0 for x0 in deserialized_dict.get("ids")] if deserialized_dict.get("ids") is not None else None,
		)

__all__ = ['ContactByServiceIdsFilter']