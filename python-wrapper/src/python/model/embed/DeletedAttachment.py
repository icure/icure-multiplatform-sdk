import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class DeletedAttachment:
	couch_db_attachment_id: Optional[str] = None
	object_store_attachment_id: Optional[str] = None
	key: Optional[str] = None
	deletion_time: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"couchDbAttachmentId": self.couch_db_attachment_id,
			"objectStoreAttachmentId": self.object_store_attachment_id,
			"key": self.key,
			"deletionTime": self.deletion_time,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeletedAttachment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			couch_db_attachment_id = deserialized_dict.get("couchDbAttachmentId"),
			object_store_attachment_id = deserialized_dict.get("objectStoreAttachmentId"),
			key = deserialized_dict.get("key"),
			deletion_time = deserialized_dict.get("deletionTime"),
		)

__all__ = ['DeletedAttachment']