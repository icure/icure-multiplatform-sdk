import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class Weekday:
	weekday: Optional['CodeStub'] = None
	week_number: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"weekNumber": self.week_number,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Weekday':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			weekday = CodeStub._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			week_number = deserialized_dict.get("weekNumber"),
		)

__all__ = ['Weekday']