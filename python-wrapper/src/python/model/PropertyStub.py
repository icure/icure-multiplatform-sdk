import json
from typing import Union, Dict, Optional
from model.PropertyTypeStub import PropertyTypeStub
from model.embed.TypedValue import EncryptedTypedValue, DecryptedTypedValue
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

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
			id = deserialized_dict.get("id"),
			type = PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value = EncryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			deletion_date = deserialized_dict.get("deletionDate"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			id = deserialized_dict.get("id"),
			type = PropertyTypeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			typed_value = DecryptedTypedValue._deserialize(deserialized_dict.get("typedValue")) if deserialized_dict.get("typedValue") is not None else None,
			deletion_date = deserialized_dict.get("deletionDate"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['PropertyStub','serialize_property_stub','deserialize_property_stub','EncryptedPropertyStub','DecryptedPropertyStub']