import json
from model.filter.AbstractFilter import AbstractFilter
from typing import Optional, Union, Dict
from model.filter.predicate.Predicate import Predicate
from dataclasses import dataclass

@dataclass
class FilterChain:
	filter: 'AbstractFilter'
	predicate: Optional['Predicate'] = None

	def __serialize__(self) -> object:
		return {
			"filter": serialize_abstract_filter(self.filter),
			"predicate": serialize_predicate(self.predicate) if self.predicate is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FilterChain':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			filter = deserialize_abstract_filter(deserialized_dict["filter"]),
			predicate = deserialize_predicate(deserialized_dict.get("predicate")) if deserialized_dict.get("predicate") is not None else None,
		)

__all__ = ['FilterChain']