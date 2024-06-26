import json
from typing import Optional, Dict, Union
from dataclasses import dataclass

@dataclass
class PaginatedDocumentKeyIdPair:
	start_key: Optional[Dict[str, object]] = None
	start_key_doc_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"startKey": {k0: v0 for k0, v0 in self.start_key.items()} if self.start_key is not None else None,
			"startKeyDocId": self.start_key_doc_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaginatedDocumentKeyIdPair':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_key = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("startKey").items())) if deserialized_dict.get("startKey") is not None else None,
			start_key_doc_id = deserialized_dict.get("startKeyDocId"),
		)

__all__ = ['PaginatedDocumentKeyIdPair']