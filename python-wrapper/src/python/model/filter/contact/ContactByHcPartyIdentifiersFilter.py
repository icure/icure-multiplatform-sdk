import json
from typing import Optional, List, Union, Dict
from model.base.Identifier import Identifier
from dataclasses import field, dataclass

@dataclass
class ContactByHcPartyIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	desc: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"desc": self.desc,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			desc = deserialized_dict.get("desc"),
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
		)

__all__ = ['ContactByHcPartyIdentifiersFilter']