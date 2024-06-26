import json
from typing import List, Optional, Union, Dict
from model.embed.form.template.Action import Action
from dataclasses import field, dataclass
from model.embed.form.template.Section import Section

@dataclass
class FormTemplateLayout:
	form: str
	actions: List['Action'] = field(default_factory=list)
	sections: List['Section'] = field(default_factory=list)
	description: Optional[str] = None
	keywords: Optional[List[str]] = None

	def __serialize__(self) -> object:
		return {
			"form": self.form,
			"actions": [x0.__serialize__() for x0 in self.actions],
			"sections": [x0.__serialize__() for x0 in self.sections],
			"description": self.description,
			"keywords": [x0 for x0 in self.keywords] if self.keywords is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FormTemplateLayout':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			form = deserialized_dict["form"],
			actions = [Action._deserialize(x0) for x0 in deserialized_dict["actions"]],
			sections = [Section._deserialize(x0) for x0 in deserialized_dict["sections"]],
			description = deserialized_dict.get("description"),
			keywords = [x0 for x0 in deserialized_dict.get("keywords")] if deserialized_dict.get("keywords") is not None else None,
		)

__all__ = ['FormTemplateLayout']