import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientByHcPartyAndExternalIdFilter:
	desc: Optional[str] = None
	external_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"externalId": self.external_id,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndExternalIdFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			external_id = deserialized_dict.get("externalId"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
		)

__all__ = ['PatientByHcPartyAndExternalIdFilter']