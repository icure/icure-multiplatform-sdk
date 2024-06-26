import json
from typing import Optional, Dict, Union
from dataclasses import field, dataclass
from model.couchdb.View import View

@dataclass
class DesignDocument:
	id: str
	rev: Optional[str] = None
	rev_history: Dict[str, str] = field(default_factory=dict)
	language: Optional[str] = None
	views: Dict[str, 'View'] = field(default_factory=dict)
	lists: Dict[str, str] = field(default_factory=dict)
	shows: Dict[str, str] = field(default_factory=dict)
	update_handlers: Optional[Dict[str, str]] = None
	filters: Dict[str, str] = field(default_factory=dict)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"revHistory": {k0: v0 for k0, v0 in self.rev_history.items()},
			"language": self.language,
			"views": {k0: v0.__serialize__() for k0, v0 in self.views.items()},
			"lists": {k0: v0 for k0, v0 in self.lists.items()},
			"shows": {k0: v0 for k0, v0 in self.shows.items()},
			"updateHandlers": {k0: v0 for k0, v0 in self.update_handlers.items()} if self.update_handlers is not None else None,
			"filters": {k0: v0 for k0, v0 in self.filters.items()},
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DesignDocument':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			rev_history = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["revHistory"].items())),
			language = deserialized_dict.get("language"),
			views = dict(map(lambda kv0: (kv0[0], View._deserialize(kv0[1])), deserialized_dict["views"].items())),
			lists = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["lists"].items())),
			shows = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["shows"].items())),
			update_handlers = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("updateHandlers").items())) if deserialized_dict.get("updateHandlers") is not None else None,
			filters = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["filters"].items())),
		)

__all__ = ['DesignDocument']