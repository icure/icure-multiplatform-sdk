import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class ServiceByHcPartyHealthElementIdsFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	health_element_ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"healthElementIds": [x0 for x0 in self.health_element_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyHealthElementIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			health_element_ids = [x0 for x0 in deserialized_dict["healthElementIds"]],
		)

__all__ = ['ServiceByHcPartyHealthElementIdsFilter']