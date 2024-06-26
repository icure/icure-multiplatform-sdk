import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientByHcPartyAndSsinFilter:
	ssin: str
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ssin": self.ssin,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndSsinFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			ssin = deserialized_dict["ssin"],
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
		)

__all__ = ['PatientByHcPartyAndSsinFilter']