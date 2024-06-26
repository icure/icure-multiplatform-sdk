import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class DataAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	utis: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"utis": [x0 for x0 in self.utis],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DataAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id = deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id = deserialized_dict.get("objectStoreAttachmentId"),
			utis = [x0 for x0 in deserialized_dict["utis"]],
		)

__all__ = ['DataAttachment']