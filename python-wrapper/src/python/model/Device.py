import base64
import json
from typing import Optional, List, Dict, Union
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.base.CodeStub import CodeStub
from model.PropertyStub import DecryptedPropertyStub
from model.specializations.HexString import HexString
from model.specializations.SpkiHexString import SpkiHexString
from model.specializations.AesExchangeKeyEncryptionKeypairIdentifier import AesExchangeKeyEncryptionKeypairIdentifier

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
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			external_id = deserialized_dict.get("externalId"),
			name = deserialized_dict.get("name"),
			type = deserialized_dict.get("type"),
			brand = deserialized_dict.get("brand"),
			model = deserialized_dict.get("model"),
			serial_number = deserialized_dict.get("serialNumber"),
			parent_id = deserialized_dict.get("parentId"),
			picture = bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key = deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256 = [x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
		)

__all__ = ['Device']