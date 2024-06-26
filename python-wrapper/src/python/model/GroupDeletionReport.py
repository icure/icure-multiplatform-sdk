import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class GroupDeletionReport:
	type: str
	id: str
	server: str

	def __serialize__(self) -> object:
		return {
			"type": self.type,
			"id": self.id,
			"server": self.server,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupDeletionReport':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = deserialized_dict["type"],
			id = deserialized_dict["id"],
			server = deserialized_dict["server"],
		)

__all__ = ['GroupDeletionReport']