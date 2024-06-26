import json
from typing import List, Dict, Optional, Union
from model.specializations.SpkiHexString import SpkiHexString
from model.specializations.HexString import HexString
from dataclasses import field, dataclass
from model.specializations.AesExchangeKeyEncryptionKeypairIdentifier import AesExchangeKeyEncryptionKeypairIdentifier
from model.base.CodeStub import CodeStub

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
			id = deserialized_dict["id"],
			rev = deserialized_dict["rev"],
			hc_party_keys = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key = deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256 = [x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
		)

__all__ = ['CryptoActorStub']