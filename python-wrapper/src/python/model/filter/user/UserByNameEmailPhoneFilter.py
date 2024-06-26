import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class UserByNameEmailPhoneFilter:
	search_string: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"searchString": self.search_string,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserByNameEmailPhoneFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			search_string = deserialized_dict["searchString"],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['UserByNameEmailPhoneFilter']