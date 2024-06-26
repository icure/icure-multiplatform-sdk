import json
from typing import List, Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ServiceByContactsAndSubcontactsFilter:
	contacts: List[str]
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	sub_contacts: Optional[List[str]] = None
	start_value_date: Optional[int] = None
	end_value_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"contacts": [x0 for x0 in self.contacts],
			"subContacts": [x0 for x0 in self.sub_contacts] if self.sub_contacts is not None else None,
			"startValueDate": self.start_value_date,
			"endValueDate": self.end_value_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByContactsAndSubcontactsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			contacts = [x0 for x0 in deserialized_dict["contacts"]],
			sub_contacts = [x0 for x0 in deserialized_dict.get("subContacts")] if deserialized_dict.get("subContacts") is not None else None,
			start_value_date = deserialized_dict.get("startValueDate"),
			end_value_date = deserialized_dict.get("endValueDate"),
		)

__all__ = ['ServiceByContactsAndSubcontactsFilter']