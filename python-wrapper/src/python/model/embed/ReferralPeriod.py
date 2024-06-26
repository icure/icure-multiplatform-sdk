import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ReferralPeriod:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	comment: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"comment": self.comment,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReferralPeriod':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			comment = deserialized_dict.get("comment"),
		)

__all__ = ['ReferralPeriod']