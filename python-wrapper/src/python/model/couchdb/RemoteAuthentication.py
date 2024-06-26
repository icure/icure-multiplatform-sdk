import json
from typing import Optional, Union, Dict
from model.couchdb.Basic import Basic
from dataclasses import dataclass

@dataclass
class RemoteAuthentication:
	basic: Optional['Basic'] = None

	def __serialize__(self) -> object:
		return {
			"basic": self.basic.__serialize__() if self.basic is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RemoteAuthentication':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			basic = Basic._deserialize(deserialized_dict.get("basic")) if deserialized_dict.get("basic") is not None else None,
		)

__all__ = ['RemoteAuthentication']