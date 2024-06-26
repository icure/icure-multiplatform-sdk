import json
from typing import List, Union, Dict
from model.couchdb.DatabaseInfo import DatabaseInfo
from dataclasses import dataclass

@dataclass
class GroupDatabasesInfo:
	group_id: str
	databases_info: List['DatabaseInfo']
	gcp_storage_size: int

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"databasesInfo": [x0.__serialize__() for x0 in self.databases_info],
			"gcpStorageSize": self.gcp_storage_size,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupDatabasesInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id = deserialized_dict["groupId"],
			databases_info = [DatabaseInfo._deserialize(x0) for x0 in deserialized_dict["databasesInfo"]],
			gcp_storage_size = deserialized_dict["gcpStorageSize"],
		)

__all__ = ['GroupDatabasesInfo']