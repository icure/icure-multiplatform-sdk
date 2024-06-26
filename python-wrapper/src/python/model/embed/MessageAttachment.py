import json
from typing import Optional, List, Union, Dict
from model.embed.DocumentLocation import DocumentLocation
from dataclasses import field, dataclass

@dataclass
class MessageAttachment:
	type: Optional['DocumentLocation'] = None
	ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__() if self.type is not None else None,
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = DocumentLocation._deserialize(deserialized_dict.get("type")) if deserialized_dict.get("type") is not None else None,
			ids = [x0 for x0 in deserialized_dict["ids"]],
		)

__all__ = ['MessageAttachment']