import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class EntityReference:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	doc_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"docId": self.doc_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityReference':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			doc_id = deserialized_dict.get("docId"),
		)

__all__ = ['EntityReference']