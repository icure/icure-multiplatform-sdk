import json
from typing import Union, Dict, List
from crypto.entities.UseAnyConfidential import SecretIdOptionUseAnyConfidential
from crypto.entities.UseAnySharedWithParent import SecretIdOptionUseAnySharedWithParent
from dataclasses import dataclass

SecretIdOption = Union['SecretIdOptionUseAnyConfidential', 'SecretIdOptionUseAnySharedWithParent', 'SecretIdOptionUse']

def serialize_secret_id_option(secret_id_option: SecretIdOption) -> object:
	if instanceof(secret_id_option, SecretIdOptionUseAnyConfidential):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential"})
		return serialized_entity
	elif instanceof(secret_id_option, SecretIdOptionUseAnySharedWithParent):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent"})
		return serialized_entity
	elif instanceof(secret_id_option, SecretIdOptionUse):
		serialized_entity = secret_id_option.__serialize__()
		serialized_entity.update({"type": "com.icure.sdk.crypto.entities.SecretIdOption.Use"})
		return serialized_entity
	else:
		raise Exception(f"{type(secret_id_option)} is not a known subclass of SecretIdOption")

def deserialize_secret_id_option(data: Union[str, Dict[str, object]]) -> 'SecretIdOption':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential":
		SecretIdOptionUseAnyConfidential._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent":
		SecretIdOptionUseAnySharedWithParent._deserialize(deserialized_dict)
	elif qualifier == "com.icure.sdk.crypto.entities.SecretIdOption.Use":
		SecretIdOptionUse._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of SecretIdOption")

@dataclass
class SecretIdOptionUse:
	secret_ids: List[str]

	def __serialize__(self) -> object:
		return {
			"secretIds": [x0 for x0 in self.secret_ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SecretIdOptionUse':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret_ids = [x0 for x0 in deserialized_dict["secretIds"]],
		)

__all__ = ['SecretIdOption','serialize_secret_id_option','deserialize_secret_id_option','SecretIdOptionUse']