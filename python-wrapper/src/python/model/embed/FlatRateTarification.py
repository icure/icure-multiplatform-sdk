import json
from typing import Union, Dict, Optional, List
from model.embed.FlatRateType import FlatRateType
from model.embed.Valorisation import EncryptedValorisation, DecryptedValorisation
from dataclasses import field, dataclass
from model.specializations.Base64String import Base64String

FlatRateTarification = Union['EncryptedFlatRateTarification', 'DecryptedFlatRateTarification']

def serialize_flat_rate_tarification(flat_rate_tarification: FlatRateTarification) -> object:
	if instanceof(flat_rate_tarification, EncryptedFlatRateTarification):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedFlatRateTarification",
			"entity": flat_rate_tarification.__serialize__()
		}
	elif instanceof(flat_rate_tarification, DecryptedFlatRateTarification):
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
			code = deserialized_dict.get("code"),
			flat_rate_type = FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations = [EncryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			code = deserialized_dict.get("code"),
			flat_rate_type = FlatRateType._deserialize(deserialized_dict.get("flatRateType")) if deserialized_dict.get("flatRateType") is not None else None,
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			valorisations = [DecryptedValorisation._deserialize(x0) for x0 in deserialized_dict["valorisations"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['FlatRateTarification','serialize_flat_rate_tarification','deserialize_flat_rate_tarification','EncryptedFlatRateTarification','DecryptedFlatRateTarification']