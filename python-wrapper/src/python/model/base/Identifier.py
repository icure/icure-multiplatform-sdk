import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class Identifier:
	id: Optional[str] = None
	assigner: Optional[str] = None
	start: Optional[str] = None
	end: Optional[str] = None
	system: Optional[str] = None
	type: Optional['CodeStub'] = None
	use: Optional[str] = None
	value: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"assigner": self.assigner,
			"start": self.start,
			"end": self.end,
			"system": self.system,
			"type": self.type.__serialize__() if self.type is not None else None,
			"use": self.use,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Identifier':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			assigner = deserialized_dict.get("assigner"),
			start = deserialized_dict.get("start"),
			end = deserialized_dict.get("end"),
			system = deserialized_dict.get("system"),
			type = CodeStub._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			use = deserialized_dict.get("use"),
			value = deserialized_dict.get("value"),
		)

__all__ = ['Identifier']