import json
from typing import Union, Dict, Optional
from dataclasses import field, dataclass
from model.specializations.Base64String import Base64String

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
			parameters = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation = deserialized_dict.get("hospitalisation"),
			ambulatory = deserialized_dict.get("ambulatory"),
			dental = deserialized_dict.get("dental"),
			identification_number = deserialized_dict.get("identificationNumber"),
			insurance_id = deserialized_dict.get("insuranceId"),
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			titulary_id = deserialized_dict.get("titularyId"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			parameters = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["parameters"].items())),
			hospitalisation = deserialized_dict.get("hospitalisation"),
			ambulatory = deserialized_dict.get("ambulatory"),
			dental = deserialized_dict.get("dental"),
			identification_number = deserialized_dict.get("identificationNumber"),
			insurance_id = deserialized_dict.get("insuranceId"),
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			titulary_id = deserialized_dict.get("titularyId"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Insurability','serialize_insurability','deserialize_insurability','DecryptedInsurability','EncryptedInsurability']