import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class Basic:
	username: str
	password: str

	def __serialize__(self) -> object:
		return {
			"username": self.username,
			"password": self.password,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Basic':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			username = deserialized_dict["username"],
			password = deserialized_dict["password"],
		)

__all__ = ['Basic']