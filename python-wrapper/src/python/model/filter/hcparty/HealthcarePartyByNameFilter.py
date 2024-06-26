import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class HealthcarePartyByNameFilter:
	name: str
	desc: Optional[str] = None
	descending: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"name": self.name,
			"descending": self.descending,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByNameFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			name = deserialized_dict["name"],
			descending = deserialized_dict.get("descending"),
		)

__all__ = ['HealthcarePartyByNameFilter']