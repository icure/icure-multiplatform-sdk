import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class TokenWithGroup:
	token: str
	group_id: str
	group_name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"token": self.token,
			"groupId": self.group_id,
			"groupName": self.group_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TokenWithGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token = deserialized_dict["token"],
			group_id = deserialized_dict["groupId"],
			group_name = deserialized_dict.get("groupName"),
		)

__all__ = ['TokenWithGroup']