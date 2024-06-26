import json
from typing import Optional, Dict, Union
from dataclasses import dataclass

@dataclass
class IndexingInfo:
	statuses: Optional[Dict[str, int]] = None

	def __serialize__(self) -> object:
		return {
			"statuses": {k0: v0 for k0, v0 in self.statuses.items()} if self.statuses is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IndexingInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			statuses = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("statuses").items())) if deserialized_dict.get("statuses") is not None else None,
		)

__all__ = ['IndexingInfo']