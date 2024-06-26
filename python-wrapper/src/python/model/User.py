import json
from typing import Optional, List, Dict, Union
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.PropertyStub import DecryptedPropertyStub
from model.security.Permission import Permission
from model.enums.UsersType import UsersType
from model.enums.UsersStatus import UsersStatus
from model.embed.DelegationTag import DelegationTag
from model.security.AuthenticationToken import AuthenticationToken

@dataclass
class User:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	created: Optional[int] = None
	identifier: List['Identifier'] = field(default_factory=list)
	name: Optional[str] = None
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	permissions: List['Permission'] = field(default_factory=list)
	roles: List[str] = field(default_factory=list)
	type: Optional['UsersType'] = None
	status: Optional['UsersStatus'] = None
	login: Optional[str] = None
	password_hash: Optional[str] = None
	group_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_id: Optional[str] = None
	device_id: Optional[str] = None
	auto_delegations: Dict['DelegationTag', List[str]] = field(default_factory=dict)
	created_date: Optional[int] = None
	terms_of_use_date: Optional[int] = None
	email: Optional[str] = None
	mobile_phone: Optional[str] = None
	application_tokens: Dict[str, str] = field(default_factory=dict)
	authentication_tokens: Dict[str, 'AuthenticationToken'] = field(default_factory=dict)
	system_metadata: Optional['SystemMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"created": self.created,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"name": self.name,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"permissions": [x0.__serialize__() for x0 in self.permissions],
			"roles": [x0 for x0 in self.roles],
			"type": self.type.__serialize__() if self.type is not None else None,
			"status": self.status.__serialize__() if self.status is not None else None,
			"login": self.login,
			"passwordHash": self.password_hash,
			"groupId": self.group_id,
			"healthcarePartyId": self.healthcare_party_id,
			"patientId": self.patient_id,
			"deviceId": self.device_id,
			"autoDelegations": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.auto_delegations.items()},
			"createdDate": self.created_date,
			"termsOfUseDate": self.terms_of_use_date,
			"email": self.email,
			"mobilePhone": self.mobile_phone,
			"applicationTokens": {k0: v0 for k0, v0 in self.application_tokens.items()},
			"authenticationTokens": {k0: v0.__serialize__() for k0, v0 in self.authentication_tokens.items()},
			"systemMetadata": self.system_metadata.__serialize__() if self.system_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'User':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			created = deserialized_dict.get("created"),
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			name = deserialized_dict.get("name"),
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			permissions = [Permission._deserialize(x0) for x0 in deserialized_dict["permissions"]],
			roles = [x0 for x0 in deserialized_dict["roles"]],
			type = UsersType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status = UsersStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			login = deserialized_dict.get("login"),
			password_hash = deserialized_dict.get("passwordHash"),
			group_id = deserialized_dict.get("groupId"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			patient_id = deserialized_dict.get("patientId"),
			device_id = deserialized_dict.get("deviceId"),
			auto_delegations = dict(map(lambda kv0: (DelegationTag._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["autoDelegations"].items())),
			created_date = deserialized_dict.get("createdDate"),
			terms_of_use_date = deserialized_dict.get("termsOfUseDate"),
			email = deserialized_dict.get("email"),
			mobile_phone = deserialized_dict.get("mobilePhone"),
			application_tokens = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["applicationTokens"].items())),
			authentication_tokens = dict(map(lambda kv0: (kv0[0], AuthenticationToken._deserialize(kv0[1])), deserialized_dict["authenticationTokens"].items())),
			system_metadata = SystemMetadata._deserialize(deserialized_dict.get("systemMetadata")) if deserialized_dict.get("systemMetadata") is not None else None,
		)

	@dataclass
	class SystemMetadata:
		roles: List[str]
		is_admin: bool
		inherits_roles: bool

		def __serialize__(self) -> object:
			return {
				"roles": [x0 for x0 in self.roles],
				"isAdmin": self.is_admin,
				"inheritsRoles": self.inherits_roles,
			}

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SystemMetadata':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				roles = [x0 for x0 in deserialized_dict["roles"]],
				is_admin = deserialized_dict["isAdmin"],
				inherits_roles = deserialized_dict["inheritsRoles"],
			)

__all__ = ['User']