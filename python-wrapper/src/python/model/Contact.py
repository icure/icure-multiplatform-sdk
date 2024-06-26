import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.base.Identifier import Identifier
from model.embed.Address import DecryptedAddress, EncryptedAddress
from model.embed.SubContact import DecryptedSubContact, EncryptedSubContact
from model.embed.Service import DecryptedService, EncryptedService
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata
from model.embed.Annotation import Annotation

Contact = Union['DecryptedContact', 'EncryptedContact']

def serialize_contact(contact: Contact) -> object:
	if isinstance(contact, DecryptedContact):
		return {
			"type": "com.icure.sdk.model.DecryptedContact",
			"entity": contact.__serialize__()
		}
	elif isinstance(contact, EncryptedContact):
		return {
			"type": "com.icure.sdk.model.EncryptedContact",
			"entity": contact.__serialize__()
		}
	else:
		raise Exception(f"{type(contact)} is not a known subclass of Contact")

def deserialize_contact(data: Union[str, Dict[str, object]]) -> 'Contact':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedContact":
		DecryptedContact._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedContact":
		EncryptedContact._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Contact")

@dataclass
class DecryptedContact:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	identifier: List['Identifier'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	group_id: Optional[str] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	location: Optional[str] = None
	external_id: Optional[str] = None
	encounter_type: Optional['CodeStub'] = None
	encounter_location: Optional['DecryptedAddress'] = None
	sub_contacts: List['DecryptedSubContact'] = field(default_factory=list)
	services: List['DecryptedService'] = field(default_factory=list)
	healthcare_party_id: Optional[str] = None
	modified_contact_id: Optional[str] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	notes: List['Annotation'] = field(default_factory=list)

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
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"groupId": self.group_id,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"location": self.location,
			"externalId": self.external_id,
			"encounterType": self.encounter_type.__serialize__() if self.encounter_type is not None else None,
			"encounterLocation": self.encounter_location.__serialize__() if self.encounter_location is not None else None,
			"subContacts": [x0.__serialize__() for x0 in self.sub_contacts],
			"services": [x0.__serialize__() for x0 in self.services],
			"healthcarePartyId": self.healthcare_party_id,
			"modifiedContactId": self.modified_contact_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"notes": [x0.__serialize__() for x0 in self.notes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedContact':
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
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			group_id = deserialized_dict.get("groupId"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			descr = deserialized_dict.get("descr"),
			location = deserialized_dict.get("location"),
			external_id = deserialized_dict.get("externalId"),
			encounter_type = CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location = DecryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts = [DecryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services = [DecryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			modified_contact_id = deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
		)

@dataclass
class EncryptedContact:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	identifier: List['Identifier'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	group_id: Optional[str] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	location: Optional[str] = None
	external_id: Optional[str] = None
	encounter_type: Optional['CodeStub'] = None
	encounter_location: Optional['EncryptedAddress'] = None
	sub_contacts: List['EncryptedSubContact'] = field(default_factory=list)
	services: List['EncryptedService'] = field(default_factory=list)
	healthcare_party_id: Optional[str] = None
	modified_contact_id: Optional[str] = None
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	notes: List['Annotation'] = field(default_factory=list)

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
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"groupId": self.group_id,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"location": self.location,
			"externalId": self.external_id,
			"encounterType": self.encounter_type.__serialize__() if self.encounter_type is not None else None,
			"encounterLocation": self.encounter_location.__serialize__() if self.encounter_location is not None else None,
			"subContacts": [x0.__serialize__() for x0 in self.sub_contacts],
			"services": [x0.__serialize__() for x0 in self.services],
			"healthcarePartyId": self.healthcare_party_id,
			"modifiedContactId": self.modified_contact_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"notes": [x0.__serialize__() for x0 in self.notes],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedContact':
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
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			group_id = deserialized_dict.get("groupId"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			descr = deserialized_dict.get("descr"),
			location = deserialized_dict.get("location"),
			external_id = deserialized_dict.get("externalId"),
			encounter_type = CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location = EncryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts = [EncryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services = [EncryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			modified_contact_id = deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
		)

__all__ = ['Contact','serialize_contact','deserialize_contact','DecryptedContact','EncryptedContact']