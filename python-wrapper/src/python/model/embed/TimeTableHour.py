import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class TimeTableHour:
	start_hour: Optional[int] = None
	end_hour: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"startHour": self.start_hour,
			"endHour": self.end_hour,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableHour':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_hour = deserialized_dict.get("startHour"),
			end_hour = deserialized_dict.get("endHour"),
		)

__all__ = ['TimeTableHour']