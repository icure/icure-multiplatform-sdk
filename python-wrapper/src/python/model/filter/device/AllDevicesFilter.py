import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class AllDevicesFilter:
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AllDevicesFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['AllDevicesFilter']