import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class HealthElementByHcPartySecretForeignKeysFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_secret_foreign_keys: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKeys": [x0 for x0 in self.patient_secret_foreign_keys],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartySecretForeignKeysFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_keys = [x0 for x0 in deserialized_dict["patientSecretForeignKeys"]],
		)

__all__ = ['HealthElementByHcPartySecretForeignKeysFilter']