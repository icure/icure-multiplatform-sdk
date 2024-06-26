import json
from typing import Union, Dict, Optional
from model.embed.TelecomType import TelecomType
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

Telecom = Union['EncryptedTelecom', 'DecryptedTelecom']

def serialize_telecom(telecom: Telecom) -> object:
	if instanceof(telecom, EncryptedTelecom):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedTelecom",
			"entity": telecom.__serialize__()
		}
	elif instanceof(telecom, DecryptedTelecom):
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
			telecom_type = TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number = deserialized_dict.get("telecomNumber"),
			telecom_description = deserialized_dict.get("telecomDescription"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
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
			telecom_type = TelecomType._deserialize(deserialized_dict.get("telecomType")) if deserialized_dict.get("telecomType") is not None else None,
			telecom_number = deserialized_dict.get("telecomNumber"),
			telecom_description = deserialized_dict.get("telecomDescription"),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Telecom','serialize_telecom','deserialize_telecom','EncryptedTelecom','DecryptedTelecom']