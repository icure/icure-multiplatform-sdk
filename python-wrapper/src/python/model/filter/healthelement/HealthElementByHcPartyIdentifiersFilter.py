import json
from typing import Optional, List, Union, Dict
from model.base.Identifier import Identifier
from dataclasses import field, dataclass

@dataclass
class HealthElementByHcPartyIdentifiersFilter:
	desc: Optional[str] = None
	hc_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"hcPartyId": self.hc_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartyIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			hc_party_id = deserialized_dict.get("hcPartyId"),
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
		)

__all__ = ['HealthElementByHcPartyIdentifiersFilter']