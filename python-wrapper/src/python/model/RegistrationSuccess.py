import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class RegistrationSuccess:
	group_id: str
	user_id: str
	token: str

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegistrationSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id = deserialized_dict["groupId"],
			user_id = deserialized_dict["userId"],
			token = deserialized_dict["token"],
		)

__all__ = ['RegistrationSuccess']