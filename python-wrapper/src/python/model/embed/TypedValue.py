import json
from typing import Union, Dict, Optional
from model.embed.TypedValuesType import TypedValuesType
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

TypedValue = Union['DecryptedTypedValue', 'EncryptedTypedValue']

def serialize_typed_value(typed_value: TypedValue) -> object:
	if instanceof(typed_value, DecryptedTypedValue):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedTypedValue",
			"entity": typed_value.__serialize__()
		}
	elif instanceof(typed_value, EncryptedTypedValue):
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
			type = TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value = deserialized_dict.get("booleanValue"),
			integer_value = deserialized_dict.get("integerValue"),
			double_value = deserialized_dict.get("doubleValue"),
			string_value = deserialized_dict.get("stringValue"),
			date_value = deserialized_dict.get("dateValue"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			type = TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			boolean_value = deserialized_dict.get("booleanValue"),
			integer_value = deserialized_dict.get("integerValue"),
			double_value = deserialized_dict.get("doubleValue"),
			string_value = deserialized_dict.get("stringValue"),
			date_value = deserialized_dict.get("dateValue"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['TypedValue','serialize_typed_value','deserialize_typed_value','DecryptedTypedValue','EncryptedTypedValue']