import json
from typing import Union, Dict, List
from dataclasses import dataclass
from crypto.entities.FailedRequestDetails import FailedRequestDetails

SimpleShareResult = Union['SimpleShareResultSuccess', 'SimpleShareResultFailure']

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
		SimpleShareResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SimpleShareResult.Failure":
		SimpleShareResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SimpleShareResult")

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
			updated_entity = deserialized_dict["updatedEntity"],
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
			errors_details = [FailedRequestDetails._deserialize(x0) for x0 in deserialized_dict["errorsDetails"]],
		)

__all__ = ['SimpleShareResult','serialize_simple_share_result','deserialize_simple_share_result','SimpleShareResultSuccess','SimpleShareResultFailure']