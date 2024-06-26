import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class UsersByPatientIdFilter:
	patient_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"patientId": self.patient_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersByPatientIdFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			patient_id = deserialized_dict["patientId"],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['UsersByPatientIdFilter']