import json
from typing import List, Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ServiceBySecretForeignKeys:
	patient_secret_foreign_keys: List[str]
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKeys": [x0 for x0 in self.patient_secret_foreign_keys],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceBySecretForeignKeys':
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

__all__ = ['ServiceBySecretForeignKeys']