import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class MaintenanceTaskAfterDateFilter:
	date: int
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"date": self.date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskAfterDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			date = deserialized_dict["date"],
		)

__all__ = ['MaintenanceTaskAfterDateFilter']