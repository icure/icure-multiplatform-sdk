import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class TopicByParticipantFilter:
	participant_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"participantId": self.participant_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicByParticipantFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			participant_id = deserialized_dict["participantId"],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['TopicByParticipantFilter']