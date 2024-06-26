import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

Form = Union['EncryptedForm', 'DecryptedForm']

def serialize_form(form: Form) -> object:
	if isinstance(form, EncryptedForm):
		return {
			"type": "com.icure.sdk.model.EncryptedForm",
			"entity": form.__serialize__()
		}
	elif isinstance(form, DecryptedForm):
		return {
			"type": "com.icure.sdk.model.DecryptedForm",
			"entity": form.__serialize__()
		}
	else:
		raise Exception(f"{type(form)} is not a known subclass of Form")

def deserialize_form(data: Union[str, Dict[str, object]]) -> 'Form':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedForm":
		EncryptedForm._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedForm":
		DecryptedForm._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Form")

@dataclass
class EncryptedForm:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	opening_date: Optional[int] = None
	status: Optional[str] = None
	version: Optional[int] = None
	logical_uuid: Optional[str] = None
	descr: Optional[str] = None
	unique_id: Optional[str] = None
	form_template_id: Optional[str] = None
	contact_id: Optional[str] = None
	health_element_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	parent: Optional[str] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"openingDate": self.opening_date,
			"status": self.status,
			"version": self.version,
			"logicalUuid": self.logical_uuid,
			"descr": self.descr,
			"uniqueId": self.unique_id,
			"formTemplateId": self.form_template_id,
			"contactId": self.contact_id,
			"healthElementId": self.health_element_id,
			"planOfActionId": self.plan_of_action_id,
			"parent": self.parent,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedForm':
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
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			opening_date = deserialized_dict.get("openingDate"),
			status = deserialized_dict.get("status"),
			version = deserialized_dict.get("version"),
			logical_uuid = deserialized_dict.get("logicalUuid"),
			descr = deserialized_dict.get("descr"),
			unique_id = deserialized_dict.get("uniqueId"),
			form_template_id = deserialized_dict.get("formTemplateId"),
			contact_id = deserialized_dict.get("contactId"),
			health_element_id = deserialized_dict.get("healthElementId"),
			plan_of_action_id = deserialized_dict.get("planOfActionId"),
			parent = deserialized_dict.get("parent"),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedForm:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	opening_date: Optional[int] = None
	status: Optional[str] = None
	version: Optional[int] = None
	logical_uuid: Optional[str] = None
	descr: Optional[str] = None
	unique_id: Optional[str] = None
	form_template_id: Optional[str] = None
	contact_id: Optional[str] = None
	health_element_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	parent: Optional[str] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"openingDate": self.opening_date,
			"status": self.status,
			"version": self.version,
			"logicalUuid": self.logical_uuid,
			"descr": self.descr,
			"uniqueId": self.unique_id,
			"formTemplateId": self.form_template_id,
			"contactId": self.contact_id,
			"healthElementId": self.health_element_id,
			"planOfActionId": self.plan_of_action_id,
			"parent": self.parent,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedForm':
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
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			opening_date = deserialized_dict.get("openingDate"),
			status = deserialized_dict.get("status"),
			version = deserialized_dict.get("version"),
			logical_uuid = deserialized_dict.get("logicalUuid"),
			descr = deserialized_dict.get("descr"),
			unique_id = deserialized_dict.get("uniqueId"),
			form_template_id = deserialized_dict.get("formTemplateId"),
			contact_id = deserialized_dict.get("contactId"),
			health_element_id = deserialized_dict.get("healthElementId"),
			plan_of_action_id = deserialized_dict.get("planOfActionId"),
			parent = deserialized_dict.get("parent"),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['Form','serialize_form','deserialize_form','EncryptedForm','DecryptedForm']