import json
from typing import List, Union, Dict
from model.filter.predicate.Predicate import Predicate, serialize_predicate, deserialize_predicate
from dataclasses import field, dataclass

@dataclass
class OrPredicate:
	predicates: List['Predicate'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"predicates": [serialize_predicate(x0) for x0 in self.predicates],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'OrPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			predicates = [deserialize_predicate(x0) for x0 in deserialized_dict["predicates"]],
		)

__all__ = ['OrPredicate']