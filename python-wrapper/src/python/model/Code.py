import json
from typing import Optional, Dict, List, Union
from dataclasses import field, dataclass
from model.embed.Periodicity import Periodicity
from model.base.CodeFlag import CodeFlag
from model.base.AppendixType import AppendixType

@dataclass
class Code:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	context: Optional[str] = None
	type: Optional[str] = None
	code: Optional[str] = None
	version: Optional[str] = None
	label: Optional[Dict[str, str]] = None
	author: Optional[str] = None
	regions: List[str] = field(default_factory=list)
	periodicity: List['Periodicity'] = field(default_factory=list)
	level: Optional[int] = None
	links: List[str] = field(default_factory=list)
	qualified_links: Dict[str, List[str]] = field(default_factory=dict)
	flags: List['CodeFlag'] = field(default_factory=list)
	search_terms: Dict[str, List[str]] = field(default_factory=dict)
	data: Optional[str] = None
	appendices: Dict['AppendixType', str] = field(default_factory=dict)
	disabled: bool = False

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"context": self.context,
			"type": self.type,
			"code": self.code,
			"version": self.version,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"author": self.author,
			"regions": [x0 for x0 in self.regions],
			"periodicity": [x0.__serialize__() for x0 in self.periodicity],
			"level": self.level,
			"links": [x0 for x0 in self.links],
			"qualifiedLinks": {k0: [x1 for x1 in v0] for k0, v0 in self.qualified_links.items()},
			"flags": [x0.__serialize__() for x0 in self.flags],
			"searchTerms": {k0: [x1 for x1 in v0] for k0, v0 in self.search_terms.items()},
			"data": self.data,
			"appendices": {k0.__serialize__(): v0 for k0, v0 in self.appendices.items()},
			"disabled": self.disabled,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Code':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			context = deserialized_dict.get("context"),
			type = deserialized_dict.get("type"),
			code = deserialized_dict.get("code"),
			version = deserialized_dict.get("version"),
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			author = deserialized_dict.get("author"),
			regions = [x0 for x0 in deserialized_dict["regions"]],
			periodicity = [Periodicity._deserialize(x0) for x0 in deserialized_dict["periodicity"]],
			level = deserialized_dict.get("level"),
			links = [x0 for x0 in deserialized_dict["links"]],
			qualified_links = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["qualifiedLinks"].items())),
			flags = [CodeFlag._deserialize(x0) for x0 in deserialized_dict["flags"]],
			search_terms = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["searchTerms"].items())),
			data = deserialized_dict.get("data"),
			appendices = dict(map(lambda kv0: (AppendixType._deserialize(kv0[0]), kv0[1]), deserialized_dict["appendices"].items())),
			disabled = deserialized_dict["disabled"],
		)

__all__ = ['Code']