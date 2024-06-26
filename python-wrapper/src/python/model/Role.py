import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class Role:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	permissions: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"permissions": [x0 for x0 in self.permissions],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Role':
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
			permissions = [x0 for x0 in deserialized_dict["permissions"]],
		)

__all__ = ['Role']