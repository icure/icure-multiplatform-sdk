import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class PatientByHcPartyDateOfBirthBetweenFilter:
	desc: Optional[str] = None
	min_date_of_birth: Optional[int] = None
	max_date_of_birth: Optional[int] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"minDateOfBirth": self.min_date_of_birth,
			"maxDateOfBirth": self.max_date_of_birth,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyDateOfBirthBetweenFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			min_date_of_birth = deserialized_dict.get("minDateOfBirth"),
			max_date_of_birth = deserialized_dict.get("maxDateOfBirth"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
		)

__all__ = ['PatientByHcPartyDateOfBirthBetweenFilter']