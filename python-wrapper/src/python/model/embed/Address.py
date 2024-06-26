import json
from typing import Union, Dict, Optional, List
from model.embed.AddressType import AddressType
from model.embed.Annotation import Annotation
from dataclasses import field, dataclass
from model.embed.Telecom import EncryptedTelecom, DecryptedTelecom
from model.specializations.Base64String import Base64String

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
			address_type = AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr = deserialized_dict.get("descr"),
			street = deserialized_dict.get("street"),
			house_number = deserialized_dict.get("houseNumber"),
			postbox_number = deserialized_dict.get("postboxNumber"),
			postal_code = deserialized_dict.get("postalCode"),
			city = deserialized_dict.get("city"),
			state = deserialized_dict.get("state"),
			country = deserialized_dict.get("country"),
			note = deserialized_dict.get("note"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms = [EncryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			address_type = AddressType._deserialize(deserialized_dict.get("addressType")) if deserialized_dict.get("addressType") is not None else None,
			descr = deserialized_dict.get("descr"),
			street = deserialized_dict.get("street"),
			house_number = deserialized_dict.get("houseNumber"),
			postbox_number = deserialized_dict.get("postboxNumber"),
			postal_code = deserialized_dict.get("postalCode"),
			city = deserialized_dict.get("city"),
			state = deserialized_dict.get("state"),
			country = deserialized_dict.get("country"),
			note = deserialized_dict.get("note"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			telecoms = [DecryptedTelecom._deserialize(x0) for x0 in deserialized_dict["telecoms"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Address','serialize_address','deserialize_address','EncryptedAddress','DecryptedAddress']