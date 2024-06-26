import json
from typing import Optional, List, Dict, Union
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass

@dataclass
class ApplicationSettings:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	settings: Dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"settings": {k0: v0 for k0, v0 in self.settings.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ApplicationSettings':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			settings = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["settings"].items())),
		)

__all__ = ['ApplicationSettings']