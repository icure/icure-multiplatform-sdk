import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.MessageReadStatus import MessageReadStatus
from model.embed.MessageAttachment import MessageAttachment
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

Message = Union['DecryptedMessage', 'EncryptedMessage']

def serialize_message(message: Message) -> object:
	if instanceof(message, DecryptedMessage):
		return {
			"type": "com.icure.sdk.model.DecryptedMessage",
			"entity": message.__serialize__()
		}
	elif instanceof(message, EncryptedMessage):
		return {
			"type": "com.icure.sdk.model.EncryptedMessage",
			"entity": message.__serialize__()
		}
	else:
		raise Exception(f"{type(message)} is not a known subclass of Message")

def deserialize_message(data: Union[str, Dict[str, object]]) -> 'Message':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedMessage":
		DecryptedMessage._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedMessage":
		EncryptedMessage._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Message")

@dataclass
class DecryptedMessage:
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
	from_address: Optional[str] = None
	from_healthcare_party_id: Optional[str] = None
	form_id: Optional[str] = None
	status: Optional[int] = None
	recipients_type: Optional[str] = None
	recipients: List[str] = field(default_factory=list)
	to_addresses: List[str] = field(default_factory=list)
	received: Optional[int] = None
	sent: Optional[int] = None
	metas: Dict[str, str] = field(default_factory=dict)
	read_status: Dict[str, 'MessageReadStatus'] = field(default_factory=dict)
	message_attachments: List['MessageAttachment'] = field(default_factory=list)
	transport_guid: Optional[str] = None
	remark: Optional[str] = None
	conversation_guid: Optional[str] = None
	subject: Optional[str] = None
	invoice_ids: List[str] = field(default_factory=list)
	parent_id: Optional[str] = None
	external_ref: Optional[str] = None
	unassigned_results: List[str] = field(default_factory=list)
	assigned_results: Dict[str, str] = field(default_factory=dict)
	sender_references: Dict[str, str] = field(default_factory=dict)
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
			"fromAddress": self.from_address,
			"fromHealthcarePartyId": self.from_healthcare_party_id,
			"formId": self.form_id,
			"status": self.status,
			"recipientsType": self.recipients_type,
			"recipients": [x0 for x0 in self.recipients],
			"toAddresses": [x0 for x0 in self.to_addresses],
			"received": self.received,
			"sent": self.sent,
			"metas": {k0: v0 for k0, v0 in self.metas.items()},
			"readStatus": {k0: v0.__serialize__() for k0, v0 in self.read_status.items()},
			"messageAttachments": [x0.__serialize__() for x0 in self.message_attachments],
			"transportGuid": self.transport_guid,
			"remark": self.remark,
			"conversationGuid": self.conversation_guid,
			"subject": self.subject,
			"invoiceIds": [x0 for x0 in self.invoice_ids],
			"parentId": self.parent_id,
			"externalRef": self.external_ref,
			"unassignedResults": [x0 for x0 in self.unassigned_results],
			"assignedResults": {k0: v0 for k0, v0 in self.assigned_results.items()},
			"senderReferences": {k0: v0 for k0, v0 in self.sender_references.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedMessage':
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
			from_address = deserialized_dict.get("fromAddress"),
			from_healthcare_party_id = deserialized_dict.get("fromHealthcarePartyId"),
			form_id = deserialized_dict.get("formId"),
			status = deserialized_dict.get("status"),
			recipients_type = deserialized_dict.get("recipientsType"),
			recipients = [x0 for x0 in deserialized_dict["recipients"]],
			to_addresses = [x0 for x0 in deserialized_dict["toAddresses"]],
			received = deserialized_dict.get("received"),
			sent = deserialized_dict.get("sent"),
			metas = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status = dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments = [MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid = deserialized_dict.get("transportGuid"),
			remark = deserialized_dict.get("remark"),
			conversation_guid = deserialized_dict.get("conversationGuid"),
			subject = deserialized_dict.get("subject"),
			invoice_ids = [x0 for x0 in deserialized_dict["invoiceIds"]],
			parent_id = deserialized_dict.get("parentId"),
			external_ref = deserialized_dict.get("externalRef"),
			unassigned_results = [x0 for x0 in deserialized_dict["unassignedResults"]],
			assigned_results = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedMessage:
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
	from_address: Optional[str] = None
	from_healthcare_party_id: Optional[str] = None
	form_id: Optional[str] = None
	status: Optional[int] = None
	recipients_type: Optional[str] = None
	recipients: List[str] = field(default_factory=list)
	to_addresses: List[str] = field(default_factory=list)
	received: Optional[int] = None
	sent: Optional[int] = None
	metas: Dict[str, str] = field(default_factory=dict)
	read_status: Dict[str, 'MessageReadStatus'] = field(default_factory=dict)
	message_attachments: List['MessageAttachment'] = field(default_factory=list)
	transport_guid: Optional[str] = None
	remark: Optional[str] = None
	conversation_guid: Optional[str] = None
	subject: Optional[str] = None
	invoice_ids: List[str] = field(default_factory=list)
	parent_id: Optional[str] = None
	external_ref: Optional[str] = None
	unassigned_results: List[str] = field(default_factory=list)
	assigned_results: Dict[str, str] = field(default_factory=dict)
	sender_references: Dict[str, str] = field(default_factory=dict)
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
			"fromAddress": self.from_address,
			"fromHealthcarePartyId": self.from_healthcare_party_id,
			"formId": self.form_id,
			"status": self.status,
			"recipientsType": self.recipients_type,
			"recipients": [x0 for x0 in self.recipients],
			"toAddresses": [x0 for x0 in self.to_addresses],
			"received": self.received,
			"sent": self.sent,
			"metas": {k0: v0 for k0, v0 in self.metas.items()},
			"readStatus": {k0: v0.__serialize__() for k0, v0 in self.read_status.items()},
			"messageAttachments": [x0.__serialize__() for x0 in self.message_attachments],
			"transportGuid": self.transport_guid,
			"remark": self.remark,
			"conversationGuid": self.conversation_guid,
			"subject": self.subject,
			"invoiceIds": [x0 for x0 in self.invoice_ids],
			"parentId": self.parent_id,
			"externalRef": self.external_ref,
			"unassignedResults": [x0 for x0 in self.unassigned_results],
			"assignedResults": {k0: v0 for k0, v0 in self.assigned_results.items()},
			"senderReferences": {k0: v0 for k0, v0 in self.sender_references.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedMessage':
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
			from_address = deserialized_dict.get("fromAddress"),
			from_healthcare_party_id = deserialized_dict.get("fromHealthcarePartyId"),
			form_id = deserialized_dict.get("formId"),
			status = deserialized_dict.get("status"),
			recipients_type = deserialized_dict.get("recipientsType"),
			recipients = [x0 for x0 in deserialized_dict["recipients"]],
			to_addresses = [x0 for x0 in deserialized_dict["toAddresses"]],
			received = deserialized_dict.get("received"),
			sent = deserialized_dict.get("sent"),
			metas = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status = dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments = [MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid = deserialized_dict.get("transportGuid"),
			remark = deserialized_dict.get("remark"),
			conversation_guid = deserialized_dict.get("conversationGuid"),
			subject = deserialized_dict.get("subject"),
			invoice_ids = [x0 for x0 in deserialized_dict["invoiceIds"]],
			parent_id = deserialized_dict.get("parentId"),
			external_ref = deserialized_dict.get("externalRef"),
			unassigned_results = [x0 for x0 in deserialized_dict["unassignedResults"]],
			assigned_results = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['Message','serialize_message','deserialize_message','DecryptedMessage','EncryptedMessage']