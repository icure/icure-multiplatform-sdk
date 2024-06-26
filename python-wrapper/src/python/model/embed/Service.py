import json
from typing import Union, Dict, Optional, List
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.embed.Delegation import Delegation
from model.embed.Content import DecryptedContent, EncryptedContent
from model.embed.Annotation import Annotation
from model.base.LinkQualification import LinkQualification
from model.base.CodeStub import CodeStub
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

Service = Union['DecryptedService', 'EncryptedService']

def serialize_service(service: Service) -> object:
	if isinstance(service, DecryptedService):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedService",
			"entity": service.__serialize__()
		}
	elif isinstance(service, EncryptedService):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedService",
			"entity": service.__serialize__()
		}
	else:
		raise Exception(f"{type(service)} is not a known subclass of Service")

def deserialize_service(data: Union[str, Dict[str, object]]) -> 'Service':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedService":
		DecryptedService._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedService":
		EncryptedService._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Service")

@dataclass
class DecryptedService:
	id: str
	transaction_id: Optional[str] = None
	identifier: List['Identifier'] = field(default_factory=list)
	contact_id: Optional[str] = None
	sub_contact_ids: Optional[List[str]] = None
	plans_of_action_ids: Optional[List[str]] = None
	health_elements_ids: Optional[List[str]] = None
	form_ids: Optional[List[str]] = None
	secret_foreign_keys: Optional[List[str]] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	label: Optional[str] = None
	index: Optional[int] = None
	content: Dict[str, 'DecryptedContent'] = field(default_factory=dict)
	encrypted_content: Optional[str] = None
	text_indexes: Dict[str, str] = field(default_factory=dict)
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	form_id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	end_of_life: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	comment: Optional[str] = None
	status: Optional[int] = None
	invoicing_codes: List[str] = field(default_factory=list)
	notes: List['Annotation'] = field(default_factory=list)
	qualified_links: Dict['LinkQualification', Dict[str, str]] = field(default_factory=dict)
	codes: List['CodeStub'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"transactionId": self.transaction_id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"contactId": self.contact_id,
			"subContactIds": [x0 for x0 in self.sub_contact_ids] if self.sub_contact_ids is not None else None,
			"plansOfActionIds": [x0 for x0 in self.plans_of_action_ids] if self.plans_of_action_ids is not None else None,
			"healthElementsIds": [x0 for x0 in self.health_elements_ids] if self.health_elements_ids is not None else None,
			"formIds": [x0 for x0 in self.form_ids] if self.form_ids is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys] if self.secret_foreign_keys is not None else None,
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"label": self.label,
			"index": self.index,
			"content": {k0: v0.__serialize__() for k0, v0 in self.content.items()},
			"encryptedContent": self.encrypted_content,
			"textIndexes": {k0: v0 for k0, v0 in self.text_indexes.items()},
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"formId": self.form_id,
			"created": self.created,
			"modified": self.modified,
			"endOfLife": self.end_of_life,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"comment": self.comment,
			"status": self.status,
			"invoicingCodes": [x0 for x0 in self.invoicing_codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"qualifiedLinks": {k0.__serialize__(): {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.qualified_links.items()},
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedService':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			transaction_id = deserialized_dict.get("transactionId"),
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id = deserialized_dict.get("contactId"),
			sub_contact_ids = [x0 for x0 in deserialized_dict.get("subContactIds")] if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids = [x0 for x0 in deserialized_dict.get("plansOfActionIds")] if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids = [x0 for x0 in deserialized_dict.get("healthElementsIds")] if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids = [x0 for x0 in deserialized_dict.get("formIds")] if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict.get("secretForeignKeys")] if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label = deserialized_dict.get("label"),
			index = deserialized_dict.get("index"),
			content = dict(map(lambda kv0: (kv0[0], DecryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content = deserialized_dict.get("encryptedContent"),
			text_indexes = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			form_id = deserialized_dict.get("formId"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			end_of_life = deserialized_dict.get("endOfLife"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			comment = deserialized_dict.get("comment"),
			status = deserialized_dict.get("status"),
			invoicing_codes = [x0 for x0 in deserialized_dict["invoicingCodes"]],
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links = dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedService:
	id: str
	transaction_id: Optional[str] = None
	identifier: List['Identifier'] = field(default_factory=list)
	contact_id: Optional[str] = None
	sub_contact_ids: Optional[List[str]] = None
	plans_of_action_ids: Optional[List[str]] = None
	health_elements_ids: Optional[List[str]] = None
	form_ids: Optional[List[str]] = None
	secret_foreign_keys: Optional[List[str]] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	label: Optional[str] = None
	index: Optional[int] = None
	content: Dict[str, 'EncryptedContent'] = field(default_factory=dict)
	encrypted_content: Optional[str] = None
	text_indexes: Dict[str, str] = field(default_factory=dict)
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	form_id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	end_of_life: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	comment: Optional[str] = None
	status: Optional[int] = None
	invoicing_codes: List[str] = field(default_factory=list)
	notes: List['Annotation'] = field(default_factory=list)
	qualified_links: Dict['LinkQualification', Dict[str, str]] = field(default_factory=dict)
	codes: List['CodeStub'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"transactionId": self.transaction_id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"contactId": self.contact_id,
			"subContactIds": [x0 for x0 in self.sub_contact_ids] if self.sub_contact_ids is not None else None,
			"plansOfActionIds": [x0 for x0 in self.plans_of_action_ids] if self.plans_of_action_ids is not None else None,
			"healthElementsIds": [x0 for x0 in self.health_elements_ids] if self.health_elements_ids is not None else None,
			"formIds": [x0 for x0 in self.form_ids] if self.form_ids is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys] if self.secret_foreign_keys is not None else None,
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"label": self.label,
			"index": self.index,
			"content": {k0: v0.__serialize__() for k0, v0 in self.content.items()},
			"encryptedContent": self.encrypted_content,
			"textIndexes": {k0: v0 for k0, v0 in self.text_indexes.items()},
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"formId": self.form_id,
			"created": self.created,
			"modified": self.modified,
			"endOfLife": self.end_of_life,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"comment": self.comment,
			"status": self.status,
			"invoicingCodes": [x0 for x0 in self.invoicing_codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"qualifiedLinks": {k0.__serialize__(): {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.qualified_links.items()},
			"codes": [x0.__serialize__() for x0 in self.codes],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedService':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			transaction_id = deserialized_dict.get("transactionId"),
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id = deserialized_dict.get("contactId"),
			sub_contact_ids = [x0 for x0 in deserialized_dict.get("subContactIds")] if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids = [x0 for x0 in deserialized_dict.get("plansOfActionIds")] if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids = [x0 for x0 in deserialized_dict.get("healthElementsIds")] if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids = [x0 for x0 in deserialized_dict.get("formIds")] if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict.get("secretForeignKeys")] if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label = deserialized_dict.get("label"),
			index = deserialized_dict.get("index"),
			content = dict(map(lambda kv0: (kv0[0], EncryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content = deserialized_dict.get("encryptedContent"),
			text_indexes = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			form_id = deserialized_dict.get("formId"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			end_of_life = deserialized_dict.get("endOfLife"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			comment = deserialized_dict.get("comment"),
			status = deserialized_dict.get("status"),
			invoicing_codes = [x0 for x0 in deserialized_dict["invoicingCodes"]],
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links = dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['Service','serialize_service','deserialize_service','DecryptedService','EncryptedService']