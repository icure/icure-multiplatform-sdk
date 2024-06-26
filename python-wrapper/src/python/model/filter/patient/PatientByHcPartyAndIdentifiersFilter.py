import json
from typing import Optional, List, Union, Dict
from model.base.Identifier import Identifier
from dataclasses import field, dataclass

@dataclass
class PatientByHcPartyAndIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['PatientByHcPartyAndIdentifiersFilter']