import json
from model.embed.AuthenticationClass import AuthenticationClass
from typing import Optional, List, Dict, Union
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.PropertyStub import DecryptedPropertyStub
from model.embed.UserType import UserType
from model.security.OperationToken import OperationToken

@dataclass
class Group:
	id: str
	minimum_authentication_class_for_elevated_privileges: 'AuthenticationClass'
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	tags: List['CodeStub'] = field(default_factory=list)
	name: Optional[str] = None
	password: Optional[str] = None
	servers: Optional[List[str]] = None
	super_admin: bool = False
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	default_user_roles: Dict['UserType', List[str]] = field(default_factory=dict)
	operation_tokens: Dict[str, 'OperationToken'] = field(default_factory=dict)
	shared_entities: Dict[str, str] = field(default_factory=dict)
	minimum_kraken_version: Optional[str] = None
	super_group: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"name": self.name,
			"password": self.password,
			"servers": [x0 for x0 in self.servers] if self.servers is not None else None,
			"superAdmin": self.super_admin,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"defaultUserRoles": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.default_user_roles.items()},
			"operationTokens": {k0: v0.__serialize__() for k0, v0 in self.operation_tokens.items()},
			"sharedEntities": {k0: v0 for k0, v0 in self.shared_entities.items()},
			"minimumKrakenVersion": self.minimum_kraken_version,
			"minimumAuthenticationClassForElevatedPrivileges": self.minimum_authentication_class_for_elevated_privileges.__serialize__(),
			"superGroup": self.super_group,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Group':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			name = deserialized_dict.get("name"),
			password = deserialized_dict.get("password"),
			servers = [x0 for x0 in deserialized_dict.get("servers")] if deserialized_dict.get("servers") is not None else None,
			super_admin = deserialized_dict["superAdmin"],
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			default_user_roles = dict(map(lambda kv0: (UserType._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["defaultUserRoles"].items())),
			operation_tokens = dict(map(lambda kv0: (kv0[0], OperationToken._deserialize(kv0[1])), deserialized_dict["operationTokens"].items())),
			shared_entities = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["sharedEntities"].items())),
			minimum_kraken_version = deserialized_dict.get("minimumKrakenVersion"),
			minimum_authentication_class_for_elevated_privileges = AuthenticationClass._deserialize(deserialized_dict["minimumAuthenticationClassForElevatedPrivileges"]),
			super_group = deserialized_dict.get("superGroup"),
		)

__all__ = ['Group']