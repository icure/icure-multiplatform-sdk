import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class MessageReadStatus:
	time: Optional[int] = None
	read: bool = False

	def __serialize__(self) -> object:
		return {
			"time": self.time,
			"read": self.read,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageReadStatus':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			time = deserialized_dict.get("time"),
			read = deserialized_dict["read"],
		)

__all__ = ['MessageReadStatus']