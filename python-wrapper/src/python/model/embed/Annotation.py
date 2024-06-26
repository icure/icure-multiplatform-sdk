import json
from typing import Optional, Dict, List, Union
from dataclasses import field, dataclass
from model.base.CodeStub import CodeStub

@dataclass
class Annotation:
	id: str
	author: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	text: Optional[str] = None
	markdown: Dict[str, str] = field(default_factory=dict)
	location: Optional[str] = None
	confidential: Optional[bool] = None
	tags: List['CodeStub'] = field(default_factory=list)
	encrypted_self: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"author": self.author,
			"created": self.created,
			"modified": self.modified,
			"text": self.text,
			"markdown": {k0: v0 for k0, v0 in self.markdown.items()},
			"location": self.location,
			"confidential": self.confidential,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Annotation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			author = deserialized_dict.get("author"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			text = deserialized_dict.get("text"),
			markdown = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["markdown"].items())),
			location = deserialized_dict.get("location"),
			confidential = deserialized_dict.get("confidential"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Annotation']