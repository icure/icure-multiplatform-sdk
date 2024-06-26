import json
from typing import Optional, List, Dict, Union
from dataclasses import field, dataclass

@dataclass
class EntityTemplate:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	user_id: Optional[str] = None
	descr: Optional[str] = None
	keywords: Optional[List[str]] = None
	entity_type: Optional[str] = None
	sub_type: Optional[str] = None
	default_template: Optional[bool] = None
	entity: List[Dict[str, object]] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"userId": self.user_id,
			"descr": self.descr,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
			"entityType": self.entity_type,
			"subType": self.sub_type,
			"defaultTemplate": self.default_template,
			"entity": [{k1: v1 for k1, v1 in x0.items()} for x0 in self.entity],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityTemplate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			user_id = deserialized_dict.get("userId"),
			descr = deserialized_dict.get("descr"),
			keywords = [x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
			entity_type = deserialized_dict.get("entityType"),
			sub_type = deserialized_dict.get("subType"),
			default_template = deserialized_dict.get("defaultTemplate"),
			entity = [dict(map(lambda kv1: (kv1[0], kv1[1]), x0.items())) for x0 in deserialized_dict["entity"]],
		)

__all__ = ['EntityTemplate']