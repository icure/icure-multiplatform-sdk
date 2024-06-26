import json
from typing import Optional, List, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.KeywordSubword import KeywordSubword

@dataclass
class Keyword:
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
	value: Optional[str] = None
	sub_words: List['KeywordSubword'] = field(default_factory=list)
	user_id: Optional[str] = None

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
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words],
			"userId": self.user_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Keyword':
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
			value = deserialized_dict.get("value"),
			sub_words = [KeywordSubword._deserialize(x0) for x0 in deserialized_dict["subWords"]],
			user_id = deserialized_dict.get("userId"),
		)

__all__ = ['Keyword']