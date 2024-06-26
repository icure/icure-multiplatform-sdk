import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass
from model.embed.PersonNameUse import PersonNameUse

@dataclass
class PersonName:
	last_name: Optional[str] = None
	first_names: List[str] = field(default_factory=list)
	start: Optional[int] = None
	end: Optional[int] = None
	prefix: List[str] = field(default_factory=list)
	suffix: List[str] = field(default_factory=list)
	text: Optional[str] = None
	use: Optional['PersonNameUse'] = None

	def __serialize__(self) -> object:
		return {
			"lastName": self.last_name,
			"firstNames": [x0 for x0 in self.first_names],
			"start": self.start,
			"end": self.end,
			"prefix": [x0 for x0 in self.prefix],
			"suffix": [x0 for x0 in self.suffix],
			"text": self.text,
			"use": self.use.__serialize__() if self.use is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonName':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			last_name = deserialized_dict.get("lastName"),
			first_names = [x0 for x0 in deserialized_dict["firstNames"]],
			start = deserialized_dict.get("start"),
			end = deserialized_dict.get("end"),
			prefix = [x0 for x0 in deserialized_dict["prefix"]],
			suffix = [x0 for x0 in deserialized_dict["suffix"]],
			text = deserialized_dict.get("text"),
			use = PersonNameUse._deserialize(deserialized_dict.get("use")) if deserialized_dict.get("use") is not None else None,
		)

__all__ = ['PersonName']