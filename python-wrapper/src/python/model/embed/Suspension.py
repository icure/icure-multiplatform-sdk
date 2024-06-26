import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class Suspension:
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	suspension_reason: Optional[str] = None
	lifecycle: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"suspensionReason": self.suspension_reason,
			"lifecycle": self.lifecycle,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Suspension':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			begin_moment = deserialized_dict.get("beginMoment"),
			end_moment = deserialized_dict.get("endMoment"),
			suspension_reason = deserialized_dict.get("suspensionReason"),
			lifecycle = deserialized_dict.get("lifecycle"),
		)

__all__ = ['Suspension']