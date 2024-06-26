import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.TopicRole import TopicRole
from model.embed.SecurityMetadata import SecurityMetadata
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String

Topic = Union['DecryptedTopic', 'EncryptedTopic']

def serialize_topic(topic: Topic) -> object:
	if isinstance(topic, DecryptedTopic):
		return {
			"type": "com.icure.sdk.model.DecryptedTopic",
			"entity": topic.__serialize__()
		}
	elif isinstance(topic, EncryptedTopic):
		return {
			"type": "com.icure.sdk.model.EncryptedTopic",
			"entity": topic.__serialize__()
		}
	else:
		raise Exception(f"{type(topic)} is not a known subclass of Topic")

def deserialize_topic(data: Union[str, Dict[str, object]]) -> 'Topic':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedTopic":
		DecryptedTopic._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedTopic":
		EncryptedTopic._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Topic")

@dataclass
class DecryptedTopic:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	health_element_id: Optional[str] = None
	contact_id: Optional[str] = None
	description: Optional[str] = None
	codes: List['CodeStub'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	active_participants: Dict[str, 'TopicRole'] = field(default_factory=dict)
	security_metadata: Optional['SecurityMetadata'] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	linked_health_elements: List[str] = field(default_factory=list)
	linked_services: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"healthElementId": self.health_element_id,
			"contactId": self.contact_id,
			"description": self.description,
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"activeParticipants": {k0: v0.__serialize__() for k0, v0 in self.active_participants.items()},
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"linkedHealthElements": [x0 for x0 in self.linked_health_elements],
			"linkedServices": [x0 for x0 in self.linked_services],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedTopic':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			health_element_id = deserialized_dict.get("healthElementId"),
			contact_id = deserialized_dict.get("contactId"),
			description = deserialized_dict.get("description"),
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			active_participants = dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			linked_health_elements = [x0 for x0 in deserialized_dict["linkedHealthElements"]],
			linked_services = [x0 for x0 in deserialized_dict["linkedServices"]],
		)

@dataclass
class EncryptedTopic:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	health_element_id: Optional[str] = None
	contact_id: Optional[str] = None
	description: Optional[str] = None
	codes: List['CodeStub'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	active_participants: Dict[str, 'TopicRole'] = field(default_factory=dict)
	security_metadata: Optional['SecurityMetadata'] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	linked_health_elements: List[str] = field(default_factory=list)
	linked_services: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"healthElementId": self.health_element_id,
			"contactId": self.contact_id,
			"description": self.description,
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"activeParticipants": {k0: v0.__serialize__() for k0, v0 in self.active_participants.items()},
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"linkedHealthElements": [x0 for x0 in self.linked_health_elements],
			"linkedServices": [x0 for x0 in self.linked_services],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedTopic':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			health_element_id = deserialized_dict.get("healthElementId"),
			contact_id = deserialized_dict.get("contactId"),
			description = deserialized_dict.get("description"),
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			active_participants = dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			linked_health_elements = [x0 for x0 in deserialized_dict["linkedHealthElements"]],
			linked_services = [x0 for x0 in deserialized_dict["linkedServices"]],
		)

__all__ = ['Topic','serialize_topic','deserialize_topic','DecryptedTopic','EncryptedTopic']