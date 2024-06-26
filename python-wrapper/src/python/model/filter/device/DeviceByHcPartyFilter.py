import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class DeviceByHcPartyFilter:
	desc: Optional[str] = None
	responsible_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"responsibleId": self.responsible_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeviceByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			responsible_id = deserialized_dict.get("responsibleId"),
		)

__all__ = ['DeviceByHcPartyFilter']