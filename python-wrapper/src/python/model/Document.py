import json
import base64
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.DocumentLocation import DocumentLocation
from model.embed.DocumentType import DocumentType
from model.embed.DocumentStatus import DocumentStatus
from model.embed.DataAttachment import DataAttachment
from model.embed.DeletedAttachment import DeletedAttachment
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

Document = Union['EncryptedDocument', 'DecryptedDocument']

def serialize_document(document: Document) -> object:
	if instanceof(document, EncryptedDocument):
		return {
			"type": "com.icure.sdk.model.EncryptedDocument",
			"entity": document.__serialize__()
		}
	elif instanceof(document, DecryptedDocument):
		return {
			"type": "com.icure.sdk.model.DecryptedDocument",
			"entity": document.__serialize__()
		}
	else:
		raise Exception(f"{type(document)} is not a known subclass of Document")

def deserialize_document(data: Union[str, Dict[str, object]]) -> 'Document':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedDocument":
		EncryptedDocument._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedDocument":
		DecryptedDocument._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Document")

@dataclass
class EncryptedDocument:
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
	document_location: Optional['DocumentLocation'] = None
	document_type: Optional['DocumentType'] = None
	document_status: Optional['DocumentStatus'] = None
	external_uri: Optional[str] = None
	name: Optional[str] = None
	version: Optional[str] = None
	stored_icure_document_id: Optional[str] = None
	external_uuid: Optional[str] = None
	size: Optional[int] = None
	hash: Optional[str] = None
	opening_contact_id: Optional[str] = None
	attachment_id: Optional[str] = None
	object_store_reference: Optional[str] = None
	main_uti: Optional[str] = None
	other_utis: List[str] = field(default_factory=list)
	secondary_attachments: Dict[str, 'DataAttachment'] = field(default_factory=dict)
	deleted_attachments: List['DeletedAttachment'] = field(default_factory=list)
	encrypted_attachment: Optional[bytearray] = None
	decrypted_attachment: Optional[bytearray] = None
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
			"documentLocation": self.document_location.__serialize__() if self.document_location is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"documentStatus": self.document_status.__serialize__() if self.document_status is not None else None,
			"externalUri": self.external_uri,
			"name": self.name,
			"version": self.version,
			"storedICureDocumentId": self.stored_icure_document_id,
			"externalUuid": self.external_uuid,
			"size": self.size,
			"hash": self.hash,
			"openingContactId": self.opening_contact_id,
			"attachmentId": self.attachment_id,
			"objectStoreReference": self.object_store_reference,
			"mainUti": self.main_uti,
			"otherUtis": [x0 for x0 in self.other_utis],
			"secondaryAttachments": {k0: v0.__serialize__() for k0, v0 in self.secondary_attachments.items()},
			"deletedAttachments": [x0.__serialize__() for x0 in self.deleted_attachments],
			"encryptedAttachment": base64.b64encode(self.encrypted_attachment).decode('utf-8') if self.encrypted_attachment is not None else None,
			"decryptedAttachment": base64.b64encode(self.decrypted_attachment).decode('utf-8') if self.decrypted_attachment is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedDocument':
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
			document_location = DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type = DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status = DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri = deserialized_dict.get("externalUri"),
			name = deserialized_dict.get("name"),
			version = deserialized_dict.get("version"),
			stored_icure_document_id = deserialized_dict.get("storedICureDocumentId"),
			external_uuid = deserialized_dict.get("externalUuid"),
			size = deserialized_dict.get("size"),
			hash = deserialized_dict.get("hash"),
			opening_contact_id = deserialized_dict.get("openingContactId"),
			attachment_id = deserialized_dict.get("attachmentId"),
			object_store_reference = deserialized_dict.get("objectStoreReference"),
			main_uti = deserialized_dict.get("mainUti"),
			other_utis = [x0 for x0 in deserialized_dict["otherUtis"]],
			secondary_attachments = dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments = [DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment = bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment = bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedDocument:
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
	document_location: Optional['DocumentLocation'] = None
	document_type: Optional['DocumentType'] = None
	document_status: Optional['DocumentStatus'] = None
	external_uri: Optional[str] = None
	name: Optional[str] = None
	version: Optional[str] = None
	stored_icure_document_id: Optional[str] = None
	external_uuid: Optional[str] = None
	size: Optional[int] = None
	hash: Optional[str] = None
	opening_contact_id: Optional[str] = None
	attachment_id: Optional[str] = None
	object_store_reference: Optional[str] = None
	main_uti: Optional[str] = None
	other_utis: List[str] = field(default_factory=list)
	secondary_attachments: Dict[str, 'DataAttachment'] = field(default_factory=dict)
	deleted_attachments: List['DeletedAttachment'] = field(default_factory=list)
	encrypted_attachment: Optional[bytearray] = None
	decrypted_attachment: Optional[bytearray] = None
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
			"documentLocation": self.document_location.__serialize__() if self.document_location is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"documentStatus": self.document_status.__serialize__() if self.document_status is not None else None,
			"externalUri": self.external_uri,
			"name": self.name,
			"version": self.version,
			"storedICureDocumentId": self.stored_icure_document_id,
			"externalUuid": self.external_uuid,
			"size": self.size,
			"hash": self.hash,
			"openingContactId": self.opening_contact_id,
			"attachmentId": self.attachment_id,
			"objectStoreReference": self.object_store_reference,
			"mainUti": self.main_uti,
			"otherUtis": [x0 for x0 in self.other_utis],
			"secondaryAttachments": {k0: v0.__serialize__() for k0, v0 in self.secondary_attachments.items()},
			"deletedAttachments": [x0.__serialize__() for x0 in self.deleted_attachments],
			"encryptedAttachment": base64.b64encode(self.encrypted_attachment).decode('utf-8') if self.encrypted_attachment is not None else None,
			"decryptedAttachment": base64.b64encode(self.decrypted_attachment).decode('utf-8') if self.decrypted_attachment is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedDocument':
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
			document_location = DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type = DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status = DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri = deserialized_dict.get("externalUri"),
			name = deserialized_dict.get("name"),
			version = deserialized_dict.get("version"),
			stored_icure_document_id = deserialized_dict.get("storedICureDocumentId"),
			external_uuid = deserialized_dict.get("externalUuid"),
			size = deserialized_dict.get("size"),
			hash = deserialized_dict.get("hash"),
			opening_contact_id = deserialized_dict.get("openingContactId"),
			attachment_id = deserialized_dict.get("attachmentId"),
			object_store_reference = deserialized_dict.get("objectStoreReference"),
			main_uti = deserialized_dict.get("mainUti"),
			other_utis = [x0 for x0 in deserialized_dict["otherUtis"]],
			secondary_attachments = dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments = [DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment = bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment = bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['Document','serialize_document','deserialize_document','EncryptedDocument','DecryptedDocument']