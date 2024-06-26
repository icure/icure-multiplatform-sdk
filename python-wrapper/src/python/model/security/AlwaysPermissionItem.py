import json
from model.security.PermissionType import PermissionType
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class AlwaysPermissionItem:
	type: 'PermissionType'

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AlwaysPermissionItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = PermissionType._deserialize(deserialized_dict["type"]),
		)

__all__ = ['AlwaysPermissionItem']