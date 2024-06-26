import json
from typing import Optional, List, Union, Dict
from model.embed.FrontEndMigrationStatus import FrontEndMigrationStatus
from model.PropertyStub import DecryptedPropertyStub
from dataclasses import field, dataclass

@dataclass
class FrontEndMigration:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	status: Optional['FrontEndMigrationStatus'] = None
	logs: Optional[str] = None
	user_id: Optional[str] = None
	start_key: Optional[str] = None
	start_key_doc_id: Optional[str] = None
	process_count: Optional[int] = None
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"startDate": self.start_date,
			"endDate": self.end_date,
			"status": self.status.__serialize__() if self.status is not None else None,
			"logs": self.logs,
			"userId": self.user_id,
			"startKey": self.start_key,
			"startKeyDocId": self.start_key_doc_id,
			"processCount": self.process_count,
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FrontEndMigration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			name = deserialized_dict.get("name"),
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			status = FrontEndMigrationStatus._deserialize(deserialized_dict.get("status")) if deserialized_dict.get("status") is not None else None,
			logs = deserialized_dict.get("logs"),
			user_id = deserialized_dict.get("userId"),
			start_key = deserialized_dict.get("startKey"),
			start_key_doc_id = deserialized_dict.get("startKeyDocId"),
			process_count = deserialized_dict.get("processCount"),
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

__all__ = ['FrontEndMigration']