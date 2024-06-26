import json
from typing import List, Optional, Union, Dict
from dataclasses import field, dataclass
from model.PaginatedDocumentKeyIdPair import PaginatedDocumentKeyIdPair

@dataclass
class PaginatedList:
	rows: List[object] = field(default_factory=list)
	next_key_pair: Optional['PaginatedDocumentKeyIdPair'] = None

	def __serialize__(self) -> object:
		return {
			"rows": [x0.__serialize__() for x0 in self.rows],
			"nextKeyPair": self.next_key_pair.__serialize__() if self.next_key_pair is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaginatedList':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			rows = [x0 for x0 in deserialized_dict["rows"]],
			next_key_pair = PaginatedDocumentKeyIdPair._deserialize(deserialized_dict.get("nextKeyPair")) if deserialized_dict.get("nextKeyPair") is not None else None,
		)

__all__ = ['PaginatedList']