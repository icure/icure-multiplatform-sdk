import json
from typing import List, Union, Dict
from model.security.PermissionItem import PermissionItem, serialize_permission_item, deserialize_permission_item
from dataclasses import field, dataclass

@dataclass
class Permission:
	grants: List['PermissionItem'] = field(default_factory=list)
	revokes: List['PermissionItem'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"grants": [serialize_permission_item(x0) for x0 in self.grants],
			"revokes": [serialize_permission_item(x0) for x0 in self.revokes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Permission':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			grants = [deserialize_permission_item(x0) for x0 in deserialized_dict["grants"]],
			revokes = [deserialize_permission_item(x0) for x0 in deserialized_dict["revokes"]],
		)

__all__ = ['Permission']