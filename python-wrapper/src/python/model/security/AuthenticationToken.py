import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class AuthenticationToken:
	creation_time: int
	validity: int
	token: Optional[str] = None
	deletion_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"token": self.token,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"deletionDate": self.deletion_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AuthenticationToken':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token = deserialized_dict.get("token"),
			creation_time = deserialized_dict["creationTime"],
			validity = deserialized_dict["validity"],
			deletion_date = deserialized_dict.get("deletionDate"),
		)

__all__ = ['AuthenticationToken']