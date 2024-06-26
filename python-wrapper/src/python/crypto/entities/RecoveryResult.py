import json
from typing import Union, Dict
from dataclasses import dataclass
from crypto.entities.RecoveryDataUseFailureReason import RecoveryDataUseFailureReason

RecoveryResult = Union['RecoveryResultSuccess', 'RecoveryResultFailure']

def serialize_recovery_result(recovery_result: RecoveryResult) -> object:
	if instanceof(recovery_result, RecoveryResultSuccess):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Success"})
		return serialized_entity
	elif instanceof(recovery_result, RecoveryResultFailure):
		serialized_entity = recovery_result.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.RecoveryResult.Failure"})
		return serialized_entity
	else:
		raise Exception(f"{type(recovery_result)} is not a known subclass of RecoveryResult")

def deserialize_recovery_result(data: Union[str, Dict[str, object]]) -> 'RecoveryResult':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Success":
		RecoveryResultSuccess._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.RecoveryResult.Failure":
		RecoveryResultFailure._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of RecoveryResult")

@dataclass
class RecoveryResultSuccess:
	data: object

	def __serialize__(self) -> object:
		return {
			"data": self.data.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultSuccess':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			data = deserialized_dict["data"],
		)

@dataclass
class RecoveryResultFailure:
	reason: 'RecoveryDataUseFailureReason'

	def __serialize__(self) -> object:
		return {
			"reason": self.reason.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryResultFailure':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			reason = RecoveryDataUseFailureReason._deserialize(deserialized_dict["reason"]),
		)

__all__ = ['RecoveryResult','serialize_recovery_result','deserialize_recovery_result','RecoveryResultSuccess','RecoveryResultFailure']