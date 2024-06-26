import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientByHcPartyAndAddressFilter:
	desc: Optional[str] = None
	search_string: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	postal_code: Optional[str] = None
	house_number: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"searchString": self.search_string,
			"healthcarePartyId": self.healthcare_party_id,
			"postalCode": self.postal_code,
			"houseNumber": self.house_number,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndAddressFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			search_string = deserialized_dict.get("searchString"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			postal_code = deserialized_dict.get("postalCode"),
			house_number = deserialized_dict.get("houseNumber"),
		)

__all__ = ['PatientByHcPartyAndAddressFilter']