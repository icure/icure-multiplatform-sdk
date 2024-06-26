import json
from typing import Optional, List, Union, Dict
from model.embed.DatabaseSynchronization import DatabaseSynchronization
from dataclasses import field, dataclass

@dataclass
class Replication:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	context: Optional[str] = None
	database_synchronizations: List['DatabaseSynchronization'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"context": self.context,
			"databaseSynchronizations": [x0.__serialize__() for x0 in self.database_synchronizations],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Replication':
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
			context = deserialized_dict.get("context"),
			database_synchronizations = [DatabaseSynchronization._deserialize(x0) for x0 in deserialized_dict["databaseSynchronizations"]],
		)

__all__ = ['Replication']