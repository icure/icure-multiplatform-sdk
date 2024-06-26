import json
from typing import Optional, List, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientByHcPartyAndSsinsFilter:
	desc: Optional[str] = None
	ssins: Optional[List[str]] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ssins": [x0 for x0 in self.ssins] if self.ssins is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndSsinsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			ssins = [x0 for x0 in deserialized_dict.get("ssins")] if deserialized_dict.get("ssins") is not None else None,
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
		)

__all__ = ['PatientByHcPartyAndSsinsFilter']