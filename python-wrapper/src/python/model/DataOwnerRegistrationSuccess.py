import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class DataOwnerRegistrationSuccess:
	user_login: str
	user_id: str
	token: str

	def __serialize__(self) -> object:
		return {
			"userLogin": self.user_login,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerRegistrationSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			user_login = deserialized_dict["userLogin"],
			user_id = deserialized_dict["userId"],
			token = deserialized_dict["token"],
		)

__all__ = ['DataOwnerRegistrationSuccess']