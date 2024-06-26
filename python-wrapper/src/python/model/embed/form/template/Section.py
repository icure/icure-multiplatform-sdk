import json
from typing import List, Optional, Union, Dict
from model.embed.form.template.StructureElement import StructureElement
from dataclasses import dataclass

@dataclass
class Section:
	section: str
	fields: List['StructureElement']
	description: Optional[str] = None
	keywords: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"section": self.section,
			"fields": [serialize_structure_element(x0) for x0 in self.fields],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Section':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			section = deserialized_dict["section"],
			fields = [deserialize_structure_element(x0) for x0 in deserialized_dict["fields"]],
			description = deserialized_dict.get("description"),
			keywords = [x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

__all__ = ['Section']