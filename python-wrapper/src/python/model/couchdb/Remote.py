import json
from typing import Optional, Union, Dict
from model.couchdb.RemoteAuthentication import RemoteAuthentication
from dataclasses import dataclass

@dataclass
class Remote:
	url: str
	auth: Optional['RemoteAuthentication'] = None

	def __serialize__(self) -> object:
		return {
			"url": self.url,
			"auth": self.auth.__serialize__() if self.auth is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Remote':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			url = deserialized_dict["url"],
			auth = RemoteAuthentication._deserialize(deserialized_dict.get("auth")) if deserialized_dict.get("auth") is not None else None,
		)

__all__ = ['Remote']