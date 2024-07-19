import json
import base64
from typing import Optional
from typing import List
from dataclasses import field
from typing import Union
from typing import Dict
from dataclasses import dataclass
from icure.model.specializations import HexString
from icure.model.specializations import SpkiHexString
from icure.model.specializations import AesExchangeKeyEncryptionKeypairIdentifier
from icure.model.specializations import Base64String
from enum import Enum
from icure.model.SingletonMeta import SingletonMeta
from datetime import timedelta
from icure.model.serialization import serialize_timedelta
from icure.model.serialization import deserialize_timedelta
from icure.model.specializations import SecureDelegationKeyString
from icure.model.specializations import Sha256HexString

@dataclass
class Keyword:
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
	value: Optional[str] = None
	sub_words: List['KeywordSubword'] = field(default_factory=list)
	user_id: Optional[str] = None

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
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words],
			"userId": self.user_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Keyword':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			value=deserialized_dict.get("value"),
			sub_words=[KeywordSubword._deserialize(x0) for x0 in deserialized_dict["subWords"]],
			user_id=deserialized_dict.get("userId"),
		)

@dataclass
class PaginatedList:
	rows: List[object] = field(default_factory=list)
	next_key_pair: Optional['PaginatedDocumentKeyIdPair'] = None

	def __serialize__(self) -> object:
		return {
			"rows": [x0.__serialize__() for x0 in self.rows],
			"nextKeyPair": self.next_key_pair.__serialize__() if self.next_key_pair is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaginatedList':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rows=[x0 for x0 in deserialized_dict["rows"]],
			next_key_pair=PaginatedDocumentKeyIdPair._deserialize(deserialized_dict.get("nextKeyPair")) if deserialized_dict.get("nextKeyPair") is not None else None,
		)

@dataclass
class DocIdentifier:
	id: Optional[str] = None
	rev: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocIdentifier':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			rev=deserialized_dict.get("rev"),
		)

@dataclass
class Device:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	identifiers: List['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	medical_location_id: Optional[str] = None
	external_id: Optional[str] = None
	name: Optional[str] = None
	type: Optional[str] = None
	brand: Optional[str] = None
	model: Optional[str] = None
	serial_number: Optional[str] = None
	parent_id: Optional[str] = None
	picture: Optional[bytearray] = None
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"medicalLocationId": self.medical_location_id,
			"externalId": self.external_id,
			"name": self.name,
			"type": self.type,
			"brand": self.brand,
			"model": self.model,
			"serialNumber": self.serial_number,
			"parentId": self.parent_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Device':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			external_id=deserialized_dict.get("externalId"),
			name=deserialized_dict.get("name"),
			type=deserialized_dict.get("type"),
			brand=deserialized_dict.get("brand"),
			model=deserialized_dict.get("model"),
			serial_number=deserialized_dict.get("serialNumber"),
			parent_id=deserialized_dict.get("parentId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256=[x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
		)

@dataclass
class IdWithRev:
	id: str
	rev: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdWithRev':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
		)

@dataclass
class FilterChain:
	filter: 'objectAbstractFilter'
	predicate: Optional['Predicate'] = None

	def __serialize__(self) -> object:
		return {
			"filter": serialize_abstract_filter(self.filter),
			"predicate": serialize_predicate(self.predicate) if self.predicate is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FilterChain':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			filter=deserialize_abstract_filter(deserialized_dict["filter"]),
			predicate=deserialize_predicate(deserialized_dict.get("predicate")) if deserialized_dict.get("predicate") is not None else None,
		)

@dataclass
class ContactByHcPartyPatientTagCodeDateFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_secret_foreign_key: Optional[str] = None
	patient_secret_foreign_keys: Optional[List[str]] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	start_of_contact_opening_date: Optional[int] = None
	end_of_contact_opening_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKey": self.patient_secret_foreign_key,
			"patientSecretForeignKeys": [x0 for x0 in self.patient_secret_foreign_keys] if self.patient_secret_foreign_keys is not None else None,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"startOfContactOpeningDate": self.start_of_contact_opening_date,
			"endOfContactOpeningDate": self.end_of_contact_opening_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyPatientTagCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_key=deserialized_dict.get("patientSecretForeignKey"),
			patient_secret_foreign_keys=[x0 for x0 in deserialized_dict.get("patientSecretForeignKeys")] if deserialized_dict.get("patientSecretForeignKeys") is not None else None,
			tag_type=deserialized_dict.get("tagType"),
			tag_code=deserialized_dict.get("tagCode"),
			code_type=deserialized_dict.get("codeType"),
			code_code=deserialized_dict.get("codeCode"),
			start_of_contact_opening_date=deserialized_dict.get("startOfContactOpeningDate"),
			end_of_contact_opening_date=deserialized_dict.get("endOfContactOpeningDate"),
		)

@dataclass
class ContactByHcPartyTagCodeDateFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	start_of_contact_opening_date: Optional[int] = None
	end_of_contact_opening_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"startOfContactOpeningDate": self.start_of_contact_opening_date,
			"endOfContactOpeningDate": self.end_of_contact_opening_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyTagCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			tag_type=deserialized_dict.get("tagType"),
			tag_code=deserialized_dict.get("tagCode"),
			code_type=deserialized_dict.get("codeType"),
			code_code=deserialized_dict.get("codeCode"),
			start_of_contact_opening_date=deserialized_dict.get("startOfContactOpeningDate"),
			end_of_contact_opening_date=deserialized_dict.get("endOfContactOpeningDate"),
		)

@dataclass
class ContactByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id=deserialized_dict["hcpId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class ContactByServiceIdsFilter:
	desc: Optional[str] = None
	ids: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ids": [x0 for x0 in self.ids] if self.ids is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByServiceIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			ids=[x0 for x0 in deserialized_dict.get("ids")] if deserialized_dict.get("ids") is not None else None,
		)

@dataclass
class ContactByHcPartyIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	desc: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"desc": self.desc,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			desc=deserialized_dict.get("desc"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
		)

@dataclass
class HealthcarePartyByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class HealthcarePartyByTagCodeFilter:
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByTagCodeFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			tag_type=deserialized_dict.get("tagType"),
			tag_code=deserialized_dict.get("tagCode"),
			code_type=deserialized_dict.get("codeType"),
			code_code=deserialized_dict.get("codeCode"),
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class AllHealthcarePartiesFilter:
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AllHealthcarePartiesFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class HealthcarePartyByIdentifiersFilter:
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class HealthcarePartyByNameFilter:
	name: str
	desc: Optional[str] = None
	descending: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"name": self.name,
			"descending": self.descending,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByNameFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			name=deserialized_dict["name"],
			descending=deserialized_dict.get("descending"),
		)

@dataclass
class HealthElementByHcPartySecretForeignKeysFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_secret_foreign_keys: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKeys": [x0 for x0 in self.patient_secret_foreign_keys],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartySecretForeignKeysFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_keys=[x0 for x0 in deserialized_dict["patientSecretForeignKeys"]],
		)

@dataclass
class HealthElementByHcPartyTagCodeFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	status: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"status": self.status,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartyTagCodeFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			code_type=deserialized_dict.get("codeType"),
			code_code=deserialized_dict.get("codeCode"),
			tag_type=deserialized_dict.get("tagType"),
			tag_code=deserialized_dict.get("tagCode"),
			status=deserialized_dict.get("status"),
		)

@dataclass
class HealthElementByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class HealthElementByHcPartyIdentifiersFilter:
	desc: Optional[str] = None
	hc_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"hcPartyId": self.hc_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartyIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			hc_party_id=deserialized_dict.get("hcPartyId"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
		)

@dataclass
class HealthElementByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id=deserialized_dict["hcpId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class CodeIdsByTypeCodeVersionIntervalFilter:
	desc: Optional[str] = None
	start_type: Optional[str] = None
	start_code: Optional[str] = None
	start_version: Optional[str] = None
	end_type: Optional[str] = None
	end_code: Optional[str] = None
	end_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"startType": self.start_type,
			"startCode": self.start_code,
			"startVersion": self.start_version,
			"endType": self.end_type,
			"endCode": self.end_code,
			"endVersion": self.end_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeIdsByTypeCodeVersionIntervalFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			start_type=deserialized_dict.get("startType"),
			start_code=deserialized_dict.get("startCode"),
			start_version=deserialized_dict.get("startVersion"),
			end_type=deserialized_dict.get("endType"),
			end_code=deserialized_dict.get("endCode"),
			end_version=deserialized_dict.get("endVersion"),
		)

@dataclass
class AllCodesFilter:
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AllCodesFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class CodeByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class CodeByRegionTypeLabelLanguageFilter:
	type: str
	language: str
	desc: Optional[str] = None
	region: Optional[str] = None
	label: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"region": self.region,
			"type": self.type,
			"language": self.language,
			"label": self.label,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeByRegionTypeLabelLanguageFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			region=deserialized_dict.get("region"),
			type=deserialized_dict["type"],
			language=deserialized_dict["language"],
			label=deserialized_dict.get("label"),
		)

@dataclass
class MessageByHcPartyTransportGuidFilter:
	healthcare_party_id: str
	transport_guid: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"transportGuid": self.transport_guid,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageByHcPartyTransportGuidFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict["healthcarePartyId"],
			transport_guid=deserialized_dict["transportGuid"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class MessageByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id=deserialized_dict["hcpId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class LatestMessageByHcPartyTransportGuidFilter:
	healthcare_party_id: str
	transport_guid: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"transportGuid": self.transport_guid,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LatestMessageByHcPartyTransportGuidFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict["healthcarePartyId"],
			transport_guid=deserialized_dict["transportGuid"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class UserByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class AllUsersFilter:
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AllUsersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class UserByNameEmailPhoneFilter:
	search_string: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"searchString": self.search_string,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserByNameEmailPhoneFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			search_string=deserialized_dict["searchString"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class UsersByPatientIdFilter:
	patient_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"patientId": self.patient_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersByPatientIdFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			patient_id=deserialized_dict["patientId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class TopicByParticipantFilter:
	participant_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"participantId": self.participant_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicByParticipantFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			participant_id=deserialized_dict["participantId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class TopicByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id=deserialized_dict["hcpId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class UnionFilter:
	desc: Optional[str] = None
	filters: List['objectAbstractFilter'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"filters": [serialize_abstract_filter(x0) for x0 in self.filters],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UnionFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			filters=[deserialize_abstract_filter(x0) for x0 in deserialized_dict["filters"]],
		)

@dataclass
class PatientByHcPartyGenderEducationProfession:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	gender: Optional['Gender'] = None
	education: Optional[str] = None
	profession: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"education": self.education,
			"profession": self.profession,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyGenderEducationProfession':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			education=deserialized_dict.get("education"),
			profession=deserialized_dict.get("profession"),
		)

@dataclass
class PatientByHcPartyDateOfBirthFilter:
	date_of_birth: int
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"dateOfBirth": self.date_of_birth,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyDateOfBirthFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			date_of_birth=deserialized_dict["dateOfBirth"],
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndExternalIdFilter:
	desc: Optional[str] = None
	external_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"externalId": self.external_id,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndExternalIdFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			external_id=deserialized_dict.get("externalId"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndSsinsFilter:
	desc: Optional[str] = None
	ssins: Optional[List[str]] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ssins": [x0 for x0 in self.ssins] if self.ssins is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndSsinsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			ssins=[x0 for x0 in deserialized_dict.get("ssins")] if deserialized_dict.get("ssins") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndActiveFilter:
	desc: Optional[str] = None
	active: bool = False
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"active": self.active,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndActiveFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			active=deserialized_dict["active"],
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndAddressFilter:
	desc: Optional[str] = None
	search_string: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	postal_code: Optional[str] = None
	house_number: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"searchString": self.search_string,
			"healthcarePartyId": self.healthcare_party_id,
			"postalCode": self.postal_code,
			"houseNumber": self.house_number,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndAddressFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			search_string=deserialized_dict.get("searchString"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			postal_code=deserialized_dict.get("postalCode"),
			house_number=deserialized_dict.get("houseNumber"),
		)

@dataclass
class PatientByHcPartyNameFilter:
	desc: Optional[str] = None
	name: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"name": self.name,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyNameFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			name=deserialized_dict.get("name"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndSsinFilter:
	ssin: str
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ssin": self.ssin,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndSsinFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			ssin=deserialized_dict["ssin"],
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyNameContainsFuzzyFilter:
	desc: Optional[str] = None
	search_string: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"searchString": self.search_string,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyNameContainsFuzzyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			search_string=deserialized_dict.get("searchString"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class PatientByHcPartyAndIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class PatientByHcPartyDateOfBirthBetweenFilter:
	desc: Optional[str] = None
	min_date_of_birth: Optional[int] = None
	max_date_of_birth: Optional[int] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"minDateOfBirth": self.min_date_of_birth,
			"maxDateOfBirth": self.max_date_of_birth,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyDateOfBirthBetweenFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			min_date_of_birth=deserialized_dict.get("minDateOfBirth"),
			max_date_of_birth=deserialized_dict.get("maxDateOfBirth"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyAndTelecomFilter:
	desc: Optional[str] = None
	search_string: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"searchString": self.search_string,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyAndTelecomFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			search_string=deserialized_dict.get("searchString"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class PatientByHcPartyFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class DeviceByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeviceByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class DeviceByHcPartyFilter:
	desc: Optional[str] = None
	responsible_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"responsibleId": self.responsible_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeviceByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			responsible_id=deserialized_dict.get("responsibleId"),
		)

@dataclass
class AllDevicesFilter:
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AllDevicesFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class ComplementFilter:
	super_set: 'objectAbstractFilter'
	sub_set: 'objectAbstractFilter'
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"superSet": serialize_abstract_filter(self.super_set),
			"subSet": serialize_abstract_filter(self.sub_set),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ComplementFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			super_set=deserialize_abstract_filter(deserialized_dict["superSet"]),
			sub_set=deserialize_abstract_filter(deserialized_dict["subSet"]),
		)

@dataclass
class ExternalViewFilter:
	view: str
	partition: str
	entity_qualified_name: str
	start_key: Optional['ExternalFilterKey']
	end_key: Optional['ExternalFilterKey']
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"view": self.view,
			"partition": self.partition,
			"entityQualifiedName": self.entity_qualified_name,
			"startKey": serialize_external_filter_key(self.start_key) if self.start_key is not None else None,
			"endKey": serialize_external_filter_key(self.end_key) if self.end_key is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ExternalViewFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			view=deserialized_dict["view"],
			partition=deserialized_dict["partition"],
			entity_qualified_name=deserialized_dict["entityQualifiedName"],
			start_key=deserialize_external_filter_key(deserialized_dict.get("startKey")) if deserialized_dict.get("startKey") is not None else None,
			end_key=deserialize_external_filter_key(deserialized_dict.get("endKey")) if deserialized_dict.get("endKey") is not None else None,
		)

@dataclass
class IntersectionFilter:
	desc: Optional[str] = None
	filters: List['objectAbstractFilter'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"filters": [serialize_abstract_filter(x0) for x0 in self.filters],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IntersectionFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			filters=[deserialize_abstract_filter(x0) for x0 in deserialized_dict["filters"]],
		)

@dataclass
class IdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			ids=[x0 for x0 in deserialized_dict["ids"]],
		)

@dataclass
class ServiceBySecretForeignKeys:
	patient_secret_foreign_keys: List[str]
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKeys": [x0 for x0 in self.patient_secret_foreign_keys],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceBySecretForeignKeys':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_keys=[x0 for x0 in deserialized_dict["patientSecretForeignKeys"]],
		)

@dataclass
class ServiceByContactsAndSubcontactsFilter:
	contacts: List[str]
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	sub_contacts: Optional[List[str]] = None
	start_value_date: Optional[int] = None
	end_value_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"contacts": [x0 for x0 in self.contacts],
			"subContacts": [x0 for x0 in self.sub_contacts] if self.sub_contacts is not None else None,
			"startValueDate": self.start_value_date,
			"endValueDate": self.end_value_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByContactsAndSubcontactsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			contacts=[x0 for x0 in deserialized_dict["contacts"]],
			sub_contacts=[x0 for x0 in deserialized_dict.get("subContacts")] if deserialized_dict.get("subContacts") is not None else None,
			start_value_date=deserialized_dict.get("startValueDate"),
			end_value_date=deserialized_dict.get("endValueDate"),
		)

@dataclass
class ServiceByHcPartyTagCodeDateFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_secret_foreign_key: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	start_value_date: Optional[int] = None
	end_value_date: Optional[int] = None
	descending: bool = False

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKey": self.patient_secret_foreign_key,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"startValueDate": self.start_value_date,
			"endValueDate": self.end_value_date,
			"descending": self.descending,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyTagCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_key=deserialized_dict.get("patientSecretForeignKey"),
			tag_type=deserialized_dict.get("tagType"),
			tag_code=deserialized_dict.get("tagCode"),
			code_type=deserialized_dict.get("codeType"),
			code_code=deserialized_dict.get("codeCode"),
			start_value_date=deserialized_dict.get("startValueDate"),
			end_value_date=deserialized_dict.get("endValueDate"),
			descending=deserialized_dict["descending"],
		)

@dataclass
class ServiceByHcPartyHealthElementIdsFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	health_element_ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"healthElementIds": [x0 for x0 in self.health_element_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyHealthElementIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			health_element_ids=[x0 for x0 in deserialized_dict["healthElementIds"]],
		)

@dataclass
class ServiceByHcPartyIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class ServiceByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id=deserialized_dict["hcpId"],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class ServiceByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class MaintenanceTaskByHcPartyAndTypeFilter:
	type: str
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"type": self.type,
			"healthcarePartyId": self.healthcare_party_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskByHcPartyAndTypeFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			type=deserialized_dict["type"],
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
		)

@dataclass
class MaintenanceTaskByHcPartyAndIdentifiersFilter:
	healthcare_party_id: Optional[str] = None
	identifiers: List['Identifier'] = field(default_factory=list)
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"healthcarePartyId": self.healthcare_party_id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskByHcPartyAndIdentifiersFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class MaintenanceTaskByIdsFilter:
	ids: List[str]
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskByIdsFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
			desc=deserialized_dict.get("desc"),
		)

@dataclass
class MaintenanceTaskAfterDateFilter:
	date: int
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"date": self.date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskAfterDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			date=deserialized_dict["date"],
		)

@dataclass
class InvoiceByHcPartyCodeDateFilter:
	code: str
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	start_invoice_date: Optional[int] = None
	end_invoice_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"code": self.code,
			"startInvoiceDate": self.start_invoice_date,
			"endInvoiceDate": self.end_invoice_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceByHcPartyCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc=deserialized_dict.get("desc"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			code=deserialized_dict["code"],
			start_invoice_date=deserialized_dict.get("startInvoiceDate"),
			end_invoice_date=deserialized_dict.get("endInvoiceDate"),
		)

AbstractFilter = Union['ContactByHcPartyPatientTagCodeDateFilter', 'ContactByHcPartyTagCodeDateFilter', 'ContactByHcPartyFilter', 'ContactByServiceIdsFilter', 'ContactByHcPartyIdentifiersFilter', 'HealthcarePartyByIdsFilter', 'HealthcarePartyByTagCodeFilter', 'AllHealthcarePartiesFilter', 'HealthcarePartyByIdentifiersFilter', 'HealthcarePartyByNameFilter', 'HealthElementByHcPartySecretForeignKeysFilter', 'HealthElementByHcPartyTagCodeFilter', 'HealthElementByIdsFilter', 'HealthElementByHcPartyIdentifiersFilter', 'HealthElementByHcPartyFilter', 'CodeIdsByTypeCodeVersionIntervalFilter', 'AllCodesFilter', 'CodeByIdsFilter', 'CodeByRegionTypeLabelLanguageFilter', 'MessageByHcPartyTransportGuidFilter', 'MessageByHcPartyFilter', 'LatestMessageByHcPartyTransportGuidFilter', 'UserByIdsFilter', 'AllUsersFilter', 'UserByNameEmailPhoneFilter', 'UsersByPatientIdFilter', 'TopicByParticipantFilter', 'TopicByHcPartyFilter', 'UnionFilter', 'PatientByHcPartyGenderEducationProfession', 'PatientByHcPartyDateOfBirthFilter', 'PatientByHcPartyAndExternalIdFilter', 'PatientByHcPartyAndSsinsFilter', 'PatientByHcPartyAndActiveFilter', 'PatientByHcPartyAndAddressFilter', 'PatientByHcPartyNameFilter', 'PatientByHcPartyAndSsinFilter', 'PatientByHcPartyNameContainsFuzzyFilter', 'PatientByIdsFilter', 'PatientByHcPartyAndIdentifiersFilter', 'PatientByHcPartyDateOfBirthBetweenFilter', 'PatientByHcPartyAndTelecomFilter', 'PatientByHcPartyFilter', 'DeviceByIdsFilter', 'DeviceByHcPartyFilter', 'AllDevicesFilter', 'ComplementFilter', 'ExternalViewFilter', 'IntersectionFilter', 'IdsFilter', 'ServiceBySecretForeignKeys', 'ServiceByContactsAndSubcontactsFilter', 'ServiceByHcPartyTagCodeDateFilter', 'ServiceByHcPartyHealthElementIdsFilter', 'ServiceByHcPartyIdentifiersFilter', 'ServiceByHcPartyFilter', 'ServiceByIdsFilter', 'MaintenanceTaskByHcPartyAndTypeFilter', 'MaintenanceTaskByHcPartyAndIdentifiersFilter', 'MaintenanceTaskByIdsFilter', 'MaintenanceTaskAfterDateFilter', 'InvoiceByHcPartyCodeDateFilter']

def serialize_abstract_filter(abstract_filter: AbstractFilter) -> object:
	if isinstance(abstract_filter, ContactByHcPartyPatientTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyPatientTagCodeDateFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ContactByHcPartyTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyTagCodeDateFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ContactByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ContactByServiceIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByServiceIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ContactByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthcarePartyByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthcarePartyByTagCodeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByTagCodeFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, AllHealthcarePartiesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllHealthcarePartiesFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthcarePartyByIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthcarePartyByNameFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByNameFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthElementByHcPartySecretForeignKeysFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartySecretForeignKeysFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthElementByHcPartyTagCodeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyTagCodeFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthElementByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthElementByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, HealthElementByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, CodeIdsByTypeCodeVersionIntervalFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeIdsByTypeCodeVersionIntervalFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, AllCodesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllCodesFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, CodeByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, CodeByRegionTypeLabelLanguageFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeByRegionTypeLabelLanguageFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MessageByHcPartyTransportGuidFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MessageByHcPartyTransportGuidFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MessageByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MessageByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, LatestMessageByHcPartyTransportGuidFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "LatestMessageByHcPartyTransportGuidFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, UserByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UserByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, AllUsersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllUsersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, UserByNameEmailPhoneFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UserByNameEmailPhoneFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, UsersByPatientIdFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UsersByPatientIdFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, TopicByParticipantFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "TopicByParticipantFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, TopicByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "TopicByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, UnionFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UnionFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyGenderEducationProfession):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyGenderEducationProfession"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyDateOfBirthFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyDateOfBirthFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndExternalIdFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndExternalIdFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndSsinsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndSsinsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndActiveFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndActiveFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndAddressFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndAddressFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyNameFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyNameFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndSsinFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndSsinFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyNameContainsFuzzyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyNameContainsFuzzyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyDateOfBirthBetweenFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyDateOfBirthBetweenFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyAndTelecomFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndTelecomFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, PatientByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, DeviceByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "DeviceByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, DeviceByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "DeviceByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, AllDevicesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllDevicesFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ComplementFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ComplementFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ExternalViewFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ExternalViewFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, IntersectionFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "IntersectionFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, IdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "IdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceBySecretForeignKeys):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceBySecretForeignKeys"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByContactsAndSubcontactsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByContactsAndSubcontactsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByHcPartyTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyTagCodeDateFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByHcPartyHealthElementIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyHealthElementIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, ServiceByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MaintenanceTaskByHcPartyAndTypeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByHcPartyAndTypeFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MaintenanceTaskByHcPartyAndIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByHcPartyAndIdentifiersFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MaintenanceTaskByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByIdsFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, MaintenanceTaskAfterDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskAfterDateFilter"})
		return serialized_entity
	elif isinstance(abstract_filter, InvoiceByHcPartyCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "InvoiceByHcPartyCodeDateFilter"})
		return serialized_entity
	else:
		raise Exception(f"{type(abstract_filter)} is not a known subclass of AbstractFilter")

def deserialize_abstract_filter(data: Union[str, Dict[str, object]]) -> 'AbstractFilter':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("$type")
	if qualifier is None:
		raise Exception("Missing qualifier: $type")
	if qualifier == "ContactByHcPartyPatientTagCodeDateFilter":
		return ContactByHcPartyPatientTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyTagCodeDateFilter":
		return ContactByHcPartyTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyFilter":
		return ContactByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByServiceIdsFilter":
		return ContactByServiceIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyIdentifiersFilter":
		return ContactByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByIdsFilter":
		return HealthcarePartyByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByTagCodeFilter":
		return HealthcarePartyByTagCodeFilter._deserialize(deserialized_dict)
	elif qualifier == "AllHealthcarePartiesFilter":
		return AllHealthcarePartiesFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByIdentifiersFilter":
		return HealthcarePartyByIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByNameFilter":
		return HealthcarePartyByNameFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartySecretForeignKeysFilter":
		return HealthElementByHcPartySecretForeignKeysFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyTagCodeFilter":
		return HealthElementByHcPartyTagCodeFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByIdsFilter":
		return HealthElementByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyIdentifiersFilter":
		return HealthElementByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyFilter":
		return HealthElementByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeIdsByTypeCodeVersionIntervalFilter":
		return CodeIdsByTypeCodeVersionIntervalFilter._deserialize(deserialized_dict)
	elif qualifier == "AllCodesFilter":
		return AllCodesFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeByIdsFilter":
		return CodeByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeByRegionTypeLabelLanguageFilter":
		return CodeByRegionTypeLabelLanguageFilter._deserialize(deserialized_dict)
	elif qualifier == "MessageByHcPartyTransportGuidFilter":
		return MessageByHcPartyTransportGuidFilter._deserialize(deserialized_dict)
	elif qualifier == "MessageByHcPartyFilter":
		return MessageByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "LatestMessageByHcPartyTransportGuidFilter":
		return LatestMessageByHcPartyTransportGuidFilter._deserialize(deserialized_dict)
	elif qualifier == "UserByIdsFilter":
		return UserByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "AllUsersFilter":
		return AllUsersFilter._deserialize(deserialized_dict)
	elif qualifier == "UserByNameEmailPhoneFilter":
		return UserByNameEmailPhoneFilter._deserialize(deserialized_dict)
	elif qualifier == "UsersByPatientIdFilter":
		return UsersByPatientIdFilter._deserialize(deserialized_dict)
	elif qualifier == "TopicByParticipantFilter":
		return TopicByParticipantFilter._deserialize(deserialized_dict)
	elif qualifier == "TopicByHcPartyFilter":
		return TopicByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "UnionFilter":
		return UnionFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyGenderEducationProfession":
		return PatientByHcPartyGenderEducationProfession._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyDateOfBirthFilter":
		return PatientByHcPartyDateOfBirthFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndExternalIdFilter":
		return PatientByHcPartyAndExternalIdFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndSsinsFilter":
		return PatientByHcPartyAndSsinsFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndActiveFilter":
		return PatientByHcPartyAndActiveFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndAddressFilter":
		return PatientByHcPartyAndAddressFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyNameFilter":
		return PatientByHcPartyNameFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndSsinFilter":
		return PatientByHcPartyAndSsinFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyNameContainsFuzzyFilter":
		return PatientByHcPartyNameContainsFuzzyFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByIdsFilter":
		return PatientByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndIdentifiersFilter":
		return PatientByHcPartyAndIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyDateOfBirthBetweenFilter":
		return PatientByHcPartyDateOfBirthBetweenFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndTelecomFilter":
		return PatientByHcPartyAndTelecomFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyFilter":
		return PatientByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "DeviceByIdsFilter":
		return DeviceByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "DeviceByHcPartyFilter":
		return DeviceByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "AllDevicesFilter":
		return AllDevicesFilter._deserialize(deserialized_dict)
	elif qualifier == "ComplementFilter":
		return ComplementFilter._deserialize(deserialized_dict)
	elif qualifier == "ExternalViewFilter":
		return ExternalViewFilter._deserialize(deserialized_dict)
	elif qualifier == "IntersectionFilter":
		return IntersectionFilter._deserialize(deserialized_dict)
	elif qualifier == "IdsFilter":
		return IdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceBySecretForeignKeys":
		return ServiceBySecretForeignKeys._deserialize(deserialized_dict)
	elif qualifier == "ServiceByContactsAndSubcontactsFilter":
		return ServiceByContactsAndSubcontactsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyTagCodeDateFilter":
		return ServiceByHcPartyTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyHealthElementIdsFilter":
		return ServiceByHcPartyHealthElementIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyIdentifiersFilter":
		return ServiceByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyFilter":
		return ServiceByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByIdsFilter":
		return ServiceByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByHcPartyAndTypeFilter":
		return MaintenanceTaskByHcPartyAndTypeFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByHcPartyAndIdentifiersFilter":
		return MaintenanceTaskByHcPartyAndIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByIdsFilter":
		return MaintenanceTaskByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskAfterDateFilter":
		return MaintenanceTaskAfterDateFilter._deserialize(deserialized_dict)
	elif qualifier == "InvoiceByHcPartyCodeDateFilter":
		return InvoiceByHcPartyCodeDateFilter._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of AbstractFilter")

