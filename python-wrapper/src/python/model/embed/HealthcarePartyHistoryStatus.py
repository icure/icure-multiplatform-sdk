import json
from model.embed.HealthcarePartyStatus import HealthcarePartyStatus
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class HealthcarePartyHistoryStatus:
	status: 'HealthcarePartyStatus'
	specialisation_code: str
	start_date: int
	active: bool

	def __serialize__(self) -> object:
		return {
			"status": self.status.__serialize__(),
			"specialisationCode": self.specialisation_code,
			"startDate": self.start_date,
			"active": self.active,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyHistoryStatus':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			status = HealthcarePartyStatus._deserialize(deserialized_dict["status"]),
			specialisation_code = deserialized_dict["specialisationCode"],
			start_date = deserialized_dict["startDate"],
			active = deserialized_dict["active"],
		)

__all__ = ['HealthcarePartyHistoryStatus']