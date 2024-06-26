import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class DocumentGroup:
	guid: Optional[str] = None
	name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"guid": self.guid,
			"name": self.name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			guid = deserialized_dict.get("guid"),
			name = deserialized_dict.get("name"),
		)

__all__ = ['DocumentGroup']