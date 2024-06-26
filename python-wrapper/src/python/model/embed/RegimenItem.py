import json
from typing import Optional, Union, Dict
from model.embed.Weekday import Weekday
from model.base.CodeStub import CodeStub
from model.embed.AdministrationQuantity import AdministrationQuantity
from dataclasses import dataclass

@dataclass
class RegimenItem:
	date: Optional[int] = None
	day_number: Optional[int] = None
	weekday: Optional['Weekday'] = None
	day_period: Optional['CodeStub'] = None
	time_of_day: Optional[int] = None
	administrated_quantity: Optional['AdministrationQuantity'] = None

	def __serialize__(self) -> object:
		return {
			"date": self.date,
			"dayNumber": self.day_number,
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"dayPeriod": self.day_period.__serialize__() if self.day_period is not None else None,
			"timeOfDay": self.time_of_day,
			"administratedQuantity": self.administrated_quantity.__serialize__() if self.administrated_quantity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegimenItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			date = deserialized_dict.get("date"),
			day_number = deserialized_dict.get("dayNumber"),
			weekday = Weekday._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			day_period = CodeStub._deserialize(deserialized_dict.get("dayPeriod")) if deserialized_dict.get("dayPeriod") is not None else None,
			time_of_day = deserialized_dict.get("timeOfDay"),
			administrated_quantity = AdministrationQuantity._deserialize(deserialized_dict.get("administratedQuantity")) if deserialized_dict.get("administratedQuantity") is not None else None,
		)

__all__ = ['RegimenItem']