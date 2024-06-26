import json
from typing import List, Optional, Union, Dict
from model.base.Identifier import Identifier
from dataclasses import field, dataclass

@dataclass
class HealthcarePartyByIdentifiersFilter:
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['HealthcarePartyByIdentifiersFilter']