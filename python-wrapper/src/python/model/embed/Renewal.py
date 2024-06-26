import json
from typing import Optional, Union, Dict
from model.embed.Duration import Duration
from dataclasses import dataclass

@dataclass
class Renewal:
	decimal: Optional[int] = None
	duration: Optional['Duration'] = None

	def __serialize__(self) -> object:
		return {
			"decimal": self.decimal,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Renewal':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			decimal = deserialized_dict.get("decimal"),
			duration = Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
		)

__all__ = ['Renewal']