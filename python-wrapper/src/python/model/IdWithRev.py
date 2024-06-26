import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class IdWithRev:
	id: str
	rev: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdWithRev':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
		)

__all__ = ['IdWithRev']