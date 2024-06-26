import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ReplicationInfo:
	active: bool = False
	running: bool = False
	pending_from: Optional[int] = None
	pending_to: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"active": self.active,
			"running": self.running,
			"pendingFrom": self.pending_from,
			"pendingTo": self.pending_to,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicationInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			active = deserialized_dict["active"],
			running = deserialized_dict["running"],
			pending_from = deserialized_dict.get("pendingFrom"),
			pending_to = deserialized_dict.get("pendingTo"),
		)

__all__ = ['ReplicationInfo']