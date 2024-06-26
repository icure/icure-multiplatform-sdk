import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class CalendarItemTag:
	code: Optional[str] = None
	date: Optional[int] = None
	user_id: Optional[str] = None
	user_name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"code": self.code,
			"date": self.date,
			"userId": self.user_id,
			"userName": self.user_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CalendarItemTag':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code = deserialized_dict.get("code"),
			date = deserialized_dict.get("date"),
			user_id = deserialized_dict.get("userId"),
			user_name = deserialized_dict.get("userName"),
		)

__all__ = ['CalendarItemTag']