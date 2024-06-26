import json
from typing import Optional, List, Union, Dict
from model.embed.form.template.StructureElement import StructureElement, serialize_structure_element, deserialize_structure_element
from dataclasses import dataclass

@dataclass
class FieldsGroup:
	group: str
	fields: Optional[List['StructureElement']] = None

	def __serialize__(self) -> object:
		return {
			"group": self.group,
			"fields": [serialize_structure_element(x0) for x0 in self.fields] if self.fields is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FieldsGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group = deserialized_dict["group"],
			fields = [deserialize_structure_element(x0) for x0 in deserialized_dict.get("fields")] if deserialized_dict.get("fields") is not None else None,
		)

__all__ = ['FieldsGroup']