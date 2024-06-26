import json
from typing import Optional, List, Union, Dict
from model.filter.AbstractFilter import AbstractFilter, serialize_abstract_filter, deserialize_abstract_filter
from dataclasses import field, dataclass

@dataclass
class IntersectionFilter:
	desc: Optional[str] = None
	filters: List['AbstractFilter'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"filters": [serialize_abstract_filter(x0) for x0 in self.filters],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'IntersectionFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			filters = [deserialize_abstract_filter(x0) for x0 in deserialized_dict["filters"]],
		)

__all__ = ['IntersectionFilter']