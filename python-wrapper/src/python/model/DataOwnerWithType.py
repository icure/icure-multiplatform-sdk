import json
from typing import Union, Dict
from model.HealthcareParty import HealthcareParty
from dataclasses import dataclass
from model.Patient import EncryptedPatient
from model.Device import Device

DataOwnerWithType = Union['DataOwnerWithTypeHcpDataOwner', 'DataOwnerWithTypePatientDataOwner', 'DataOwnerWithTypeDeviceDataOwner']

def serialize_data_owner_with_type(data_owner_with_type: DataOwnerWithType) -> object:
	if instanceof(data_owner_with_type, DataOwnerWithTypeHcpDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.DataOwnerWithType.HcpDataOwner"})
		return serialized_entity
	elif instanceof(data_owner_with_type, DataOwnerWithTypePatientDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.DataOwnerWithType.PatientDataOwner"})
		return serialized_entity
	elif instanceof(data_owner_with_type, DataOwnerWithTypeDeviceDataOwner):
		serialized_entity = data_owner_with_type.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.model.DataOwnerWithType.DeviceDataOwner"})
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
	if qualifier == "com.icure.sdk.model.DataOwnerWithType.HcpDataOwner":
		DataOwnerWithTypeHcpDataOwner._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.DataOwnerWithType.PatientDataOwner":
		DataOwnerWithTypePatientDataOwner._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.model.DataOwnerWithType.DeviceDataOwner":
		DataOwnerWithTypeDeviceDataOwner._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of DataOwnerWithType")

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
			data_owner = HealthcareParty._deserialize(deserialized_dict["dataOwner"]),
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
			data_owner = EncryptedPatient._deserialize(deserialized_dict["dataOwner"]),
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
			data_owner = Device._deserialize(deserialized_dict["dataOwner"]),
		)

__all__ = ['DataOwnerWithType','serialize_data_owner_with_type','deserialize_data_owner_with_type','DataOwnerWithTypeHcpDataOwner','DataOwnerWithTypePatientDataOwner','DataOwnerWithTypeDeviceDataOwner']