ContactAbstractFilter = Union['ContactByHcPartyPatientTagCodeDateFilter', 'ContactByHcPartyTagCodeDateFilter', 'ContactByHcPartyFilter', 'ContactByServiceIdsFilter', 'ContactByHcPartyIdentifiersFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

HealthcarePartyAbstractFilter = Union['HealthcarePartyByIdsFilter', 'HealthcarePartyByTagCodeFilter', 'AllHealthcarePartiesFilter', 'HealthcarePartyByIdentifiersFilter', 'HealthcarePartyByNameFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

HealthElementAbstractFilter = Union['HealthElementByHcPartySecretForeignKeysFilter', 'HealthElementByHcPartyTagCodeFilter', 'HealthElementByIdsFilter', 'HealthElementByHcPartyIdentifiersFilter', 'HealthElementByHcPartyFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

CodeAbstractFilter = Union['CodeIdsByTypeCodeVersionIntervalFilter', 'AllCodesFilter', 'CodeByIdsFilter', 'CodeByRegionTypeLabelLanguageFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

MessageAbstractFilter = Union['MessageByHcPartyTransportGuidFilter', 'MessageByHcPartyFilter', 'LatestMessageByHcPartyTransportGuidFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

UserAbstractFilter = Union['UserByIdsFilter', 'AllUsersFilter', 'UserByNameEmailPhoneFilter', 'UsersByPatientIdFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

TopicAbstractFilter = Union['TopicByParticipantFilter', 'TopicByHcPartyFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

PatientAbstractFilter = Union['PatientByHcPartyGenderEducationProfession', 'PatientByHcPartyDateOfBirthFilter', 'PatientByHcPartyAndExternalIdFilter', 'PatientByHcPartyAndSsinsFilter', 'PatientByHcPartyAndActiveFilter', 'PatientByHcPartyAndAddressFilter', 'PatientByHcPartyNameFilter', 'PatientByHcPartyAndSsinFilter', 'PatientByHcPartyNameContainsFuzzyFilter', 'PatientByIdsFilter', 'PatientByHcPartyAndIdentifiersFilter', 'PatientByHcPartyDateOfBirthBetweenFilter', 'PatientByHcPartyAndTelecomFilter', 'PatientByHcPartyFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

DeviceAbstractFilter = Union['DeviceByIdsFilter', 'DeviceByHcPartyFilter', 'AllDevicesFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

IdentifiableAbstractFilter = Union['ExternalViewFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

ServiceAbstractFilter = Union['ServiceBySecretForeignKeys', 'ServiceByContactsAndSubcontactsFilter', 'ServiceByHcPartyTagCodeDateFilter', 'ServiceByHcPartyHealthElementIdsFilter', 'ServiceByHcPartyIdentifiersFilter', 'ServiceByHcPartyFilter', 'ServiceByIdsFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

MaintenanceTaskAbstractFilter = Union['MaintenanceTaskByHcPartyAndTypeFilter', 'MaintenanceTaskByHcPartyAndIdentifiersFilter', 'MaintenanceTaskByIdsFilter', 'MaintenanceTaskAfterDateFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

InvoiceAbstractFilter = Union['InvoiceByHcPartyCodeDateFilter', 'UnionFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter']

@dataclass
class CryptoActorStub:
	id: str
	rev: str
	public_keys_for_oaep_with_sha256: List['SpkiHexString']
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	tags: List['CodeStub'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"tags": [x0.__serialize__() for x0 in self.tags],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CryptoActorStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict["rev"],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256=[x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
		)

@dataclass
class EncryptedPatient:
	id: str
	identifier: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: List[str] = field(default_factory=list)
	addresses: List['EncryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	birth_sex: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	merge_to_patient_id: Optional[str] = None
	merged_ids: List[str] = field(default_factory=list)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = field(default_factory=lambda: DeactivationReason.Nothing)
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = field(default_factory=lambda: PersonalStatus.Unknown)
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: List['EncryptedInsurability'] = field(default_factory=list)
	partnerships: List['Partnership'] = field(default_factory=list)
	patient_health_care_parties: List['EncryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: List['EncryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: List['EncryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: List['CodeStub'] = field(default_factory=list)
	parameters: Dict[str, List[str]] = field(default_factory=dict)
	properties: List['EncryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: List[str] = field(default_factory=list)
	encrypted_administratives_documents: List[str] = field(default_factory=list)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: List['SchoolingInfo'] = field(default_factory=list)
	employement_infos: List['EmploymentInfo'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPatient':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			first_name=deserialized_dict.get("firstName"),
			last_name=deserialized_dict.get("lastName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name=deserialized_dict.get("companyName"),
			languages=[x0 for x0 in deserialized_dict["languages"]],
			addresses=[EncryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility=deserialized_dict.get("civility"),
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex=Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id=deserialized_dict.get("mergeToPatientId"),
			merged_ids=[x0 for x0 in deserialized_dict["mergedIds"]],
			alias=deserialized_dict.get("alias"),
			active=deserialized_dict["active"],
			deactivation_reason=DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date=deserialized_dict.get("deactivationDate"),
			ssin=deserialized_dict.get("ssin"),
			maiden_name=deserialized_dict.get("maidenName"),
			spouse_name=deserialized_dict.get("spouseName"),
			partner_name=deserialized_dict.get("partnerName"),
			personal_status=PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth=deserialized_dict.get("dateOfBirth"),
			date_of_death=deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading=deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth=deserialized_dict.get("placeOfBirth"),
			place_of_death=deserialized_dict.get("placeOfDeath"),
			deceased=deserialized_dict.get("deceased"),
			education=deserialized_dict.get("education"),
			profession=deserialized_dict.get("profession"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note=deserialized_dict.get("note"),
			administrative_note=deserialized_dict.get("administrativeNote"),
			nationality=deserialized_dict.get("nationality"),
			race=deserialized_dict.get("race"),
			ethnicity=deserialized_dict.get("ethnicity"),
			preferred_user_id=deserialized_dict.get("preferredUserId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id=deserialized_dict.get("externalId"),
			insurabilities=[EncryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships=[Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties=[EncryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information=[EncryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts=[EncryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions=[CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties=[EncryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256=[x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids=[x0 for x0 in deserialized_dict["nonDuplicateIds"]],
			encrypted_administratives_documents=[x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]],
			comment=deserialized_dict.get("comment"),
			warning=deserialized_dict.get("warning"),
			father_birth_country=CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country=CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country=CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status=CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income=CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos=[SchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos=[EmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
		)

@dataclass
class DecryptedPatient:
	id: str
	identifier: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: List[str] = field(default_factory=list)
	addresses: List['DecryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	birth_sex: Optional['Gender'] = field(default_factory=lambda: Gender.Unknown)
	merge_to_patient_id: Optional[str] = None
	merged_ids: List[str] = field(default_factory=list)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = field(default_factory=lambda: DeactivationReason.Nothing)
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = field(default_factory=lambda: PersonalStatus.Unknown)
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: List['DecryptedInsurability'] = field(default_factory=list)
	partnerships: List['Partnership'] = field(default_factory=list)
	patient_health_care_parties: List['DecryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: List['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: List['DecryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: List['CodeStub'] = field(default_factory=list)
	parameters: Dict[str, List[str]] = field(default_factory=dict)
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: List[str] = field(default_factory=list)
	encrypted_administratives_documents: List[str] = field(default_factory=list)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: List['SchoolingInfo'] = field(default_factory=list)
	employement_infos: List['EmploymentInfo'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPatient':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			first_name=deserialized_dict.get("firstName"),
			last_name=deserialized_dict.get("lastName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name=deserialized_dict.get("companyName"),
			languages=[x0 for x0 in deserialized_dict["languages"]],
			addresses=[DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility=deserialized_dict.get("civility"),
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex=Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id=deserialized_dict.get("mergeToPatientId"),
			merged_ids=[x0 for x0 in deserialized_dict["mergedIds"]],
			alias=deserialized_dict.get("alias"),
			active=deserialized_dict["active"],
			deactivation_reason=DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date=deserialized_dict.get("deactivationDate"),
			ssin=deserialized_dict.get("ssin"),
			maiden_name=deserialized_dict.get("maidenName"),
			spouse_name=deserialized_dict.get("spouseName"),
			partner_name=deserialized_dict.get("partnerName"),
			personal_status=PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth=deserialized_dict.get("dateOfBirth"),
			date_of_death=deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading=deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth=deserialized_dict.get("placeOfBirth"),
			place_of_death=deserialized_dict.get("placeOfDeath"),
			deceased=deserialized_dict.get("deceased"),
			education=deserialized_dict.get("education"),
			profession=deserialized_dict.get("profession"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note=deserialized_dict.get("note"),
			administrative_note=deserialized_dict.get("administrativeNote"),
			nationality=deserialized_dict.get("nationality"),
			race=deserialized_dict.get("race"),
			ethnicity=deserialized_dict.get("ethnicity"),
			preferred_user_id=deserialized_dict.get("preferredUserId"),
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id=deserialized_dict.get("externalId"),
			insurabilities=[DecryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships=[Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties=[DecryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information=[DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts=[DecryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions=[CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256=[x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids=[x0 for x0 in deserialized_dict["nonDuplicateIds"]],
			encrypted_administratives_documents=[x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]],
			comment=deserialized_dict.get("comment"),
			warning=deserialized_dict.get("warning"),
			father_birth_country=CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country=CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country=CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status=CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income=CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos=[SchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos=[EmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
		)

Patient = Union['EncryptedPatient', 'DecryptedPatient']

def serialize_patient(patient: Patient) -> object:
	if isinstance(patient, EncryptedPatient):
		return {
			"type": "com.icure.sdk.model.EncryptedPatient",
			"entity": patient.__serialize__()
		}
	elif isinstance(patient, DecryptedPatient):
		return {
			"type": "com.icure.sdk.model.DecryptedPatient",
			"entity": patient.__serialize__()
		}
	else:
		raise Exception(f"{type(patient)} is not a known subclass of Patient")

def deserialize_patient(data: Union[str, Dict[str, object]]) -> 'Patient':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedPatient":
		EncryptedPatient._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedPatient":
		DecryptedPatient._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Patient")

@dataclass
class HealthcareParty:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	deletion_date: Optional[int] = None
	identifier: List['Identifier'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	name: Optional[str] = None
	last_name: Optional[str] = None
	first_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	gender: Optional['Gender'] = None
	civility: Optional[str] = None
	company_name: Optional[str] = None
	speciality: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	invoice_header: Optional[str] = None
	cbe: Optional[str] = None
	ehp: Optional[str] = None
	user_id: Optional[str] = None
	parent_id: Optional[str] = None
	convention: Optional[int] = None
	nihii: Optional[str] = None
	nihii_spec_code: Optional[str] = None
	ssin: Optional[str] = None
	addresses: List['DecryptedAddress'] = field(default_factory=list)
	languages: List[str] = field(default_factory=list)
	picture: Optional[bytearray] = None
	statuses: List['HealthcarePartyStatus'] = field(default_factory=list)
	status_history: List['HealthcarePartyHistoryStatus'] = field(default_factory=list)
	speciality_codes: List['CodeStub'] = field(default_factory=list)
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	notes: Optional[str] = None
	financial_institution_information: List['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	descr: Optional[Dict[str, str]] = field(default_factory=dict)
	billing_type: Optional[str] = None
	type: Optional[str] = None
	contact_person: Optional[str] = None
	contact_person_hcp_id: Optional[str] = None
	supervisor_id: Optional[str] = None
	flat_rate_tarifications: List['DecryptedFlatRateTarification'] = field(default_factory=list)
	imported_data: Dict[str, str] = field(default_factory=dict)
	options: Dict[str, str] = field(default_factory=dict)
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"deletionDate": self.deletion_date,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"name": self.name,
			"lastName": self.last_name,
			"firstName": self.first_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"civility": self.civility,
			"companyName": self.company_name,
			"speciality": self.speciality,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"invoiceHeader": self.invoice_header,
			"cbe": self.cbe,
			"ehp": self.ehp,
			"userId": self.user_id,
			"parentId": self.parent_id,
			"convention": self.convention,
			"nihii": self.nihii,
			"nihiiSpecCode": self.nihii_spec_code,
			"ssin": self.ssin,
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"languages": [x0 for x0 in self.languages],
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"statuses": [x0.__serialize__() for x0 in self.statuses],
			"statusHistory": [x0.__serialize__() for x0 in self.status_history],
			"specialityCodes": [x0.__serialize__() for x0 in self.speciality_codes],
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"notes": self.notes,
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"descr": {k0: v0 for k0, v0 in self.descr.items()} if self.descr is not None else None,
			"billingType": self.billing_type,
			"type": self.type,
			"contactPerson": self.contact_person,
			"contactPersonHcpId": self.contact_person_hcp_id,
			"supervisorId": self.supervisor_id,
			"flatRateTarifications": [x0.__serialize__() for x0 in self.flat_rate_tarifications],
			"importedData": {k0: v0 for k0, v0 in self.imported_data.items()},
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			deletion_date=deserialized_dict.get("deletionDate"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			name=deserialized_dict.get("name"),
			last_name=deserialized_dict.get("lastName"),
			first_name=deserialized_dict.get("firstName"),
			names=[PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			gender=Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			civility=deserialized_dict.get("civility"),
			company_name=deserialized_dict.get("companyName"),
			speciality=deserialized_dict.get("speciality"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			invoice_header=deserialized_dict.get("invoiceHeader"),
			cbe=deserialized_dict.get("cbe"),
			ehp=deserialized_dict.get("ehp"),
			user_id=deserialized_dict.get("userId"),
			parent_id=deserialized_dict.get("parentId"),
			convention=deserialized_dict.get("convention"),
			nihii=deserialized_dict.get("nihii"),
			nihii_spec_code=deserialized_dict.get("nihiiSpecCode"),
			ssin=deserialized_dict.get("ssin"),
			addresses=[DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			languages=[x0 for x0 in deserialized_dict["languages"]],
			picture=bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			statuses=[HealthcarePartyStatus._deserialize(x0) for x0 in deserialized_dict["statuses"]],
			status_history=[HealthcarePartyHistoryStatus._deserialize(x0) for x0 in deserialized_dict["statusHistory"]],
			speciality_codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["specialityCodes"]],
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			notes=deserialized_dict.get("notes"),
			financial_institution_information=[DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			descr=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("descr").items())) if deserialized_dict.get("descr") is not None else None,
			billing_type=deserialized_dict.get("billingType"),
			type=deserialized_dict.get("type"),
			contact_person=deserialized_dict.get("contactPerson"),
			contact_person_hcp_id=deserialized_dict.get("contactPersonHcpId"),
			supervisor_id=deserialized_dict.get("supervisorId"),
			flat_rate_tarifications=[DecryptedFlatRateTarification._deserialize(x0) for x0 in deserialized_dict["flatRateTarifications"]],
			imported_data=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["importedData"].items())),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys=dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key=deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256=[x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
		)

CryptoActor = Union['CryptoActorStub', 'EncryptedPatient', 'DecryptedPatient', 'Device', 'HealthcareParty']

def serialize_crypto_actor(crypto_actor: CryptoActor) -> object:
	if isinstance(crypto_actor, CryptoActorStub):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.CryptoActorStub"})
		return serialized_entity
	elif isinstance(crypto_actor, EncryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.EncryptedPatient"})
		return serialized_entity
	elif isinstance(crypto_actor, DecryptedPatient):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.DecryptedPatient"})
		return serialized_entity
	elif isinstance(crypto_actor, Device):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.Device"})
		return serialized_entity
	elif isinstance(crypto_actor, HealthcareParty):
		serialized_entity = crypto_actor.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.HealthcareParty"})
		return serialized_entity
	else:
		raise Exception(f"{type(crypto_actor)} is not a known subclass of CryptoActor")

def deserialize_crypto_actor(data: Union[str, Dict[str, object]]) -> 'CryptoActor':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.CryptoActorStub":
		return CryptoActorStub._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.EncryptedPatient":
		return EncryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.DecryptedPatient":
		return DecryptedPatient._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.Device":
		return Device._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.HealthcareParty":
		return HealthcareParty._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of CryptoActor")

@dataclass
class CryptoActorStubWithType:
	type: 'DataOwnerType'
	stub: 'CryptoActorStub'

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__(),
			"stub": self.stub.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CryptoActorStubWithType':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=DataOwnerType._deserialize(deserialized_dict["type"]),
			stub=CryptoActorStub._deserialize(deserialized_dict["stub"]),
		)

@dataclass
class ShamirUpdateRequest:
	notaries_ids: List[str]
	min_shares: int

	def __serialize__(self) -> object:
		return {
			"notariesIds": [x0 for x0 in self.notaries_ids],
			"minShares": self.min_shares,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShamirUpdateRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			notaries_ids=[x0 for x0 in deserialized_dict["notariesIds"]],
			min_shares=deserialized_dict["minShares"],
		)

@dataclass
class Place:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	address: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"address": self.address.__serialize__() if self.address is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Place':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			address=DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
		)

RecoveryDataKey = 'HexString'

RecoveryResult = Union['RecoveryResultSuccess', 'RecoveryResultFailure']

@dataclass
class RecoveryResultSuccess:
	data: object

	def __serialize__(self) -> object:
		return {
			"data": self.data.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data=deserialized_dict["data"],
		)

@dataclass
class RecoveryResultFailure:
	reason: 'RecoveryDataUseFailureReason'

	def __serialize__(self) -> object:
		return {
			"reason": self.reason.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			reason=RecoveryDataUseFailureReason._deserialize(deserialized_dict["reason"]),
		)

def serialize_recovery_result(recovery_result: RecoveryResult) -> object:
	if isinstance(recovery_result, RecoveryResultSuccess):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Success"})
		return serialized_entity
	elif isinstance(recovery_result, RecoveryResultFailure):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Failure"})
		return serialized_entity
	else:
		raise Exception(f"{type(recovery_result)} is not a known subclass of RecoveryResult")

def deserialize_recovery_result(data: Union[str, Dict[str, object]]) -> 'RecoveryResult':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Success":
		return RecoveryResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Failure":
		return RecoveryResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of RecoveryResult")

class RecoveryDataUseFailureReason(Enum):
	Missing = "Missing"
	Unauthorized = "Unauthorized"
	InvalidType = "InvalidType"
	InvalidContent = "InvalidContent"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryDataUseFailureReason':
		if data == "Missing":
			return RecoveryDataUseFailureReason.Missing
		elif data == "Unauthorized":
			return RecoveryDataUseFailureReason.Unauthorized
		elif data == "InvalidType":
			return RecoveryDataUseFailureReason.InvalidType
		elif data == "InvalidContent":
			return RecoveryDataUseFailureReason.InvalidContent
		else:
			raise Exception(f"{data} is not a valid value for RecoveryDataUseFailureReason enum.")

@dataclass
class Tarification:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	label: Optional[Dict[str, str]] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	author: Optional[str] = None
	regions: List[str] = field(default_factory=list)
	periodicity: List['Periodicity'] = field(default_factory=list)
	level: Optional[int] = None
	links: List[str] = field(default_factory=list)
	qualified_links: Dict['LinkQualification', List[str]] = field(default_factory=dict)
	flags: List['CodeFlag'] = field(default_factory=list)
	search_terms: Dict[str, List[str]] = field(default_factory=dict)
	data: Optional[str] = None
	appendices: Dict['AppendixType', str] = field(default_factory=dict)
	disabled: bool = False
	valorisations: List['DecryptedValorisation'] = field(default_factory=list)
	category: Dict[str, str] = field(default_factory=dict)
	consultation_code: Optional[bool] = None
	has_related_code: Optional[bool] = None
	needs_prescriber: Optional[bool] = None
	related_codes: List[str] = field(default_factory=list)
	ngroup: Optional[str] = None
	letter_values: List['LetterValue'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"author": self.author,
			"regions": [x0 for x0 in self.regions],
			"periodicity": [x0.__serialize__() for x0 in self.periodicity],
			"level": self.level,
			"links": [x0 for x0 in self.links],
			"qualifiedLinks": {k0.__serialize__(): [x1 for x1 in v0] for k0, v0 in self.qualified_links.items()},
			"flags": [x0.__serialize__() for x0 in self.flags],
			"searchTerms": {k0: [x1 for x1 in v0] for k0, v0 in self.search_terms.items()},
			"data": self.data,
			"appendices": {k0.__serialize__(): v0 for k0, v0 in self.appendices.items()},
			"disabled": self.disabled,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"category": {k0: v0 for k0, v0 in self.category.items()},
			"consultationCode": self.consultation_code,
			"hasRelatedCode": self.has_related_code,
			"needsPrescriber": self.needs_prescriber,
			"relatedCodes": [x0 for x0 in self.related_codes],
			"ngroup": self.ngroup,
			"letterValues": [x0.__serialize__() for x0 in self.letter_values],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Tarification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			author=deserialized_dict.get("author"),
			regions=[x0 for x0 in deserialized_dict["regions"]],
			periodicity=[Periodicity._deserialize(x0) for x0 in deserialized_dict["periodicity"]],
			level=deserialized_dict.get("level"),
			links=[x0 for x0 in deserialized_dict["links"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["qualifiedLinks"].items())),
			flags=[CodeFlag._deserialize(x0) for x0 in deserialized_dict["flags"]],
			search_terms=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["searchTerms"].items())),
			data=deserialized_dict.get("data"),
			appendices=dict(map(lambda kv0: (AppendixType._deserialize(kv0[0]), kv0[1]), deserialized_dict["appendices"].items())),
			disabled=deserialized_dict["disabled"],
			valorisations=[DecryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			category=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["category"].items())),
			consultation_code=deserialized_dict.get("consultationCode"),
			has_related_code=deserialized_dict.get("hasRelatedCode"),
			needs_prescriber=deserialized_dict.get("needsPrescriber"),
			related_codes=[x0 for x0 in deserialized_dict["relatedCodes"]],
			ngroup=deserialized_dict.get("ngroup"),
			letter_values=[LetterValue._deserialize(x0) for x0 in deserialized_dict["letterValues"]],
		)

@dataclass
class PublicKey:
	hc_party_id: Optional[str] = None
	hex_string: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcPartyId": self.hc_party_id,
			"hexString": self.hex_string,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PublicKey':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hc_party_id=deserialized_dict.get("hcPartyId"),
			hex_string=deserialized_dict.get("hexString"),
		)

@dataclass
class DataOwnerRegistrationSuccess:
	user_login: str
	user_id: str
	token: str

	def __serialize__(self) -> object:
		return {
			"userLogin": self.user_login,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerRegistrationSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			user_login=deserialized_dict["userLogin"],
			user_id=deserialized_dict["userId"],
			token=deserialized_dict["token"],
		)

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
			grants=[deserialize_permission_item(x0) for x0 in deserialized_dict["grants"]],
			revokes=[deserialize_permission_item(x0) for x0 in deserialized_dict["revokes"]],
		)

@dataclass
class Code:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	label: Optional[Dict[str, str]] = None
	author: Optional[str] = None
	regions: List[str] = field(default_factory=list)
	periodicity: List['Periodicity'] = field(default_factory=list)
	level: Optional[int] = None
	links: List[str] = field(default_factory=list)
	qualified_links: Dict[str, List[str]] = field(default_factory=dict)
	flags: List['CodeFlag'] = field(default_factory=list)
	search_terms: Dict[str, List[str]] = field(default_factory=dict)
	data: Optional[str] = None
	appendices: Dict['AppendixType', str] = field(default_factory=dict)
	disabled: bool = False

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"author": self.author,
			"regions": [x0 for x0 in self.regions],
			"periodicity": [x0.__serialize__() for x0 in self.periodicity],
			"level": self.level,
			"links": [x0 for x0 in self.links],
			"qualifiedLinks": {k0: [x1 for x1 in v0] for k0, v0 in self.qualified_links.items()},
			"flags": [x0.__serialize__() for x0 in self.flags],
			"searchTerms": {k0: [x1 for x1 in v0] for k0, v0 in self.search_terms.items()},
			"data": self.data,
			"appendices": {k0.__serialize__(): v0 for k0, v0 in self.appendices.items()},
			"disabled": self.disabled,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Code':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			author=deserialized_dict.get("author"),
			regions=[x0 for x0 in deserialized_dict["regions"]],
			periodicity=[Periodicity._deserialize(x0) for x0 in deserialized_dict["periodicity"]],
			level=deserialized_dict.get("level"),
			links=[x0 for x0 in deserialized_dict["links"]],
			qualified_links=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["qualifiedLinks"].items())),
			flags=[CodeFlag._deserialize(x0) for x0 in deserialized_dict["flags"]],
			search_terms=dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["searchTerms"].items())),
			data=deserialized_dict.get("data"),
			appendices=dict(map(lambda kv0: (AppendixType._deserialize(kv0[0]), kv0[1]), deserialized_dict["appendices"].items())),
			disabled=deserialized_dict["disabled"],
		)

@dataclass
class BooleanResponse:
	response: bool

	def __serialize__(self) -> object:
		return {
			"response": self.response,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'BooleanResponse':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			response=deserialized_dict["response"],
		)

@dataclass
class FrontEndMigration:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	status: Optional['FrontEndMigrationStatus'] = None
	logs: Optional[str] = None
	user_id: Optional[str] = None
	start_key: Optional[str] = None
	start_key_doc_id: Optional[str] = None
	process_count: Optional[int] = None
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"status": self.status.__serialize__() if self.status is not None else None,
			"logs": self.logs,
			"userId": self.user_id,
			"startKey": self.start_key,
			"startKeyDocId": self.start_key_doc_id,
			"processCount": self.process_count,
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FrontEndMigration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			status=FrontEndMigrationStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			logs=deserialized_dict.get("logs"),
			user_id=deserialized_dict.get("userId"),
			start_key=deserialized_dict.get("startKey"),
			start_key_doc_id=deserialized_dict.get("startKeyDocId"),
			process_count=deserialized_dict.get("processCount"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

@dataclass
class DocumentTemplate:
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
	attachment: Optional[bytearray] = None
	document_type: Optional['DocumentType'] = None
	main_uti: Optional[str] = None
	name: Optional[str] = None
	other_utis: List[str] = field(default_factory=list)
	attachment_id: Optional[str] = None
	version: Optional['ReportVersion'] = None
	owner: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None

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
			"attachment": base64.b64encode(self.attachment).decode('utf-8') if self.attachment is not None else None,
			"documentType": self.document_type.__serialize__() if self.document_type is not None else None,
			"mainUti": self.main_uti,
			"name": self.name,
			"otherUtis": [x0 for x0 in self.other_utis],
			"attachmentId": self.attachment_id,
			"version": self.version.__serialize__() if self.version is not None else None,
			"owner": self.owner,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment=bytearray(base64.b64decode(deserialized_dict.get("attachment"))) if deserialized_dict.get("attachment") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			main_uti=deserialized_dict.get("mainUti"),
			name=deserialized_dict.get("name"),
			other_utis=[x0 for x0 in deserialized_dict["otherUtis"]],
			attachment_id=deserialized_dict.get("attachmentId"),
			version=ReportVersion._deserialize(deserialized_dict.get("version")) if deserialized_dict.get("version") is not None else None,
			owner=deserialized_dict.get("owner"),
			guid=deserialized_dict.get("guid"),
			group=DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr=deserialized_dict.get("descr"),
			disabled=deserialized_dict.get("disabled"),
			specialty=CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
		)

@dataclass
class ApplicationSettings:
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
	settings: Dict[str, str] = field(default_factory=dict)

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
			"settings": {k0: v0 for k0, v0 in self.settings.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ApplicationSettings':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			settings=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["settings"].items())),
		)

@dataclass
class EntityReference:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	doc_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"docId": self.doc_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityReference':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			doc_id=deserialized_dict.get("docId"),
		)

@dataclass
class EntityTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	user_id: Optional[str] = None
	descr: Optional[str] = None
	keywords: Optional[List[str]] = None
	entity_type: Optional[str] = None
	sub_type: Optional[str] = None
	default_template: Optional[bool] = None
	entity: List[Dict[str, object]] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"userId": self.user_id,
			"descr": self.descr,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
			"entityType": self.entity_type,
			"subType": self.sub_type,
			"defaultTemplate": self.default_template,
			"entity": [{k1: v1 for k1, v1 in x0.items()} for x0 in self.entity],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			user_id=deserialized_dict.get("userId"),
			descr=deserialized_dict.get("descr"),
			keywords=[x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
			entity_type=deserialized_dict.get("entityType"),
			sub_type=deserialized_dict.get("subType"),
			default_template=deserialized_dict.get("defaultTemplate"),
			entity=[dict(map(lambda kv1: (kv1[0], kv1[1]), x0.items())) for x0 in deserialized_dict["entity"]],
		)

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
	system_metadata: Optional['User.SystemMetadata'] = None

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
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'User.SystemMetadata':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				roles=[x0 for x0 in deserialized_dict["roles"]],
				is_admin=deserialized_dict["isAdmin"],
				inherits_roles=deserialized_dict["inheritsRoles"],
			)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			created=deserialized_dict.get("created"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			name=deserialized_dict.get("name"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			permissions=[Permission._deserialize(x0) for x0 in deserialized_dict["permissions"]],
			roles=[x0 for x0 in deserialized_dict["roles"]],
			type=UsersType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status=UsersStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			login=deserialized_dict.get("login"),
			password_hash=deserialized_dict.get("passwordHash"),
			group_id=deserialized_dict.get("groupId"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			patient_id=deserialized_dict.get("patientId"),
			device_id=deserialized_dict.get("deviceId"),
			auto_delegations=dict(map(lambda kv0: (DelegationTag._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["autoDelegations"].items())),
			created_date=deserialized_dict.get("createdDate"),
			terms_of_use_date=deserialized_dict.get("termsOfUseDate"),
			email=deserialized_dict.get("email"),
			mobile_phone=deserialized_dict.get("mobilePhone"),
			application_tokens=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["applicationTokens"].items())),
			authentication_tokens=dict(map(lambda kv0: (kv0[0], AuthenticationToken._deserialize(kv0[1])), deserialized_dict["authenticationTokens"].items())),
			system_metadata=User.SystemMetadata._deserialize(deserialized_dict.get("systemMetadata")) if deserialized_dict.get("systemMetadata") is not None else None,
		)

@dataclass
class EncryptedPropertyStub:
	id: Optional[str] = None
	type: Optional['PropertyTypeStub'] = None
	typed_value: Optional['EncryptedTypedValue'] = None
	deletion_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"type": self.type.__serialize__() if self.type is not None else None,
			"typedValue": self.typed_value.__serialize__() if self.typed_value is not None else None,
			"deletionDate": self.deletion_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPropertyStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			type=PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value=EncryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			deletion_date=deserialized_dict.get("deletionDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPropertyStub:
	id: Optional[str] = None
	type: Optional['PropertyTypeStub'] = None
	typed_value: Optional['DecryptedTypedValue'] = None
	deletion_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"type": self.type.__serialize__() if self.type is not None else None,
			"typedValue": self.typed_value.__serialize__() if self.typed_value is not None else None,
			"deletionDate": self.deletion_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPropertyStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			type=PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value=DecryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			deletion_date=deserialized_dict.get("deletionDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

PropertyStub = Union['EncryptedPropertyStub', 'DecryptedPropertyStub']

def serialize_property_stub(property_stub: PropertyStub) -> object:
	if isinstance(property_stub, EncryptedPropertyStub):
		return {
			"type": "com.icure.sdk.model.EncryptedPropertyStub",
			"entity": property_stub.__serialize__()
		}
	elif isinstance(property_stub, DecryptedPropertyStub):
		return {
			"type": "com.icure.sdk.model.DecryptedPropertyStub",
			"entity": property_stub.__serialize__()
		}
	else:
		raise Exception(f"{type(property_stub)} is not a known subclass of PropertyStub")

def deserialize_property_stub(data: Union[str, Dict[str, object]]) -> 'PropertyStub':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedPropertyStub":
		EncryptedPropertyStub._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedPropertyStub":
		DecryptedPropertyStub._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of PropertyStub")

@dataclass
class UserGroup:
	group_id: Optional[str] = None
	group_name: Optional[str] = None
	groups_hierarchy: List['Group'] = field(default_factory=list)
	user_id: Optional[str] = None
	login: Optional[str] = None
	name: Optional[str] = None
	email: Optional[str] = None
	phone: Optional[str] = None
	patient_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	device_id: Optional[str] = None
	name_of_parent_of_topmost_group_in_hierarchy: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"groupName": self.group_name,
			"groupsHierarchy": [x0.__serialize__() for x0 in self.groups_hierarchy],
			"userId": self.user_id,
			"login": self.login,
			"name": self.name,
			"email": self.email,
			"phone": self.phone,
			"patientId": self.patient_id,
			"healthcarePartyId": self.healthcare_party_id,
			"deviceId": self.device_id,
			"nameOfParentOfTopmostGroupInHierarchy": self.name_of_parent_of_topmost_group_in_hierarchy,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict.get("groupId"),
			group_name=deserialized_dict.get("groupName"),
			groups_hierarchy=[Group._deserialize(x0) for x0 in deserialized_dict["groupsHierarchy"]],
			user_id=deserialized_dict.get("userId"),
			login=deserialized_dict.get("login"),
			name=deserialized_dict.get("name"),
			email=deserialized_dict.get("email"),
			phone=deserialized_dict.get("phone"),
			patient_id=deserialized_dict.get("patientId"),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			device_id=deserialized_dict.get("deviceId"),
			name_of_parent_of_topmost_group_in_hierarchy=deserialized_dict.get("nameOfParentOfTopmostGroupInHierarchy"),
		)

@dataclass
class ListOfIds:
	ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ListOfIds':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids=[x0 for x0 in deserialized_dict["ids"]],
		)

@dataclass
class TokenWithGroup:
	token: str
	group_id: str
	group_name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"token": self.token,
			"groupId": self.group_id,
			"groupName": self.group_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TokenWithGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token=deserialized_dict["token"],
			group_id=deserialized_dict["groupId"],
			group_name=deserialized_dict.get("groupName"),
		)

@dataclass
class Enable2faRequest:
	secret: str

	def __serialize__(self) -> object:
		return {
			"secret": self.secret,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Enable2faRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret=deserialized_dict["secret"],
		)

@dataclass
class Role:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	permissions: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"permissions": [x0 for x0 in self.permissions],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Role':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			permissions=[x0 for x0 in deserialized_dict["permissions"]],
		)

@dataclass
class KeyPairUpdateNotification:
	new_public_key: 'SpkiHexString'
	concerned_data_owner_id: str

	def __serialize__(self) -> object:
		return {
			"newPublicKey": self.new_public_key,
			"concernedDataOwnerId": self.concerned_data_owner_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyPairUpdateNotification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			new_public_key=deserialized_dict["newPublicKey"],
			concerned_data_owner_id=deserialized_dict["concernedDataOwnerId"],
		)

class DataOwnerType(Enum):
	Hcp = "hcp"
	Device = "device"
	Patient = "patient"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerType':
		if data == "hcp":
			return DataOwnerType.Hcp
		elif data == "device":
			return DataOwnerType.Device
		elif data == "patient":
			return DataOwnerType.Patient
		else:
			raise Exception(f"{data} is not a valid value for DataOwnerType enum.")

DataOwnerWithType = Union['DataOwnerWithTypeHcpDataOwner', 'DataOwnerWithTypePatientDataOwner', 'DataOwnerWithTypeDeviceDataOwner']

@dataclass
class DataOwnerWithTypeHcpDataOwner:
	data_owner: 'HealthcareParty'

	def __serialize__(self) -> object:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerWithTypeHcpDataOwner':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=HealthcareParty._deserialize(deserialized_dict["dataOwner"]),
		)

@dataclass
class DataOwnerWithTypePatientDataOwner:
	data_owner: 'EncryptedPatient'

	def __serialize__(self) -> object:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerWithTypePatientDataOwner':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=EncryptedPatient._deserialize(deserialized_dict["dataOwner"]),
		)

@dataclass
class DataOwnerWithTypeDeviceDataOwner:
	data_owner: 'Device'

	def __serialize__(self) -> object:
		return {
			"dataOwner": self.data_owner.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataOwnerWithTypeDeviceDataOwner':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data_owner=Device._deserialize(deserialized_dict["dataOwner"]),
		)

def serialize_data_owner_with_type(data_owner_with_type: DataOwnerWithType) -> object:
	if isinstance(data_owner_with_type, DataOwnerWithTypeHcpDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "hcp"})
		return serialized_entity
	elif isinstance(data_owner_with_type, DataOwnerWithTypePatientDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "patient"})
		return serialized_entity
	elif isinstance(data_owner_with_type, DataOwnerWithTypeDeviceDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "device"})
		return serialized_entity
	else:
		raise Exception(f"{type(data_owner_with_type)} is not a known subclass of DataOwnerWithType")

def deserialize_data_owner_with_type(data: Union[str, Dict[str, object]]) -> 'DataOwnerWithType':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "hcp":
		return DataOwnerWithTypeHcpDataOwner._deserialize(deserialized_dict)
	elif qualifier == "patient":
		return DataOwnerWithTypePatientDataOwner._deserialize(deserialized_dict)
	elif qualifier == "device":
		return DataOwnerWithTypeDeviceDataOwner._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of DataOwnerWithType")

@dataclass
class IndexingInfo:
	statuses: Optional[Dict[str, int]] = None

	def __serialize__(self) -> object:
		return {
			"statuses": {k0: v0 for k0, v0 in self.statuses.items()} if self.statuses is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IndexingInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			statuses=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("statuses").items())) if deserialized_dict.get("statuses") is not None else None,
		)

@dataclass
class ReplicationInfo:
	active: bool = False
	running: bool = False
	pending_from: Optional[int] = None
	pending_to: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"active": self.active,
			"running": self.running,
			"pendingFrom": self.pending_from,
			"pendingTo": self.pending_to,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicationInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			active=deserialized_dict["active"],
			running=deserialized_dict["running"],
			pending_from=deserialized_dict.get("pendingFrom"),
			pending_to=deserialized_dict.get("pendingTo"),
		)

@dataclass
class ReplicatorDocument:
	id: str
	rev: Optional[str] = None
	source: Optional['Remote'] = None
	target: Optional['Remote'] = None
	owner: Optional[str] = None
	create_target: Optional[bool] = None
	continuous: Optional[bool] = None
	doc_ids: Optional[List[str]] = None
	replication_state: Optional[str] = None
	replication_state_time: Optional[str] = None
	replication_stats: Optional['ReplicationStats'] = None
	error_count: Optional[int] = None
	revs_info: Optional[List[Dict[str, str]]] = None
	rev_history: Optional[Dict[str, str]] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"source": self.source.__serialize__() if self.source is not None else None,
			"target": self.target.__serialize__() if self.target is not None else None,
			"owner": self.owner,
			"create_target": self.create_target,
			"continuous": self.continuous,
			"doc_ids": [x0 for x0 in self.doc_ids] if self.doc_ids is not None else None,
			"replicationState": self.replication_state,
			"replicationStateTime": self.replication_state_time,
			"replicationStats": self.replication_stats.__serialize__() if self.replication_stats is not None else None,
			"errorCount": self.error_count,
			"revsInfo": [{k1: v1 for k1, v1 in x0.items()} for x0 in self.revs_info] if self.revs_info is not None else None,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()} if self.rev_history is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicatorDocument':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			source=Remote._deserialize(deserialized_dict.get("source")) if deserialized_dict.get("source") is not None else None,
			target=Remote._deserialize(deserialized_dict.get("target")) if deserialized_dict.get("target") is not None else None,
			owner=deserialized_dict.get("owner"),
			create_target=deserialized_dict.get("create_target"),
			continuous=deserialized_dict.get("continuous"),
			doc_ids=[x0 for x0 in deserialized_dict.get("doc_ids")] if deserialized_dict.get("doc_ids") is not None else None,
			replication_state=deserialized_dict.get("replicationState"),
			replication_state_time=deserialized_dict.get("replicationStateTime"),
			replication_stats=ReplicationStats._deserialize(deserialized_dict.get("replicationStats")) if deserialized_dict.get("replicationStats") is not None else None,
			error_count=deserialized_dict.get("errorCount"),
			revs_info=[dict(map(lambda kv1: (kv1[0], kv1[1]), x0.items())) for x0 in deserialized_dict.get("revsInfo")] if deserialized_dict.get("revsInfo") is not None else None,
			rev_history=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("revHistory").items())) if deserialized_dict.get("revHistory") is not None else None,
		)

@dataclass
class EncryptedTimeTable:
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
	name: Optional[str] = None
	agenda_id: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	items: List['TimeTableItem'] = field(default_factory=list)
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
			"name": self.name,
			"agendaId": self.agenda_id,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"items": [x0.__serialize__() for x0 in self.items],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedTimeTable':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			agenda_id=deserialized_dict.get("agendaId"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			items=[TimeTableItem._deserialize(x0) for x0 in deserialized_dict["items"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedTimeTable:
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
	name: Optional[str] = None
	agenda_id: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	items: List['TimeTableItem'] = field(default_factory=list)
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
			"name": self.name,
			"agendaId": self.agenda_id,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"items": [x0.__serialize__() for x0 in self.items],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedTimeTable':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			agenda_id=deserialized_dict.get("agendaId"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			items=[TimeTableItem._deserialize(x0) for x0 in deserialized_dict["items"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

TimeTable = Union['EncryptedTimeTable', 'DecryptedTimeTable']

def serialize_time_table(time_table: TimeTable) -> object:
	if isinstance(time_table, EncryptedTimeTable):
		return {
			"type": "com.icure.sdk.model.EncryptedTimeTable",
			"entity": time_table.__serialize__()
		}
	elif isinstance(time_table, DecryptedTimeTable):
		return {
			"type": "com.icure.sdk.model.DecryptedTimeTable",
			"entity": time_table.__serialize__()
		}
	else:
		raise Exception(f"{type(time_table)} is not a known subclass of TimeTable")

def deserialize_time_table(data: Union[str, Dict[str, object]]) -> 'TimeTable':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedTimeTable":
		EncryptedTimeTable._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedTimeTable":
		DecryptedTimeTable._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of TimeTable")

class AccessLevel(Enum):
	Read = "READ"
	Write = "WRITE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AccessLevel':
		if data == "READ":
			return AccessLevel.Read
		elif data == "WRITE":
			return AccessLevel.Write
		else:
			raise Exception(f"{data} is not a valid value for AccessLevel enum.")

SecretIdOption = Union['SecretIdOptionUseAnyConfidential', 'SecretIdOptionUseAnySharedWithParent', 'SecretIdOptionUse']

class SecretIdOptionUseAnyConfidential(metaclass=SingletonMeta):

	def __serialize__(self) -> object:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UseAnyConfidential':
		return cls()

class SecretIdOptionUseAnySharedWithParent(metaclass=SingletonMeta):

	def __serialize__(self) -> object:
		return {}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UseAnySharedWithParent':
		return cls()

@dataclass
class SecretIdOptionUse:
	secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"secretIds": [x0 for x0 in self.secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecretIdOptionUse':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret_ids=[x0 for x0 in deserialized_dict["secretIds"]],
		)

def serialize_secret_id_option(secret_id_option: SecretIdOption) -> object:
	if isinstance(secret_id_option, SecretIdOptionUseAnyConfidential):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential"})
		return serialized_entity
	elif isinstance(secret_id_option, SecretIdOptionUseAnySharedWithParent):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent"})
		return serialized_entity
	elif isinstance(secret_id_option, SecretIdOptionUse):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.Use"})
		return serialized_entity
	else:
		raise Exception(f"{type(secret_id_option)} is not a known subclass of SecretIdOption")

def deserialize_secret_id_option(data: Union[str, Dict[str, object]]) -> 'SecretIdOption':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential":
		return SecretIdOptionUseAnyConfidential._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent":
		return SecretIdOptionUseAnySharedWithParent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.Use":
		return SecretIdOptionUse._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SecretIdOption")

SimpleShareResult = Union['SimpleShareResultSuccess', 'SimpleShareResultFailure']

@dataclass
class SimpleShareResultSuccess:
	updated_entity: object

	def __serialize__(self) -> object:
		return {
			"updatedEntity": self.updated_entity.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SimpleShareResultSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			updated_entity=deserialized_dict["updatedEntity"],
		)

@dataclass
class SimpleShareResultFailure:
	errors_details: List['FailedRequestDetails']

	def __serialize__(self) -> object:
		return {
			"errorsDetails": [x0.__serialize__() for x0 in self.errors_details],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SimpleShareResultFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			errors_details=[FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errorsDetails"]],
		)

def serialize_simple_share_result(simple_share_result: SimpleShareResult) -> object:
	if isinstance(simple_share_result, SimpleShareResultSuccess):
		serialized_entity = simple_share_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SimpleShareResult.Success"})
		return serialized_entity
	elif isinstance(simple_share_result, SimpleShareResultFailure):
		serialized_entity = simple_share_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SimpleShareResult.Failure"})
		return serialized_entity
	else:
		raise Exception(f"{type(simple_share_result)} is not a known subclass of SimpleShareResult")

def deserialize_simple_share_result(data: Union[str, Dict[str, object]]) -> 'SimpleShareResult':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.SimpleShareResult.Success":
		return SimpleShareResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SimpleShareResult.Failure":
		return SimpleShareResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SimpleShareResult")

class ShareMetadataBehaviour(Enum):
	Required = "REQUIRED"
	IfAvailable = "IF_AVAILABLE"
	Never = "NEVER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareMetadataBehaviour':
		if data == "REQUIRED":
			return ShareMetadataBehaviour.Required
		elif data == "IF_AVAILABLE":
			return ShareMetadataBehaviour.IfAvailable
		elif data == "NEVER":
			return ShareMetadataBehaviour.Never
		else:
			raise Exception(f"{data} is not a valid value for ShareMetadataBehaviour enum.")

class RequestedPermission(Enum):
	MaxRead = "MAX_READ"
	FullRead = "FULL_READ"
	MaxWrite = "MAX_WRITE"
	FullWrite = "FULL_WRITE"
	Root = "ROOT"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RequestedPermission':
		if data == "MAX_READ":
			return RequestedPermission.MaxRead
		elif data == "FULL_READ":
			return RequestedPermission.FullRead
		elif data == "MAX_WRITE":
			return RequestedPermission.MaxWrite
		elif data == "FULL_WRITE":
			return RequestedPermission.FullWrite
		elif data == "ROOT":
			return RequestedPermission.Root
		else:
			raise Exception(f"{data} is not a valid value for RequestedPermission enum.")

@dataclass
class TimeTableShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			document_location=DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status=DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri=deserialized_dict.get("externalUri"),
			name=deserialized_dict.get("name"),
			version=deserialized_dict.get("version"),
			stored_icure_document_id=deserialized_dict.get("storedICureDocumentId"),
			external_uuid=deserialized_dict.get("externalUuid"),
			size=deserialized_dict.get("size"),
			hash=deserialized_dict.get("hash"),
			opening_contact_id=deserialized_dict.get("openingContactId"),
			attachment_id=deserialized_dict.get("attachmentId"),
			object_store_reference=deserialized_dict.get("objectStoreReference"),
			main_uti=deserialized_dict.get("mainUti"),
			other_utis=[x0 for x0 in deserialized_dict["otherUtis"]],
			secondary_attachments=dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments=[DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			document_location=DocumentLocation._deserialize(deserialized_dict.get("documentLocation")) if deserialized_dict.get("documentLocation") is not None else None,
			document_type=DocumentType._deserialize(deserialized_dict.get("documentType")) if deserialized_dict.get("documentType") is not None else None,
			document_status=DocumentStatus._deserialize(deserialized_dict.get("documentStatus")) if deserialized_dict.get("documentStatus") is not None else None,
			external_uri=deserialized_dict.get("externalUri"),
			name=deserialized_dict.get("name"),
			version=deserialized_dict.get("version"),
			stored_icure_document_id=deserialized_dict.get("storedICureDocumentId"),
			external_uuid=deserialized_dict.get("externalUuid"),
			size=deserialized_dict.get("size"),
			hash=deserialized_dict.get("hash"),
			opening_contact_id=deserialized_dict.get("openingContactId"),
			attachment_id=deserialized_dict.get("attachmentId"),
			object_store_reference=deserialized_dict.get("objectStoreReference"),
			main_uti=deserialized_dict.get("mainUti"),
			other_utis=[x0 for x0 in deserialized_dict["otherUtis"]],
			secondary_attachments=dict(map(lambda kv0: (kv0[0], DataAttachment._deserialize(kv0[1])), deserialized_dict["secondaryAttachments"].items())),
			deleted_attachments=[DeletedAttachment._deserialize(x0) for x0 in deserialized_dict["deletedAttachments"]],
			encrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("encryptedAttachment"))) if deserialized_dict.get("encryptedAttachment") is not None else None,
			decrypted_attachment=bytearray(base64.b64decode(deserialized_dict.get("decryptedAttachment"))) if deserialized_dict.get("decryptedAttachment") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

Document = Union['EncryptedDocument', 'DecryptedDocument']

def serialize_document(document: Document) -> object:
	if isinstance(document, EncryptedDocument):
		return {
			"type": "com.icure.sdk.model.EncryptedDocument",
			"entity": document.__serialize__()
		}
	elif isinstance(document, DecryptedDocument):
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
class EntityAccessInformation:
	permissions_by_data_owner_id: Dict[str, 'AccessLevel']
	has_unknown_anonymous_data_owners: bool

	def __serialize__(self) -> object:
		return {
			"permissionsByDataOwnerId": {k0: v0.__serialize__() for k0, v0 in self.permissions_by_data_owner_id.items()},
			"hasUnknownAnonymousDataOwners": self.has_unknown_anonymous_data_owners,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityAccessInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			permissions_by_data_owner_id=dict(map(lambda kv0: (kv0[0], AccessLevel._deserialize(kv0[1])), deserialized_dict["permissionsByDataOwnerId"].items())),
			has_unknown_anonymous_data_owners=deserialized_dict["hasUnknownAnonymousDataOwners"],
		)

class SubscriptionEventType(Enum):
	Create = "CREATE"
	Update = "UPDATE"
	Delete = "DELETE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SubscriptionEventType':
		if data == "CREATE":
			return SubscriptionEventType.Create
		elif data == "UPDATE":
			return SubscriptionEventType.Update
		elif data == "DELETE":
			return SubscriptionEventType.Delete
		else:
			raise Exception(f"{data} is not a valid value for SubscriptionEventType enum.")

@dataclass
class EntitySubscriptionConfiguration:
	channel_buffer_capacity: int = 100
	on_buffer_full: 'EntitySubscriptionConfiguration.FullBufferBehaviour' = field(default_factory=lambda: EntitySubscriptionConfiguration.FullBufferBehaviour.Close)
	reconnection_delay: timedelta = timedelta(seconds=2)
	retry_delay_exponent_factor: float = 2.0
	connection_max_retries: int = 5

	class FullBufferBehaviour(Enum):
		Close = "Close"
		DropOldest = "DropOldest"
		Ignore = "Ignore"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntitySubscriptionConfiguration.FullBufferBehaviour':
			if data == "Close":
				return EntitySubscriptionConfiguration.FullBufferBehaviour.Close
			elif data == "DropOldest":
				return EntitySubscriptionConfiguration.FullBufferBehaviour.DropOldest
			elif data == "Ignore":
				return EntitySubscriptionConfiguration.FullBufferBehaviour.Ignore
			else:
				raise Exception(f"{data} is not a valid value for FullBufferBehaviour enum.")

	def __serialize__(self) -> object:
		return {
			"channelBufferCapacity": self.channel_buffer_capacity,
			"onBufferFull": self.on_buffer_full.__serialize__(),
			"reconnectionDelay": serialize_timedelta(self.reconnection_delay),
			"retryDelayExponentFactor": self.retry_delay_exponent_factor,
			"connectionMaxRetries": self.connection_max_retries,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntitySubscriptionConfiguration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			channel_buffer_capacity=deserialized_dict["channelBufferCapacity"],
			on_buffer_full=EntitySubscriptionConfiguration.FullBufferBehaviour._deserialize(deserialized_dict["onBufferFull"]),
			reconnection_delay=deserialize_timedelta(deserialized_dict["reconnectionDelay"]),
			retry_delay_exponent_factor=deserialized_dict["retryDelayExponentFactor"],
			connection_max_retries=deserialized_dict["connectionMaxRetries"],
		)

class SortDirection(Enum):
	Asc = "asc"
	Desc = "desc"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SortDirection':
		if data == "asc":
			return SortDirection.Asc
		elif data == "desc":
			return SortDirection.Desc
		else:
			raise Exception(f"{data} is not a valid value for SortDirection enum.")

@dataclass
class EncryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[List['EncryptedService']] = None
	ratio: Optional[List['Measure']] = None
	range: Optional[List['Measure']] = None

	def __serialize__(self) -> object:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedContent':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value=deserialized_dict.get("stringValue"),
			number_value=deserialized_dict.get("numberValue"),
			boolean_value=deserialized_dict.get("booleanValue"),
			instant_value=deserialized_dict.get("instantValue"),
			fuzzy_date_value=deserialized_dict.get("fuzzyDateValue"),
			binary_value=bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id=deserialized_dict.get("documentId"),
			measure_value=Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value=Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series=TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value=[EncryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio=[Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range=[Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

@dataclass
class DecryptedContent:
	string_value: Optional[str] = None
	number_value: Optional[float] = None
	boolean_value: Optional[bool] = None
	instant_value: Optional[int] = None
	fuzzy_date_value: Optional[int] = None
	binary_value: Optional[bytearray] = None
	document_id: Optional[str] = None
	measure_value: Optional['Measure'] = None
	medication_value: Optional['Medication'] = None
	time_series: Optional['TimeSeries'] = None
	compound_value: Optional[List['DecryptedService']] = None
	ratio: Optional[List['Measure']] = None
	range: Optional[List['Measure']] = None

	def __serialize__(self) -> object:
		return {
			"stringValue": self.string_value,
			"numberValue": self.number_value,
			"booleanValue": self.boolean_value,
			"instantValue": self.instant_value,
			"fuzzyDateValue": self.fuzzy_date_value,
			"binaryValue": base64.b64encode(self.binary_value).decode('utf-8') if self.binary_value is not None else None,
			"documentId": self.document_id,
			"measureValue": self.measure_value.__serialize__() if self.measure_value is not None else None,
			"medicationValue": self.medication_value.__serialize__() if self.medication_value is not None else None,
			"timeSeries": self.time_series.__serialize__() if self.time_series is not None else None,
			"compoundValue": [x0.__serialize__() for x0 in self.compound_value] if self.compound_value is not None else None,
			"ratio": [x0.__serialize__() for x0 in self.ratio] if self.ratio is not None else None,
			"range": [x0.__serialize__() for x0 in self.range] if self.range is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedContent':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			string_value=deserialized_dict.get("stringValue"),
			number_value=deserialized_dict.get("numberValue"),
			boolean_value=deserialized_dict.get("booleanValue"),
			instant_value=deserialized_dict.get("instantValue"),
			fuzzy_date_value=deserialized_dict.get("fuzzyDateValue"),
			binary_value=bytearray(base64.b64decode(deserialized_dict.get("binaryValue"))) if deserialized_dict.get("binaryValue") is not None else None,
			document_id=deserialized_dict.get("documentId"),
			measure_value=Measure._deserialize(deserialized_dict.get("measureValue")) if deserialized_dict.get("measureValue") is not None else None,
			medication_value=Medication._deserialize(deserialized_dict.get("medicationValue")) if deserialized_dict.get("medicationValue") is not None else None,
			time_series=TimeSeries._deserialize(deserialized_dict.get("timeSeries")) if deserialized_dict.get("timeSeries") is not None else None,
			compound_value=[DecryptedService._deserialize(x0) for x0 in deserialized_dict.get("compoundValue")] if deserialized_dict.get("compoundValue") is not None else None,
			ratio=[Measure._deserialize(x0) for x0 in deserialized_dict.get("ratio")] if deserialized_dict.get("ratio") is not None else None,
			range=[Measure._deserialize(x0) for x0 in deserialized_dict.get("range")] if deserialized_dict.get("range") is not None else None,
		)

Content = Union['EncryptedContent', 'DecryptedContent']

def serialize_content(content: Content) -> object:
	if isinstance(content, EncryptedContent):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedContent",
			"entity": content.__serialize__()
		}
	elif isinstance(content, DecryptedContent):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedContent",
			"entity": content.__serialize__()
		}
	else:
		raise Exception(f"{type(content)} is not a known subclass of Content")

def deserialize_content(data: Union[str, Dict[str, object]]) -> 'Content':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedContent":
		EncryptedContent._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedContent":
		DecryptedContent._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Content")

@dataclass
class EncryptedClassification:
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
	parent_id: Optional[str] = None
	label: str = ""
	template_id: Optional[str] = None
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
			"parentId": self.parent_id,
			"label": self.label,
			"templateId": self.template_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedClassification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			parent_id=deserialized_dict.get("parentId"),
			label=deserialized_dict["label"],
			template_id=deserialized_dict.get("templateId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedClassification:
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
	parent_id: Optional[str] = None
	label: str = ""
	template_id: Optional[str] = None
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
			"parentId": self.parent_id,
			"label": self.label,
			"templateId": self.template_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedClassification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			parent_id=deserialized_dict.get("parentId"),
			label=deserialized_dict["label"],
			template_id=deserialized_dict.get("templateId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

Classification = Union['EncryptedClassification', 'DecryptedClassification']

def serialize_classification(classification: Classification) -> object:
	if isinstance(classification, EncryptedClassification):
		return {
			"type": "com.icure.sdk.model.EncryptedClassification",
			"entity": classification.__serialize__()
		}
	elif isinstance(classification, DecryptedClassification):
		return {
			"type": "com.icure.sdk.model.DecryptedClassification",
			"entity": classification.__serialize__()
		}
	else:
		raise Exception(f"{type(classification)} is not a known subclass of Classification")

def deserialize_classification(data: Union[str, Dict[str, object]]) -> 'Classification':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedClassification":
		EncryptedClassification._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedClassification":
		DecryptedClassification._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Classification")

@dataclass
class ClassificationShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ClassificationShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DecryptedMaintenanceTask:
	id: str
	rev: Optional[str] = None
	identifier: List['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	task_type: Optional[str] = None
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	status: 'TaskStatus' = field(default_factory=lambda: TaskStatus.Pending)
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
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"taskType": self.task_type,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"status": self.status.__serialize__(),
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedMaintenanceTask':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			task_type=deserialized_dict.get("taskType"),
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			status=TaskStatus._deserialize(deserialized_dict["status"]),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedMaintenanceTask:
	id: str
	rev: Optional[str] = None
	identifier: List['Identifier'] = field(default_factory=list)
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	task_type: Optional[str] = None
	properties: List['EncryptedPropertyStub'] = field(default_factory=list)
	status: 'TaskStatus' = field(default_factory=lambda: TaskStatus.Pending)
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
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"taskType": self.task_type,
			"properties": [x0.__serialize__() for x0 in self.properties],
			"status": self.status.__serialize__(),
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedMaintenanceTask':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			task_type=deserialized_dict.get("taskType"),
			properties=[EncryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			status=TaskStatus._deserialize(deserialized_dict["status"]),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

MaintenanceTask = Union['DecryptedMaintenanceTask', 'EncryptedMaintenanceTask']

def serialize_maintenance_task(maintenance_task: MaintenanceTask) -> object:
	if isinstance(maintenance_task, DecryptedMaintenanceTask):
		return {
			"type": "com.icure.sdk.model.DecryptedMaintenanceTask",
			"entity": maintenance_task.__serialize__()
		}
	elif isinstance(maintenance_task, EncryptedMaintenanceTask):
		return {
			"type": "com.icure.sdk.model.EncryptedMaintenanceTask",
			"entity": maintenance_task.__serialize__()
		}
	else:
		raise Exception(f"{type(maintenance_task)} is not a known subclass of MaintenanceTask")

def deserialize_maintenance_task(data: Union[str, Dict[str, object]]) -> 'MaintenanceTask':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedMaintenanceTask":
		DecryptedMaintenanceTask._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedMaintenanceTask":
		EncryptedMaintenanceTask._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of MaintenanceTask")

@dataclass
class MaintenanceTaskShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MaintenanceTaskShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

@dataclass
class FormTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	template_layout: Optional['FormTemplateLayout'] = None
	raw_template_layout: Optional[bytearray] = None
	name: Optional[str] = None
	guid: Optional[str] = None
	group: Optional['DocumentGroup'] = None
	descr: Optional[str] = None
	disabled: Optional[str] = None
	specialty: Optional['CodeStub'] = None
	author: Optional[str] = None
	form_instance_preferred_location: Optional[str] = None
	keyboard_shortcut: Optional[str] = None
	short_report: Optional[str] = None
	medium_report: Optional[str] = None
	long_report: Optional[str] = None
	reports: List[str] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	layout_attachment_id: Optional[str] = None
	template_layout_attachment_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"templateLayout": self.template_layout.__serialize__() if self.template_layout is not None else None,
			"rawTemplateLayout": base64.b64encode(self.raw_template_layout).decode('utf-8') if self.raw_template_layout is not None else None,
			"name": self.name,
			"guid": self.guid,
			"group": self.group.__serialize__() if self.group is not None else None,
			"descr": self.descr,
			"disabled": self.disabled,
			"specialty": self.specialty.__serialize__() if self.specialty is not None else None,
			"author": self.author,
			"formInstancePreferredLocation": self.form_instance_preferred_location,
			"keyboardShortcut": self.keyboard_shortcut,
			"shortReport": self.short_report,
			"mediumReport": self.medium_report,
			"longReport": self.long_report,
			"reports": [x0 for x0 in self.reports],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"layoutAttachmentId": self.layout_attachment_id,
			"templateLayoutAttachmentId": self.template_layout_attachment_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			template_layout=FormTemplateLayout._deserialize(deserialized_dict.get("templateLayout")) if deserialized_dict.get("templateLayout") is not None else None,
			raw_template_layout=bytearray(base64.b64decode(deserialized_dict.get("rawTemplateLayout"))) if deserialized_dict.get("rawTemplateLayout") is not None else None,
			name=deserialized_dict.get("name"),
			guid=deserialized_dict.get("guid"),
			group=DocumentGroup._deserialize(deserialized_dict.get("group")) if deserialized_dict.get("group") is not None else None,
			descr=deserialized_dict.get("descr"),
			disabled=deserialized_dict.get("disabled"),
			specialty=CodeStub._deserialize(deserialized_dict.get("specialty")) if deserialized_dict.get("specialty") is not None else None,
			author=deserialized_dict.get("author"),
			form_instance_preferred_location=deserialized_dict.get("formInstancePreferredLocation"),
			keyboard_shortcut=deserialized_dict.get("keyboardShortcut"),
			short_report=deserialized_dict.get("shortReport"),
			medium_report=deserialized_dict.get("mediumReport"),
			long_report=deserialized_dict.get("longReport"),
			reports=[x0 for x0 in deserialized_dict["reports"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			layout_attachment_id=deserialized_dict.get("layoutAttachmentId"),
			template_layout_attachment_id=deserialized_dict.get("templateLayoutAttachmentId"),
		)

class ShareAllPatientDataOptions(metaclass=SingletonMeta):

	class Tag(Enum):
		All = "All"
		MedicalInformation = "MedicalInformation"
		FinancialInformation = "FinancialInformation"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.Tag':
			if data == "All":
				return ShareAllPatientDataOptions.Tag.All
			elif data == "MedicalInformation":
				return ShareAllPatientDataOptions.Tag.MedicalInformation
			elif data == "FinancialInformation":
				return ShareAllPatientDataOptions.Tag.FinancialInformation
			else:
				raise Exception(f"{data} is not a valid value for Tag enum.")

	class ShareableEntity(Enum):
		CalendarItem = "CalendarItem"
		Contact = "Contact"
		Classification = "Classification"
		Document = "Document"
		Form = "Form"
		HealthElement = "HealthElement"
		Invoice = "Invoice"
		Patient = "Patient"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.ShareableEntity':
			if data == "CalendarItem":
				return ShareAllPatientDataOptions.ShareableEntity.CalendarItem
			elif data == "Contact":
				return ShareAllPatientDataOptions.ShareableEntity.Contact
			elif data == "Classification":
				return ShareAllPatientDataOptions.ShareableEntity.Classification
			elif data == "Document":
				return ShareAllPatientDataOptions.ShareableEntity.Document
			elif data == "Form":
				return ShareAllPatientDataOptions.ShareableEntity.Form
			elif data == "HealthElement":
				return ShareAllPatientDataOptions.ShareableEntity.HealthElement
			elif data == "Invoice":
				return ShareAllPatientDataOptions.ShareableEntity.Invoice
			elif data == "Patient":
				return ShareAllPatientDataOptions.ShareableEntity.Patient
			else:
				raise Exception(f"{data} is not a valid value for ShareableEntity enum.")

	@dataclass
	class EntityResult:
		modified: int
		success: Optional[bool] = None
		error: Optional['ShareAllPatientDataOptions.SharePatientDataError'] = None

		def __serialize__(self) -> object:
			return {
				"success": self.success,
				"error": ShareAllPatientDataOptions.serialize_share_patient_data_error(self.error) if self.error is not None else None,
				"modified": self.modified,
			}

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.EntityResult':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				success=deserialized_dict.get("success"),
				error=ShareAllPatientDataOptions.deserialize_share_patient_data_error(deserialized_dict.get("error")) if deserialized_dict.get("error") is not None else None,
				modified=deserialized_dict["modified"],
			)

	@dataclass
	class Result:
		patient: 'Patient'
		statuses: Dict['ShareAllPatientDataOptions.ShareableEntity', 'ShareAllPatientDataOptions.EntityResult']

		def __serialize__(self) -> object:
			return {
				"patient": serialize_patient(self.patient),
				"statuses": {k0.__serialize__(): v0.__serialize__() for k0, v0 in self.statuses.items()},
			}

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.Result':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				patient=deserialize_patient(deserialized_dict["patient"]),
				statuses=dict(map(lambda kv0: (ShareAllPatientDataOptions.ShareableEntity._deserialize(kv0[0]), ShareAllPatientDataOptions.EntityResult._deserialize(kv0[1])), deserialized_dict["statuses"].items())),
			)

	SharePatientDataError = Union['ShareAllPatientDataOptions.BulkShareFailure', 'ShareAllPatientDataOptions.FailedRequest']

	@dataclass
	class BulkShareFailure:
		errors: List['FailedRequestDetails']
		message: str

		def __serialize__(self) -> object:
			return {
				"errors": [x0.__serialize__() for x0 in self.errors],
				"message": self.message,
			}

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.BulkShareFailure':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				errors=[FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errors"]],
				message=deserialized_dict["message"],
			)

	@dataclass
	class FailedRequest:
		description: str

		def __serialize__(self) -> object:
			return {
				"description": self.description,
			}

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.FailedRequest':
			deserialized_dict: dict[str, object]
			if isinstance(data, str):
				deserialized_dict = json.loads(data)
			else:
				deserialized_dict = data
			return cls(
				description=deserialized_dict["description"],
			)

	@classmethod
	def serialize_share_patient_data_error(cls, share_patient_data_error: SharePatientDataError) -> object:
		if isinstance(share_patient_data_error, ShareAllPatientDataOptions.BulkShareFailure):
			serialized_entity = share_patient_data_error.__serialize__()
			serialized_entity.update({"type": "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure"})
			return serialized_entity
		elif isinstance(share_patient_data_error, ShareAllPatientDataOptions.FailedRequest):
			serialized_entity = share_patient_data_error.__serialize__()
			serialized_entity.update({"type": "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest"})
			return serialized_entity
		else:
			raise Exception(f"{type(share_patient_data_error)} is not a known subclass of SharePatientDataError")

	def deserialize_share_patient_data_error(data: Union[str, Dict[str, object]]) -> 'ShareAllPatientDataOptions.SharePatientDataError':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		qualifier = deserialized_dict.get("type")
		if qualifier is None:
			raise Exception("Missing qualifier: type")
		if qualifier == "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure":
			return ShareAllPatientDataOptions.BulkShareFailure._deserialize(deserialized_dict)
		elif qualifier == "com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest":
			return ShareAllPatientDataOptions.FailedRequest._deserialize(deserialized_dict)
		else:
			raise Exception(f"{qualifier} is not a known subclass of SharePatientDataError")

@dataclass
class EntityWithTypeInfo:
	entity: object
	type: 'EntityWithEncryptionMetadataTypeName'

	def __serialize__(self) -> object:
		return {
			"entity": self.entity.__serialize__(),
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithTypeInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity=deserialized_dict["entity"],
			type=EntityWithEncryptionMetadataTypeName._deserialize(deserialized_dict["type"]),
		)

@dataclass
class PatientShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_secret_ids=[x0 for x0 in deserialized_dict["shareSecretIds"]],
		)

@dataclass
class EncryptedHealthElement:
	id: str
	identifiers: List['Identifier'] = field(default_factory=list)
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
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: List['EncryptedPlanOfAction'] = field(default_factory=list)
	episodes: List['EncryptedEpisode'] = field(default_factory=list)
	care_team: List['EncryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
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
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedHealthElement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			health_element_id=deserialized_dict.get("healthElementId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant=deserialized_dict["relevant"],
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			id_service=deserialized_dict.get("idService"),
			status=deserialized_dict["status"],
			laterality=Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action=[EncryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes=[EncryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team=[EncryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedHealthElement:
	id: str
	identifiers: List['Identifier'] = field(default_factory=list)
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
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: List['DecryptedPlanOfAction'] = field(default_factory=list)
	episodes: List['DecryptedEpisode'] = field(default_factory=list)
	care_team: List['DecryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
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
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedHealthElement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			identifiers=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			health_element_id=deserialized_dict.get("healthElementId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant=deserialized_dict["relevant"],
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			id_service=deserialized_dict.get("idService"),
			status=deserialized_dict["status"],
			laterality=Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action=[DecryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes=[DecryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team=[DecryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

HealthElement = Union['EncryptedHealthElement', 'DecryptedHealthElement']

def serialize_health_element(health_element: HealthElement) -> object:
	if isinstance(health_element, EncryptedHealthElement):
		return {
			"type": "com.icure.sdk.model.EncryptedHealthElement",
			"entity": health_element.__serialize__()
		}
	elif isinstance(health_element, DecryptedHealthElement):
		return {
			"type": "com.icure.sdk.model.DecryptedHealthElement",
			"entity": health_element.__serialize__()
		}
	else:
		raise Exception(f"{type(health_element)} is not a known subclass of HealthElement")

def deserialize_health_element(data: Union[str, Dict[str, object]]) -> 'HealthElement':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedHealthElement":
		EncryptedHealthElement._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedHealthElement":
		DecryptedHealthElement._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of HealthElement")

@dataclass
class IcureStub:
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
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
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
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IcureStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

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
	participants: Dict['ParticipantType', str] = field(default_factory=dict)
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
			"participants": {k0.__serialize__(): v0 for k0, v0 in self.participants.items()},
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			group_id=deserialized_dict.get("groupId"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			location=deserialized_dict.get("location"),
			external_id=deserialized_dict.get("externalId"),
			encounter_type=CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location=DecryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts=[DecryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services=[DecryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			participants=dict(map(lambda kv0: (ParticipantType._deserialize(kv0[0]), kv0[1]), deserialized_dict["participants"].items())),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			modified_contact_id=deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
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
	participants: Dict['ParticipantType', str] = field(default_factory=dict)
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
			"participants": {k0.__serialize__(): v0 for k0, v0 in self.participants.items()},
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			group_id=deserialized_dict.get("groupId"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			descr=deserialized_dict.get("descr"),
			location=deserialized_dict.get("location"),
			external_id=deserialized_dict.get("externalId"),
			encounter_type=CodeStub._deserialize(deserialized_dict.get("encounterType")) if deserialized_dict.get("encounterType") is not None else None,
			encounter_location=EncryptedAddress._deserialize(deserialized_dict.get("encounterLocation")) if deserialized_dict.get("encounterLocation") is not None else None,
			sub_contacts=[EncryptedSubContact._deserialize(x0) for x0 in deserialized_dict["subContacts"]],
			services=[EncryptedService._deserialize(x0) for x0 in deserialized_dict["services"]],
			participants=dict(map(lambda kv0: (ParticipantType._deserialize(kv0[0]), kv0[1]), deserialized_dict["participants"].items())),
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			modified_contact_id=deserialized_dict.get("modifiedContactId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
		)

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
			id=deserialized_dict["id"],
			transaction_id=deserialized_dict.get("transactionId"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id=deserialized_dict.get("contactId"),
			sub_contact_ids=[x0 for x0 in deserialized_dict.get("subContactIds")] if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids=[x0 for x0 in deserialized_dict.get("plansOfActionIds")] if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids=[x0 for x0 in deserialized_dict.get("healthElementsIds")] if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids=[x0 for x0 in deserialized_dict.get("formIds")] if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict.get("secretForeignKeys")] if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label=deserialized_dict.get("label"),
			index=deserialized_dict.get("index"),
			content=dict(map(lambda kv0: (kv0[0], DecryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content=deserialized_dict.get("encryptedContent"),
			text_indexes=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			form_id=deserialized_dict.get("formId"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			end_of_life=deserialized_dict.get("endOfLife"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			comment=deserialized_dict.get("comment"),
			status=deserialized_dict.get("status"),
			invoicing_codes=[x0 for x0 in deserialized_dict["invoicingCodes"]],
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
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
			id=deserialized_dict["id"],
			transaction_id=deserialized_dict.get("transactionId"),
			identifier=[Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			contact_id=deserialized_dict.get("contactId"),
			sub_contact_ids=[x0 for x0 in deserialized_dict.get("subContactIds")] if deserialized_dict.get("subContactIds") is not None else None,
			plans_of_action_ids=[x0 for x0 in deserialized_dict.get("plansOfActionIds")] if deserialized_dict.get("plansOfActionIds") is not None else None,
			health_elements_ids=[x0 for x0 in deserialized_dict.get("healthElementsIds")] if deserialized_dict.get("healthElementsIds") is not None else None,
			form_ids=[x0 for x0 in deserialized_dict.get("formIds")] if deserialized_dict.get("formIds") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict.get("secretForeignKeys")] if deserialized_dict.get("secretForeignKeys") is not None else None,
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			label=deserialized_dict.get("label"),
			index=deserialized_dict.get("index"),
			content=dict(map(lambda kv0: (kv0[0], EncryptedContent._deserialize(kv0[1])), deserialized_dict["content"].items())),
			encrypted_content=deserialized_dict.get("encryptedContent"),
			text_indexes=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["textIndexes"].items())),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			form_id=deserialized_dict.get("formId"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			end_of_life=deserialized_dict.get("endOfLife"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			comment=deserialized_dict.get("comment"),
			status=deserialized_dict.get("status"),
			invoicing_codes=[x0 for x0 in deserialized_dict["invoicingCodes"]],
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			qualified_links=dict(map(lambda kv0: (LinkQualification._deserialize(kv0[0]), dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["qualifiedLinks"].items())),
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

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
class LabelledOccurence:
	label: str
	occurence: int

	def __serialize__(self) -> object:
		return {
			"label": self.label,
			"occurence": self.occurence,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LabelledOccurence':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			label=deserialized_dict["label"],
			occurence=deserialized_dict["occurence"],
		)

@dataclass
class ContactShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DecryptedReceipt:
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
	attachment_ids: Dict['ReceiptBlobType', str] = field(default_factory=dict)
	references: List[str] = field(default_factory=list)
	document_id: Optional[str] = None
	category: Optional[str] = None
	sub_category: Optional[str] = None
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
			"attachmentIds": {k0.__serialize__(): v0 for k0, v0 in self.attachment_ids.items()},
			"references": [x0 for x0 in self.references],
			"documentId": self.document_id,
			"category": self.category,
			"subCategory": self.sub_category,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedReceipt':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment_ids=dict(map(lambda kv0: (ReceiptBlobType._deserialize(kv0[0]), kv0[1]), deserialized_dict["attachmentIds"].items())),
			references=[x0 for x0 in deserialized_dict["references"]],
			document_id=deserialized_dict.get("documentId"),
			category=deserialized_dict.get("category"),
			sub_category=deserialized_dict.get("subCategory"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedReceipt:
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
	attachment_ids: Dict['ReceiptBlobType', str] = field(default_factory=dict)
	references: List[str] = field(default_factory=list)
	document_id: Optional[str] = None
	category: Optional[str] = None
	sub_category: Optional[str] = None
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
			"attachmentIds": {k0.__serialize__(): v0 for k0, v0 in self.attachment_ids.items()},
			"references": [x0 for x0 in self.references],
			"documentId": self.document_id,
			"category": self.category,
			"subCategory": self.sub_category,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedReceipt':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			attachment_ids=dict(map(lambda kv0: (ReceiptBlobType._deserialize(kv0[0]), kv0[1]), deserialized_dict["attachmentIds"].items())),
			references=[x0 for x0 in deserialized_dict["references"]],
			document_id=deserialized_dict.get("documentId"),
			category=deserialized_dict.get("category"),
			sub_category=deserialized_dict.get("subCategory"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

Receipt = Union['DecryptedReceipt', 'EncryptedReceipt']

def serialize_receipt(receipt: Receipt) -> object:
	if isinstance(receipt, DecryptedReceipt):
		return {
			"type": "com.icure.sdk.model.DecryptedReceipt",
			"entity": receipt.__serialize__()
		}
	elif isinstance(receipt, EncryptedReceipt):
		return {
			"type": "com.icure.sdk.model.EncryptedReceipt",
			"entity": receipt.__serialize__()
		}
	else:
		raise Exception(f"{type(receipt)} is not a known subclass of Receipt")

def deserialize_receipt(data: Union[str, Dict[str, object]]) -> 'Receipt':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedReceipt":
		DecryptedReceipt._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedReceipt":
		EncryptedReceipt._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Receipt")

@dataclass
class ReceiptShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReceiptShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
		)

@dataclass
class HealthElementShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DecryptedAccessLog:
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
	object_id: Optional[str] = None
	access_type: Optional[str] = None
	user: Optional[str] = None
	detail: Optional[str] = None
	date: Optional[int] = None
	patient_id: Optional[str] = None
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
			"objectId": self.object_id,
			"accessType": self.access_type,
			"user": self.user,
			"detail": self.detail,
			"date": self.date,
			"patientId": self.patient_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedAccessLog':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			object_id=deserialized_dict.get("objectId"),
			access_type=deserialized_dict.get("accessType"),
			user=deserialized_dict.get("user"),
			detail=deserialized_dict.get("detail"),
			date=deserialized_dict.get("date"),
			patient_id=deserialized_dict.get("patientId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedAccessLog:
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
	object_id: Optional[str] = None
	access_type: Optional[str] = None
	user: Optional[str] = None
	detail: Optional[str] = None
	date: Optional[int] = None
	patient_id: Optional[str] = None
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
			"objectId": self.object_id,
			"accessType": self.access_type,
			"user": self.user,
			"detail": self.detail,
			"date": self.date,
			"patientId": self.patient_id,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedAccessLog':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			object_id=deserialized_dict.get("objectId"),
			access_type=deserialized_dict.get("accessType"),
			user=deserialized_dict.get("user"),
			detail=deserialized_dict.get("detail"),
			date=deserialized_dict.get("date"),
			patient_id=deserialized_dict.get("patientId"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

AccessLog = Union['DecryptedAccessLog', 'EncryptedAccessLog']

def serialize_access_log(access_log: AccessLog) -> object:
	if isinstance(access_log, DecryptedAccessLog):
		return {
			"type": "com.icure.sdk.model.DecryptedAccessLog",
			"entity": access_log.__serialize__()
		}
	elif isinstance(access_log, EncryptedAccessLog):
		return {
			"type": "com.icure.sdk.model.EncryptedAccessLog",
			"entity": access_log.__serialize__()
		}
	else:
		raise Exception(f"{type(access_log)} is not a known subclass of AccessLog")

def deserialize_access_log(data: Union[str, Dict[str, object]]) -> 'AccessLog':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedAccessLog":
		DecryptedAccessLog._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedAccessLog":
		EncryptedAccessLog._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of AccessLog")

@dataclass
class AccessLogShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AccessLogShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			health_element_id=deserialized_dict.get("healthElementId"),
			contact_id=deserialized_dict.get("contactId"),
			description=deserialized_dict.get("description"),
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			active_participants=dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			linked_health_elements=[x0 for x0 in deserialized_dict["linkedHealthElements"]],
			linked_services=[x0 for x0 in deserialized_dict["linkedServices"]],
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			health_element_id=deserialized_dict.get("healthElementId"),
			contact_id=deserialized_dict.get("contactId"),
			description=deserialized_dict.get("description"),
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			active_participants=dict(map(lambda kv0: (kv0[0], TopicRole._deserialize(kv0[1])), deserialized_dict["activeParticipants"].items())),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			linked_health_elements=[x0 for x0 in deserialized_dict["linkedHealthElements"]],
			linked_services=[x0 for x0 in deserialized_dict["linkedServices"]],
		)

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
class TopicShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

class TopicRole(Enum):
	Participant = "PARTICIPANT"
	Admin = "ADMIN"
	Owner = "OWNER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicRole':
		if data == "PARTICIPANT":
			return TopicRole.Participant
		elif data == "ADMIN":
			return TopicRole.Admin
		elif data == "OWNER":
			return TopicRole.Owner
		else:
			raise Exception(f"{data} is not a valid value for TopicRole enum.")

@dataclass
class DecryptedCalendarItem:
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
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['DecryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	confirmation_time: Optional[int] = None
	cancellation_timestamp: Optional[int] = None
	confirmation_id: Optional[str] = None
	duration: Optional[int] = None
	all_day: Optional[bool] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: List['CalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
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
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"confirmationTime": self.confirmation_time,
			"cancellationTimestamp": self.cancellation_timestamp,
			"confirmationId": self.confirmation_id,
			"duration": self.duration,
			"allDay": self.all_day,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCalendarItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			title=deserialized_dict.get("title"),
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id=deserialized_dict.get("masterCalendarItemId"),
			patient_id=deserialized_dict.get("patientId"),
			important=deserialized_dict.get("important"),
			home_visit=deserialized_dict.get("homeVisit"),
			phone_number=deserialized_dict.get("phoneNumber"),
			place_id=deserialized_dict.get("placeId"),
			address=DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text=deserialized_dict.get("addressText"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			confirmation_time=deserialized_dict.get("confirmationTime"),
			cancellation_timestamp=deserialized_dict.get("cancellationTimestamp"),
			confirmation_id=deserialized_dict.get("confirmationId"),
			duration=deserialized_dict.get("duration"),
			all_day=deserialized_dict.get("allDay"),
			details=deserialized_dict.get("details"),
			was_migrated=deserialized_dict.get("wasMigrated"),
			agenda_id=deserialized_dict.get("agendaId"),
			hcp_id=deserialized_dict.get("hcpId"),
			recurrence_id=deserialized_dict.get("recurrenceId"),
			meeting_tags=[CalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item=FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedCalendarItem:
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
	title: Optional[str] = None
	calendar_item_type_id: Optional[str] = None
	master_calendar_item_id: Optional[str] = None
	patient_id: Optional[str] = None
	important: Optional[bool] = None
	home_visit: Optional[bool] = None
	phone_number: Optional[str] = None
	place_id: Optional[str] = None
	address: Optional['EncryptedAddress'] = None
	address_text: Optional[str] = None
	start_time: Optional[int] = None
	end_time: Optional[int] = None
	confirmation_time: Optional[int] = None
	cancellation_timestamp: Optional[int] = None
	confirmation_id: Optional[str] = None
	duration: Optional[int] = None
	all_day: Optional[bool] = None
	details: Optional[str] = None
	was_migrated: Optional[bool] = None
	agenda_id: Optional[str] = None
	hcp_id: Optional[str] = None
	recurrence_id: Optional[str] = None
	meeting_tags: List['CalendarItemTag'] = field(default_factory=list)
	flow_item: Optional['FlowItem'] = None
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
			"title": self.title,
			"calendarItemTypeId": self.calendar_item_type_id,
			"masterCalendarItemId": self.master_calendar_item_id,
			"patientId": self.patient_id,
			"important": self.important,
			"homeVisit": self.home_visit,
			"phoneNumber": self.phone_number,
			"placeId": self.place_id,
			"address": self.address.__serialize__() if self.address is not None else None,
			"addressText": self.address_text,
			"startTime": self.start_time,
			"endTime": self.end_time,
			"confirmationTime": self.confirmation_time,
			"cancellationTimestamp": self.cancellation_timestamp,
			"confirmationId": self.confirmation_id,
			"duration": self.duration,
			"allDay": self.all_day,
			"details": self.details,
			"wasMigrated": self.was_migrated,
			"agendaId": self.agenda_id,
			"hcpId": self.hcp_id,
			"recurrenceId": self.recurrence_id,
			"meetingTags": [x0.__serialize__() for x0 in self.meeting_tags],
			"flowItem": self.flow_item.__serialize__() if self.flow_item is not None else None,
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCalendarItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			title=deserialized_dict.get("title"),
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			master_calendar_item_id=deserialized_dict.get("masterCalendarItemId"),
			patient_id=deserialized_dict.get("patientId"),
			important=deserialized_dict.get("important"),
			home_visit=deserialized_dict.get("homeVisit"),
			phone_number=deserialized_dict.get("phoneNumber"),
			place_id=deserialized_dict.get("placeId"),
			address=EncryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
			address_text=deserialized_dict.get("addressText"),
			start_time=deserialized_dict.get("startTime"),
			end_time=deserialized_dict.get("endTime"),
			confirmation_time=deserialized_dict.get("confirmationTime"),
			cancellation_timestamp=deserialized_dict.get("cancellationTimestamp"),
			confirmation_id=deserialized_dict.get("confirmationId"),
			duration=deserialized_dict.get("duration"),
			all_day=deserialized_dict.get("allDay"),
			details=deserialized_dict.get("details"),
			was_migrated=deserialized_dict.get("wasMigrated"),
			agenda_id=deserialized_dict.get("agendaId"),
			hcp_id=deserialized_dict.get("hcpId"),
			recurrence_id=deserialized_dict.get("recurrenceId"),
			meeting_tags=[CalendarItemTag._deserialize(x0) for x0 in deserialized_dict["meetingTags"]],
			flow_item=FlowItem._deserialize(deserialized_dict.get("flowItem")) if deserialized_dict.get("flowItem") is not None else None,
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

CalendarItem = Union['DecryptedCalendarItem', 'EncryptedCalendarItem']

def serialize_calendar_item(calendar_item: CalendarItem) -> object:
	if isinstance(calendar_item, DecryptedCalendarItem):
		return {
			"type": "com.icure.sdk.model.DecryptedCalendarItem",
			"entity": calendar_item.__serialize__()
		}
	elif isinstance(calendar_item, EncryptedCalendarItem):
		return {
			"type": "com.icure.sdk.model.EncryptedCalendarItem",
			"entity": calendar_item.__serialize__()
		}
	else:
		raise Exception(f"{type(calendar_item)} is not a known subclass of CalendarItem")

def deserialize_calendar_item(data: Union[str, Dict[str, object]]) -> 'CalendarItem':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedCalendarItem":
		DecryptedCalendarItem._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedCalendarItem":
		EncryptedCalendarItem._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CalendarItem")

@dataclass
class CalendarItemShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CalendarItemShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			from_address=deserialized_dict.get("fromAddress"),
			from_healthcare_party_id=deserialized_dict.get("fromHealthcarePartyId"),
			form_id=deserialized_dict.get("formId"),
			status=deserialized_dict.get("status"),
			recipients_type=deserialized_dict.get("recipientsType"),
			recipients=[x0 for x0 in deserialized_dict["recipients"]],
			to_addresses=[x0 for x0 in deserialized_dict["toAddresses"]],
			received=deserialized_dict.get("received"),
			sent=deserialized_dict.get("sent"),
			metas=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status=dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments=[MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid=deserialized_dict.get("transportGuid"),
			remark=deserialized_dict.get("remark"),
			conversation_guid=deserialized_dict.get("conversationGuid"),
			subject=deserialized_dict.get("subject"),
			invoice_ids=[x0 for x0 in deserialized_dict["invoiceIds"]],
			parent_id=deserialized_dict.get("parentId"),
			external_ref=deserialized_dict.get("externalRef"),
			unassigned_results=[x0 for x0 in deserialized_dict["unassignedResults"]],
			assigned_results=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			from_address=deserialized_dict.get("fromAddress"),
			from_healthcare_party_id=deserialized_dict.get("fromHealthcarePartyId"),
			form_id=deserialized_dict.get("formId"),
			status=deserialized_dict.get("status"),
			recipients_type=deserialized_dict.get("recipientsType"),
			recipients=[x0 for x0 in deserialized_dict["recipients"]],
			to_addresses=[x0 for x0 in deserialized_dict["toAddresses"]],
			received=deserialized_dict.get("received"),
			sent=deserialized_dict.get("sent"),
			metas=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["metas"].items())),
			read_status=dict(map(lambda kv0: (kv0[0], MessageReadStatus._deserialize(kv0[1])), deserialized_dict["readStatus"].items())),
			message_attachments=[MessageAttachment._deserialize(x0) for x0 in deserialized_dict["messageAttachments"]],
			transport_guid=deserialized_dict.get("transportGuid"),
			remark=deserialized_dict.get("remark"),
			conversation_guid=deserialized_dict.get("conversationGuid"),
			subject=deserialized_dict.get("subject"),
			invoice_ids=[x0 for x0 in deserialized_dict["invoiceIds"]],
			parent_id=deserialized_dict.get("parentId"),
			external_ref=deserialized_dict.get("externalRef"),
			unassigned_results=[x0 for x0 in deserialized_dict["unassignedResults"]],
			assigned_results=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["assignedResults"].items())),
			sender_references=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["senderReferences"].items())),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

Message = Union['DecryptedMessage', 'EncryptedMessage']

def serialize_message(message: Message) -> object:
	if isinstance(message, DecryptedMessage):
		return {
			"type": "com.icure.sdk.model.DecryptedMessage",
			"entity": message.__serialize__()
		}
	elif isinstance(message, EncryptedMessage):
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
class DocumentShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_message_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"shareMessageId": self.share_message_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_message_id=ShareMetadataBehaviour._deserialize(deserialized_dict["shareMessageId"]),
		)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			opening_date=deserialized_dict.get("openingDate"),
			status=deserialized_dict.get("status"),
			version=deserialized_dict.get("version"),
			logical_uuid=deserialized_dict.get("logicalUuid"),
			descr=deserialized_dict.get("descr"),
			unique_id=deserialized_dict.get("uniqueId"),
			form_template_id=deserialized_dict.get("formTemplateId"),
			contact_id=deserialized_dict.get("contactId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			parent=deserialized_dict.get("parent"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			opening_date=deserialized_dict.get("openingDate"),
			status=deserialized_dict.get("status"),
			version=deserialized_dict.get("version"),
			logical_uuid=deserialized_dict.get("logicalUuid"),
			descr=deserialized_dict.get("descr"),
			unique_id=deserialized_dict.get("uniqueId"),
			form_template_id=deserialized_dict.get("formTemplateId"),
			contact_id=deserialized_dict.get("contactId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			parent=deserialized_dict.get("parent"),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

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
class FormShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DecryptedInvoice:
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
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: List['DecryptedInvoicingCode'] = field(default_factory=list)
	receipts: Dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[List['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
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
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedInvoice':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			invoice_date=deserialized_dict.get("invoiceDate"),
			sent_date=deserialized_dict.get("sentDate"),
			printed_date=deserialized_dict.get("printedDate"),
			invoicing_codes=[DecryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type=deserialized_dict.get("recipientType"),
			recipient_id=deserialized_dict.get("recipientId"),
			invoice_reference=deserialized_dict.get("invoiceReference"),
			third_party_reference=deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification=deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason=deserialized_dict.get("thirdPartyPaymentReason"),
			reason=deserialized_dict.get("reason"),
			invoice_type=InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type=MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type=InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id=deserialized_dict.get("groupId"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			payments=[Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii=deserialized_dict.get("gnotionNihii"),
			gnotion_ssin=deserialized_dict.get("gnotionSsin"),
			gnotion_last_name=deserialized_dict.get("gnotionLastName"),
			gnotion_first_name=deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party=deserialized_dict.get("gnotionCdHcParty"),
			invoice_period=deserialized_dict.get("invoicePeriod"),
			care_provider_type=deserialized_dict.get("careProviderType"),
			internship_nihii=deserialized_dict.get("internshipNihii"),
			internship_ssin=deserialized_dict.get("internshipSsin"),
			internship_last_name=deserialized_dict.get("internshipLastName"),
			internship_first_name=deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party=deserialized_dict.get("internshipCdHcParty"),
			internship_cbe=deserialized_dict.get("internshipCbe"),
			supervisor_nihii=deserialized_dict.get("supervisorNihii"),
			supervisor_ssin=deserialized_dict.get("supervisorSsin"),
			supervisor_last_name=deserialized_dict.get("supervisorLastName"),
			supervisor_first_name=deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party=deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe=deserialized_dict.get("supervisorCbe"),
			error=deserialized_dict.get("error"),
			encounter_location_name=deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii=deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm=deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification=deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id=deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id=deserialized_dict.get("correctedInvoiceId"),
			credit_note=deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id=deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document=IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date=deserialized_dict.get("admissionDate"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_service=deserialized_dict.get("locationService"),
			cancel_reason=deserialized_dict.get("cancelReason"),
			cancel_date=deserialized_dict.get("cancelDate"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class EncryptedInvoice:
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
	invoice_date: Optional[int] = None
	sent_date: Optional[int] = None
	printed_date: Optional[int] = None
	invoicing_codes: List['EncryptedInvoicingCode'] = field(default_factory=list)
	receipts: Dict[str, str] = field(default_factory=dict)
	recipient_type: Optional[str] = None
	recipient_id: Optional[str] = None
	invoice_reference: Optional[str] = None
	third_party_reference: Optional[str] = None
	third_party_payment_justification: Optional[str] = None
	third_party_payment_reason: Optional[str] = None
	reason: Optional[str] = None
	invoice_type: Optional['InvoiceType'] = None
	sent_medium_type: Optional['MediumType'] = None
	intervention_type: Optional['InvoiceInterventionType'] = None
	group_id: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	payments: Optional[List['Payment']] = None
	gnotion_nihii: Optional[str] = None
	gnotion_ssin: Optional[str] = None
	gnotion_last_name: Optional[str] = None
	gnotion_first_name: Optional[str] = None
	gnotion_cd_hc_party: Optional[str] = None
	invoice_period: Optional[int] = None
	care_provider_type: Optional[str] = None
	internship_nihii: Optional[str] = None
	internship_ssin: Optional[str] = None
	internship_last_name: Optional[str] = None
	internship_first_name: Optional[str] = None
	internship_cd_hc_party: Optional[str] = None
	internship_cbe: Optional[str] = None
	supervisor_nihii: Optional[str] = None
	supervisor_ssin: Optional[str] = None
	supervisor_last_name: Optional[str] = None
	supervisor_first_name: Optional[str] = None
	supervisor_cd_hc_party: Optional[str] = None
	supervisor_cbe: Optional[str] = None
	error: Optional[str] = None
	encounter_location_name: Optional[str] = None
	encounter_location_nihii: Optional[str] = None
	encounter_location_norm: Optional[int] = None
	long_delay_justification: Optional[int] = None
	corrective_invoice_id: Optional[str] = None
	corrected_invoice_id: Optional[str] = None
	credit_note: Optional[bool] = None
	credit_note_related_invoice_id: Optional[str] = None
	id_document: Optional['IdentityDocumentReader'] = None
	admission_date: Optional[int] = None
	location_nihii: Optional[str] = None
	location_service: Optional[int] = None
	cancel_reason: Optional[str] = None
	cancel_date: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
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
			"invoiceDate": self.invoice_date,
			"sentDate": self.sent_date,
			"printedDate": self.printed_date,
			"invoicingCodes": [x0.__serialize__() for x0 in self.invoicing_codes],
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"recipientType": self.recipient_type,
			"recipientId": self.recipient_id,
			"invoiceReference": self.invoice_reference,
			"thirdPartyReference": self.third_party_reference,
			"thirdPartyPaymentJustification": self.third_party_payment_justification,
			"thirdPartyPaymentReason": self.third_party_payment_reason,
			"reason": self.reason,
			"invoiceType": self.invoice_type.__serialize__() if self.invoice_type is not None else None,
			"sentMediumType": self.sent_medium_type.__serialize__() if self.sent_medium_type is not None else None,
			"interventionType": self.intervention_type.__serialize__() if self.intervention_type is not None else None,
			"groupId": self.group_id,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"payments": [x0.__serialize__() for x0 in self.payments] if self.payments is not None else None,
			"gnotionNihii": self.gnotion_nihii,
			"gnotionSsin": self.gnotion_ssin,
			"gnotionLastName": self.gnotion_last_name,
			"gnotionFirstName": self.gnotion_first_name,
			"gnotionCdHcParty": self.gnotion_cd_hc_party,
			"invoicePeriod": self.invoice_period,
			"careProviderType": self.care_provider_type,
			"internshipNihii": self.internship_nihii,
			"internshipSsin": self.internship_ssin,
			"internshipLastName": self.internship_last_name,
			"internshipFirstName": self.internship_first_name,
			"internshipCdHcParty": self.internship_cd_hc_party,
			"internshipCbe": self.internship_cbe,
			"supervisorNihii": self.supervisor_nihii,
			"supervisorSsin": self.supervisor_ssin,
			"supervisorLastName": self.supervisor_last_name,
			"supervisorFirstName": self.supervisor_first_name,
			"supervisorCdHcParty": self.supervisor_cd_hc_party,
			"supervisorCbe": self.supervisor_cbe,
			"error": self.error,
			"encounterLocationName": self.encounter_location_name,
			"encounterLocationNihii": self.encounter_location_nihii,
			"encounterLocationNorm": self.encounter_location_norm,
			"longDelayJustification": self.long_delay_justification,
			"correctiveInvoiceId": self.corrective_invoice_id,
			"correctedInvoiceId": self.corrected_invoice_id,
			"creditNote": self.credit_note,
			"creditNoteRelatedInvoiceId": self.credit_note_related_invoice_id,
			"idDocument": self.id_document.__serialize__() if self.id_document is not None else None,
			"admissionDate": self.admission_date,
			"locationNihii": self.location_nihii,
			"locationService": self.location_service,
			"cancelReason": self.cancel_reason,
			"cancelDate": self.cancel_date,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedInvoice':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			deletion_date=deserialized_dict.get("deletionDate"),
			invoice_date=deserialized_dict.get("invoiceDate"),
			sent_date=deserialized_dict.get("sentDate"),
			printed_date=deserialized_dict.get("printedDate"),
			invoicing_codes=[EncryptedInvoicingCode._deserialize(x0) for x0 in deserialized_dict["invoicingCodes"]],
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			recipient_type=deserialized_dict.get("recipientType"),
			recipient_id=deserialized_dict.get("recipientId"),
			invoice_reference=deserialized_dict.get("invoiceReference"),
			third_party_reference=deserialized_dict.get("thirdPartyReference"),
			third_party_payment_justification=deserialized_dict.get("thirdPartyPaymentJustification"),
			third_party_payment_reason=deserialized_dict.get("thirdPartyPaymentReason"),
			reason=deserialized_dict.get("reason"),
			invoice_type=InvoiceType._deserialize(deserialized_dict.get("invoiceType")) if deserialized_dict.get("invoiceType") is not None else None,
			sent_medium_type=MediumType._deserialize(deserialized_dict.get("sentMediumType")) if deserialized_dict.get("sentMediumType") is not None else None,
			intervention_type=InvoiceInterventionType._deserialize(deserialized_dict.get("interventionType")) if deserialized_dict.get("interventionType") is not None else None,
			group_id=deserialized_dict.get("groupId"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			payments=[Payment._deserialize(x0) for x0 in deserialized_dict.get("payments")] if deserialized_dict.get("payments") is not None else None,
			gnotion_nihii=deserialized_dict.get("gnotionNihii"),
			gnotion_ssin=deserialized_dict.get("gnotionSsin"),
			gnotion_last_name=deserialized_dict.get("gnotionLastName"),
			gnotion_first_name=deserialized_dict.get("gnotionFirstName"),
			gnotion_cd_hc_party=deserialized_dict.get("gnotionCdHcParty"),
			invoice_period=deserialized_dict.get("invoicePeriod"),
			care_provider_type=deserialized_dict.get("careProviderType"),
			internship_nihii=deserialized_dict.get("internshipNihii"),
			internship_ssin=deserialized_dict.get("internshipSsin"),
			internship_last_name=deserialized_dict.get("internshipLastName"),
			internship_first_name=deserialized_dict.get("internshipFirstName"),
			internship_cd_hc_party=deserialized_dict.get("internshipCdHcParty"),
			internship_cbe=deserialized_dict.get("internshipCbe"),
			supervisor_nihii=deserialized_dict.get("supervisorNihii"),
			supervisor_ssin=deserialized_dict.get("supervisorSsin"),
			supervisor_last_name=deserialized_dict.get("supervisorLastName"),
			supervisor_first_name=deserialized_dict.get("supervisorFirstName"),
			supervisor_cd_hc_party=deserialized_dict.get("supervisorCdHcParty"),
			supervisor_cbe=deserialized_dict.get("supervisorCbe"),
			error=deserialized_dict.get("error"),
			encounter_location_name=deserialized_dict.get("encounterLocationName"),
			encounter_location_nihii=deserialized_dict.get("encounterLocationNihii"),
			encounter_location_norm=deserialized_dict.get("encounterLocationNorm"),
			long_delay_justification=deserialized_dict.get("longDelayJustification"),
			corrective_invoice_id=deserialized_dict.get("correctiveInvoiceId"),
			corrected_invoice_id=deserialized_dict.get("correctedInvoiceId"),
			credit_note=deserialized_dict.get("creditNote"),
			credit_note_related_invoice_id=deserialized_dict.get("creditNoteRelatedInvoiceId"),
			id_document=IdentityDocumentReader._deserialize(deserialized_dict.get("idDocument")) if deserialized_dict.get("idDocument") is not None else None,
			admission_date=deserialized_dict.get("admissionDate"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_service=deserialized_dict.get("locationService"),
			cancel_reason=deserialized_dict.get("cancelReason"),
			cancel_date=deserialized_dict.get("cancelDate"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			secret_foreign_keys=[x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys=dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
			security_metadata=SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

Invoice = Union['DecryptedInvoice', 'EncryptedInvoice']

def serialize_invoice(invoice: Invoice) -> object:
	if isinstance(invoice, DecryptedInvoice):
		return {
			"type": "com.icure.sdk.model.DecryptedInvoice",
			"entity": invoice.__serialize__()
		}
	elif isinstance(invoice, EncryptedInvoice):
		return {
			"type": "com.icure.sdk.model.EncryptedInvoice",
			"entity": invoice.__serialize__()
		}
	else:
		raise Exception(f"{type(invoice)} is not a known subclass of Invoice")

def deserialize_invoice(data: Union[str, Dict[str, object]]) -> 'Invoice':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.DecryptedInvoice":
		DecryptedInvoice._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.EncryptedInvoice":
		EncryptedInvoice._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Invoice")

@dataclass
class InvoiceShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class DecryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedInvoicingCode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			date_code=deserialized_dict.get("dateCode"),
			logical_id=deserialized_dict.get("logicalId"),
			label=deserialized_dict.get("label"),
			user_id=deserialized_dict.get("userId"),
			contact_id=deserialized_dict.get("contactId"),
			service_id=deserialized_dict.get("serviceId"),
			tarification_id=deserialized_dict.get("tarificationId"),
			code=deserialized_dict.get("code"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			convention_amount=deserialized_dict.get("conventionAmount"),
			vat=deserialized_dict.get("vat"),
			error=deserialized_dict.get("error"),
			contract=deserialized_dict.get("contract"),
			contract_date=deserialized_dict.get("contractDate"),
			units=deserialized_dict.get("units"),
			side=deserialized_dict.get("side"),
			time_of_day=deserialized_dict.get("timeOfDay"),
			eid_reading_hour=deserialized_dict.get("eidReadingHour"),
			eid_reading_value=deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code=deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason=deserialized_dict.get("override3rdPayerReason"),
			transplantation_code=deserialized_dict.get("transplantationCode"),
			prescriber_norm=deserialized_dict.get("prescriberNorm"),
			percent_norm=deserialized_dict.get("percentNorm"),
			prescriber_nihii=deserialized_dict.get("prescriberNihii"),
			related_code=deserialized_dict.get("relatedCode"),
			prescription_date=deserialized_dict.get("prescriptionDate"),
			derogation_max_number=deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin=deserialized_dict.get("prescriberSsin"),
			prescriber_last_name=deserialized_dict.get("prescriberLastName"),
			prescriber_first_name=deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party=deserialized_dict.get("prescriberCdHcParty"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_cd_hc_party=deserialized_dict.get("locationCdHcParty"),
			location_service=deserialized_dict.get("locationService"),
			admission_date=deserialized_dict.get("admissionDate"),
			canceled=deserialized_dict.get("canceled"),
			accepted=deserialized_dict.get("accepted"),
			pending=deserialized_dict.get("pending"),
			resent=deserialized_dict.get("resent"),
			archived=deserialized_dict.get("archived"),
			lost=deserialized_dict.get("lost"),
			insurance_justification=deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason=deserialized_dict.get("cancelPatientInterventionReason"),
			status=deserialized_dict.get("status"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedInvoicingCode:
	id: Optional[str]
	date_code: Optional[int] = None
	logical_id: Optional[str] = None
	label: Optional[str] = None
	user_id: Optional[str] = None
	contact_id: Optional[str] = None
	service_id: Optional[str] = None
	tarification_id: Optional[str] = None
	code: Optional[str] = None
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	convention_amount: Optional[float] = None
	vat: Optional[float] = None
	error: Optional[str] = None
	contract: Optional[str] = None
	contract_date: Optional[int] = None
	units: Optional[int] = None
	side: Optional[int] = None
	time_of_day: Optional[int] = None
	eid_reading_hour: Optional[int] = None
	eid_reading_value: Optional[str] = None
	override3rd_payer_code: Optional[int] = None
	override3rd_payer_reason: Optional[str] = None
	transplantation_code: Optional[int] = None
	prescriber_norm: Optional[int] = None
	percent_norm: Optional[int] = None
	prescriber_nihii: Optional[str] = None
	related_code: Optional[str] = None
	prescription_date: Optional[int] = None
	derogation_max_number: Optional[int] = None
	prescriber_ssin: Optional[str] = None
	prescriber_last_name: Optional[str] = None
	prescriber_first_name: Optional[str] = None
	prescriber_cd_hc_party: Optional[str] = None
	location_nihii: Optional[str] = None
	location_cd_hc_party: Optional[str] = None
	location_service: Optional[int] = None
	admission_date: Optional[int] = None
	canceled: Optional[bool] = None
	accepted: Optional[bool] = None
	pending: Optional[bool] = None
	resent: Optional[bool] = None
	archived: Optional[bool] = None
	lost: Optional[bool] = None
	insurance_justification: Optional[int] = None
	cancel_patient_intervention_reason: Optional[int] = None
	status: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"dateCode": self.date_code,
			"logicalId": self.logical_id,
			"label": self.label,
			"userId": self.user_id,
			"contactId": self.contact_id,
			"serviceId": self.service_id,
			"tarificationId": self.tarification_id,
			"code": self.code,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"conventionAmount": self.convention_amount,
			"vat": self.vat,
			"error": self.error,
			"contract": self.contract,
			"contractDate": self.contract_date,
			"units": self.units,
			"side": self.side,
			"timeOfDay": self.time_of_day,
			"eidReadingHour": self.eid_reading_hour,
			"eidReadingValue": self.eid_reading_value,
			"override3rdPayerCode": self.override3rd_payer_code,
			"override3rdPayerReason": self.override3rd_payer_reason,
			"transplantationCode": self.transplantation_code,
			"prescriberNorm": self.prescriber_norm,
			"percentNorm": self.percent_norm,
			"prescriberNihii": self.prescriber_nihii,
			"relatedCode": self.related_code,
			"prescriptionDate": self.prescription_date,
			"derogationMaxNumber": self.derogation_max_number,
			"prescriberSsin": self.prescriber_ssin,
			"prescriberLastName": self.prescriber_last_name,
			"prescriberFirstName": self.prescriber_first_name,
			"prescriberCdHcParty": self.prescriber_cd_hc_party,
			"locationNihii": self.location_nihii,
			"locationCdHcParty": self.location_cd_hc_party,
			"locationService": self.location_service,
			"admissionDate": self.admission_date,
			"canceled": self.canceled,
			"accepted": self.accepted,
			"pending": self.pending,
			"resent": self.resent,
			"archived": self.archived,
			"lost": self.lost,
			"insuranceJustification": self.insurance_justification,
			"cancelPatientInterventionReason": self.cancel_patient_intervention_reason,
			"status": self.status,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedInvoicingCode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			date_code=deserialized_dict.get("dateCode"),
			logical_id=deserialized_dict.get("logicalId"),
			label=deserialized_dict.get("label"),
			user_id=deserialized_dict.get("userId"),
			contact_id=deserialized_dict.get("contactId"),
			service_id=deserialized_dict.get("serviceId"),
			tarification_id=deserialized_dict.get("tarificationId"),
			code=deserialized_dict.get("code"),
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			convention_amount=deserialized_dict.get("conventionAmount"),
			vat=deserialized_dict.get("vat"),
			error=deserialized_dict.get("error"),
			contract=deserialized_dict.get("contract"),
			contract_date=deserialized_dict.get("contractDate"),
			units=deserialized_dict.get("units"),
			side=deserialized_dict.get("side"),
			time_of_day=deserialized_dict.get("timeOfDay"),
			eid_reading_hour=deserialized_dict.get("eidReadingHour"),
			eid_reading_value=deserialized_dict.get("eidReadingValue"),
			override3rd_payer_code=deserialized_dict.get("override3rdPayerCode"),
			override3rd_payer_reason=deserialized_dict.get("override3rdPayerReason"),
			transplantation_code=deserialized_dict.get("transplantationCode"),
			prescriber_norm=deserialized_dict.get("prescriberNorm"),
			percent_norm=deserialized_dict.get("percentNorm"),
			prescriber_nihii=deserialized_dict.get("prescriberNihii"),
			related_code=deserialized_dict.get("relatedCode"),
			prescription_date=deserialized_dict.get("prescriptionDate"),
			derogation_max_number=deserialized_dict.get("derogationMaxNumber"),
			prescriber_ssin=deserialized_dict.get("prescriberSsin"),
			prescriber_last_name=deserialized_dict.get("prescriberLastName"),
			prescriber_first_name=deserialized_dict.get("prescriberFirstName"),
			prescriber_cd_hc_party=deserialized_dict.get("prescriberCdHcParty"),
			location_nihii=deserialized_dict.get("locationNihii"),
			location_cd_hc_party=deserialized_dict.get("locationCdHcParty"),
			location_service=deserialized_dict.get("locationService"),
			admission_date=deserialized_dict.get("admissionDate"),
			canceled=deserialized_dict.get("canceled"),
			accepted=deserialized_dict.get("accepted"),
			pending=deserialized_dict.get("pending"),
			resent=deserialized_dict.get("resent"),
			archived=deserialized_dict.get("archived"),
			lost=deserialized_dict.get("lost"),
			insurance_justification=deserialized_dict.get("insuranceJustification"),
			cancel_patient_intervention_reason=deserialized_dict.get("cancelPatientInterventionReason"),
			status=deserialized_dict.get("status"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

InvoicingCode = Union['DecryptedInvoicingCode', 'EncryptedInvoicingCode']

def serialize_invoicing_code(invoicing_code: InvoicingCode) -> object:
	if isinstance(invoicing_code, DecryptedInvoicingCode):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedInvoicingCode",
			"entity": invoicing_code.__serialize__()
		}
	elif isinstance(invoicing_code, EncryptedInvoicingCode):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedInvoicingCode",
			"entity": invoicing_code.__serialize__()
		}
	else:
		raise Exception(f"{type(invoicing_code)} is not a known subclass of InvoicingCode")

def deserialize_invoicing_code(data: Union[str, Dict[str, object]]) -> 'InvoicingCode':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedInvoicingCode":
		DecryptedInvoicingCode._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedInvoicingCode":
		EncryptedInvoicingCode._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of InvoicingCode")

class MediumType(Enum):
	Cdrom = "cdrom"
	Eattest = "eattest"
	Efact = "efact"
	Email = "email"
	Mediprima = "mediprima"
	Paper = "paper"
	Stat = "stat"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MediumType':
		if data == "cdrom":
			return MediumType.Cdrom
		elif data == "eattest":
			return MediumType.Eattest
		elif data == "efact":
			return MediumType.Efact
		elif data == "email":
			return MediumType.Email
		elif data == "mediprima":
			return MediumType.Mediprima
		elif data == "paper":
			return MediumType.Paper
		elif data == "stat":
			return MediumType.Stat
		else:
			raise Exception(f"{data} is not a valid value for MediumType enum.")

class InvoiceType(Enum):
	Patient = "patient"
	Mutualfund = "mutualfund"
	Payingagency = "payingagency"
	Insurance = "insurance"
	Efact = "efact"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceType':
		if data == "patient":
			return InvoiceType.Patient
		elif data == "mutualfund":
			return InvoiceType.Mutualfund
		elif data == "payingagency":
			return InvoiceType.Payingagency
		elif data == "insurance":
			return InvoiceType.Insurance
		elif data == "efact":
			return InvoiceType.Efact
		elif data == "other":
			return InvoiceType.Other
		else:
			raise Exception(f"{data} is not a valid value for InvoiceType enum.")

@dataclass
class MessageShareOptions:
	requested_permissions: 'RequestedPermission'
	share_encryption_key: 'ShareMetadataBehaviour'
	share_patient_id: 'ShareMetadataBehaviour'

	def __serialize__(self) -> object:
		return {
			"requestedPermissions": self.requested_permissions.__serialize__(),
			"shareEncryptionKey": self.share_encryption_key.__serialize__(),
			"sharePatientId": self.share_patient_id.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
			share_encryption_key=ShareMetadataBehaviour._deserialize(deserialized_dict["shareEncryptionKey"]),
			share_patient_id=ShareMetadataBehaviour._deserialize(deserialized_dict["sharePatientId"]),
		)

@dataclass
class Insurance:
	id: str
	address: 'DecryptedAddress'
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Dict[str, str] = field(default_factory=dict)
	private_insurance: bool = False
	hospitalisation_insurance: bool = False
	ambulatory_insurance: bool = False
	code: Optional[str] = None
	agreement_number: Optional[str] = None
	parent: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": {k0: v0 for k0, v0 in self.name.items()},
			"privateInsurance": self.private_insurance,
			"hospitalisationInsurance": self.hospitalisation_insurance,
			"ambulatoryInsurance": self.ambulatory_insurance,
			"code": self.code,
			"agreementNumber": self.agreement_number,
			"parent": self.parent,
			"address": self.address.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Insurance':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["name"].items())),
			private_insurance=deserialized_dict["privateInsurance"],
			hospitalisation_insurance=deserialized_dict["hospitalisationInsurance"],
			ambulatory_insurance=deserialized_dict["ambulatoryInsurance"],
			code=deserialized_dict.get("code"),
			agreement_number=deserialized_dict.get("agreementNumber"),
			parent=deserialized_dict.get("parent"),
			address=DecryptedAddress._deserialize(deserialized_dict["address"]),
		)

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
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			name=deserialized_dict.get("name"),
			password=deserialized_dict.get("password"),
			servers=[x0 for x0 in deserialized_dict.get("servers")] if deserialized_dict.get("servers") is not None else None,
			super_admin=deserialized_dict["superAdmin"],
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			default_user_roles=dict(map(lambda kv0: (UserType._deserialize(kv0[0]), [x1 for x1 in kv0[1]]), deserialized_dict["defaultUserRoles"].items())),
			operation_tokens=dict(map(lambda kv0: (kv0[0], OperationToken._deserialize(kv0[1])), deserialized_dict["operationTokens"].items())),
			shared_entities=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["sharedEntities"].items())),
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
			minimum_authentication_class_for_elevated_privileges=AuthenticationClass._deserialize(deserialized_dict["minimumAuthenticationClassForElevatedPrivileges"]),
			super_group=deserialized_dict.get("superGroup"),
		)

class GroupType(Enum):
	Root = "root"
	App = "app"
	Database = "database"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupType':
		if data == "root":
			return GroupType.Root
		elif data == "app":
			return GroupType.App
		elif data == "database":
			return GroupType.Database
		else:
			raise Exception(f"{data} is not a valid value for GroupType enum.")

@dataclass
class DatabaseInitialisation:
	users: Optional[List['User']] = field(default_factory=list)
	healthcare_parties: Optional[List['HealthcareParty']] = field(default_factory=list)
	replication: Optional['Replication'] = None
	minimum_kraken_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"users": [x0.__serialize__() for x0 in self.users] if self.users is not None else None,
			"healthcareParties": [x0.__serialize__() for x0 in self.healthcare_parties] if self.healthcare_parties is not None else None,
			"replication": self.replication.__serialize__() if self.replication is not None else None,
			"minimumKrakenVersion": self.minimum_kraken_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseInitialisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			users=[User._deserialize(x0) for x0 in deserialized_dict.get("users")] if deserialized_dict.get("users") is not None else None,
			healthcare_parties=[HealthcareParty._deserialize(x0) for x0 in deserialized_dict.get("healthcareParties")] if deserialized_dict.get("healthcareParties") is not None else None,
			replication=Replication._deserialize(deserialized_dict.get("replication")) if deserialized_dict.get("replication") is not None else None,
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
		)

@dataclass
class RegistrationSuccess:
	group_id: str
	user_id: str
	token: str

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"userId": self.user_id,
			"token": self.token,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegistrationSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict["groupId"],
			user_id=deserialized_dict["userId"],
			token=deserialized_dict["token"],
		)

class PermissionType(Enum):
	Authenticate = "AUTHENTICATE"
	Hcp = "HCP"
	Physician = "PHYSICIAN"
	Admin = "ADMIN"
	PatientView = "PATIENT_VIEW"
	PatientCreate = "PATIENT_CREATE"
	PatientChangeDelete = "PATIENT_CHANGE_DELETE"
	MedicalDataView = "MEDICAL_DATA_VIEW"
	MedicalDataCreate = "MEDICAL_DATA_CREATE"
	MedicalChangeDelete = "MEDICAL_CHANGE_DELETE"
	FinancialDataView = "FINANCIAL_DATA_VIEW"
	FinancialDataCreate = "FINANCIAL_DATA_CREATE"
	FinancialChangeDelete = "FINANCIAL_CHANGE_DELETE"
	LegacyDataView = "LEGACY_DATA_VIEW"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PermissionType':
		if data == "AUTHENTICATE":
			return PermissionType.Authenticate
		elif data == "HCP":
			return PermissionType.Hcp
		elif data == "PHYSICIAN":
			return PermissionType.Physician
		elif data == "ADMIN":
			return PermissionType.Admin
		elif data == "PATIENT_VIEW":
			return PermissionType.PatientView
		elif data == "PATIENT_CREATE":
			return PermissionType.PatientCreate
		elif data == "PATIENT_CHANGE_DELETE":
			return PermissionType.PatientChangeDelete
		elif data == "MEDICAL_DATA_VIEW":
			return PermissionType.MedicalDataView
		elif data == "MEDICAL_DATA_CREATE":
			return PermissionType.MedicalDataCreate
		elif data == "MEDICAL_CHANGE_DELETE":
			return PermissionType.MedicalChangeDelete
		elif data == "FINANCIAL_DATA_VIEW":
			return PermissionType.FinancialDataView
		elif data == "FINANCIAL_DATA_CREATE":
			return PermissionType.FinancialDataCreate
		elif data == "FINANCIAL_CHANGE_DELETE":
			return PermissionType.FinancialChangeDelete
		elif data == "LEGACY_DATA_VIEW":
			return PermissionType.LegacyDataView
		else:
			raise Exception(f"{data} is not a valid value for PermissionType enum.")

@dataclass
class RegistrationInformation:
	first_name: str
	last_name: str
	email_address: str
	user_options: Optional[str] = None
	user_roles: List[str] = field(default_factory=list)
	minimum_kraken_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"firstName": self.first_name,
			"lastName": self.last_name,
			"emailAddress": self.email_address,
			"userOptions": self.user_options,
			"userRoles": [x0 for x0 in self.user_roles],
			"minimumKrakenVersion": self.minimum_kraken_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegistrationInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			first_name=deserialized_dict["firstName"],
			last_name=deserialized_dict["lastName"],
			email_address=deserialized_dict["emailAddress"],
			user_options=deserialized_dict.get("userOptions"),
			user_roles=[x0 for x0 in deserialized_dict["userRoles"]],
			minimum_kraken_version=deserialized_dict.get("minimumKrakenVersion"),
		)

class Operation(Enum):
	TransferGroup = "TRANSFER_GROUP"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Operation':
		if data == "TRANSFER_GROUP":
			return Operation.TransferGroup
		else:
			raise Exception(f"{data} is not a valid value for Operation enum.")

class UserType(Enum):
	Hcp = "HCP"
	Patient = "PATIENT"
	Device = "DEVICE"
	User = "USER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserType':
		if data == "HCP":
			return UserType.Hcp
		elif data == "PATIENT":
			return UserType.Patient
		elif data == "DEVICE":
			return UserType.Device
		elif data == "USER":
			return UserType.User
		else:
			raise Exception(f"{data} is not a valid value for UserType enum.")

@dataclass
class RoleConfiguration:
	source: 'RoleConfiguration.Source'
	roles: List[str] = field(default_factory=list)

	class Source(Enum):
		Configuration = "CONFIGURATION"
		Inherited = "INHERITED"
		Default = "DEFAULT"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RoleConfiguration.Source':
			if data == "CONFIGURATION":
				return RoleConfiguration.Source.Configuration
			elif data == "INHERITED":
				return RoleConfiguration.Source.Inherited
			elif data == "DEFAULT":
				return RoleConfiguration.Source.Default
			else:
				raise Exception(f"{data} is not a valid value for Source enum.")

	def __serialize__(self) -> object:
		return {
			"source": self.source.__serialize__(),
			"roles": [x0 for x0 in self.roles],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RoleConfiguration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source=RoleConfiguration.Source._deserialize(deserialized_dict["source"]),
			roles=[x0 for x0 in deserialized_dict["roles"]],
		)

@dataclass
class GroupDeletionReport:
	type: str
	id: str
	server: str

	def __serialize__(self) -> object:
		return {
			"type": self.type,
			"id": self.id,
			"server": self.server,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupDeletionReport':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=deserialized_dict["type"],
			id=deserialized_dict["id"],
			server=deserialized_dict["server"],
		)

@dataclass
class ListOfProperties:
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ListOfProperties':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			properties=[DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

@dataclass
class DesignDocument:
	id: str
	rev: Optional[str] = None
	rev_history: Dict[str, str] = field(default_factory=dict)
	language: Optional[str] = None
	views: Dict[str, 'View'] = field(default_factory=dict)
	lists: Dict[str, str] = field(default_factory=dict)
	shows: Dict[str, str] = field(default_factory=dict)
	update_handlers: Optional[Dict[str, str]] = None
	filters: Dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()},
			"language": self.language,
			"views": {k0: v0.__serialize__() for k0, v0 in self.views.items()},
			"lists": {k0: v0 for k0, v0 in self.lists.items()},
			"shows": {k0: v0 for k0, v0 in self.shows.items()},
			"updateHandlers": {k0: v0 for k0, v0 in self.update_handlers.items()} if self.update_handlers is not None else None,
			"filters": {k0: v0 for k0, v0 in self.filters.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DesignDocument':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			rev_history=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["revHistory"].items())),
			language=deserialized_dict.get("language"),
			views=dict(map(lambda kv0: (kv0[0], View._deserialize(kv0[1])), deserialized_dict["views"].items())),
			lists=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["lists"].items())),
			shows=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["shows"].items())),
			update_handlers=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("updateHandlers").items())) if deserialized_dict.get("updateHandlers") is not None else None,
			filters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["filters"].items())),
		)

@dataclass
class GroupDatabasesInfo:
	group_id: str
	databases_info: List['DatabaseInfo']
	gcp_storage_size: int

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"databasesInfo": [x0.__serialize__() for x0 in self.databases_info],
			"gcpStorageSize": self.gcp_storage_size,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupDatabasesInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id=deserialized_dict["groupId"],
			databases_info=[DatabaseInfo._deserialize(x0) for x0 in deserialized_dict["databasesInfo"]],
			gcp_storage_size=deserialized_dict["gcpStorageSize"],
		)

class EntitySubscriptionCloseReason(Enum):
	ChannelFull = "ChannelFull"
	ConnectionLost = "ConnectionLost"
	IntentionallyClosed = "IntentionallyClosed"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntitySubscriptionCloseReason':
		if data == "ChannelFull":
			return EntitySubscriptionCloseReason.ChannelFull
		elif data == "ConnectionLost":
			return EntitySubscriptionCloseReason.ConnectionLost
		elif data == "IntentionallyClosed":
			return EntitySubscriptionCloseReason.IntentionallyClosed
		else:
			raise Exception(f"{data} is not a valid value for EntitySubscriptionCloseReason enum.")

@dataclass
class CodeStub:
	id: Optional[str] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	context_label: Optional[str] = None
	label: Optional[Dict[str, str]] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"contextLabel": self.context_label,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			context=deserialized_dict.get("context"),
			type=deserialized_dict.get("type"),
			code=deserialized_dict.get("code"),
			version=deserialized_dict.get("version"),
			context_label=deserialized_dict.get("contextLabel"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
		)

@dataclass
class KeywordSubword:
	value: Optional[str] = None
	sub_words: Optional[List['KeywordSubword']] = None

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words] if self.sub_words is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeywordSubword':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			sub_words=[KeywordSubword._deserialize(x0) for x0 in deserialized_dict.get("subWords")] if deserialized_dict.get("subWords") is not None else None,
		)

@dataclass
class PaginatedDocumentKeyIdPair:
	start_key: Optional[Dict[str, object]] = None
	start_key_doc_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"startKey": {k0: v0 for k0, v0 in self.start_key.items()} if self.start_key is not None else None,
			"startKeyDocId": self.start_key_doc_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaginatedDocumentKeyIdPair':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_key=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("startKey").items())) if deserialized_dict.get("startKey") is not None else None,
			start_key_doc_id=deserialized_dict.get("startKeyDocId"),
		)

@dataclass
class Identifier:
	id: Optional[str] = None
	assigner: Optional[str] = None
	start: Optional[str] = None
	end: Optional[str] = None
	system: Optional[str] = None
	type: Optional['CodeStub'] = None
	use: Optional[str] = None
	value: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"assigner": self.assigner,
			"start": self.start,
			"end": self.end,
			"system": self.system,
			"type": self.type.__serialize__() if self.type is not None else None,
			"use": self.use,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Identifier':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			assigner=deserialized_dict.get("assigner"),
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			system=deserialized_dict.get("system"),
			type=CodeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			use=deserialized_dict.get("use"),
			value=deserialized_dict.get("value"),
		)

@dataclass
class NotPredicate:
	predicate: 'Predicate'

	def __serialize__(self) -> object:
		return {
			"predicate": serialize_predicate(self.predicate),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'NotPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			predicate=deserialize_predicate(deserialized_dict["predicate"]),
		)

@dataclass
class AndPredicate:
	predicates: List['Predicate'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"predicates": [serialize_predicate(x0) for x0 in self.predicates],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AndPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			predicates=[deserialize_predicate(x0) for x0 in deserialized_dict["predicates"]],
		)

@dataclass
class AlwaysPredicate:

	def __serialize__(self) -> object:
		return {
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AlwaysPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
		)

@dataclass
class OrPredicate:
	predicates: List['Predicate'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"predicates": [serialize_predicate(x0) for x0 in self.predicates],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'OrPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			predicates=[deserialize_predicate(x0) for x0 in deserialized_dict["predicates"]],
		)

@dataclass
class KeyValuePredicate:
	key: Optional[str] = None
	operator: Optional['Operator'] = None
	value: Optional[object] = None

	def __serialize__(self) -> object:
		return {
			"key": self.key,
			"operator": self.operator.__serialize__() if self.operator is not None else None,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyValuePredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key=deserialized_dict.get("key"),
			operator=Operator._deserialize(deserialized_dict.get("operator")) if deserialized_dict.get("operator") is not None else None,
			value=deserialized_dict.get("value"),
		)

Predicate = Union['NotPredicate', 'AndPredicate', 'AlwaysPredicate', 'OrPredicate', 'KeyValuePredicate']

def serialize_predicate(predicate: Predicate) -> object:
	if isinstance(predicate, NotPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.NotPredicate"})
		return serialized_entity
	elif isinstance(predicate, AndPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.AndPredicate"})
		return serialized_entity
	elif isinstance(predicate, AlwaysPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.AlwaysPredicate"})
		return serialized_entity
	elif isinstance(predicate, OrPredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.OrPredicate"})
		return serialized_entity
	elif isinstance(predicate, KeyValuePredicate):
		serialized_entity = predicate.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.filter.predicate.KeyValuePredicate"})
		return serialized_entity
	else:
		raise Exception(f"{type(predicate)} is not a known subclass of Predicate")

def deserialize_predicate(data: Union[str, Dict[str, object]]) -> 'Predicate':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.filter.predicate.NotPredicate":
		return NotPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.AndPredicate":
		return AndPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.AlwaysPredicate":
		return AlwaysPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.OrPredicate":
		return OrPredicate._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.filter.predicate.KeyValuePredicate":
		return KeyValuePredicate._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of Predicate")

class Gender(Enum):
	Male = "male"
	Female = "female"
	Indeterminate = "indeterminate"
	Changed = "changed"
	ChangedToMale = "changedToMale"
	ChangedToFemale = "changedToFemale"
	Unknown = "unknown"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Gender':
		if data == "male":
			return Gender.Male
		elif data == "female":
			return Gender.Female
		elif data == "indeterminate":
			return Gender.Indeterminate
		elif data == "changed":
			return Gender.Changed
		elif data == "changedToMale":
			return Gender.ChangedToMale
		elif data == "changedToFemale":
			return Gender.ChangedToFemale
		elif data == "unknown":
			return Gender.Unknown
		else:
			raise Exception(f"{data} is not a valid value for Gender enum.")

ExternalFilterKey = Union['ExternalFilterKeyExternalFilterStringKey', 'ExternalFilterKeyExternalFilterLongKey', 'ExternalFilterKeyExternalFilterComplexKey']

@dataclass
class ExternalFilterKeyExternalFilterStringKey:
	key: str

	def __serialize__(self) -> object:
		return {
			"key": self.key,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ExternalFilterKeyExternalFilterStringKey':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key=deserialized_dict["key"],
		)

@dataclass
class ExternalFilterKeyExternalFilterLongKey:
	key: int

	def __serialize__(self) -> object:
		return {
			"key": self.key,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ExternalFilterKeyExternalFilterLongKey':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key=deserialized_dict["key"],
		)

@dataclass
class ExternalFilterKeyExternalFilterComplexKey:
	key: Dict[str, object]

	def __serialize__(self) -> object:
		return {
			"key": {k0: v0 for k0, v0 in self.key.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ExternalFilterKeyExternalFilterComplexKey':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["key"].items())),
		)

def serialize_external_filter_key(external_filter_key: ExternalFilterKey) -> object:
	if isinstance(external_filter_key, ExternalFilterKeyExternalFilterStringKey):
		serialized_entity = external_filter_key.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterStringKey"})
		return serialized_entity
	elif isinstance(external_filter_key, ExternalFilterKeyExternalFilterLongKey):
		serialized_entity = external_filter_key.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterLongKey"})
		return serialized_entity
	elif isinstance(external_filter_key, ExternalFilterKeyExternalFilterComplexKey):
		serialized_entity = external_filter_key.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterComplexKey"})
		return serialized_entity
	else:
		raise Exception(f"{type(external_filter_key)} is not a known subclass of ExternalFilterKey")

def deserialize_external_filter_key(data: Union[str, Dict[str, object]]) -> 'ExternalFilterKey':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterStringKey":
		return ExternalFilterKeyExternalFilterStringKey._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterLongKey":
		return ExternalFilterKeyExternalFilterLongKey._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.utils.ExternalFilterKey.ExternalFilterComplexKey":
		return ExternalFilterKeyExternalFilterComplexKey._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of ExternalFilterKey")

@dataclass
class PersonName:
	last_name: Optional[str] = None
	first_names: List[str] = field(default_factory=list)
	start: Optional[int] = None
	end: Optional[int] = None
	prefix: List[str] = field(default_factory=list)
	suffix: List[str] = field(default_factory=list)
	text: Optional[str] = None
	use: Optional['PersonNameUse'] = None

	def __serialize__(self) -> object:
		return {
			"lastName": self.last_name,
			"firstNames": [x0 for x0 in self.first_names],
			"start": self.start,
			"end": self.end,
			"prefix": [x0 for x0 in self.prefix],
			"suffix": [x0 for x0 in self.suffix],
			"text": self.text,
			"use": self.use.__serialize__() if self.use is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonName':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			last_name=deserialized_dict.get("lastName"),
			first_names=[x0 for x0 in deserialized_dict["firstNames"]],
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			prefix=[x0 for x0 in deserialized_dict["prefix"]],
			suffix=[x0 for x0 in deserialized_dict["suffix"]],
			text=deserialized_dict.get("text"),
			use=PersonNameUse._deserialize(deserialized_dict.get("use")) if deserialized_dict.get("use") is not None else None,
		)

@dataclass
class EncryptedAddress:
	address_type: Optional['AddressType'] = None
	descr: Optional[str] = None
	street: Optional[str] = None
	house_number: Optional[str] = None
	postbox_number: Optional[str] = None
	postal_code: Optional[str] = None
	city: Optional[str] = None
	state: Optional[str] = None
	country: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	telecoms: List['EncryptedTelecom'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"addressType": self.address_type.__serialize__() if self.address_type is not None else None,
			"descr": self.descr,
			"street": self.street,
			"houseNumber": self.house_number,
			"postboxNumber": self.postbox_number,
			"postalCode": self.postal_code,
			"city": self.city,
			"state": self.state,
			"country": self.country,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"telecoms": [x0.__serialize__() for x0 in self.telecoms],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedAddress':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			address_type=AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr=deserialized_dict.get("descr"),
			street=deserialized_dict.get("street"),
			house_number=deserialized_dict.get("houseNumber"),
			postbox_number=deserialized_dict.get("postboxNumber"),
			postal_code=deserialized_dict.get("postalCode"),
			city=deserialized_dict.get("city"),
			state=deserialized_dict.get("state"),
			country=deserialized_dict.get("country"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms=[EncryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedAddress:
	address_type: Optional['AddressType'] = None
	descr: Optional[str] = None
	street: Optional[str] = None
	house_number: Optional[str] = None
	postbox_number: Optional[str] = None
	postal_code: Optional[str] = None
	city: Optional[str] = None
	state: Optional[str] = None
	country: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	telecoms: List['DecryptedTelecom'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"addressType": self.address_type.__serialize__() if self.address_type is not None else None,
			"descr": self.descr,
			"street": self.street,
			"houseNumber": self.house_number,
			"postboxNumber": self.postbox_number,
			"postalCode": self.postal_code,
			"city": self.city,
			"state": self.state,
			"country": self.country,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"telecoms": [x0.__serialize__() for x0 in self.telecoms],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedAddress':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			address_type=AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr=deserialized_dict.get("descr"),
			street=deserialized_dict.get("street"),
			house_number=deserialized_dict.get("houseNumber"),
			postbox_number=deserialized_dict.get("postboxNumber"),
			postal_code=deserialized_dict.get("postalCode"),
			city=deserialized_dict.get("city"),
			state=deserialized_dict.get("state"),
			country=deserialized_dict.get("country"),
			note=deserialized_dict.get("note"),
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms=[DecryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

Address = Union['EncryptedAddress', 'DecryptedAddress']

def serialize_address(address: Address) -> object:
	if isinstance(address, EncryptedAddress):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedAddress",
			"entity": address.__serialize__()
		}
	elif isinstance(address, DecryptedAddress):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedAddress",
			"entity": address.__serialize__()
		}
	else:
		raise Exception(f"{type(address)} is not a known subclass of Address")

def deserialize_address(data: Union[str, Dict[str, object]]) -> 'Address':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedAddress":
		EncryptedAddress._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedAddress":
		DecryptedAddress._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Address")

class DeactivationReason(Enum):
	Deceased = "deceased"
	Moved = "moved"
	OtherDoctor = "other_doctor"
	Retired = "retired"
	NoContact = "no_contact"
	Unknown = "unknown"
	Nothing = "none"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeactivationReason':
		if data == "deceased":
			return DeactivationReason.Deceased
		elif data == "moved":
			return DeactivationReason.Moved
		elif data == "other_doctor":
			return DeactivationReason.OtherDoctor
		elif data == "retired":
			return DeactivationReason.Retired
		elif data == "no_contact":
			return DeactivationReason.NoContact
		elif data == "unknown":
			return DeactivationReason.Unknown
		elif data == "none":
			return DeactivationReason.Nothing
		else:
			raise Exception(f"{data} is not a valid value for DeactivationReason enum.")

class PersonalStatus(Enum):
	Single = "single"
	InCouple = "in_couple"
	Married = "married"
	Separated = "separated"
	Divorced = "divorced"
	Divorcing = "divorcing"
	Widowed = "widowed"
	Widower = "widower"
	Complicated = "complicated"
	Unknown = "unknown"
	Contract = "contract"
	Other = "other"
	Annulled = "annulled"
	Polygamous = "polygamous"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonalStatus':
		if data == "single":
			return PersonalStatus.Single
		elif data == "in_couple":
			return PersonalStatus.InCouple
		elif data == "married":
			return PersonalStatus.Married
		elif data == "separated":
			return PersonalStatus.Separated
		elif data == "divorced":
			return PersonalStatus.Divorced
		elif data == "divorcing":
			return PersonalStatus.Divorcing
		elif data == "widowed":
			return PersonalStatus.Widowed
		elif data == "widower":
			return PersonalStatus.Widower
		elif data == "complicated":
			return PersonalStatus.Complicated
		elif data == "unknown":
			return PersonalStatus.Unknown
		elif data == "contract":
			return PersonalStatus.Contract
		elif data == "other":
			return PersonalStatus.Other
		elif data == "annulled":
			return PersonalStatus.Annulled
		elif data == "polygamous":
			return PersonalStatus.Polygamous
		else:
			raise Exception(f"{data} is not a valid value for PersonalStatus enum.")

@dataclass
class Annotation:
	id: str
	author: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	text: Optional[str] = None
	markdown: Dict[str, str] = field(default_factory=dict)
	location: Optional[str] = None
	confidential: Optional[bool] = None
	tags: List['CodeStub'] = field(default_factory=list)
	encrypted_self: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"author": self.author,
			"created": self.created,
			"modified": self.modified,
			"text": self.text,
			"markdown": {k0: v0 for k0, v0 in self.markdown.items()},
			"location": self.location,
			"confidential": self.confidential,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Annotation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			author=deserialized_dict.get("author"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			text=deserialized_dict.get("text"),
			markdown=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["markdown"].items())),
			location=deserialized_dict.get("location"),
			confidential=deserialized_dict.get("confidential"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedInsurability:
	parameters: Dict[str, str] = field(default_factory=dict)
	hospitalisation: Optional[bool] = None
	ambulatory: Optional[bool] = None
	dental: Optional[bool] = None
	identification_number: Optional[str] = None
	insurance_id: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	titulary_id: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"parameters": {k0: v0 for k0, v0 in self.parameters.items()},
			"hospitalisation": self.hospitalisation,
			"ambulatory": self.ambulatory,
			"dental": self.dental,
			"identificationNumber": self.identification_number,
			"insuranceId": self.insurance_id,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"titularyId": self.titulary_id,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedInsurability':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			parameters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation=deserialized_dict.get("hospitalisation"),
			ambulatory=deserialized_dict.get("ambulatory"),
			dental=deserialized_dict.get("dental"),
			identification_number=deserialized_dict.get("identificationNumber"),
			insurance_id=deserialized_dict.get("insuranceId"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			titulary_id=deserialized_dict.get("titularyId"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedInsurability:
	parameters: Dict[str, str] = field(default_factory=dict)
	hospitalisation: Optional[bool] = None
	ambulatory: Optional[bool] = None
	dental: Optional[bool] = None
	identification_number: Optional[str] = None
	insurance_id: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	titulary_id: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"parameters": {k0: v0 for k0, v0 in self.parameters.items()},
			"hospitalisation": self.hospitalisation,
			"ambulatory": self.ambulatory,
			"dental": self.dental,
			"identificationNumber": self.identification_number,
			"insuranceId": self.insurance_id,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"titularyId": self.titulary_id,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedInsurability':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			parameters=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation=deserialized_dict.get("hospitalisation"),
			ambulatory=deserialized_dict.get("ambulatory"),
			dental=deserialized_dict.get("dental"),
			identification_number=deserialized_dict.get("identificationNumber"),
			insurance_id=deserialized_dict.get("insuranceId"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			titulary_id=deserialized_dict.get("titularyId"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

Insurability = Union['DecryptedInsurability', 'EncryptedInsurability']

def serialize_insurability(insurability: Insurability) -> object:
	if isinstance(insurability, DecryptedInsurability):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedInsurability",
			"entity": insurability.__serialize__()
		}
	elif isinstance(insurability, EncryptedInsurability):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedInsurability",
			"entity": insurability.__serialize__()
		}
	else:
		raise Exception(f"{type(insurability)} is not a known subclass of Insurability")

def deserialize_insurability(data: Union[str, Dict[str, object]]) -> 'Insurability':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedInsurability":
		DecryptedInsurability._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedInsurability":
		EncryptedInsurability._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Insurability")

@dataclass
class Partnership:
	type: Optional['PartnershipType'] = None
	status: Optional['PartnershipStatus'] = None
	partner_id: Optional[str] = None
	me_to_other_relationship_description: Optional[str] = None
	other_to_me_relationship_description: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"status": self.status.__serialize__() if self.status is not None else None,
			"partnerId": self.partner_id,
			"meToOtherRelationshipDescription": self.me_to_other_relationship_description,
			"otherToMeRelationshipDescription": self.other_to_me_relationship_description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Partnership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PartnershipType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			status=PartnershipStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			partner_id=deserialized_dict.get("partnerId"),
			me_to_other_relationship_description=deserialized_dict.get("meToOtherRelationshipDescription"),
			other_to_me_relationship_description=deserialized_dict.get("otherToMeRelationshipDescription"),
		)

@dataclass
class EncryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: List['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPatientHealthCareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods=[ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral=deserialized_dict["referral"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPatientHealthCareParty:
	type: Optional['PatientHealthCarePartyType'] = None
	healthcare_party_id: Optional[str] = None
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	referral_periods: List['ReferralPeriod'] = field(default_factory=list)
	referral: bool = False
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"referralPeriods": [x0.__serialize__() for x0 in self.referral_periods],
			"referral": self.referral,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPatientHealthCareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PatientHealthCarePartyType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			send_formats=dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			referral_periods=[ReferralPeriod._deserialize(x0) for x0 in deserialized_dict["referralPeriods"]],
			referral=deserialized_dict["referral"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

PatientHealthCareParty = Union['EncryptedPatientHealthCareParty', 'DecryptedPatientHealthCareParty']

def serialize_patient_health_care_party(patient_health_care_party: PatientHealthCareParty) -> object:
	if isinstance(patient_health_care_party, EncryptedPatientHealthCareParty):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedPatientHealthCareParty",
			"entity": patient_health_care_party.__serialize__()
		}
	elif isinstance(patient_health_care_party, DecryptedPatientHealthCareParty):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedPatientHealthCareParty",
			"entity": patient_health_care_party.__serialize__()
		}
	else:
		raise Exception(f"{type(patient_health_care_party)} is not a known subclass of PatientHealthCareParty")

def deserialize_patient_health_care_party(data: Union[str, Dict[str, object]]) -> 'PatientHealthCareParty':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedPatientHealthCareParty":
		EncryptedPatientHealthCareParty._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedPatientHealthCareParty":
		DecryptedPatientHealthCareParty._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of PatientHealthCareParty")

@dataclass
class EncryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: List[str] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			key=deserialized_dict.get("key"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners=[x0 for x0 in deserialized_dict["preferredFiiForPartners"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: List[str] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			key=deserialized_dict.get("key"),
			bank_account=deserialized_dict.get("bankAccount"),
			bic=deserialized_dict.get("bic"),
			proxy_bank_account=deserialized_dict.get("proxyBankAccount"),
			proxy_bic=deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners=[x0 for x0 in deserialized_dict["preferredFiiForPartners"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

FinancialInstitutionInformation = Union['EncryptedFinancialInstitutionInformation', 'DecryptedFinancialInstitutionInformation']

def serialize_financial_institution_information(financial_institution_information: FinancialInstitutionInformation) -> object:
	if isinstance(financial_institution_information, EncryptedFinancialInstitutionInformation):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation",
			"entity": financial_institution_information.__serialize__()
		}
	elif isinstance(financial_institution_information, DecryptedFinancialInstitutionInformation):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation",
			"entity": financial_institution_information.__serialize__()
		}
	else:
		raise Exception(f"{type(financial_institution_information)} is not a known subclass of FinancialInstitutionInformation")

def deserialize_financial_institution_information(data: Union[str, Dict[str, object]]) -> 'FinancialInstitutionInformation':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation":
		EncryptedFinancialInstitutionInformation._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation":
		DecryptedFinancialInstitutionInformation._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of FinancialInstitutionInformation")

@dataclass
class DecryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
	receipts: Dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedMedicalHouseContract':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id=deserialized_dict.get("contractId"),
			valid_from=deserialized_dict.get("validFrom"),
			valid_to=deserialized_dict.get("validTo"),
			mm_nihii=deserialized_dict.get("mmNihii"),
			hcp_id=deserialized_dict.get("hcpId"),
			change_type=ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id=deserialized_dict.get("parentContractId"),
			changed_by=deserialized_dict.get("changedBy"),
			start_of_contract=deserialized_dict.get("startOfContract"),
			start_of_coverage=deserialized_dict.get("startOfCoverage"),
			end_of_contract=deserialized_dict.get("endOfContract"),
			end_of_coverage=deserialized_dict.get("endOfCoverage"),
			kine=deserialized_dict["kine"],
			gp=deserialized_dict["gp"],
			ptd=deserialized_dict["ptd"],
			nurse=deserialized_dict["nurse"],
			no_kine=deserialized_dict["noKine"],
			no_gp=deserialized_dict["noGp"],
			no_nurse=deserialized_dict["noNurse"],
			unsubscription_reason_id=deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start=deserialized_dict.get("ptdStart"),
			ptd_end=deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced=deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension=deserialized_dict.get("startOfSuspension"),
			end_of_suspension=deserialized_dict.get("endOfSuspension"),
			suspension_reason=SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source=deserialized_dict.get("suspensionSource"),
			forced_suspension=deserialized_dict["forcedSuspension"],
			signature_type=MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status=deserialized_dict.get("status"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedMedicalHouseContract:
	contract_id: Optional[str] = None
	valid_from: Optional[int] = None
	valid_to: Optional[int] = None
	mm_nihii: Optional[str] = None
	hcp_id: Optional[str] = None
	change_type: Optional['ContractChangeType'] = None
	parent_contract_id: Optional[str] = None
	changed_by: Optional[str] = None
	start_of_contract: Optional[int] = None
	start_of_coverage: Optional[int] = None
	end_of_contract: Optional[int] = None
	end_of_coverage: Optional[int] = None
	kine: bool = False
	gp: bool = False
	ptd: bool = False
	nurse: bool = False
	no_kine: bool = False
	no_gp: bool = False
	no_nurse: bool = False
	unsubscription_reason_id: Optional[int] = None
	ptd_start: Optional[int] = None
	ptd_end: Optional[int] = None
	ptd_last_invoiced: Optional[int] = None
	start_of_suspension: Optional[int] = None
	end_of_suspension: Optional[int] = None
	suspension_reason: Optional['SuspensionReason'] = None
	suspension_source: Optional[str] = None
	forced_suspension: bool = False
	signature_type: Optional['MhcSignatureType'] = None
	status: Optional[int] = None
	options: Dict[str, str] = field(default_factory=dict)
	receipts: Dict[str, str] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"contractId": self.contract_id,
			"validFrom": self.valid_from,
			"validTo": self.valid_to,
			"mmNihii": self.mm_nihii,
			"hcpId": self.hcp_id,
			"changeType": self.change_type.__serialize__() if self.change_type is not None else None,
			"parentContractId": self.parent_contract_id,
			"changedBy": self.changed_by,
			"startOfContract": self.start_of_contract,
			"startOfCoverage": self.start_of_coverage,
			"endOfContract": self.end_of_contract,
			"endOfCoverage": self.end_of_coverage,
			"kine": self.kine,
			"gp": self.gp,
			"ptd": self.ptd,
			"nurse": self.nurse,
			"noKine": self.no_kine,
			"noGp": self.no_gp,
			"noNurse": self.no_nurse,
			"unsubscriptionReasonId": self.unsubscription_reason_id,
			"ptdStart": self.ptd_start,
			"ptdEnd": self.ptd_end,
			"ptdLastInvoiced": self.ptd_last_invoiced,
			"startOfSuspension": self.start_of_suspension,
			"endOfSuspension": self.end_of_suspension,
			"suspensionReason": self.suspension_reason.__serialize__() if self.suspension_reason is not None else None,
			"suspensionSource": self.suspension_source,
			"forcedSuspension": self.forced_suspension,
			"signatureType": self.signature_type.__serialize__() if self.signature_type is not None else None,
			"status": self.status,
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"receipts": {k0: v0 for k0, v0 in self.receipts.items()},
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedMedicalHouseContract':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			contract_id=deserialized_dict.get("contractId"),
			valid_from=deserialized_dict.get("validFrom"),
			valid_to=deserialized_dict.get("validTo"),
			mm_nihii=deserialized_dict.get("mmNihii"),
			hcp_id=deserialized_dict.get("hcpId"),
			change_type=ContractChangeType._deserialize(deserialized_dict.get("changeType")) if deserialized_dict.get("changeType") is not None else None,
			parent_contract_id=deserialized_dict.get("parentContractId"),
			changed_by=deserialized_dict.get("changedBy"),
			start_of_contract=deserialized_dict.get("startOfContract"),
			start_of_coverage=deserialized_dict.get("startOfCoverage"),
			end_of_contract=deserialized_dict.get("endOfContract"),
			end_of_coverage=deserialized_dict.get("endOfCoverage"),
			kine=deserialized_dict["kine"],
			gp=deserialized_dict["gp"],
			ptd=deserialized_dict["ptd"],
			nurse=deserialized_dict["nurse"],
			no_kine=deserialized_dict["noKine"],
			no_gp=deserialized_dict["noGp"],
			no_nurse=deserialized_dict["noNurse"],
			unsubscription_reason_id=deserialized_dict.get("unsubscriptionReasonId"),
			ptd_start=deserialized_dict.get("ptdStart"),
			ptd_end=deserialized_dict.get("ptdEnd"),
			ptd_last_invoiced=deserialized_dict.get("ptdLastInvoiced"),
			start_of_suspension=deserialized_dict.get("startOfSuspension"),
			end_of_suspension=deserialized_dict.get("endOfSuspension"),
			suspension_reason=SuspensionReason._deserialize(deserialized_dict.get("suspensionReason")) if deserialized_dict.get("suspensionReason") is not None else None,
			suspension_source=deserialized_dict.get("suspensionSource"),
			forced_suspension=deserialized_dict["forcedSuspension"],
			signature_type=MhcSignatureType._deserialize(deserialized_dict.get("signatureType")) if deserialized_dict.get("signatureType") is not None else None,
			status=deserialized_dict.get("status"),
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			receipts=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["receipts"].items())),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

MedicalHouseContract = Union['DecryptedMedicalHouseContract', 'EncryptedMedicalHouseContract']

def serialize_medical_house_contract(medical_house_contract: MedicalHouseContract) -> object:
	if isinstance(medical_house_contract, DecryptedMedicalHouseContract):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedMedicalHouseContract",
			"entity": medical_house_contract.__serialize__()
		}
	elif isinstance(medical_house_contract, EncryptedMedicalHouseContract):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedMedicalHouseContract",
			"entity": medical_house_contract.__serialize__()
		}
	else:
		raise Exception(f"{type(medical_house_contract)} is not a known subclass of MedicalHouseContract")

def deserialize_medical_house_contract(data: Union[str, Dict[str, object]]) -> 'MedicalHouseContract':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedMedicalHouseContract":
		DecryptedMedicalHouseContract._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedMedicalHouseContract":
		EncryptedMedicalHouseContract._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of MedicalHouseContract")

@dataclass
class Delegation:
	owner: Optional[str] = None
	delegated_to: Optional[str] = None
	key: Optional['HexString'] = None
	tags: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"owner": self.owner,
			"delegatedTo": self.delegated_to,
			"key": self.key,
			"tags": [x0 for x0 in self.tags],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Delegation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			owner=deserialized_dict.get("owner"),
			delegated_to=deserialized_dict.get("delegatedTo"),
			key=deserialized_dict.get("key"),
			tags=[x0 for x0 in deserialized_dict["tags"]],
		)

@dataclass
class SecurityMetadata:
	secure_delegations: Dict['SecureDelegationKeyString', 'SecureDelegation']
	keys_equivalences: Dict['Sha256HexString', 'Sha256HexString'] = field(default_factory=dict)

	def __serialize__(self) -> object:
		return {
			"secureDelegations": {k0: v0.__serialize__() for k0, v0 in self.secure_delegations.items()},
			"keysEquivalences": {k0: v0 for k0, v0 in self.keys_equivalences.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecurityMetadata':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secure_delegations=dict(map(lambda kv0: (kv0[0], SecureDelegation._deserialize(kv0[1])), deserialized_dict["secureDelegations"].items())),
			keys_equivalences=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["keysEquivalences"].items())),
		)

@dataclass
class SchoolingInfo:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	school: Optional[str] = None
	type_of_education: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"school": self.school,
			"typeOfEducation": self.type_of_education.__serialize__() if self.type_of_education is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SchoolingInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			school=deserialized_dict.get("school"),
			type_of_education=CodeStub._deserialize(deserialized_dict.get("typeOfEducation")) if deserialized_dict.get("typeOfEducation") is not None else None,
		)

@dataclass
class EmploymentInfo:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	profession_type: Optional['CodeStub'] = None
	employer: Optional['Employer'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"professionType": self.profession_type.__serialize__() if self.profession_type is not None else None,
			"employer": self.employer.__serialize__() if self.employer is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EmploymentInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			profession_type=CodeStub._deserialize(deserialized_dict.get("professionType")) if deserialized_dict.get("professionType") is not None else None,
			employer=Employer._deserialize(deserialized_dict.get("employer")) if deserialized_dict.get("employer") is not None else None,
		)

class HealthcarePartyStatus(Enum):
	Trainee = "trainee"
	Withconvention = "withconvention"
	Accreditated = "accreditated"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyStatus':
		if data == "trainee":
			return HealthcarePartyStatus.Trainee
		elif data == "withconvention":
			return HealthcarePartyStatus.Withconvention
		elif data == "accreditated":
			return HealthcarePartyStatus.Accreditated
		else:
			raise Exception(f"{data} is not a valid value for HealthcarePartyStatus enum.")

@dataclass
class HealthcarePartyHistoryStatus:
	status: 'HealthcarePartyStatus'
	specialisation_code: str
	start_date: int
	active: bool

	def __serialize__(self) -> object:
		return {
			"status": self.status.__serialize__(),
			"specialisationCode": self.specialisation_code,
			"startDate": self.start_date,
			"active": self.active,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyHistoryStatus':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			status=HealthcarePartyStatus._deserialize(deserialized_dict["status"]),
			specialisation_code=deserialized_dict["specialisationCode"],
			start_date=deserialized_dict["startDate"],
			active=deserialized_dict["active"],
		)

class TelecomType(Enum):
	Mobile = "mobile"
	Phone = "phone"
	Email = "email"
	Fax = "fax"
	Skype = "skype"
	Im = "im"
	Medibridge = "medibridge"
	Ehealthbox = "ehealthbox"
	Apicrypt = "apicrypt"
	Web = "web"
	Print = "print"
	Disk = "disk"
	Other = "other"
	Pager = "pager"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TelecomType':
		if data == "mobile":
			return TelecomType.Mobile
		elif data == "phone":
			return TelecomType.Phone
		elif data == "email":
			return TelecomType.Email
		elif data == "fax":
			return TelecomType.Fax
		elif data == "skype":
			return TelecomType.Skype
		elif data == "im":
			return TelecomType.Im
		elif data == "medibridge":
			return TelecomType.Medibridge
		elif data == "ehealthbox":
			return TelecomType.Ehealthbox
		elif data == "apicrypt":
			return TelecomType.Apicrypt
		elif data == "web":
			return TelecomType.Web
		elif data == "print":
			return TelecomType.Print
		elif data == "disk":
			return TelecomType.Disk
		elif data == "other":
			return TelecomType.Other
		elif data == "pager":
			return TelecomType.Pager
		else:
			raise Exception(f"{data} is not a valid value for TelecomType enum.")

@dataclass
class EncryptedFlatRateTarification:
	code: Optional[str] = None
	flat_rate_type: Optional['FlatRateType'] = None
	label: Optional[Dict[str, str]] = None
	valorisations: List['EncryptedValorisation'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"code": self.code,
			"flatRateType": self.flat_rate_type.__serialize__() if self.flat_rate_type is not None else None,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedFlatRateTarification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			flat_rate_type=FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations=[EncryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedFlatRateTarification:
	code: Optional[str] = None
	flat_rate_type: Optional['FlatRateType'] = None
	label: Optional[Dict[str, str]] = None
	valorisations: List['DecryptedValorisation'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"code": self.code,
			"flatRateType": self.flat_rate_type.__serialize__() if self.flat_rate_type is not None else None,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"valorisations": [x0.__serialize__() for x0 in self.valorisations],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedFlatRateTarification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			flat_rate_type=FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations=[DecryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

FlatRateTarification = Union['EncryptedFlatRateTarification', 'DecryptedFlatRateTarification']

def serialize_flat_rate_tarification(flat_rate_tarification: FlatRateTarification) -> object:
	if isinstance(flat_rate_tarification, EncryptedFlatRateTarification):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedFlatRateTarification",
			"entity": flat_rate_tarification.__serialize__()
		}
	elif isinstance(flat_rate_tarification, DecryptedFlatRateTarification):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedFlatRateTarification",
			"entity": flat_rate_tarification.__serialize__()
		}
	else:
		raise Exception(f"{type(flat_rate_tarification)} is not a known subclass of FlatRateTarification")

def deserialize_flat_rate_tarification(data: Union[str, Dict[str, object]]) -> 'FlatRateTarification':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedFlatRateTarification":
		EncryptedFlatRateTarification._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedFlatRateTarification":
		DecryptedFlatRateTarification._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of FlatRateTarification")

@dataclass
class Periodicity:
	related_code: Optional['CodeStub'] = None
	related_periodicity: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"relatedCode": self.related_code.__serialize__() if self.related_code is not None else None,
			"relatedPeriodicity": self.related_periodicity.__serialize__() if self.related_periodicity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Periodicity':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			related_code=CodeStub._deserialize(deserialized_dict.get("relatedCode")) if deserialized_dict.get("relatedCode") is not None else None,
			related_periodicity=CodeStub._deserialize(deserialized_dict.get("relatedPeriodicity")) if deserialized_dict.get("relatedPeriodicity") is not None else None,
		)

class LinkQualification(Enum):
	Exact = "exact"
	Narrower = "narrower"
	Broader = "broader"
	Approximate = "approximate"
	Sequence = "sequence"
	Parent = "parent"
	Child = "child"
	RelatedCode = "relatedCode"
	LinkedPackage = "linkedPackage"
	RelatedService = "relatedService"
	InResponseTo = "inResponseTo"
	Replaces = "replaces"
	Transforms = "transforms"
	TransformsAndReplaces = "transformsAndReplaces"
	AppendsTo = "appendsTo"
	BasedOn = "basedOn"
	DerivedFrom = "derivedFrom"
	Device = "device"
	Focus = "focus"
	HasMember = "hasMember"
	Performer = "performer"
	Specimen = "specimen"
	ResultInterpreter = "resultInterpreter"
	Request = "request"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LinkQualification':
		if data == "exact":
			return LinkQualification.Exact
		elif data == "narrower":
			return LinkQualification.Narrower
		elif data == "broader":
			return LinkQualification.Broader
		elif data == "approximate":
			return LinkQualification.Approximate
		elif data == "sequence":
			return LinkQualification.Sequence
		elif data == "parent":
			return LinkQualification.Parent
		elif data == "child":
			return LinkQualification.Child
		elif data == "relatedCode":
			return LinkQualification.RelatedCode
		elif data == "linkedPackage":
			return LinkQualification.LinkedPackage
		elif data == "relatedService":
			return LinkQualification.RelatedService
		elif data == "inResponseTo":
			return LinkQualification.InResponseTo
		elif data == "replaces":
			return LinkQualification.Replaces
		elif data == "transforms":
			return LinkQualification.Transforms
		elif data == "transformsAndReplaces":
			return LinkQualification.TransformsAndReplaces
		elif data == "appendsTo":
			return LinkQualification.AppendsTo
		elif data == "basedOn":
			return LinkQualification.BasedOn
		elif data == "derivedFrom":
			return LinkQualification.DerivedFrom
		elif data == "device":
			return LinkQualification.Device
		elif data == "focus":
			return LinkQualification.Focus
		elif data == "hasMember":
			return LinkQualification.HasMember
		elif data == "performer":
			return LinkQualification.Performer
		elif data == "specimen":
			return LinkQualification.Specimen
		elif data == "resultInterpreter":
			return LinkQualification.ResultInterpreter
		elif data == "request":
			return LinkQualification.Request
		else:
			raise Exception(f"{data} is not a valid value for LinkQualification enum.")

class CodeFlag(Enum):
	MaleOnly = "male_only"
	FemaleOnly = "female_only"
	Deptkinesitherapy = "deptkinesitherapy"
	Deptnursing = "deptnursing"
	Deptgeneralpractice = "deptgeneralpractice"
	Deptsocialworker = "deptsocialworker"
	Deptpsychology = "deptpsychology"
	Deptadministrative = "deptadministrative"
	Deptdietetics = "deptdietetics"
	Deptspeechtherapy = "deptspeechtherapy"
	Deptdentistry = "deptdentistry"
	Deptoccupationaltherapy = "deptoccupationaltherapy"
	Depthealthcare = "depthealthcare"
	Deptgynecology = "deptgynecology"
	Deptpediatry = "deptpediatry"
	Deptalgology = "deptalgology"
	Deptanatomopathology = "deptanatomopathology"
	Deptanesthesiology = "deptanesthesiology"
	Deptbacteriology = "deptbacteriology"
	Deptcardiacsurgery = "deptcardiacsurgery"
	Deptcardiology = "deptcardiology"
	Deptchildandadolescentpsychiatry = "deptchildandadolescentpsychiatry"
	Deptdermatology = "deptdermatology"
	Deptdiabetology = "deptdiabetology"
	Deptemergency = "deptemergency"
	Deptendocrinology = "deptendocrinology"
	Deptgastroenterology = "deptgastroenterology"
	Deptgenetics = "deptgenetics"
	Deptgeriatry = "deptgeriatry"
	Depthandsurgery = "depthandsurgery"
	Depthematology = "depthematology"
	Deptinfectiousdisease = "deptinfectiousdisease"
	Deptintensivecare = "deptintensivecare"
	Deptlaboratory = "deptlaboratory"
	Deptmajorburns = "deptmajorburns"
	Deptmaxillofacialsurgery = "deptmaxillofacialsurgery"
	Deptmedicine = "deptmedicine"
	Deptmolecularbiology = "deptmolecularbiology"
	Deptneonatalogy = "deptneonatalogy"
	Deptnephrology = "deptnephrology"
	Deptneurology = "deptneurology"
	Deptneurosurgery = "deptneurosurgery"
	Deptnte = "deptnte"
	Deptnuclear = "deptnuclear"
	Deptnutritiondietetics = "deptnutritiondietetics"
	Deptobstetrics = "deptobstetrics"
	Deptoncology = "deptoncology"
	Deptophtalmology = "deptophtalmology"
	Deptorthopedy = "deptorthopedy"
	Deptpalliativecare = "deptpalliativecare"
	Deptpediatricintensivecare = "deptpediatricintensivecare"
	Deptpediatricsurgery = "deptpediatricsurgery"
	Deptpharmacy = "deptpharmacy"
	Deptphysicalmedecine = "deptphysicalmedecine"
	Deptphysiotherapy = "deptphysiotherapy"
	Deptplasticandreparatorysurgery = "deptplasticandreparatorysurgery"
	Deptpneumology = "deptpneumology"
	Deptpodiatry = "deptpodiatry"
	Deptpsychiatry = "deptpsychiatry"
	Deptradiology = "deptradiology"
	Deptradiotherapy = "deptradiotherapy"
	Deptrevalidation = "deptrevalidation"
	Deptrheumatology = "deptrheumatology"
	Deptrhumatology = "deptrhumatology"
	Deptsenology = "deptsenology"
	Deptsocialservice = "deptsocialservice"
	Deptsportsmedecine = "deptsportsmedecine"
	Deptstomatology = "deptstomatology"
	Deptsurgery = "deptsurgery"
	Deptthoracicsurgery = "deptthoracicsurgery"
	Depttoxicology = "depttoxicology"
	Depttropicalmedecine = "depttropicalmedecine"
	Depturology = "depturology"
	Deptvascularsurgery = "deptvascularsurgery"
	Deptvisceraldigestiveabdominalsurgery = "deptvisceraldigestiveabdominalsurgery"
	Depttransplantsurgery = "depttransplantsurgery"
	Deptpercutaneous = "deptpercutaneous"
	Deptchildbirth = "deptchildbirth"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeFlag':
		if data == "male_only":
			return CodeFlag.MaleOnly
		elif data == "female_only":
			return CodeFlag.FemaleOnly
		elif data == "deptkinesitherapy":
			return CodeFlag.Deptkinesitherapy
		elif data == "deptnursing":
			return CodeFlag.Deptnursing
		elif data == "deptgeneralpractice":
			return CodeFlag.Deptgeneralpractice
		elif data == "deptsocialworker":
			return CodeFlag.Deptsocialworker
		elif data == "deptpsychology":
			return CodeFlag.Deptpsychology
		elif data == "deptadministrative":
			return CodeFlag.Deptadministrative
		elif data == "deptdietetics":
			return CodeFlag.Deptdietetics
		elif data == "deptspeechtherapy":
			return CodeFlag.Deptspeechtherapy
		elif data == "deptdentistry":
			return CodeFlag.Deptdentistry
		elif data == "deptoccupationaltherapy":
			return CodeFlag.Deptoccupationaltherapy
		elif data == "depthealthcare":
			return CodeFlag.Depthealthcare
		elif data == "deptgynecology":
			return CodeFlag.Deptgynecology
		elif data == "deptpediatry":
			return CodeFlag.Deptpediatry
		elif data == "deptalgology":
			return CodeFlag.Deptalgology
		elif data == "deptanatomopathology":
			return CodeFlag.Deptanatomopathology
		elif data == "deptanesthesiology":
			return CodeFlag.Deptanesthesiology
		elif data == "deptbacteriology":
			return CodeFlag.Deptbacteriology
		elif data == "deptcardiacsurgery":
			return CodeFlag.Deptcardiacsurgery
		elif data == "deptcardiology":
			return CodeFlag.Deptcardiology
		elif data == "deptchildandadolescentpsychiatry":
			return CodeFlag.Deptchildandadolescentpsychiatry
		elif data == "deptdermatology":
			return CodeFlag.Deptdermatology
		elif data == "deptdiabetology":
			return CodeFlag.Deptdiabetology
		elif data == "deptemergency":
			return CodeFlag.Deptemergency
		elif data == "deptendocrinology":
			return CodeFlag.Deptendocrinology
		elif data == "deptgastroenterology":
			return CodeFlag.Deptgastroenterology
		elif data == "deptgenetics":
			return CodeFlag.Deptgenetics
		elif data == "deptgeriatry":
			return CodeFlag.Deptgeriatry
		elif data == "depthandsurgery":
			return CodeFlag.Depthandsurgery
		elif data == "depthematology":
			return CodeFlag.Depthematology
		elif data == "deptinfectiousdisease":
			return CodeFlag.Deptinfectiousdisease
		elif data == "deptintensivecare":
			return CodeFlag.Deptintensivecare
		elif data == "deptlaboratory":
			return CodeFlag.Deptlaboratory
		elif data == "deptmajorburns":
			return CodeFlag.Deptmajorburns
		elif data == "deptmaxillofacialsurgery":
			return CodeFlag.Deptmaxillofacialsurgery
		elif data == "deptmedicine":
			return CodeFlag.Deptmedicine
		elif data == "deptmolecularbiology":
			return CodeFlag.Deptmolecularbiology
		elif data == "deptneonatalogy":
			return CodeFlag.Deptneonatalogy
		elif data == "deptnephrology":
			return CodeFlag.Deptnephrology
		elif data == "deptneurology":
			return CodeFlag.Deptneurology
		elif data == "deptneurosurgery":
			return CodeFlag.Deptneurosurgery
		elif data == "deptnte":
			return CodeFlag.Deptnte
		elif data == "deptnuclear":
			return CodeFlag.Deptnuclear
		elif data == "deptnutritiondietetics":
			return CodeFlag.Deptnutritiondietetics
		elif data == "deptobstetrics":
			return CodeFlag.Deptobstetrics
		elif data == "deptoncology":
			return CodeFlag.Deptoncology
		elif data == "deptophtalmology":
			return CodeFlag.Deptophtalmology
		elif data == "deptorthopedy":
			return CodeFlag.Deptorthopedy
		elif data == "deptpalliativecare":
			return CodeFlag.Deptpalliativecare
		elif data == "deptpediatricintensivecare":
			return CodeFlag.Deptpediatricintensivecare
		elif data == "deptpediatricsurgery":
			return CodeFlag.Deptpediatricsurgery
		elif data == "deptpharmacy":
			return CodeFlag.Deptpharmacy
		elif data == "deptphysicalmedecine":
			return CodeFlag.Deptphysicalmedecine
		elif data == "deptphysiotherapy":
			return CodeFlag.Deptphysiotherapy
		elif data == "deptplasticandreparatorysurgery":
			return CodeFlag.Deptplasticandreparatorysurgery
		elif data == "deptpneumology":
			return CodeFlag.Deptpneumology
		elif data == "deptpodiatry":
			return CodeFlag.Deptpodiatry
		elif data == "deptpsychiatry":
			return CodeFlag.Deptpsychiatry
		elif data == "deptradiology":
			return CodeFlag.Deptradiology
		elif data == "deptradiotherapy":
			return CodeFlag.Deptradiotherapy
		elif data == "deptrevalidation":
			return CodeFlag.Deptrevalidation
		elif data == "deptrheumatology":
			return CodeFlag.Deptrheumatology
		elif data == "deptrhumatology":
			return CodeFlag.Deptrhumatology
		elif data == "deptsenology":
			return CodeFlag.Deptsenology
		elif data == "deptsocialservice":
			return CodeFlag.Deptsocialservice
		elif data == "deptsportsmedecine":
			return CodeFlag.Deptsportsmedecine
		elif data == "deptstomatology":
			return CodeFlag.Deptstomatology
		elif data == "deptsurgery":
			return CodeFlag.Deptsurgery
		elif data == "deptthoracicsurgery":
			return CodeFlag.Deptthoracicsurgery
		elif data == "depttoxicology":
			return CodeFlag.Depttoxicology
		elif data == "depttropicalmedecine":
			return CodeFlag.Depttropicalmedecine
		elif data == "depturology":
			return CodeFlag.Depturology
		elif data == "deptvascularsurgery":
			return CodeFlag.Deptvascularsurgery
		elif data == "deptvisceraldigestiveabdominalsurgery":
			return CodeFlag.Deptvisceraldigestiveabdominalsurgery
		elif data == "depttransplantsurgery":
			return CodeFlag.Depttransplantsurgery
		elif data == "deptpercutaneous":
			return CodeFlag.Deptpercutaneous
		elif data == "deptchildbirth":
			return CodeFlag.Deptchildbirth
		else:
			raise Exception(f"{data} is not a valid value for CodeFlag enum.")

class AppendixType(Enum):
	ExternalLink = "externalLink"
	Video = "video"
	Description = "description"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AppendixType':
		if data == "externalLink":
			return AppendixType.ExternalLink
		elif data == "video":
			return AppendixType.Video
		elif data == "description":
			return AppendixType.Description
		else:
			raise Exception(f"{data} is not a valid value for AppendixType enum.")

@dataclass
class EncryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[List[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[Dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedValorisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity=deserialized_dict.get("startOfValidity"),
			end_of_validity=deserialized_dict.get("endOfValidity"),
			predicate=deserialized_dict.get("predicate"),
			reference=[x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			vat=deserialized_dict.get("vat"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[List[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[Dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedValorisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity=deserialized_dict.get("startOfValidity"),
			end_of_validity=deserialized_dict.get("endOfValidity"),
			predicate=deserialized_dict.get("predicate"),
			reference=[x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount=deserialized_dict.get("totalAmount"),
			reimbursement=deserialized_dict.get("reimbursement"),
			patient_intervention=deserialized_dict.get("patientIntervention"),
			doctor_supplement=deserialized_dict.get("doctorSupplement"),
			vat=deserialized_dict.get("vat"),
			label=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

Valorisation = Union['EncryptedValorisation', 'DecryptedValorisation']

def serialize_valorisation(valorisation: Valorisation) -> object:
	if isinstance(valorisation, EncryptedValorisation):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedValorisation",
			"entity": valorisation.__serialize__()
		}
	elif isinstance(valorisation, DecryptedValorisation):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedValorisation",
			"entity": valorisation.__serialize__()
		}
	else:
		raise Exception(f"{type(valorisation)} is not a known subclass of Valorisation")

def deserialize_valorisation(data: Union[str, Dict[str, object]]) -> 'Valorisation':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedValorisation":
		EncryptedValorisation._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedValorisation":
		DecryptedValorisation._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Valorisation")

@dataclass
class LetterValue:
	letter: Optional[str] = None
	index: Optional[str] = None
	coefficient: Optional[float] = None
	value: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"letter": self.letter,
			"index": self.index,
			"coefficient": self.coefficient,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LetterValue':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			letter=deserialized_dict.get("letter"),
			index=deserialized_dict.get("index"),
			coefficient=deserialized_dict.get("coefficient"),
			value=deserialized_dict.get("value"),
		)

@dataclass
class AlwaysPermissionItem:
	type: 'PermissionType'

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AlwaysPermissionItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=PermissionType._deserialize(deserialized_dict["type"]),
		)

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
		return AlwaysPermissionItem._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of PermissionItem")

class FrontEndMigrationStatus(Enum):
	Started = "STARTED"
	Paused = "PAUSED"
	Error = "ERROR"
	Success = "SUCCESS"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FrontEndMigrationStatus':
		if data == "STARTED":
			return FrontEndMigrationStatus.Started
		elif data == "PAUSED":
			return FrontEndMigrationStatus.Paused
		elif data == "ERROR":
			return FrontEndMigrationStatus.Error
		elif data == "SUCCESS":
			return FrontEndMigrationStatus.Success
		else:
			raise Exception(f"{data} is not a valid value for FrontEndMigrationStatus enum.")

class DocumentType(Enum):
	Admission = "admission"
	Alert = "alert"
	BvtSample = "bvt_sample"
	Clinicalpath = "clinicalpath"
	Clinicalsummary = "clinicalsummary"
	Contactreport = "contactreport"
	Quote = "quote"
	Invoice = "invoice"
	Death = "death"
	Discharge = "discharge"
	Dischargereport = "dischargereport"
	EbirthBabyMedicalform = "ebirth_baby_medicalform"
	EbirthBabyNotification = "ebirth_baby_notification"
	EbirthMotherMedicalform = "ebirth_mother_medicalform"
	EbirthMotherNotification = "ebirth_mother_notification"
	EcareSafeConsultation = "ecare_safe_consultation"
	Epidemiology = "epidemiology"
	Intervention = "intervention"
	Labrequest = "labrequest"
	Labresult = "labresult"
	Medicaladvisoragreement = "medicaladvisoragreement"
	Medicationschemeelement = "medicationschemeelement"
	Note = "note"
	Notification = "notification"
	Pharmaceuticalprescription = "pharmaceuticalprescription"
	Prescription = "prescription"
	Productdelivery = "productdelivery"
	Quickdischargereport = "quickdischargereport"
	Radiationexposuremonitoring = "radiationexposuremonitoring"
	Referral = "referral"
	Report = "report"
	Request = "request"
	Result = "result"
	Sumehr = "sumehr"
	Telemonitoring = "telemonitoring"
	Template = "template"
	TemplateAdmin = "template_admin"
	Treatmentsuspension = "treatmentsuspension"
	Vaccination = "vaccination"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentType':
		if data == "admission":
			return DocumentType.Admission
		elif data == "alert":
			return DocumentType.Alert
		elif data == "bvt_sample":
			return DocumentType.BvtSample
		elif data == "clinicalpath":
			return DocumentType.Clinicalpath
		elif data == "clinicalsummary":
			return DocumentType.Clinicalsummary
		elif data == "contactreport":
			return DocumentType.Contactreport
		elif data == "quote":
			return DocumentType.Quote
		elif data == "invoice":
			return DocumentType.Invoice
		elif data == "death":
			return DocumentType.Death
		elif data == "discharge":
			return DocumentType.Discharge
		elif data == "dischargereport":
			return DocumentType.Dischargereport
		elif data == "ebirth_baby_medicalform":
			return DocumentType.EbirthBabyMedicalform
		elif data == "ebirth_baby_notification":
			return DocumentType.EbirthBabyNotification
		elif data == "ebirth_mother_medicalform":
			return DocumentType.EbirthMotherMedicalform
		elif data == "ebirth_mother_notification":
			return DocumentType.EbirthMotherNotification
		elif data == "ecare_safe_consultation":
			return DocumentType.EcareSafeConsultation
		elif data == "epidemiology":
			return DocumentType.Epidemiology
		elif data == "intervention":
			return DocumentType.Intervention
		elif data == "labrequest":
			return DocumentType.Labrequest
		elif data == "labresult":
			return DocumentType.Labresult
		elif data == "medicaladvisoragreement":
			return DocumentType.Medicaladvisoragreement
		elif data == "medicationschemeelement":
			return DocumentType.Medicationschemeelement
		elif data == "note":
			return DocumentType.Note
		elif data == "notification":
			return DocumentType.Notification
		elif data == "pharmaceuticalprescription":
			return DocumentType.Pharmaceuticalprescription
		elif data == "prescription":
			return DocumentType.Prescription
		elif data == "productdelivery":
			return DocumentType.Productdelivery
		elif data == "quickdischargereport":
			return DocumentType.Quickdischargereport
		elif data == "radiationexposuremonitoring":
			return DocumentType.Radiationexposuremonitoring
		elif data == "referral":
			return DocumentType.Referral
		elif data == "report":
			return DocumentType.Report
		elif data == "request":
			return DocumentType.Request
		elif data == "result":
			return DocumentType.Result
		elif data == "sumehr":
			return DocumentType.Sumehr
		elif data == "telemonitoring":
			return DocumentType.Telemonitoring
		elif data == "template":
			return DocumentType.Template
		elif data == "template_admin":
			return DocumentType.TemplateAdmin
		elif data == "treatmentsuspension":
			return DocumentType.Treatmentsuspension
		elif data == "vaccination":
			return DocumentType.Vaccination
		else:
			raise Exception(f"{data} is not a valid value for DocumentType enum.")

class ReportVersion(Enum):
	V1_0_0 = "V1_0_0"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReportVersion':
		if data == "V1_0_0":
			return ReportVersion.V1_0_0
		else:
			raise Exception(f"{data} is not a valid value for ReportVersion enum.")

@dataclass
class DocumentGroup:
	guid: Optional[str] = None
	name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"guid": self.guid,
			"name": self.name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			guid=deserialized_dict.get("guid"),
			name=deserialized_dict.get("name"),
		)

class UsersType(Enum):
	Database = "database"
	Ldap = "ldap"
	Token = "token"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersType':
		if data == "database":
			return UsersType.Database
		elif data == "ldap":
			return UsersType.Ldap
		elif data == "token":
			return UsersType.Token
		else:
			raise Exception(f"{data} is not a valid value for UsersType enum.")

class UsersStatus(Enum):
	Active = "ACTIVE"
	Disabled = "DISABLED"
	Registering = "REGISTERING"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersStatus':
		if data == "ACTIVE":
			return UsersStatus.Active
		elif data == "DISABLED":
			return UsersStatus.Disabled
		elif data == "REGISTERING":
			return UsersStatus.Registering
		else:
			raise Exception(f"{data} is not a valid value for UsersStatus enum.")

class DelegationTag(Enum):
	All = "all"
	AdministrativeData = "administrativeData"
	AnonymousMedicalInformation = "anonymousMedicalInformation"
	GeneralInformation = "generalInformation"
	FinancialInformation = "financialInformation"
	MedicalInformation = "medicalInformation"
	SensitiveInformation = "sensitiveInformation"
	ConfidentialInformation = "confidentialInformation"
	CdItemRisk = "cdItemRisk"
	CdItemFamilyRisk = "cdItemFamilyRisk"
	CdItemHealthcareelement = "cdItemHealthcareelement"
	CdItemHealthcareapproach = "cdItemHealthcareapproach"
	CdItemAllergy = "cdItemAllergy"
	CdItemDiagnosis = "cdItemDiagnosis"
	CdItemLab = "cdItemLab"
	CdItemResult = "cdItemResult"
	CdItemParameter = "cdItemParameter"
	CdItemMedication = "cdItemMedication"
	CdItemTreatment = "cdItemTreatment"
	CdItemVaccine = "cdItemVaccine"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DelegationTag':
		if data == "all":
			return DelegationTag.All
		elif data == "administrativeData":
			return DelegationTag.AdministrativeData
		elif data == "anonymousMedicalInformation":
			return DelegationTag.AnonymousMedicalInformation
		elif data == "generalInformation":
			return DelegationTag.GeneralInformation
		elif data == "financialInformation":
			return DelegationTag.FinancialInformation
		elif data == "medicalInformation":
			return DelegationTag.MedicalInformation
		elif data == "sensitiveInformation":
			return DelegationTag.SensitiveInformation
		elif data == "confidentialInformation":
			return DelegationTag.ConfidentialInformation
		elif data == "cdItemRisk":
			return DelegationTag.CdItemRisk
		elif data == "cdItemFamilyRisk":
			return DelegationTag.CdItemFamilyRisk
		elif data == "cdItemHealthcareelement":
			return DelegationTag.CdItemHealthcareelement
		elif data == "cdItemHealthcareapproach":
			return DelegationTag.CdItemHealthcareapproach
		elif data == "cdItemAllergy":
			return DelegationTag.CdItemAllergy
		elif data == "cdItemDiagnosis":
			return DelegationTag.CdItemDiagnosis
		elif data == "cdItemLab":
			return DelegationTag.CdItemLab
		elif data == "cdItemResult":
			return DelegationTag.CdItemResult
		elif data == "cdItemParameter":
			return DelegationTag.CdItemParameter
		elif data == "cdItemMedication":
			return DelegationTag.CdItemMedication
		elif data == "cdItemTreatment":
			return DelegationTag.CdItemTreatment
		elif data == "cdItemVaccine":
			return DelegationTag.CdItemVaccine
		else:
			raise Exception(f"{data} is not a valid value for DelegationTag enum.")

@dataclass
class AuthenticationToken:
	creation_time: int
	validity: int
	token: Optional[str] = None
	deletion_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"token": self.token,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"deletionDate": self.deletion_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AuthenticationToken':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token=deserialized_dict.get("token"),
			creation_time=deserialized_dict["creationTime"],
			validity=deserialized_dict["validity"],
			deletion_date=deserialized_dict.get("deletionDate"),
		)

@dataclass
class PropertyTypeStub:
	identifier: Optional[str] = None
	type: Optional['TypedValuesType'] = None

	def __serialize__(self) -> object:
		return {
			"identifier": self.identifier,
			"type": self.type.__serialize__() if self.type is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PropertyTypeStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifier=deserialized_dict.get("identifier"),
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
		)

@dataclass
class DecryptedTypedValue:
	type: Optional['TypedValuesType'] = None
	boolean_value: Optional[bool] = None
	integer_value: Optional[int] = None
	double_value: Optional[float] = None
	string_value: Optional[str] = None
	date_value: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"booleanValue": self.boolean_value,
			"integerValue": self.integer_value,
			"doubleValue": self.double_value,
			"stringValue": self.string_value,
			"dateValue": self.date_value,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedTypedValue':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value=deserialized_dict.get("booleanValue"),
			integer_value=deserialized_dict.get("integerValue"),
			double_value=deserialized_dict.get("doubleValue"),
			string_value=deserialized_dict.get("stringValue"),
			date_value=deserialized_dict.get("dateValue"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedTypedValue:
	type: Optional['TypedValuesType'] = None
	boolean_value: Optional[bool] = None
	integer_value: Optional[int] = None
	double_value: Optional[float] = None
	string_value: Optional[str] = None
	date_value: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"booleanValue": self.boolean_value,
			"integerValue": self.integer_value,
			"doubleValue": self.double_value,
			"stringValue": self.string_value,
			"dateValue": self.date_value,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedTypedValue':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value=deserialized_dict.get("booleanValue"),
			integer_value=deserialized_dict.get("integerValue"),
			double_value=deserialized_dict.get("doubleValue"),
			string_value=deserialized_dict.get("stringValue"),
			date_value=deserialized_dict.get("dateValue"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

TypedValue = Union['DecryptedTypedValue', 'EncryptedTypedValue']

def serialize_typed_value(typed_value: TypedValue) -> object:
	if isinstance(typed_value, DecryptedTypedValue):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedTypedValue",
			"entity": typed_value.__serialize__()
		}
	elif isinstance(typed_value, EncryptedTypedValue):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedTypedValue",
			"entity": typed_value.__serialize__()
		}
	else:
		raise Exception(f"{type(typed_value)} is not a known subclass of TypedValue")

def deserialize_typed_value(data: Union[str, Dict[str, object]]) -> 'TypedValue':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedTypedValue":
		DecryptedTypedValue._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedTypedValue":
		EncryptedTypedValue._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of TypedValue")

@dataclass
class Remote:
	url: str
	auth: Optional['RemoteAuthentication'] = None

	def __serialize__(self) -> object:
		return {
			"url": self.url,
			"auth": self.auth.__serialize__() if self.auth is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Remote':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			url=deserialized_dict["url"],
			auth=RemoteAuthentication._deserialize(deserialized_dict.get("auth")) if deserialized_dict.get("auth") is not None else None,
		)

@dataclass
class ReplicationStats:
	revisions_checked: Optional[int] = None
	missing_revisions_found: Optional[int] = None
	docs_read: Optional[int] = None
	docs_written: Optional[int] = None
	changes_pending: Optional[int] = None
	doc_write_failures: Optional[int] = None
	checkpointed_source_seq: Optional[str] = None
	start_time: Optional[str] = None
	error: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"revisionsChecked": self.revisions_checked,
			"missingRevisionsFound": self.missing_revisions_found,
			"docsRead": self.docs_read,
			"docsWritten": self.docs_written,
			"changesPending": self.changes_pending,
			"docWriteFailures": self.doc_write_failures,
			"checkpointedSourceSeq": self.checkpointed_source_seq,
			"startTime": self.start_time,
			"error": self.error,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReplicationStats':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			revisions_checked=deserialized_dict.get("revisionsChecked"),
			missing_revisions_found=deserialized_dict.get("missingRevisionsFound"),
			docs_read=deserialized_dict.get("docsRead"),
			docs_written=deserialized_dict.get("docsWritten"),
			changes_pending=deserialized_dict.get("changesPending"),
			doc_write_failures=deserialized_dict.get("docWriteFailures"),
			checkpointed_source_seq=deserialized_dict.get("checkpointedSourceSeq"),
			start_time=deserialized_dict.get("startTime"),
			error=deserialized_dict.get("error"),
		)

@dataclass
class TimeTableItem:
	rrule_start_date: Optional[int] = None
	rrule: Optional[str] = None
	not_before_in_minutes: Optional[int] = None
	not_after_in_minutes: Optional[int] = None
	zone_id: Optional[str] = None
	days: List[str] = field(default_factory=list)
	recurrence_types: List[str] = field(default_factory=list)
	hours: List['TimeTableHour'] = field(default_factory=list)
	calendar_item_type_id: Optional[str] = None
	home_visit: bool = False
	place_id: Optional[str] = None
	public_time_table_item: bool = False
	accepts_new_patient: bool = True
	unavailable: bool = False

	def __serialize__(self) -> object:
		return {
			"rruleStartDate": self.rrule_start_date,
			"rrule": self.rrule,
			"notBeforeInMinutes": self.not_before_in_minutes,
			"notAfterInMinutes": self.not_after_in_minutes,
			"zoneId": self.zone_id,
			"days": [x0 for x0 in self.days],
			"recurrenceTypes": [x0 for x0 in self.recurrence_types],
			"hours": [x0.__serialize__() for x0 in self.hours],
			"calendarItemTypeId": self.calendar_item_type_id,
			"homeVisit": self.home_visit,
			"placeId": self.place_id,
			"publicTimeTableItem": self.public_time_table_item,
			"acceptsNewPatient": self.accepts_new_patient,
			"unavailable": self.unavailable,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rrule_start_date=deserialized_dict.get("rruleStartDate"),
			rrule=deserialized_dict.get("rrule"),
			not_before_in_minutes=deserialized_dict.get("notBeforeInMinutes"),
			not_after_in_minutes=deserialized_dict.get("notAfterInMinutes"),
			zone_id=deserialized_dict.get("zoneId"),
			days=[x0 for x0 in deserialized_dict["days"]],
			recurrence_types=[x0 for x0 in deserialized_dict["recurrenceTypes"]],
			hours=[TimeTableHour._deserialize(x0) for x0 in deserialized_dict["hours"]],
			calendar_item_type_id=deserialized_dict.get("calendarItemTypeId"),
			home_visit=deserialized_dict["homeVisit"],
			place_id=deserialized_dict.get("placeId"),
			public_time_table_item=deserialized_dict["publicTimeTableItem"],
			accepts_new_patient=deserialized_dict["acceptsNewPatient"],
			unavailable=deserialized_dict["unavailable"],
		)

@dataclass
class FailedRequestDetails:
	entity_id: str
	delegate_id: str
	updated_for_migration: bool
	code: Optional[int]
	reason: Optional[str]
	request: Optional['DelegateShareOptions']

	def __serialize__(self) -> object:
		return {
			"entityId": self.entity_id,
			"delegateId": self.delegate_id,
			"updatedForMigration": self.updated_for_migration,
			"code": self.code,
			"reason": self.reason,
			"request": self.request.__serialize__() if self.request is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FailedRequestDetails':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity_id=deserialized_dict["entityId"],
			delegate_id=deserialized_dict["delegateId"],
			updated_for_migration=deserialized_dict["updatedForMigration"],
			code=deserialized_dict.get("code"),
			reason=deserialized_dict.get("reason"),
			request=DelegateShareOptions._deserialize(deserialized_dict.get("request")) if deserialized_dict.get("request") is not None else None,
		)

class DocumentLocation(Enum):
	Annex = "annex"
	Body = "body"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentLocation':
		if data == "annex":
			return DocumentLocation.Annex
		elif data == "body":
			return DocumentLocation.Body
		else:
			raise Exception(f"{data} is not a valid value for DocumentLocation enum.")

class DocumentStatus(Enum):
	Draft = "draft"
	Finalized = "finalized"
	PendingReview = "pending_review"
	Reviewed = "reviewed"
	PendingSignature = "pending_signature"
	Signed = "signed"
	Canceled = "canceled"
	Sent = "sent"
	Delivered = "delivered"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentStatus':
		if data == "draft":
			return DocumentStatus.Draft
		elif data == "finalized":
			return DocumentStatus.Finalized
		elif data == "pending_review":
			return DocumentStatus.PendingReview
		elif data == "reviewed":
			return DocumentStatus.Reviewed
		elif data == "pending_signature":
			return DocumentStatus.PendingSignature
		elif data == "signed":
			return DocumentStatus.Signed
		elif data == "canceled":
			return DocumentStatus.Canceled
		elif data == "sent":
			return DocumentStatus.Sent
		elif data == "delivered":
			return DocumentStatus.Delivered
		else:
			raise Exception(f"{data} is not a valid value for DocumentStatus enum.")

@dataclass
class DataAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	utis: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"utis": [x0 for x0 in self.utis],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id=deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id=deserialized_dict.get("objectStoreAttachmentId"),
			utis=[x0 for x0 in deserialized_dict["utis"]],
		)

@dataclass
class DeletedAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	key: Optional[str] = None
	deletion_time: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"key": self.key,
			"deletionTime": self.deletion_time,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeletedAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id=deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id=deserialized_dict.get("objectStoreAttachmentId"),
			key=deserialized_dict.get("key"),
			deletion_time=deserialized_dict.get("deletionTime"),
		)

@dataclass
class Measure:
	value: Optional[float] = None
	ref: Optional[float] = None
	severity: Optional[int] = None
	severity_code: Optional[str] = None
	evolution: Optional[int] = None
	unit: Optional[str] = None
	unit_codes: Optional[List['CodeStub']] = None
	comment: Optional[str] = None
	comparator: Optional[str] = None
	sign: Optional[str] = None
	reference_ranges: List['ReferenceRange'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"ref": self.ref,
			"severity": self.severity,
			"severityCode": self.severity_code,
			"evolution": self.evolution,
			"unit": self.unit,
			"unitCodes": [x0.__serialize__() for x0 in self.unit_codes] if self.unit_codes is not None else None,
			"comment": self.comment,
			"comparator": self.comparator,
			"sign": self.sign,
			"referenceRanges": [x0.__serialize__() for x0 in self.reference_ranges],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Measure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			ref=deserialized_dict.get("ref"),
			severity=deserialized_dict.get("severity"),
			severity_code=deserialized_dict.get("severityCode"),
			evolution=deserialized_dict.get("evolution"),
			unit=deserialized_dict.get("unit"),
			unit_codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict.get("unitCodes")] if deserialized_dict.get("unitCodes") is not None else None,
			comment=deserialized_dict.get("comment"),
			comparator=deserialized_dict.get("comparator"),
			sign=deserialized_dict.get("sign"),
			reference_ranges=[ReferenceRange._deserialize(x0) for x0 in deserialized_dict["referenceRanges"]],
		)

@dataclass
class Medication:
	compound_prescription: Optional[str] = None
	substance_product: Optional['Substanceproduct'] = None
	medicinal_product: Optional['Medicinalproduct'] = None
	number_of_packages: Optional[int] = None
	batch: Optional[str] = None
	expiration_date: Optional[int] = None
	instruction_for_patient: Optional[str] = None
	instruction_for_reimbursement: Optional[str] = None
	comment_for_delivery: Optional[str] = None
	drug_route: Optional[str] = None
	temporality: Optional[str] = None
	frequency: Optional['CodeStub'] = None
	reimbursement_reason: Optional['CodeStub'] = None
	substitution_allowed: Optional[bool] = None
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	delivery_moment: Optional[int] = None
	end_execution_moment: Optional[int] = None
	duration: Optional['Duration'] = None
	renewal: Optional['Renewal'] = None
	known_usage: Optional[bool] = None
	regimen: Optional[List['RegimenItem']] = None
	posology: Optional[str] = None
	agreements: Optional[Dict[str, 'ParagraphAgreement']] = None
	medication_scheme_id_on_safe: Optional[str] = None
	medication_scheme_safe_version: Optional[int] = None
	medication_scheme_time_stamp_on_safe: Optional[int] = None
	medication_scheme_document_id: Optional[str] = None
	safe_id_name: Optional[str] = None
	id_on_safes: Optional[str] = None
	timestamp_on_safe: Optional[int] = None
	change_validated: Optional[bool] = None
	new_safe_medication: Optional[bool] = None
	medication_use: Optional[str] = None
	begin_condition: Optional[str] = None
	end_condition: Optional[str] = None
	origin: Optional[str] = None
	medication_changed: Optional[bool] = None
	posology_changed: Optional[bool] = None
	suspension: Optional[List['Suspension']] = None
	prescription_rid: Optional[str] = None
	status: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"compoundPrescription": self.compound_prescription,
			"substanceProduct": self.substance_product.__serialize__() if self.substance_product is not None else None,
			"medicinalProduct": self.medicinal_product.__serialize__() if self.medicinal_product is not None else None,
			"numberOfPackages": self.number_of_packages,
			"batch": self.batch,
			"expirationDate": self.expiration_date,
			"instructionForPatient": self.instruction_for_patient,
			"instructionForReimbursement": self.instruction_for_reimbursement,
			"commentForDelivery": self.comment_for_delivery,
			"drugRoute": self.drug_route,
			"temporality": self.temporality,
			"frequency": self.frequency.__serialize__() if self.frequency is not None else None,
			"reimbursementReason": self.reimbursement_reason.__serialize__() if self.reimbursement_reason is not None else None,
			"substitutionAllowed": self.substitution_allowed,
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"deliveryMoment": self.delivery_moment,
			"endExecutionMoment": self.end_execution_moment,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
			"renewal": self.renewal.__serialize__() if self.renewal is not None else None,
			"knownUsage": self.known_usage,
			"regimen": [x0.__serialize__() for x0 in self.regimen] if self.regimen is not None else None,
			"posology": self.posology,
			"agreements": {k0: v0.__serialize__() for k0, v0 in self.agreements.items()} if self.agreements is not None else None,
			"medicationSchemeIdOnSafe": self.medication_scheme_id_on_safe,
			"medicationSchemeSafeVersion": self.medication_scheme_safe_version,
			"medicationSchemeTimeStampOnSafe": self.medication_scheme_time_stamp_on_safe,
			"medicationSchemeDocumentId": self.medication_scheme_document_id,
			"safeIdName": self.safe_id_name,
			"idOnSafes": self.id_on_safes,
			"timestampOnSafe": self.timestamp_on_safe,
			"changeValidated": self.change_validated,
			"newSafeMedication": self.new_safe_medication,
			"medicationUse": self.medication_use,
			"beginCondition": self.begin_condition,
			"endCondition": self.end_condition,
			"origin": self.origin,
			"medicationChanged": self.medication_changed,
			"posologyChanged": self.posology_changed,
			"suspension": [x0.__serialize__() for x0 in self.suspension] if self.suspension is not None else None,
			"prescriptionRID": self.prescription_rid,
			"status": self.status,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Medication':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			compound_prescription=deserialized_dict.get("compoundPrescription"),
			substance_product=Substanceproduct._deserialize(deserialized_dict.get("substanceProduct")) if deserialized_dict.get("substanceProduct") is not None else None,
			medicinal_product=Medicinalproduct._deserialize(deserialized_dict.get("medicinalProduct")) if deserialized_dict.get("medicinalProduct") is not None else None,
			number_of_packages=deserialized_dict.get("numberOfPackages"),
			batch=deserialized_dict.get("batch"),
			expiration_date=deserialized_dict.get("expirationDate"),
			instruction_for_patient=deserialized_dict.get("instructionForPatient"),
			instruction_for_reimbursement=deserialized_dict.get("instructionForReimbursement"),
			comment_for_delivery=deserialized_dict.get("commentForDelivery"),
			drug_route=deserialized_dict.get("drugRoute"),
			temporality=deserialized_dict.get("temporality"),
			frequency=CodeStub._deserialize(deserialized_dict.get("frequency")) if deserialized_dict.get("frequency") is not None else None,
			reimbursement_reason=CodeStub._deserialize(deserialized_dict.get("reimbursementReason")) if deserialized_dict.get("reimbursementReason") is not None else None,
			substitution_allowed=deserialized_dict.get("substitutionAllowed"),
			begin_moment=deserialized_dict.get("beginMoment"),
			end_moment=deserialized_dict.get("endMoment"),
			delivery_moment=deserialized_dict.get("deliveryMoment"),
			end_execution_moment=deserialized_dict.get("endExecutionMoment"),
			duration=Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
			renewal=Renewal._deserialize(deserialized_dict.get("renewal")) if deserialized_dict.get("renewal") is not None else None,
			known_usage=deserialized_dict.get("knownUsage"),
			regimen=[RegimenItem._deserialize(x0) for x0 in deserialized_dict.get("regimen")] if deserialized_dict.get("regimen") is not None else None,
			posology=deserialized_dict.get("posology"),
			agreements=dict(map(lambda kv0: (kv0[0], ParagraphAgreement._deserialize(kv0[1])), deserialized_dict.get("agreements").items())) if deserialized_dict.get("agreements") is not None else None,
			medication_scheme_id_on_safe=deserialized_dict.get("medicationSchemeIdOnSafe"),
			medication_scheme_safe_version=deserialized_dict.get("medicationSchemeSafeVersion"),
			medication_scheme_time_stamp_on_safe=deserialized_dict.get("medicationSchemeTimeStampOnSafe"),
			medication_scheme_document_id=deserialized_dict.get("medicationSchemeDocumentId"),
			safe_id_name=deserialized_dict.get("safeIdName"),
			id_on_safes=deserialized_dict.get("idOnSafes"),
			timestamp_on_safe=deserialized_dict.get("timestampOnSafe"),
			change_validated=deserialized_dict.get("changeValidated"),
			new_safe_medication=deserialized_dict.get("newSafeMedication"),
			medication_use=deserialized_dict.get("medicationUse"),
			begin_condition=deserialized_dict.get("beginCondition"),
			end_condition=deserialized_dict.get("endCondition"),
			origin=deserialized_dict.get("origin"),
			medication_changed=deserialized_dict.get("medicationChanged"),
			posology_changed=deserialized_dict.get("posologyChanged"),
			suspension=[Suspension._deserialize(x0) for x0 in deserialized_dict.get("suspension")] if deserialized_dict.get("suspension") is not None else None,
			prescription_rid=deserialized_dict.get("prescriptionRID"),
			status=deserialized_dict.get("status"),
		)

@dataclass
class TimeSeries:
	fields: List[str] = field(default_factory=list)
	samples: List[List[float]] = field(default_factory=list)
	min: List[float] = field(default_factory=list)
	max: List[float] = field(default_factory=list)
	mean: List[float] = field(default_factory=list)
	median: List[float] = field(default_factory=list)
	variance: List[float] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"fields": [x0 for x0 in self.fields],
			"samples": [[x1 for x1 in x0] for x0 in self.samples],
			"min": [x0 for x0 in self.min],
			"max": [x0 for x0 in self.max],
			"mean": [x0 for x0 in self.mean],
			"median": [x0 for x0 in self.median],
			"variance": [x0 for x0 in self.variance],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeSeries':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			fields=[x0 for x0 in deserialized_dict["fields"]],
			samples=[[x1 for x1 in x0] for x0 in deserialized_dict["samples"]],
			min=[x0 for x0 in deserialized_dict["min"]],
			max=[x0 for x0 in deserialized_dict["max"]],
			mean=[x0 for x0 in deserialized_dict["mean"]],
			median=[x0 for x0 in deserialized_dict["median"]],
			variance=[x0 for x0 in deserialized_dict["variance"]],
		)

class TaskStatus(Enum):
	Pending = "pending"
	Ongoing = "ongoing"
	Cancelled = "cancelled"
	Completed = "completed"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TaskStatus':
		if data == "pending":
			return TaskStatus.Pending
		elif data == "ongoing":
			return TaskStatus.Ongoing
		elif data == "cancelled":
			return TaskStatus.Cancelled
		elif data == "completed":
			return TaskStatus.Completed
		else:
			raise Exception(f"{data} is not a valid value for TaskStatus enum.")

@dataclass
class FormTemplateLayout:
	form: str
	actions: List['Action'] = field(default_factory=list)
	sections: List['Section'] = field(default_factory=list)
	description: Optional[str] = None
	keywords: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"form": self.form,
			"actions": [x0.__serialize__() for x0 in self.actions],
			"sections": [x0.__serialize__() for x0 in self.sections],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormTemplateLayout':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			form=deserialized_dict["form"],
			actions=[Action._deserialize(x0) for x0 in deserialized_dict["actions"]],
			sections=[Section._deserialize(x0) for x0 in deserialized_dict["sections"]],
			description=deserialized_dict.get("description"),
			keywords=[x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

class EntityWithEncryptionMetadataTypeName(Enum):
	Article = "Article"
	AccessLog = "AccessLog"
	CalendarItem = "CalendarItem"
	Classification = "Classification"
	ClassificationTemplate = "ClassificationTemplate"
	Contact = "Contact"
	Service = "Service"
	Document = "Document"
	Form = "Form"
	HealthElement = "HealthElement"
	Invoice = "Invoice"
	MaintenanceTask = "MaintenanceTask"
	Message = "Message"
	Patient = "Patient"
	Receipt = "Receipt"
	TimeTable = "TimeTable"
	Topic = "Topic"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithEncryptionMetadataTypeName':
		if data == "Article":
			return EntityWithEncryptionMetadataTypeName.Article
		elif data == "AccessLog":
			return EntityWithEncryptionMetadataTypeName.AccessLog
		elif data == "CalendarItem":
			return EntityWithEncryptionMetadataTypeName.CalendarItem
		elif data == "Classification":
			return EntityWithEncryptionMetadataTypeName.Classification
		elif data == "ClassificationTemplate":
			return EntityWithEncryptionMetadataTypeName.ClassificationTemplate
		elif data == "Contact":
			return EntityWithEncryptionMetadataTypeName.Contact
		elif data == "Service":
			return EntityWithEncryptionMetadataTypeName.Service
		elif data == "Document":
			return EntityWithEncryptionMetadataTypeName.Document
		elif data == "Form":
			return EntityWithEncryptionMetadataTypeName.Form
		elif data == "HealthElement":
			return EntityWithEncryptionMetadataTypeName.HealthElement
		elif data == "Invoice":
			return EntityWithEncryptionMetadataTypeName.Invoice
		elif data == "MaintenanceTask":
			return EntityWithEncryptionMetadataTypeName.MaintenanceTask
		elif data == "Message":
			return EntityWithEncryptionMetadataTypeName.Message
		elif data == "Patient":
			return EntityWithEncryptionMetadataTypeName.Patient
		elif data == "Receipt":
			return EntityWithEncryptionMetadataTypeName.Receipt
		elif data == "TimeTable":
			return EntityWithEncryptionMetadataTypeName.TimeTable
		elif data == "Topic":
			return EntityWithEncryptionMetadataTypeName.Topic
		else:
			raise Exception(f"{data} is not a valid value for EntityWithEncryptionMetadataTypeName enum.")

class Laterality(Enum):
	Left = "left"
	Right = "right"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Laterality':
		if data == "left":
			return Laterality.Left
		elif data == "right":
			return Laterality.Right
		else:
			raise Exception(f"{data} is not a valid value for Laterality enum.")

@dataclass
class EncryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: List[str] = field(default_factory=list)
	number_of_cares: Optional[int] = None
	care_team_memberships: List[Optional['EncryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPlanOfAction':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			prescriber_id=deserialized_dict.get("prescriberId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			deadline_date=deserialized_dict.get("deadlineDate"),
			name=deserialized_dict.get("name"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			status=deserialized_dict["status"],
			document_ids=[x0 for x0 in deserialized_dict["documentIds"]],
			number_of_cares=deserialized_dict.get("numberOfCares"),
			care_team_memberships=[EncryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant=deserialized_dict["relevant"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: List[str] = field(default_factory=list)
	number_of_cares: Optional[int] = None
	care_team_memberships: List[Optional['DecryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPlanOfAction':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			prescriber_id=deserialized_dict.get("prescriberId"),
			value_date=deserialized_dict.get("valueDate"),
			opening_date=deserialized_dict.get("openingDate"),
			closing_date=deserialized_dict.get("closingDate"),
			deadline_date=deserialized_dict.get("deadlineDate"),
			name=deserialized_dict.get("name"),
			descr=deserialized_dict.get("descr"),
			note=deserialized_dict.get("note"),
			id_opening_contact=deserialized_dict.get("idOpeningContact"),
			id_closing_contact=deserialized_dict.get("idClosingContact"),
			status=deserialized_dict["status"],
			document_ids=[x0 for x0 in deserialized_dict["documentIds"]],
			number_of_cares=deserialized_dict.get("numberOfCares"),
			care_team_memberships=[DecryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant=deserialized_dict["relevant"],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

PlanOfAction = Union['EncryptedPlanOfAction', 'DecryptedPlanOfAction']

def serialize_plan_of_action(plan_of_action: PlanOfAction) -> object:
	if isinstance(plan_of_action, EncryptedPlanOfAction):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedPlanOfAction",
			"entity": plan_of_action.__serialize__()
		}
	elif isinstance(plan_of_action, DecryptedPlanOfAction):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedPlanOfAction",
			"entity": plan_of_action.__serialize__()
		}
	else:
		raise Exception(f"{type(plan_of_action)} is not a known subclass of PlanOfAction")

def deserialize_plan_of_action(data: Union[str, Dict[str, object]]) -> 'PlanOfAction':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedPlanOfAction":
		EncryptedPlanOfAction._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedPlanOfAction":
		DecryptedPlanOfAction._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of PlanOfAction")

@dataclass
class DecryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedEpisode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			name=deserialized_dict.get("name"),
			comment=deserialized_dict.get("comment"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedEpisode:
	id: str
	name: Optional[str] = None
	comment: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"name": self.name,
			"comment": self.comment,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedEpisode':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			name=deserialized_dict.get("name"),
			comment=deserialized_dict.get("comment"),
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

Episode = Union['DecryptedEpisode', 'EncryptedEpisode']

def serialize_episode(episode: Episode) -> object:
	if isinstance(episode, DecryptedEpisode):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedEpisode",
			"entity": episode.__serialize__()
		}
	elif isinstance(episode, EncryptedEpisode):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedEpisode",
			"entity": episode.__serialize__()
		}
	else:
		raise Exception(f"{type(episode)} is not a known subclass of Episode")

def deserialize_episode(data: Union[str, Dict[str, object]]) -> 'Episode':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedEpisode":
		DecryptedEpisode._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedEpisode":
		EncryptedEpisode._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Episode")

@dataclass
class EncryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCareTeamMember':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			care_team_member_type=CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			quality=CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCareTeamMember':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			care_team_member_type=CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id=deserialized_dict.get("healthcarePartyId"),
			quality=CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

CareTeamMember = Union['EncryptedCareTeamMember', 'DecryptedCareTeamMember']

def serialize_care_team_member(care_team_member: CareTeamMember) -> object:
	if isinstance(care_team_member, EncryptedCareTeamMember):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedCareTeamMember",
			"entity": care_team_member.__serialize__()
		}
	elif isinstance(care_team_member, DecryptedCareTeamMember):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedCareTeamMember",
			"entity": care_team_member.__serialize__()
		}
	else:
		raise Exception(f"{type(care_team_member)} is not a known subclass of CareTeamMember")

def deserialize_care_team_member(data: Union[str, Dict[str, object]]) -> 'CareTeamMember':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedCareTeamMember":
		EncryptedCareTeamMember._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedCareTeamMember":
		DecryptedCareTeamMember._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMember")

@dataclass
class EncryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: List['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedSubContact':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			descr=deserialized_dict.get("descr"),
			protocol=deserialized_dict.get("protocol"),
			status=deserialized_dict.get("status"),
			form_id=deserialized_dict.get("formId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			classification_id=deserialized_dict.get("classificationId"),
			services=[ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: List['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedSubContact':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			created=deserialized_dict.get("created"),
			modified=deserialized_dict.get("modified"),
			author=deserialized_dict.get("author"),
			responsible=deserialized_dict.get("responsible"),
			medical_location_id=deserialized_dict.get("medicalLocationId"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life=deserialized_dict.get("endOfLife"),
			descr=deserialized_dict.get("descr"),
			protocol=deserialized_dict.get("protocol"),
			status=deserialized_dict.get("status"),
			form_id=deserialized_dict.get("formId"),
			plan_of_action_id=deserialized_dict.get("planOfActionId"),
			health_element_id=deserialized_dict.get("healthElementId"),
			classification_id=deserialized_dict.get("classificationId"),
			services=[ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

SubContact = Union['EncryptedSubContact', 'DecryptedSubContact']

def serialize_sub_contact(sub_contact: SubContact) -> object:
	if isinstance(sub_contact, EncryptedSubContact):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedSubContact",
			"entity": sub_contact.__serialize__()
		}
	elif isinstance(sub_contact, DecryptedSubContact):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedSubContact",
			"entity": sub_contact.__serialize__()
		}
	else:
		raise Exception(f"{type(sub_contact)} is not a known subclass of SubContact")

def deserialize_sub_contact(data: Union[str, Dict[str, object]]) -> 'SubContact':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedSubContact":
		EncryptedSubContact._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedSubContact":
		DecryptedSubContact._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of SubContact")

class ParticipantType(Enum):
	Admitter = "Admitter"
	Attender = "Attender"
	CallbackContact = "CallbackContact"
	Consultant = "Consultant"
	Discharger = "Discharger"
	Escort = "Escort"
	Referrer = "Referrer"
	SecondaryPerformer = "SecondaryPerformer"
	PrimaryPerformer = "PrimaryPerformer"
	Participation = "Participation"
	Translator = "Translator"
	Emergency = "Emergency"
	Location = "Location"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ParticipantType':
		if data == "Admitter":
			return ParticipantType.Admitter
		elif data == "Attender":
			return ParticipantType.Attender
		elif data == "CallbackContact":
			return ParticipantType.CallbackContact
		elif data == "Consultant":
			return ParticipantType.Consultant
		elif data == "Discharger":
			return ParticipantType.Discharger
		elif data == "Escort":
			return ParticipantType.Escort
		elif data == "Referrer":
			return ParticipantType.Referrer
		elif data == "SecondaryPerformer":
			return ParticipantType.SecondaryPerformer
		elif data == "PrimaryPerformer":
			return ParticipantType.PrimaryPerformer
		elif data == "Participation":
			return ParticipantType.Participation
		elif data == "Translator":
			return ParticipantType.Translator
		elif data == "Emergency":
			return ParticipantType.Emergency
		elif data == "Location":
			return ParticipantType.Location
		else:
			raise Exception(f"{data} is not a valid value for ParticipantType enum.")

class ReceiptBlobType(Enum):
	Xades = "xades"
	KmehrRequest = "kmehrRequest"
	KmehrResponse = "kmehrResponse"
	SoapRequest = "soapRequest"
	SoapResponse = "soapResponse"
	SoapConversation = "soapConversation"
	Tack = "tack"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReceiptBlobType':
		if data == "xades":
			return ReceiptBlobType.Xades
		elif data == "kmehrRequest":
			return ReceiptBlobType.KmehrRequest
		elif data == "kmehrResponse":
			return ReceiptBlobType.KmehrResponse
		elif data == "soapRequest":
			return ReceiptBlobType.SoapRequest
		elif data == "soapResponse":
			return ReceiptBlobType.SoapResponse
		elif data == "soapConversation":
			return ReceiptBlobType.SoapConversation
		elif data == "tack":
			return ReceiptBlobType.Tack
		else:
			raise Exception(f"{data} is not a valid value for ReceiptBlobType enum.")

@dataclass
class CalendarItemTag:
	code: Optional[str] = None
	date: Optional[int] = None
	user_id: Optional[str] = None
	user_name: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"code": self.code,
			"date": self.date,
			"userId": self.user_id,
			"userName": self.user_name,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CalendarItemTag':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			code=deserialized_dict.get("code"),
			date=deserialized_dict.get("date"),
			user_id=deserialized_dict.get("userId"),
			user_name=deserialized_dict.get("userName"),
		)

@dataclass
class FlowItem:
	id: Optional[str] = None
	title: Optional[str] = None
	comment: Optional[str] = None
	reception_date: Optional[int] = None
	processing_date: Optional[int] = None
	processer: Optional[str] = None
	cancellation_date: Optional[int] = None
	canceller: Optional[str] = None
	cancellation_reason: Optional[str] = None
	cancellation_note: Optional[str] = None
	status: Optional[str] = None
	home_visit: Optional[bool] = None
	municipality: Optional[str] = None
	town: Optional[str] = None
	zip_code: Optional[str] = None
	street: Optional[str] = None
	building: Optional[str] = None
	building_number: Optional[str] = None
	doorbell_name: Optional[str] = None
	floor: Optional[str] = None
	letter_box: Optional[str] = None
	notes_ops: Optional[str] = None
	notes_contact: Optional[str] = None
	latitude: Optional[str] = None
	longitude: Optional[str] = None
	type: Optional[str] = None
	emergency: Optional[bool] = None
	phone_number: Optional[str] = None
	patient_id: Optional[str] = None
	patient_last_name: Optional[str] = None
	patient_first_name: Optional[str] = None
	description: Optional[str] = None
	intervention_code: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"title": self.title,
			"comment": self.comment,
			"receptionDate": self.reception_date,
			"processingDate": self.processing_date,
			"processer": self.processer,
			"cancellationDate": self.cancellation_date,
			"canceller": self.canceller,
			"cancellationReason": self.cancellation_reason,
			"cancellationNote": self.cancellation_note,
			"status": self.status,
			"homeVisit": self.home_visit,
			"municipality": self.municipality,
			"town": self.town,
			"zipCode": self.zip_code,
			"street": self.street,
			"building": self.building,
			"buildingNumber": self.building_number,
			"doorbellName": self.doorbell_name,
			"floor": self.floor,
			"letterBox": self.letter_box,
			"notesOps": self.notes_ops,
			"notesContact": self.notes_contact,
			"latitude": self.latitude,
			"longitude": self.longitude,
			"type": self.type,
			"emergency": self.emergency,
			"phoneNumber": self.phone_number,
			"patientId": self.patient_id,
			"patientLastName": self.patient_last_name,
			"patientFirstName": self.patient_first_name,
			"description": self.description,
			"interventionCode": self.intervention_code,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FlowItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict.get("id"),
			title=deserialized_dict.get("title"),
			comment=deserialized_dict.get("comment"),
			reception_date=deserialized_dict.get("receptionDate"),
			processing_date=deserialized_dict.get("processingDate"),
			processer=deserialized_dict.get("processer"),
			cancellation_date=deserialized_dict.get("cancellationDate"),
			canceller=deserialized_dict.get("canceller"),
			cancellation_reason=deserialized_dict.get("cancellationReason"),
			cancellation_note=deserialized_dict.get("cancellationNote"),
			status=deserialized_dict.get("status"),
			home_visit=deserialized_dict.get("homeVisit"),
			municipality=deserialized_dict.get("municipality"),
			town=deserialized_dict.get("town"),
			zip_code=deserialized_dict.get("zipCode"),
			street=deserialized_dict.get("street"),
			building=deserialized_dict.get("building"),
			building_number=deserialized_dict.get("buildingNumber"),
			doorbell_name=deserialized_dict.get("doorbellName"),
			floor=deserialized_dict.get("floor"),
			letter_box=deserialized_dict.get("letterBox"),
			notes_ops=deserialized_dict.get("notesOps"),
			notes_contact=deserialized_dict.get("notesContact"),
			latitude=deserialized_dict.get("latitude"),
			longitude=deserialized_dict.get("longitude"),
			type=deserialized_dict.get("type"),
			emergency=deserialized_dict.get("emergency"),
			phone_number=deserialized_dict.get("phoneNumber"),
			patient_id=deserialized_dict.get("patientId"),
			patient_last_name=deserialized_dict.get("patientLastName"),
			patient_first_name=deserialized_dict.get("patientFirstName"),
			description=deserialized_dict.get("description"),
			intervention_code=deserialized_dict.get("interventionCode"),
		)

@dataclass
class MessageReadStatus:
	time: Optional[int] = None
	read: bool = False

	def __serialize__(self) -> object:
		return {
			"time": self.time,
			"read": self.read,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageReadStatus':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			time=deserialized_dict.get("time"),
			read=deserialized_dict["read"],
		)

@dataclass
class MessageAttachment:
	type: Optional['DocumentLocation'] = None
	ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type=DocumentLocation._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			ids=[x0 for x0 in deserialized_dict["ids"]],
		)

class InvoiceInterventionType(Enum):
	Total = "total"
	Userfees = "userfees"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceInterventionType':
		if data == "total":
			return InvoiceInterventionType.Total
		elif data == "userfees":
			return InvoiceInterventionType.Userfees
		else:
			raise Exception(f"{data} is not a valid value for InvoiceInterventionType enum.")

class PaymentType(Enum):
	Cash = "cash"
	Wired = "wired"
	Insurance = "insurance"
	Creditcard = "creditcard"
	Debitcard = "debitcard"
	Paypal = "paypal"
	Bitcoin = "bitcoin"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaymentType':
		if data == "cash":
			return PaymentType.Cash
		elif data == "wired":
			return PaymentType.Wired
		elif data == "insurance":
			return PaymentType.Insurance
		elif data == "creditcard":
			return PaymentType.Creditcard
		elif data == "debitcard":
			return PaymentType.Debitcard
		elif data == "paypal":
			return PaymentType.Paypal
		elif data == "bitcoin":
			return PaymentType.Bitcoin
		elif data == "other":
			return PaymentType.Other
		else:
			raise Exception(f"{data} is not a valid value for PaymentType enum.")

@dataclass
class Payment:
	payment_date: int = 0
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"paymentDate": self.payment_date,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Payment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			payment_date=deserialized_dict["paymentDate"],
			payment_type=PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid=deserialized_dict.get("paid"),
		)

@dataclass
class IdentityDocumentReader:
	justificatif_document_number: Optional[str] = None
	support_serial_number: Optional[str] = None
	time_reading_eid_document: Optional[int] = None
	eid_document_support_type: int = 0
	reason_manual_encoding: int = 0
	reason_using_vignette: int = 0

	def __serialize__(self) -> object:
		return {
			"justificatifDocumentNumber": self.justificatif_document_number,
			"supportSerialNumber": self.support_serial_number,
			"timeReadingEIdDocument": self.time_reading_eid_document,
			"eidDocumentSupportType": self.eid_document_support_type,
			"reasonManualEncoding": self.reason_manual_encoding,
			"reasonUsingVignette": self.reason_using_vignette,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IdentityDocumentReader':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			justificatif_document_number=deserialized_dict.get("justificatifDocumentNumber"),
			support_serial_number=deserialized_dict.get("supportSerialNumber"),
			time_reading_eid_document=deserialized_dict.get("timeReadingEIdDocument"),
			eid_document_support_type=deserialized_dict["eidDocumentSupportType"],
			reason_manual_encoding=deserialized_dict["reasonManualEncoding"],
			reason_using_vignette=deserialized_dict["reasonUsingVignette"],
		)

@dataclass
class OperationToken:
	token_hash: str
	creation_time: int
	validity: int
	operation: 'Operation'
	description: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"tokenHash": self.token_hash,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"operation": self.operation.__serialize__(),
			"description": self.description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'OperationToken':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token_hash=deserialized_dict["tokenHash"],
			creation_time=deserialized_dict["creationTime"],
			validity=deserialized_dict["validity"],
			operation=Operation._deserialize(deserialized_dict["operation"]),
			description=deserialized_dict.get("description"),
		)

class AuthenticationClass(Enum):
	DigitalId = "DIGITAL_ID"
	TwoFactorAuthentication = "TWO_FACTOR_AUTHENTICATION"
	ShortLivedToken = "SHORT_LIVED_TOKEN"
	ExternalAuthentication = "EXTERNAL_AUTHENTICATION"
	Password = "PASSWORD"
	LongLivedToken = "LONG_LIVED_TOKEN"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AuthenticationClass':
		if data == "DIGITAL_ID":
			return AuthenticationClass.DigitalId
		elif data == "TWO_FACTOR_AUTHENTICATION":
			return AuthenticationClass.TwoFactorAuthentication
		elif data == "SHORT_LIVED_TOKEN":
			return AuthenticationClass.ShortLivedToken
		elif data == "EXTERNAL_AUTHENTICATION":
			return AuthenticationClass.ExternalAuthentication
		elif data == "PASSWORD":
			return AuthenticationClass.Password
		elif data == "LONG_LIVED_TOKEN":
			return AuthenticationClass.LongLivedToken
		else:
			raise Exception(f"{data} is not a valid value for AuthenticationClass enum.")

@dataclass
class Replication:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	context: Optional[str] = None
	database_synchronizations: List['DatabaseSynchronization'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"context": self.context,
			"databaseSynchronizations": [x0.__serialize__() for x0 in self.database_synchronizations],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Replication':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			rev=deserialized_dict.get("rev"),
			deletion_date=deserialized_dict.get("deletionDate"),
			name=deserialized_dict.get("name"),
			context=deserialized_dict.get("context"),
			database_synchronizations=[DatabaseSynchronization._deserialize(x0) for x0 in deserialized_dict["databaseSynchronizations"]],
		)

@dataclass
class View:
	map: str
	reduce: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"map": self.map,
			"reduce": self.reduce,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'View':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			map=deserialized_dict["map"],
			reduce=deserialized_dict.get("reduce"),
		)

@dataclass
class DatabaseInfo:
	id: str
	update_seq: Optional[str] = None
	file_size: Optional[int] = None
	external_size: Optional[int] = None
	active_size: Optional[int] = None
	docs: Optional[int] = None
	q: Optional[int] = None
	n: Optional[int] = None
	w: Optional[int] = None
	r: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"updateSeq": self.update_seq,
			"fileSize": self.file_size,
			"externalSize": self.external_size,
			"activeSize": self.active_size,
			"docs": self.docs,
			"q": self.q,
			"n": self.n,
			"w": self.w,
			"r": self.r,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id=deserialized_dict["id"],
			update_seq=deserialized_dict.get("updateSeq"),
			file_size=deserialized_dict.get("fileSize"),
			external_size=deserialized_dict.get("externalSize"),
			active_size=deserialized_dict.get("activeSize"),
			docs=deserialized_dict.get("docs"),
			q=deserialized_dict.get("q"),
			n=deserialized_dict.get("n"),
			w=deserialized_dict.get("w"),
			r=deserialized_dict.get("r"),
		)

class Operator(Enum):
	Equal = "EQUAL"
	Notequal = "NOTEQUAL"
	Greaterthan = "GREATERTHAN"
	Smallerthan = "SMALLERTHAN"
	Greaterthanorequal = "GREATERTHANOREQUAL"
	Smallerthanorequal = "SMALLERTHANOREQUAL"
	Like = "LIKE"
	Ilike = "ILIKE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Operator':
		if data == "EQUAL":
			return Operator.Equal
		elif data == "NOTEQUAL":
			return Operator.Notequal
		elif data == "GREATERTHAN":
			return Operator.Greaterthan
		elif data == "SMALLERTHAN":
			return Operator.Smallerthan
		elif data == "GREATERTHANOREQUAL":
			return Operator.Greaterthanorequal
		elif data == "SMALLERTHANOREQUAL":
			return Operator.Smallerthanorequal
		elif data == "LIKE":
			return Operator.Like
		elif data == "ILIKE":
			return Operator.Ilike
		else:
			raise Exception(f"{data} is not a valid value for Operator enum.")

class PersonNameUse(Enum):
	Usual = "usual"
	Official = "official"
	Temp = "temp"
	Nickname = "nickname"
	Anonymous = "anonymous"
	Maiden = "maiden"
	Old = "old"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PersonNameUse':
		if data == "usual":
			return PersonNameUse.Usual
		elif data == "official":
			return PersonNameUse.Official
		elif data == "temp":
			return PersonNameUse.Temp
		elif data == "nickname":
			return PersonNameUse.Nickname
		elif data == "anonymous":
			return PersonNameUse.Anonymous
		elif data == "maiden":
			return PersonNameUse.Maiden
		elif data == "old":
			return PersonNameUse.Old
		elif data == "other":
			return PersonNameUse.Other
		else:
			raise Exception(f"{data} is not a valid value for PersonNameUse enum.")

class AddressType(Enum):
	Home = "home"
	Work = "work"
	Vacation = "vacation"
	Hospital = "hospital"
	Clinic = "clinic"
	Hq = "hq"
	Other = "other"
	Temporary = "temporary"
	Postal = "postal"
	Diplomatic = "diplomatic"
	Reference = "reference"
	Careaddress = "careaddress"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AddressType':
		if data == "home":
			return AddressType.Home
		elif data == "work":
			return AddressType.Work
		elif data == "vacation":
			return AddressType.Vacation
		elif data == "hospital":
			return AddressType.Hospital
		elif data == "clinic":
			return AddressType.Clinic
		elif data == "hq":
			return AddressType.Hq
		elif data == "other":
			return AddressType.Other
		elif data == "temporary":
			return AddressType.Temporary
		elif data == "postal":
			return AddressType.Postal
		elif data == "diplomatic":
			return AddressType.Diplomatic
		elif data == "reference":
			return AddressType.Reference
		elif data == "careaddress":
			return AddressType.Careaddress
		else:
			raise Exception(f"{data} is not a valid value for AddressType enum.")

@dataclass
class EncryptedTelecom:
	telecom_type: Optional['TelecomType'] = None
	telecom_number: Optional[str] = None
	telecom_description: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"telecomType": self.telecom_type.__serialize__() if self.telecom_type is not None else None,
			"telecomNumber": self.telecom_number,
			"telecomDescription": self.telecom_description,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedTelecom':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			telecom_type=TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number=deserialized_dict.get("telecomNumber"),
			telecom_description=deserialized_dict.get("telecomDescription"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedTelecom:
	telecom_type: Optional['TelecomType'] = None
	telecom_number: Optional[str] = None
	telecom_description: Optional[str] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"telecomType": self.telecom_type.__serialize__() if self.telecom_type is not None else None,
			"telecomNumber": self.telecom_number,
			"telecomDescription": self.telecom_description,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedTelecom':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			telecom_type=TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number=deserialized_dict.get("telecomNumber"),
			telecom_description=deserialized_dict.get("telecomDescription"),
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

Telecom = Union['EncryptedTelecom', 'DecryptedTelecom']

def serialize_telecom(telecom: Telecom) -> object:
	if isinstance(telecom, EncryptedTelecom):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedTelecom",
			"entity": telecom.__serialize__()
		}
	elif isinstance(telecom, DecryptedTelecom):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedTelecom",
			"entity": telecom.__serialize__()
		}
	else:
		raise Exception(f"{type(telecom)} is not a known subclass of Telecom")

def deserialize_telecom(data: Union[str, Dict[str, object]]) -> 'Telecom':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedTelecom":
		EncryptedTelecom._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedTelecom":
		DecryptedTelecom._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Telecom")

class PartnershipType(Enum):
	PrimaryContact = "primary_contact"
	PrimaryContactFor = "primary_contact_for"
	Family = "family"
	Friend = "friend"
	Counselor = "counselor"
	Contact = "contact"
	Brother = "brother"
	Brotherinlaw = "brotherinlaw"
	Child = "child"
	Daughter = "daughter"
	Employer = "employer"
	Father = "father"
	Grandchild = "grandchild"
	Grandparent = "grandparent"
	Husband = "husband"
	Lawyer = "lawyer"
	Mother = "mother"
	Neighbour = "neighbour"
	Notary = "notary"
	Partner = "partner"
	Sister = "sister"
	Sisterinlaw = "sisterinlaw"
	Son = "son"
	Spouse = "spouse"
	Stepdaughter = "stepdaughter"
	Stepfather = "stepfather"
	Stepmother = "stepmother"
	Stepson = "stepson"
	Tutor = "tutor"
	NextOfKin = "next_of_kin"
	FederalAgency = "federal_agency"
	InsuranceCompany = "insurance_company"
	StateAgency = "state_agency"
	Unknown = "unknown"
	Seealso = "seealso"
	Refer = "refer"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PartnershipType':
		if data == "primary_contact":
			return PartnershipType.PrimaryContact
		elif data == "primary_contact_for":
			return PartnershipType.PrimaryContactFor
		elif data == "family":
			return PartnershipType.Family
		elif data == "friend":
			return PartnershipType.Friend
		elif data == "counselor":
			return PartnershipType.Counselor
		elif data == "contact":
			return PartnershipType.Contact
		elif data == "brother":
			return PartnershipType.Brother
		elif data == "brotherinlaw":
			return PartnershipType.Brotherinlaw
		elif data == "child":
			return PartnershipType.Child
		elif data == "daughter":
			return PartnershipType.Daughter
		elif data == "employer":
			return PartnershipType.Employer
		elif data == "father":
			return PartnershipType.Father
		elif data == "grandchild":
			return PartnershipType.Grandchild
		elif data == "grandparent":
			return PartnershipType.Grandparent
		elif data == "husband":
			return PartnershipType.Husband
		elif data == "lawyer":
			return PartnershipType.Lawyer
		elif data == "mother":
			return PartnershipType.Mother
		elif data == "neighbour":
			return PartnershipType.Neighbour
		elif data == "notary":
			return PartnershipType.Notary
		elif data == "partner":
			return PartnershipType.Partner
		elif data == "sister":
			return PartnershipType.Sister
		elif data == "sisterinlaw":
			return PartnershipType.Sisterinlaw
		elif data == "son":
			return PartnershipType.Son
		elif data == "spouse":
			return PartnershipType.Spouse
		elif data == "stepdaughter":
			return PartnershipType.Stepdaughter
		elif data == "stepfather":
			return PartnershipType.Stepfather
		elif data == "stepmother":
			return PartnershipType.Stepmother
		elif data == "stepson":
			return PartnershipType.Stepson
		elif data == "tutor":
			return PartnershipType.Tutor
		elif data == "next_of_kin":
			return PartnershipType.NextOfKin
		elif data == "federal_agency":
			return PartnershipType.FederalAgency
		elif data == "insurance_company":
			return PartnershipType.InsuranceCompany
		elif data == "state_agency":
			return PartnershipType.StateAgency
		elif data == "unknown":
			return PartnershipType.Unknown
		elif data == "seealso":
			return PartnershipType.Seealso
		elif data == "refer":
			return PartnershipType.Refer
		else:
			raise Exception(f"{data} is not a valid value for PartnershipType enum.")

class PartnershipStatus(Enum):
	Active = "active"
	Complicated = "complicated"
	Past = "past"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PartnershipStatus':
		if data == "active":
			return PartnershipStatus.Active
		elif data == "complicated":
			return PartnershipStatus.Complicated
		elif data == "past":
			return PartnershipStatus.Past
		else:
			raise Exception(f"{data} is not a valid value for PartnershipStatus enum.")

class PatientHealthCarePartyType(Enum):
	Doctor = "doctor"
	Referral = "referral"
	Medicalhouse = "medicalhouse"
	Retirementhome = "retirementhome"
	Hospital = "hospital"
	Other = "other"
	Referringphysician = "referringphysician"
	Managingorganization = "managingorganization"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientHealthCarePartyType':
		if data == "doctor":
			return PatientHealthCarePartyType.Doctor
		elif data == "referral":
			return PatientHealthCarePartyType.Referral
		elif data == "medicalhouse":
			return PatientHealthCarePartyType.Medicalhouse
		elif data == "retirementhome":
			return PatientHealthCarePartyType.Retirementhome
		elif data == "hospital":
			return PatientHealthCarePartyType.Hospital
		elif data == "other":
			return PatientHealthCarePartyType.Other
		elif data == "referringphysician":
			return PatientHealthCarePartyType.Referringphysician
		elif data == "managingorganization":
			return PatientHealthCarePartyType.Managingorganization
		else:
			raise Exception(f"{data} is not a valid value for PatientHealthCarePartyType enum.")

@dataclass
class ReferralPeriod:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	comment: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"comment": self.comment,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReferralPeriod':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			comment=deserialized_dict.get("comment"),
		)

class ContractChangeType(Enum):
	InscriptionStart = "inscriptionStart"
	InscriptionEnd = "inscriptionEnd"
	Suspension = "suspension"
	CoverageChange = "coverageChange"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContractChangeType':
		if data == "inscriptionStart":
			return ContractChangeType.InscriptionStart
		elif data == "inscriptionEnd":
			return ContractChangeType.InscriptionEnd
		elif data == "suspension":
			return ContractChangeType.Suspension
		elif data == "coverageChange":
			return ContractChangeType.CoverageChange
		else:
			raise Exception(f"{data} is not a valid value for ContractChangeType enum.")

class SuspensionReason(Enum):
	NotInsured = "notInsured"
	NoReasonGiven = "noReasonGiven"
	IsHospitalized = "isHospitalized"
	OutsideOfCountry = "outsideOfCountry"
	ChangeOfMutuality = "changeOfMutuality"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SuspensionReason':
		if data == "notInsured":
			return SuspensionReason.NotInsured
		elif data == "noReasonGiven":
			return SuspensionReason.NoReasonGiven
		elif data == "isHospitalized":
			return SuspensionReason.IsHospitalized
		elif data == "outsideOfCountry":
			return SuspensionReason.OutsideOfCountry
		elif data == "changeOfMutuality":
			return SuspensionReason.ChangeOfMutuality
		else:
			raise Exception(f"{data} is not a valid value for SuspensionReason enum.")

class MhcSignatureType(Enum):
	HolderEid = "holderEid"
	HolderPaper = "holderPaper"
	LegalrepresentativeEid = "legalrepresentativeEid"
	LegalrepresentativePaper = "legalrepresentativePaper"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MhcSignatureType':
		if data == "holderEid":
			return MhcSignatureType.HolderEid
		elif data == "holderPaper":
			return MhcSignatureType.HolderPaper
		elif data == "legalrepresentativeEid":
			return MhcSignatureType.LegalrepresentativeEid
		elif data == "legalrepresentativePaper":
			return MhcSignatureType.LegalrepresentativePaper
		else:
			raise Exception(f"{data} is not a valid value for MhcSignatureType enum.")

@dataclass
class SecureDelegation:
	permissions: 'AccessLevel'
	delegator: Optional[str] = None
	delegate: Optional[str] = None
	secret_ids: List['Base64String'] = field(default_factory=list)
	encryption_keys: List['Base64String'] = field(default_factory=list)
	owning_entity_ids: List['Base64String'] = field(default_factory=list)
	parent_delegations: List['SecureDelegationKeyString'] = field(default_factory=list)
	exchange_data_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"delegator": self.delegator,
			"delegate": self.delegate,
			"secretIds": [x0 for x0 in self.secret_ids],
			"encryptionKeys": [x0 for x0 in self.encryption_keys],
			"owningEntityIds": [x0 for x0 in self.owning_entity_ids],
			"parentDelegations": [x0 for x0 in self.parent_delegations],
			"exchangeDataId": self.exchange_data_id,
			"permissions": self.permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecureDelegation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			delegator=deserialized_dict.get("delegator"),
			delegate=deserialized_dict.get("delegate"),
			secret_ids=[x0 for x0 in deserialized_dict["secretIds"]],
			encryption_keys=[x0 for x0 in deserialized_dict["encryptionKeys"]],
			owning_entity_ids=[x0 for x0 in deserialized_dict["owningEntityIds"]],
			parent_delegations=[x0 for x0 in deserialized_dict["parentDelegations"]],
			exchange_data_id=deserialized_dict.get("exchangeDataId"),
			permissions=AccessLevel._deserialize(deserialized_dict["permissions"]),
		)

@dataclass
class Employer:
	name: Optional[str] = None
	addresse: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"addresse": self.addresse.__serialize__() if self.addresse is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Employer':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict.get("name"),
			addresse=DecryptedAddress._deserialize(deserialized_dict.get("addresse")) if deserialized_dict.get("addresse") is not None else None,
		)

class FlatRateType(Enum):
	Physician = "physician"
	Physiotherapist = "physiotherapist"
	Nurse = "nurse"
	Ptd = "ptd"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FlatRateType':
		if data == "physician":
			return FlatRateType.Physician
		elif data == "physiotherapist":
			return FlatRateType.Physiotherapist
		elif data == "nurse":
			return FlatRateType.Nurse
		elif data == "ptd":
			return FlatRateType.Ptd
		else:
			raise Exception(f"{data} is not a valid value for FlatRateType enum.")

class TypedValuesType(Enum):
	Boolean = "BOOLEAN"
	Integer = "INTEGER"
	Double = "DOUBLE"
	String = "STRING"
	Date = "DATE"
	Clob = "CLOB"
	Json = "JSON"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TypedValuesType':
		if data == "BOOLEAN":
			return TypedValuesType.Boolean
		elif data == "INTEGER":
			return TypedValuesType.Integer
		elif data == "DOUBLE":
			return TypedValuesType.Double
		elif data == "STRING":
			return TypedValuesType.String
		elif data == "DATE":
			return TypedValuesType.Date
		elif data == "CLOB":
			return TypedValuesType.Clob
		elif data == "JSON":
			return TypedValuesType.Json
		else:
			raise Exception(f"{data} is not a valid value for TypedValuesType enum.")

@dataclass
class RemoteAuthentication:
	basic: Optional['Basic'] = None

	def __serialize__(self) -> object:
		return {
			"basic": self.basic.__serialize__() if self.basic is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RemoteAuthentication':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			basic=Basic._deserialize(deserialized_dict.get("basic")) if deserialized_dict.get("basic") is not None else None,
		)

@dataclass
class TimeTableHour:
	start_hour: Optional[int] = None
	end_hour: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"startHour": self.start_hour,
			"endHour": self.end_hour,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimeTableHour':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_hour=deserialized_dict.get("startHour"),
			end_hour=deserialized_dict.get("endHour"),
		)

@dataclass
class DelegateShareOptions:
	share_secret_ids: List[str]
	share_encryption_keys: List['HexString']
	share_owning_entity_ids: List[str]
	requested_permissions: 'RequestedPermission'

	def __serialize__(self) -> object:
		return {
			"shareSecretIds": [x0 for x0 in self.share_secret_ids],
			"shareEncryptionKeys": [x0 for x0 in self.share_encryption_keys],
			"shareOwningEntityIds": [x0 for x0 in self.share_owning_entity_ids],
			"requestedPermissions": self.requested_permissions.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DelegateShareOptions':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			share_secret_ids=[x0 for x0 in deserialized_dict["shareSecretIds"]],
			share_encryption_keys=[x0 for x0 in deserialized_dict["shareEncryptionKeys"]],
			share_owning_entity_ids=[x0 for x0 in deserialized_dict["shareOwningEntityIds"]],
			requested_permissions=RequestedPermission._deserialize(deserialized_dict["requestedPermissions"]),
		)

@dataclass
class ReferenceRange:
	low: Optional[float] = None
	high: Optional[float] = None
	string_value: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	notes: List['Annotation'] = field(default_factory=list)
	age: Optional['Range'] = None

	def __serialize__(self) -> object:
		return {
			"low": self.low,
			"high": self.high,
			"stringValue": self.string_value,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"age": self.age.__serialize__() if self.age is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReferenceRange':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low=deserialized_dict.get("low"),
			high=deserialized_dict.get("high"),
			string_value=deserialized_dict.get("stringValue"),
			tags=[CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes=[CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			notes=[Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			age=Range._deserialize(deserialized_dict.get("age")) if deserialized_dict.get("age") is not None else None,
		)

@dataclass
class Substanceproduct:
	intendedcds: List['CodeStub'] = field(default_factory=list)
	deliveredcds: List['CodeStub'] = field(default_factory=list)
	intendedname: Optional[str] = None
	deliveredname: Optional[str] = None
	product_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"intendedcds": [x0.__serialize__() for x0 in self.intendedcds],
			"deliveredcds": [x0.__serialize__() for x0 in self.deliveredcds],
			"intendedname": self.intendedname,
			"deliveredname": self.deliveredname,
			"productId": self.product_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Substanceproduct':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			intendedcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["intendedcds"]],
			deliveredcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["deliveredcds"]],
			intendedname=deserialized_dict.get("intendedname"),
			deliveredname=deserialized_dict.get("deliveredname"),
			product_id=deserialized_dict.get("productId"),
		)

@dataclass
class Medicinalproduct:
	intendedcds: List['CodeStub'] = field(default_factory=list)
	deliveredcds: List['CodeStub'] = field(default_factory=list)
	intendedname: Optional[str] = None
	deliveredname: Optional[str] = None
	product_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"intendedcds": [x0.__serialize__() for x0 in self.intendedcds],
			"deliveredcds": [x0.__serialize__() for x0 in self.deliveredcds],
			"intendedname": self.intendedname,
			"deliveredname": self.deliveredname,
			"productId": self.product_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Medicinalproduct':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			intendedcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["intendedcds"]],
			deliveredcds=[CodeStub._deserialize(x0) for x0 in deserialized_dict["deliveredcds"]],
			intendedname=deserialized_dict.get("intendedname"),
			deliveredname=deserialized_dict.get("deliveredname"),
			product_id=deserialized_dict.get("productId"),
		)

@dataclass
class Duration:
	value: Optional[float] = None
	unit: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"unit": self.unit.__serialize__() if self.unit is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Duration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value=deserialized_dict.get("value"),
			unit=CodeStub._deserialize(deserialized_dict.get("unit")) if deserialized_dict.get("unit") is not None else None,
		)

@dataclass
class Renewal:
	decimal: Optional[int] = None
	duration: Optional['Duration'] = None

	def __serialize__(self) -> object:
		return {
			"decimal": self.decimal,
			"duration": self.duration.__serialize__() if self.duration is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Renewal':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			decimal=deserialized_dict.get("decimal"),
			duration=Duration._deserialize(deserialized_dict.get("duration")) if deserialized_dict.get("duration") is not None else None,
		)

@dataclass
class RegimenItem:
	date: Optional[int] = None
	day_number: Optional[int] = None
	weekday: Optional['Weekday'] = None
	day_period: Optional['CodeStub'] = None
	time_of_day: Optional[int] = None
	administrated_quantity: Optional['AdministrationQuantity'] = None

	def __serialize__(self) -> object:
		return {
			"date": self.date,
			"dayNumber": self.day_number,
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"dayPeriod": self.day_period.__serialize__() if self.day_period is not None else None,
			"timeOfDay": self.time_of_day,
			"administratedQuantity": self.administrated_quantity.__serialize__() if self.administrated_quantity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegimenItem':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			date=deserialized_dict.get("date"),
			day_number=deserialized_dict.get("dayNumber"),
			weekday=Weekday._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			day_period=CodeStub._deserialize(deserialized_dict.get("dayPeriod")) if deserialized_dict.get("dayPeriod") is not None else None,
			time_of_day=deserialized_dict.get("timeOfDay"),
			administrated_quantity=AdministrationQuantity._deserialize(deserialized_dict.get("administratedQuantity")) if deserialized_dict.get("administratedQuantity") is not None else None,
		)

@dataclass
class ParagraphAgreement:
	timestamp: Optional[int] = None
	paragraph: Optional[str] = None
	accepted: Optional[bool] = None
	in_treatment: Optional[bool] = None
	canceled: Optional[bool] = None
	care_provider_reference: Optional[str] = None
	decision_reference: Optional[str] = None
	start: Optional[int] = None
	end: Optional[int] = None
	cancelation_date: Optional[int] = None
	quantity_value: Optional[float] = None
	quantity_unit: Optional[str] = None
	io_request_reference: Optional[str] = None
	response_type: Optional[str] = None
	refusal_justification: Optional[Dict[str, str]] = None
	verses: Optional[List[int]] = None
	coverage_type: Optional[str] = None
	unit_number: Optional[float] = None
	strength: Optional[float] = None
	strength_unit: Optional[str] = None
	agreement_appendices: Optional[List['AgreementAppendix']] = None
	document_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"timestamp": self.timestamp,
			"paragraph": self.paragraph,
			"accepted": self.accepted,
			"inTreatment": self.in_treatment,
			"canceled": self.canceled,
			"careProviderReference": self.care_provider_reference,
			"decisionReference": self.decision_reference,
			"start": self.start,
			"end": self.end,
			"cancelationDate": self.cancelation_date,
			"quantityValue": self.quantity_value,
			"quantityUnit": self.quantity_unit,
			"ioRequestReference": self.io_request_reference,
			"responseType": self.response_type,
			"refusalJustification": {k0: v0 for k0, v0 in self.refusal_justification.items()} if self.refusal_justification is not None else None,
			"verses": [x0 for x0 in self.verses] if self.verses is not None else None,
			"coverageType": self.coverage_type,
			"unitNumber": self.unit_number,
			"strength": self.strength,
			"strengthUnit": self.strength_unit,
			"agreementAppendices": [x0.__serialize__() for x0 in self.agreement_appendices] if self.agreement_appendices is not None else None,
			"documentId": self.document_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ParagraphAgreement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			timestamp=deserialized_dict.get("timestamp"),
			paragraph=deserialized_dict.get("paragraph"),
			accepted=deserialized_dict.get("accepted"),
			in_treatment=deserialized_dict.get("inTreatment"),
			canceled=deserialized_dict.get("canceled"),
			care_provider_reference=deserialized_dict.get("careProviderReference"),
			decision_reference=deserialized_dict.get("decisionReference"),
			start=deserialized_dict.get("start"),
			end=deserialized_dict.get("end"),
			cancelation_date=deserialized_dict.get("cancelationDate"),
			quantity_value=deserialized_dict.get("quantityValue"),
			quantity_unit=deserialized_dict.get("quantityUnit"),
			io_request_reference=deserialized_dict.get("ioRequestReference"),
			response_type=deserialized_dict.get("responseType"),
			refusal_justification=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("refusalJustification").items())) if deserialized_dict.get("refusalJustification") is not None else None,
			verses=[x0 for x0 in deserialized_dict.get("verses")] if deserialized_dict.get("verses") is not None else None,
			coverage_type=deserialized_dict.get("coverageType"),
			unit_number=deserialized_dict.get("unitNumber"),
			strength=deserialized_dict.get("strength"),
			strength_unit=deserialized_dict.get("strengthUnit"),
			agreement_appendices=[AgreementAppendix._deserialize(x0) for x0 in deserialized_dict.get("agreementAppendices")] if deserialized_dict.get("agreementAppendices") is not None else None,
			document_id=deserialized_dict.get("documentId"),
		)

@dataclass
class Suspension:
	begin_moment: Optional[int] = None
	end_moment: Optional[int] = None
	suspension_reason: Optional[str] = None
	lifecycle: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"beginMoment": self.begin_moment,
			"endMoment": self.end_moment,
			"suspensionReason": self.suspension_reason,
			"lifecycle": self.lifecycle,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Suspension':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			begin_moment=deserialized_dict.get("beginMoment"),
			end_moment=deserialized_dict.get("endMoment"),
			suspension_reason=deserialized_dict.get("suspensionReason"),
			lifecycle=deserialized_dict.get("lifecycle"),
		)

@dataclass
class Action:
	launchers: Optional[List['Launcher']] = field(default_factory=list)
	expression: Optional[str] = None
	states: Optional[List['State']] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"launchers": [x0.__serialize__() for x0 in self.launchers] if self.launchers is not None else None,
			"expression": self.expression,
			"states": [x0.__serialize__() for x0 in self.states] if self.states is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Action':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			launchers=[Launcher._deserialize(x0) for x0 in deserialized_dict.get("launchers")] if deserialized_dict.get("launchers") is not None else None,
			expression=deserialized_dict.get("expression"),
			states=[State._deserialize(x0) for x0 in deserialized_dict.get("states")] if deserialized_dict.get("states") is not None else None,
		)

@dataclass
class Section:
	section: str
	fields: List['StructureElement']
	description: Optional[str] = None
	keywords: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"section": self.section,
			"fields": [serialize_structure_element(x0) for x0 in self.fields],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Section':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			section=deserialized_dict["section"],
			fields=[deserialize_structure_element(x0) for x0 in deserialized_dict["fields"]],
			description=deserialized_dict.get("description"),
			keywords=[x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

@dataclass
class DecryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCareTeamMembership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			care_team_member_id=deserialized_dict.get("careTeamMemberId"),
			membership_type=MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCareTeamMembership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date=deserialized_dict.get("startDate"),
			end_date=deserialized_dict.get("endDate"),
			care_team_member_id=deserialized_dict.get("careTeamMemberId"),
			membership_type=MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self=deserialized_dict.get("encryptedSelf"),
		)

CareTeamMembership = Union['DecryptedCareTeamMembership', 'EncryptedCareTeamMembership']

def serialize_care_team_membership(care_team_membership: CareTeamMembership) -> object:
	if isinstance(care_team_membership, DecryptedCareTeamMembership):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedCareTeamMembership",
			"entity": care_team_membership.__serialize__()
		}
	elif isinstance(care_team_membership, EncryptedCareTeamMembership):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedCareTeamMembership",
			"entity": care_team_membership.__serialize__()
		}
	else:
		raise Exception(f"{type(care_team_membership)} is not a known subclass of CareTeamMembership")

def deserialize_care_team_membership(data: Union[str, Dict[str, object]]) -> 'CareTeamMembership':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedCareTeamMembership":
		DecryptedCareTeamMembership._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedCareTeamMembership":
		EncryptedCareTeamMembership._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMembership")

class CareTeamMemberType(Enum):
	Physician = "physician"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CareTeamMemberType':
		if data == "physician":
			return CareTeamMemberType.Physician
		elif data == "specialist":
			return CareTeamMemberType.Specialist
		elif data == "other":
			return CareTeamMemberType.Other
		else:
			raise Exception(f"{data} is not a valid value for CareTeamMemberType enum.")

@dataclass
class ServiceLink:
	service_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"serviceId": self.service_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceLink':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			service_id=deserialized_dict.get("serviceId"),
		)

@dataclass
class DatabaseSynchronization:
	source: Optional[str] = None
	target: Optional[str] = None
	filter: Optional[str] = None
	local_target: Optional['DatabaseSynchronization.Target'] = None

	class Target(Enum):
		Base = "base"
		Healthdata = "healthdata"
		Patient = "patient"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseSynchronization.Target':
			if data == "base":
				return DatabaseSynchronization.Target.Base
			elif data == "healthdata":
				return DatabaseSynchronization.Target.Healthdata
			elif data == "patient":
				return DatabaseSynchronization.Target.Patient
			else:
				raise Exception(f"{data} is not a valid value for Target enum.")

	def __serialize__(self) -> object:
		return {
			"source": self.source,
			"target": self.target,
			"filter": self.filter,
			"localTarget": self.local_target.__serialize__() if self.local_target is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseSynchronization':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source=deserialized_dict.get("source"),
			target=deserialized_dict.get("target"),
			filter=deserialized_dict.get("filter"),
			local_target=DatabaseSynchronization.Target._deserialize(deserialized_dict.get("localTarget")) if deserialized_dict.get("localTarget") is not None else None,
		)

@dataclass
class Basic:
	username: str
	password: str

	def __serialize__(self) -> object:
		return {
			"username": self.username,
			"password": self.password,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Basic':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			username=deserialized_dict["username"],
			password=deserialized_dict["password"],
		)

@dataclass
class Range:
	low: Optional[float] = None
	high: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"low": self.low,
			"high": self.high,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Range':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low=deserialized_dict.get("low"),
			high=deserialized_dict.get("high"),
		)

@dataclass
class Weekday:
	weekday: Optional['CodeStub'] = None
	week_number: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"weekday": self.weekday.__serialize__() if self.weekday is not None else None,
			"weekNumber": self.week_number,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Weekday':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			weekday=CodeStub._deserialize(deserialized_dict.get("weekday")) if deserialized_dict.get("weekday") is not None else None,
			week_number=deserialized_dict.get("weekNumber"),
		)

@dataclass
class AdministrationQuantity:
	quantity: Optional[float] = None
	administration_unit: Optional['CodeStub'] = None
	unit: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"quantity": self.quantity,
			"administrationUnit": self.administration_unit.__serialize__() if self.administration_unit is not None else None,
			"unit": self.unit,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AdministrationQuantity':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			quantity=deserialized_dict.get("quantity"),
			administration_unit=CodeStub._deserialize(deserialized_dict.get("administrationUnit")) if deserialized_dict.get("administrationUnit") is not None else None,
			unit=deserialized_dict.get("unit"),
		)

@dataclass
class AgreementAppendix:
	doc_seq: Optional[int] = None
	verse_seq: Optional[int] = None
	document_id: Optional[str] = None
	path: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"docSeq": self.doc_seq,
			"verseSeq": self.verse_seq,
			"documentId": self.document_id,
			"path": self.path,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AgreementAppendix':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			doc_seq=deserialized_dict.get("docSeq"),
			verse_seq=deserialized_dict.get("verseSeq"),
			document_id=deserialized_dict.get("documentId"),
			path=deserialized_dict.get("path"),
		)

@dataclass
class Launcher:
	name: str
	triggerer: 'Trigger'
	should_pass_value: bool = False

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"triggerer": self.triggerer.__serialize__(),
			"shouldPassValue": self.should_pass_value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Launcher':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict["name"],
			triggerer=Trigger._deserialize(deserialized_dict["triggerer"]),
			should_pass_value=deserialized_dict["shouldPassValue"],
		)

@dataclass
class State:
	name: str
	state_to_update: 'StateToUpdate'
	can_launch_launcher: bool = False

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"stateToUpdate": self.state_to_update.__serialize__(),
			"canLaunchLauncher": self.can_launch_launcher,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'State':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name=deserialized_dict["name"],
			state_to_update=StateToUpdate._deserialize(deserialized_dict["stateToUpdate"]),
			can_launch_launcher=deserialized_dict["canLaunchLauncher"],
		)

@dataclass
class DropdownField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DropdownField':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class RadioButton:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RadioButton':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class DatePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatePicker':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class TimePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TimePicker':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class DateTimePicker:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DateTimePicker':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class NumberField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'NumberField':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class TextField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TextField':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class CheckBox:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CheckBox':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class MultipleChoice:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MultipleChoice':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class MeasureField:
	field: str
	short_label: Optional[str] = None
	rows: Optional[int] = None
	columns: Optional[int] = None
	grows: Optional[bool] = None
	multiline: Optional[bool] = None
	schema: Optional[str] = None
	tags: Optional[List[str]] = None
	codifications: Optional[List[str]] = None
	options: Optional[Dict[str, str]] = None
	labels: Optional[Dict[str, str]] = None
	value: Optional[str] = None
	unit: Optional[str] = None
	required: Optional[bool] = None
	hide_condition: Optional[str] = None
	now: Optional[bool] = None
	translate: Optional[bool] = None

	def __serialize__(self) -> object:
		return {
			"field": self.field,
			"shortLabel": self.short_label,
			"rows": self.rows,
			"columns": self.columns,
			"grows": self.grows,
			"multiline": self.multiline,
			"schema": self.schema,
			"tags": [x0 for x0 in self.tags] if self.tags is not None else None,
			"codifications": [x0 for x0 in self.codifications] if self.codifications is not None else None,
			"options": {k0: v0 for k0, v0 in self.options.items()} if self.options is not None else None,
			"labels": {k0: v0 for k0, v0 in self.labels.items()} if self.labels is not None else None,
			"value": self.value,
			"unit": self.unit,
			"required": self.required,
			"hideCondition": self.hide_condition,
			"now": self.now,
			"translate": self.translate,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MeasureField':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			field=deserialized_dict["field"],
			short_label=deserialized_dict.get("shortLabel"),
			rows=deserialized_dict.get("rows"),
			columns=deserialized_dict.get("columns"),
			grows=deserialized_dict.get("grows"),
			multiline=deserialized_dict.get("multiline"),
			schema=deserialized_dict.get("schema"),
			tags=[x0 for x0 in deserialized_dict.get("tags")] if deserialized_dict.get("tags") is not None else None,
			codifications=[x0 for x0 in deserialized_dict.get("codifications")] if deserialized_dict.get("codifications") is not None else None,
			options=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("options").items())) if deserialized_dict.get("options") is not None else None,
			labels=dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("labels").items())) if deserialized_dict.get("labels") is not None else None,
			value=deserialized_dict.get("value"),
			unit=deserialized_dict.get("unit"),
			required=deserialized_dict.get("required"),
			hide_condition=deserialized_dict.get("hideCondition"),
			now=deserialized_dict.get("now"),
			translate=deserialized_dict.get("translate"),
		)

@dataclass
class FieldsGroup:
	group: str
	fields: Optional[List['StructureElement']] = None

	def __serialize__(self) -> object:
		return {
			"group": self.group,
			"fields": [serialize_structure_element(x0) for x0 in self.fields] if self.fields is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FieldsGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group=deserialized_dict["group"],
			fields=[deserialize_structure_element(x0) for x0 in deserialized_dict.get("fields")] if deserialized_dict.get("fields") is not None else None,
		)

StructureElement = Union['DropdownField', 'RadioButton', 'DatePicker', 'TimePicker', 'DateTimePicker', 'NumberField', 'TextField', 'CheckBox', 'MultipleChoice', 'MeasureField', 'FieldsGroup']

def serialize_structure_element(structure_element: StructureElement) -> object:
	if isinstance(structure_element, DropdownField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DropdownField"})
		return serialized_entity
	elif isinstance(structure_element, RadioButton):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.RadioButton"})
		return serialized_entity
	elif isinstance(structure_element, DatePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DatePicker"})
		return serialized_entity
	elif isinstance(structure_element, TimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.TimePicker"})
		return serialized_entity
	elif isinstance(structure_element, DateTimePicker):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.DateTimePicker"})
		return serialized_entity
	elif isinstance(structure_element, NumberField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.NumberField"})
		return serialized_entity
	elif isinstance(structure_element, TextField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.TextField"})
		return serialized_entity
	elif isinstance(structure_element, CheckBox):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.CheckBox"})
		return serialized_entity
	elif isinstance(structure_element, MultipleChoice):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.MultipleChoice"})
		return serialized_entity
	elif isinstance(structure_element, MeasureField):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.MeasureField"})
		return serialized_entity
	elif isinstance(structure_element, FieldsGroup):
		serialized_entity = structure_element.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.embed.form.template.FieldsGroup"})
		return serialized_entity
	else:
		raise Exception(f"{type(structure_element)} is not a known subclass of StructureElement")

def deserialize_structure_element(data: Union[str, Dict[str, object]]) -> 'StructureElement':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.form.template.DropdownField":
		return DropdownField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.RadioButton":
		return RadioButton._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.DatePicker":
		return DatePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.TimePicker":
		return TimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.DateTimePicker":
		return DateTimePicker._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.NumberField":
		return NumberField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.TextField":
		return TextField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.CheckBox":
		return CheckBox._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.MultipleChoice":
		return MultipleChoice._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.MeasureField":
		return MeasureField._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.embed.form.template.FieldsGroup":
		return FieldsGroup._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of StructureElement")

class MembershipType(Enum):
	Doctor = "doctor"
	Mutuality = "mutuality"
	Patient = "patient"
	Specialist = "specialist"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MembershipType':
		if data == "doctor":
			return MembershipType.Doctor
		elif data == "mutuality":
			return MembershipType.Mutuality
		elif data == "patient":
			return MembershipType.Patient
		elif data == "specialist":
			return MembershipType.Specialist
		elif data == "other":
			return MembershipType.Other
		else:
			raise Exception(f"{data} is not a valid value for MembershipType enum.")

class Trigger(Enum):
	Init = "INIT"
	Change = "CHANGE"
	Click = "CLICK"
	Visible = "VISIBLE"
	Error = "ERROR"
	Valid = "VALID"
	Event = "EVENT"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Trigger':
		if data == "INIT":
			return Trigger.Init
		elif data == "CHANGE":
			return Trigger.Change
		elif data == "CLICK":
			return Trigger.Click
		elif data == "VISIBLE":
			return Trigger.Visible
		elif data == "ERROR":
			return Trigger.Error
		elif data == "VALID":
			return Trigger.Valid
		elif data == "EVENT":
			return Trigger.Event
		else:
			raise Exception(f"{data} is not a valid value for Trigger enum.")

class StateToUpdate(Enum):
	Value = "VALUE"
	Visible = "VISIBLE"
	Readonly = "READONLY"
	Clazz = "CLAZZ"
	Required = "REQUIRED"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'StateToUpdate':
		if data == "VALUE":
			return StateToUpdate.Value
		elif data == "VISIBLE":
			return StateToUpdate.Visible
		elif data == "READONLY":
			return StateToUpdate.Readonly
		elif data == "CLAZZ":
			return StateToUpdate.Clazz
		elif data == "REQUIRED":
			return StateToUpdate.Required
		else:
			raise Exception(f"{data} is not a valid value for StateToUpdate enum.")
