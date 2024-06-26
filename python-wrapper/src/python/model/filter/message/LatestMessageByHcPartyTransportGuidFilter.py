import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class LatestMessageByHcPartyTransportGuidFilter:
	healthcare_party_id: str
	transport_guid: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"transportGuid": self.transport_guid,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LatestMessageByHcPartyTransportGuidFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id = deserialized_dict["healthcarePartyId"],
			transport_guid = deserialized_dict["transportGuid"],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['LatestMessageByHcPartyTransportGuidFilter']