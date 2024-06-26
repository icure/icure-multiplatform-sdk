import json
from typing import Optional, Union, Dict
from model.embed.TypedValuesType import TypedValuesType
from dataclasses import dataclass

@dataclass
class PropertyTypeStub:
	identifier: Optional[str] = None
	type: Optional['TypedValuesType'] = None

	def __serialize__(self) -> object:
		return {
			"identifier": self.identifier,
			"type": self.type.__serialize__() if self.type is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PropertyTypeStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			identifier = deserialized_dict.get("identifier"),
			type = TypedValuesType._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
		)

__all__ = ['PropertyTypeStub']