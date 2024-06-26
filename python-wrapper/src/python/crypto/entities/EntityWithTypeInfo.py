import json
from crypto.entities.EntityWithEncryptionMetadataTypeName import EntityWithEncryptionMetadataTypeName
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class EntityWithTypeInfo:
	entity: object
	type: 'EntityWithEncryptionMetadataTypeName'

	def __serialize__(self) -> object:
		return {
			"entity": self.entity.__serialize__(),
			"type": self.type.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithTypeInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			entity = deserialized_dict["entity"],
			type = EntityWithEncryptionMetadataTypeName._deserialize(deserialized_dict["type"]),
		)

__all__ = ['EntityWithTypeInfo']