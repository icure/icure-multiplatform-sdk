import json
from typing import Union, Dict
from model.security.AlwaysPermissionItem import AlwaysPermissionItem

PermissionItem = Union['AlwaysPermissionItem']

def serialize_permission_item(permission_item: PermissionItem) -> object:
	if isinstance(permission_item, AlwaysPermissionItem):
		serialized_entity = permission_item.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.security.AlwaysPermissionItem"})
		return serialized_entity
	else:
		raise Exception(f"{type(permission_item)} is not a known subclass of PermissionItem")

def deserialize_permission_item(data: Union[str, Dict[str, object]]) -> 'PermissionItem':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.security.AlwaysPermissionItem":
		AlwaysPermissionItem._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PermissionItem")

__all__ = ['PermissionItem','serialize_permission_item','deserialize_permission_item']