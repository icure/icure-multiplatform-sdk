import json
from typing import Optional, Dict, Union
from dataclasses import dataclass

@dataclass
class CodeStub:
	id: Optional[str] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	context_label: Optional[str] = None
	label: Optional[Dict[str, str]] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"contextLabel": self.context_label,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeStub':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			context = deserialized_dict.get("context"),
			type = deserialized_dict.get("type"),
			code = deserialized_dict.get("code"),
			version = deserialized_dict.get("version"),
			context_label = deserialized_dict.get("contextLabel"),
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
		)

__all__ = ['CodeStub']